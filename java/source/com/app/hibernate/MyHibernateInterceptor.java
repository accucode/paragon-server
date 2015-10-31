package com.app.hibernate;

import java.io.Serializable;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import com.kodemore.log.KmLog;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;
import com.kodemore.types.KmMoney;
import com.kodemore.utility.KmDisplayStringIF;

import com.app.dao.core.MyDaoSession;
import com.app.model.MyAuditLog;
import com.app.model.MyAuditLogType;
import com.app.model.MyServerSession;
import com.app.model.MyUser;
import com.app.model.base.MyAuditLogInfo;
import com.app.model.core.MyAbstractDomain;
import com.app.utility.MyGlobals;

public class MyHibernateInterceptor
    extends EmptyInterceptor
{
    //##################################################
    //# events
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

    //##################################################
    //# audit
    //##################################################

    private void auditAdd(Object entity, Object[] state, String[] propertyNames, Type[] types)
    {
        MyAbstractDomain model = toAuditableModel(entity);
        if ( model == null )
            return;

        createAuditLog(MyAuditLogType.Add, model, "uid", null, model.formatPrimaryKey());

        int n = state.length;
        for ( int i = 0; i < n; i++ )
        {
            String field = propertyNames[i];
            Type type = types[i];
            Object value = state[i];

            auditAdd(model, field, type, value);
        }
    }

    private void auditAdd(MyAbstractDomain model, String field, Type type, Object value)
    {
        if ( !auditsFieldType(type) )
            return;

        if ( value != null )
            createAuditLog(MyAuditLogType.Add, model, field, null, value);
    }

    private void auditUpdate(
        Object entity,
        Object[] currentState,
        Object[] previousState,
        String[] propertyNames,
        Type[] types)
    {
        MyAbstractDomain model = toAuditableModel(entity);
        if ( model == null )
            return;

        int n = currentState.length;
        for ( int i = 0; i < n; i++ )
        {
            String field = propertyNames[i];
            Type type = types[i];
            Object value = currentState[i];
            Object oldValue = previousState[i];

            auditUpdate(model, field, type, value, oldValue);
        }
    }

    private void auditUpdate(
        MyAbstractDomain model,
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

        createAuditLog(MyAuditLogType.Update, model, field, oldValue, newValue);
    }

    private void auditDelete(Object entity, Object[] state, String[] propertyNames, Type[] types)
    {
        MyAbstractDomain model = toAuditableModel(entity);
        if ( model == null )
            return;

        createAuditLog(MyAuditLogType.Delete, model, "uid", model.formatPrimaryKey(), null);

        int n = state.length;
        for ( int i = 0; i < n; i++ )
        {
            String field = propertyNames[i];
            Type type = types[i];
            Object oldValue = state[i];

            auditDelete(model, field, type, oldValue);
        }
    }

    private void auditDelete(MyAbstractDomain model, String field, Type type, Object oldValue)
    {
        boolean trackType = auditsFieldType(type);
        if ( !trackType )
            return;

        Object newValue = null;

        boolean matches = matches(newValue, oldValue);
        if ( matches )
            return;

        createAuditLog(MyAuditLogType.Delete, model, field, oldValue, newValue);
    }

    private MyAbstractDomain toAuditableModel(Object obj)
    {
        if ( !(obj instanceof MyAbstractDomain) )
            return null;

        MyAbstractDomain e = (MyAbstractDomain)obj;

        if ( MyAuditLogInfo.isModelDisabled(e.getMetaName()) )
            return null;

        return e;
    }

    //##################################################
    //# create audit log
    //##################################################

    private void createAuditLog(
        MyAuditLogType changeType,
        MyAbstractDomain model,
        String fieldName,
        Object oldValue,
        Object newValue)
    {
        String modelType = model.getMetaName();
        String modelName = model.getDisplayString();

        if ( MyAuditLogInfo.isFieldDisabled(modelType, fieldName) )
            return;

        if ( MyAuditLogInfo.isFieldMasked(modelType, fieldName) )
        {
            newValue = "***";
            oldValue = "***";
        }

        MyAuditLog e;
        e = new MyAuditLog();
        e.setTransactionUid(getTransactionUid());
        e.setUser(getCurrentUser());
        e.setType(changeType);
        e.setModelType(modelType);
        e.setModelName(modelName);
        e.setModelUid(model.formatPrimaryKey());
        e.setFieldName(fieldName);
        e.setNewValue(formatValue(newValue));
        e.setOldValue(formatValue(oldValue));

        applyFieldValueTo(e, newValue);

        e.truncateUid(true);
        e.truncateModelName(true);
        e.truncateFieldName(true);
        e.truncateNewValue(true);
        e.truncateOldValue(true);
        e.truncateStringValue(true);

        e.attachDao();

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
}
