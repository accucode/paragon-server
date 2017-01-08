package com.app.hibernate;

import java.io.Serializable;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import com.kodemore.log.KmLog;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmDuration;
import com.kodemore.time.KmTimestamp;
import com.kodemore.types.KmMoney;
import com.kodemore.utility.KmDisplayStringIF;
import com.kodemore.utility.Kmu;

import com.app.dao.core.MyDaoSession;
import com.app.model.MyAuditLog;
import com.app.model.MyServerSession;
import com.app.model.MyUser;
import com.app.model.base.MyAuditLogInfo;
import com.app.model.base.MyAuditLogType;
import com.app.model.core.MyAbstractDomain;
import com.app.utility.MyBasicTimestampsIF;
import com.app.utility.MyGlobals;

public class MyHibernateInterceptor
    extends EmptyInterceptor
{
    //##################################################
    //# save / add
    //##################################################

    @Override
    public boolean onSave(
        Object entity,
        Serializable id,
        Object[] state,
        String[] propertyNames,
        Type[] types)
    {
        validate(entity);
        auditAdd(entity, state, propertyNames, types);
        return true;
    }

    private void auditAdd(Object entity, Object[] state, String[] propertyNames, Type[] types)
    {
        MyAbstractDomain domain = toAuditableDomain(entity);
        if ( domain == null )
            return;

        String bundleUid = Kmu.newUid();
        createAuditLog(
            MyAuditLogType.Add,
            domain,
            bundleUid,
            "uid",
            null,
            domain.formatPrimaryKey());

        int n = state.length;
        for ( int i = 0; i < n; i++ )
        {
            String field = propertyNames[i];
            Type type = types[i];
            Object value = state[i];

            auditAdd(domain, bundleUid, field, type, value);
        }
    }

    private void auditAdd(
        MyAbstractDomain domain,
        String bundleUid,
        String field,
        Type type,
        Object value)
    {
        if ( !auditsFieldType(type) )
            return;

        if ( value != null )
            createAuditLog(MyAuditLogType.Add, domain, bundleUid, field, null, value);
    }

    //##################################################
    //# flush / update
    //##################################################

    @Override
    public boolean onFlushDirty(
        Object entity,
        Serializable id,
        Object[] currentState,
        Object[] previousState,
        String[] propertyNames,
        Type[] types)
    {
        validate(entity);
        auditUpdate(entity, currentState, previousState, propertyNames, types);
        return true;
    }

    private void auditUpdate(
        Object entity,
        Object[] currentState,
        Object[] previousState,
        String[] propertyNames,
        Type[] types)
    {
        MyAbstractDomain domain = toAuditableDomain(entity);
        if ( domain == null )
            return;

        if ( domain instanceof MyBasicTimestampsIF )
        {
            KmTimestamp now = KmClock.getUtcTimestamp();
            MyUser user = MyGlobals.getCurrentUser();

            setState(domain, propertyNames, currentState, "updatedUtcTs", now);
            setState(domain, propertyNames, currentState, "updatedBy", user);
        }

        String bundleUid = Kmu.newUid();

        int n = currentState.length;
        for ( int i = 0; i < n; i++ )
        {
            String field = propertyNames[i];
            Type type = types[i];
            Object value = currentState[i];
            Object oldValue = previousState[i];

            auditUpdate(domain, bundleUid, field, type, value, oldValue);
        }
    }

    private void auditUpdate(
        MyAbstractDomain domain,
        String bundleUid,
        String field,
        Type type,
        Object newValue,
        Object oldValue)
    {
        boolean trackType = auditsFieldType(type);
        if ( !trackType )
            return;

        boolean matches = matches(newValue, oldValue);
        if ( matches )
            return;

        createAuditLog(MyAuditLogType.Update, domain, bundleUid, field, oldValue, newValue);
    }

    //##################################################
    //# delete
    //##################################################

    @Override
    public void onDelete(
        Object entity,
        Serializable id,
        Object[] state,
        String[] propertyNames,
        Type[] types)
    {
        auditDelete(entity, state, propertyNames, types);
    }

    private void auditDelete(Object entity, Object[] state, String[] propertyNames, Type[] types)
    {
        MyAbstractDomain domain = toAuditableDomain(entity);
        if ( domain == null )
            return;

        String bundleUid = Kmu.newUid();
        createAuditLog(
            MyAuditLogType.Delete,
            domain,
            bundleUid,
            "uid",
            domain.formatPrimaryKey(),
            null);

        int n = state.length;
        for ( int i = 0; i < n; i++ )
        {
            String field = propertyNames[i];
            Type type = types[i];
            Object oldValue = state[i];

            auditDelete(domain, bundleUid, field, type, oldValue);
        }
    }

    private void auditDelete(
        MyAbstractDomain model,
        String bundleUid,
        String field,
        Type type,
        Object oldValue)
    {
        boolean trackType = auditsFieldType(type);
        if ( !trackType )
            return;

        Object newValue = null;

        boolean matches = matches(newValue, oldValue);
        if ( matches )
            return;

        createAuditLog(MyAuditLogType.Delete, model, bundleUid, field, oldValue, newValue);
    }

    //##################################################
    //# create audit log
    //##################################################

    private void createAuditLog(
        MyAuditLogType changeType,
        MyAbstractDomain domain,
        String bundleUid,
        String fieldName,
        Object oldValue,
        Object newValue)
    {
        String domainType = domain.getMetaName();
        String domainName = domain.getDisplayString();

        if ( MyAuditLogInfo.isFieldDisabled(domainType, fieldName) )
            return;

        if ( MyAuditLogInfo.isFieldMasked(domainType, fieldName) )
        {
            newValue = "***";
            oldValue = "***";
        }

        MyAuditLog e;
        e = new MyAuditLog();
        e.setTransactionUid(getTransactionUid());
        e.setUser(getCurrentUser());
        e.setType(changeType);
        e.setDomainBundleUid(bundleUid);
        e.setDomainType(domainType);
        e.setDomainName(domainName);
        e.setDomainUid(domain.formatPrimaryKey());
        e.setFieldName(fieldName);
        e.setNewValue(formatValue(newValue));
        e.setOldValue(formatValue(oldValue));

        applyFieldValueTo(e, newValue);

        e.truncateUid(true);
        e.truncateDomainName(true);
        e.truncateFieldName(true);
        e.truncateNewValue(true);
        e.truncateOldValue(true);
        e.truncateStringValue(true);

        e.daoAttach();

        if ( printsAuditLog() )
            KmLog.printfln("AUDIT LOG..." + e.formatMessage());
    }

    /**
     * Format a short human readable string for an arbitrary object.
     */
    private String formatValue(Object value)
    {
        if ( value == null )
            return "null";

        if ( value instanceof String )
            return value.toString();

        if ( value instanceof Integer )
            return value.toString();

        if ( value instanceof Long )
            return value.toString();

        if ( value instanceof Boolean )
            return value.toString();

        if ( value instanceof Double )
            return value.toString();

        if ( value instanceof KmMoney )
            return ((KmMoney)value).format();

        if ( value instanceof KmDate )
            return ((KmDate)value).format_mm_dd_yy();

        if ( value instanceof KmTimestamp )
            return ((KmTimestamp)value).format_m_d_yyyy_hh_mm_ss();

        if ( value instanceof KmDuration )
            return ((KmDuration)value).format();

        if ( value instanceof KmDisplayStringIF )
            return ((KmDisplayStringIF)value).getDisplayString();

        return value.getClass().getSimpleName();
    }

    private void applyFieldValueTo(MyAuditLog log, Object value)
    {
        if ( value == null )
            return;

        if ( value instanceof String )
        {
            log.setStringValue((String)value);
            return;
        }

        if ( value instanceof Integer )
        {
            log.setIntegerValue((Integer)value);
            return;
        }

        if ( value instanceof Long )
        {
            log.setLongValue((Long)value);
            return;
        }

        if ( value instanceof Boolean )
        {
            log.setBooleanValue((Boolean)value);
            return;
        }

        if ( value instanceof Double )
        {
            log.setDoubleValue((Double)value);
            return;
        }

        if ( value instanceof KmMoney )
        {
            log.setMoneyValue((KmMoney)value);
            return;
        }

        if ( value instanceof KmDate )
        {
            log.setDateValue((KmDate)value);
            return;
        }

        if ( value instanceof KmTimestamp )
        {
            log.setTimestampValue((KmTimestamp)value);
            log.setDateValue(((KmTimestamp)value).getDate());
            return;
        }

        if ( value instanceof MyAbstractDomain )
        {
            log.setUidValue(((MyAbstractDomain)value).formatPrimaryKey());
            return;
        }
    }

    //##################################################
    //# support
    //##################################################

    private MyDaoSession getSession()
    {
        return MyGlobals.getDaoSession();
    }

    private String getTransactionUid()
    {
        return getSession().getTransactionUid();
    }

    /**
     * Get the current user.  This may be null for automated system events,
     * or for actions initiated by a user that has not yet logged in.
     */
    private MyUser getCurrentUser()
    {
        MyServerSession ss = MyGlobals.getServerSession();
        if ( ss == null )
            return null;

        return ss.getUser();
    }

    private void validate(Object entity)
    {
        if ( entity instanceof MyAbstractDomain )
        {
            MyAbstractDomain e;
            e = (MyAbstractDomain)entity;
            e.validate();
        }
    }

    private MyAbstractDomain toAuditableDomain(Object obj)
    {
        if ( !(obj instanceof MyAbstractDomain) )
            return null;

        MyAbstractDomain e = (MyAbstractDomain)obj;

        if ( MyAuditLogInfo.isModelDisabled(e.getMetaName()) )
            return null;

        return e;
    }

    private boolean auditsFieldType(Type e)
    {
        if ( e.isEntityType() )
            return true;

        if ( e.isComponentType() )
            return false;

        if ( e.isAssociationType() )
            return false;

        if ( e.isCollectionType() )
            return false;

        if ( e.isAnyType() )
            return false;

        return true;
    }

    protected String formatCategory(Type type)
    {
        if ( type.isEntityType() )
            return "entity";

        if ( type.isComponentType() )
            return "component";

        if ( type.isAssociationType() )
            return "association";

        if ( type.isCollectionType() )
            return "collection";

        if ( type.isAnyType() )
            return "any";

        return "value";
    }

    private boolean matches(Object a, Object b)
    {
        if ( a == null )
            return b == null;

        if ( b == null )
            return false;

        return a.equals(b);
    }

    private boolean printsAuditLog()
    {
        return MyGlobals.getProperties().getPrintAuditLog();
    }

    private void setState(Object model, String[] names, Object[] values, String name, Object value)
    {
        int i = indexOf(names, name);
        if ( i >= 0 )
            values[i] = value;
        else
            KmLog.warnTrace("Unknown property: %s.%s.", model.getClass().getName(), name);
    }

    private int indexOf(String[] arr, String s)
    {
        int n = arr.length;
        for ( int i = 0; i < n; i++ )
            if ( arr[i].equals(s) )
                return i;

        return -1;
    }

}
