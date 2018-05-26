package com.app.hibernate;

import java.io.Serializable;

import org.hibernate.type.Type;

import com.kodemore.collection.KmList;
import com.kodemore.log.KmLog;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmDuration;
import com.kodemore.time.KmTime;
import com.kodemore.time.KmTimestamp;
import com.kodemore.types.KmCost;
import com.kodemore.types.KmDayFrequency;
import com.kodemore.types.KmHtmlColor;
import com.kodemore.types.KmKilogram;
import com.kodemore.types.KmMoney;
import com.kodemore.types.KmQuantity;
import com.kodemore.types.KmRate;
import com.kodemore.utility.KmDisplayStringIF;
import com.kodemore.utility.Kmu;

import com.app.dao.core.MyDaoSession;
import com.app.model.MyAuditBundle;
import com.app.model.MyAuditLog;
import com.app.model.MyServerSession;
import com.app.model.MyUser;
import com.app.model.base.MyAuditBundleChangeType;
import com.app.model.base.MyAuditLogInfo;
import com.app.model.base.MyAuditLogType;
import com.app.model.core.MyAbstractDaoDomain;
import com.app.utility.MyBasicTimestampsIF;
import com.app.utility.MyGlobals;

/**
 * I am used to intercept hibernate change and log the changes.
 * Each hibernate event creates a new handler, which allows
 * the handler to simplify the logic and rely on local instance
 * variables.
 *
 * Note: Do not take any actions in this handler that will result in a
 * flush.  Using criteria objects is unsafe (e.g. c.findAll()). However
 * accessing a model's associations is safe (e.g. site.getProject()).
 */
public class MyHibernateInterceptHandler
{
    //##################################################
    //# constants
    //##################################################

    private static final String NULL_VALUE  = Kmu.formatMetaValue("null");
    private static final String EMPTY_VALUE = Kmu.formatMetaValue("empty");

    //##################################################
    //# static
    //##################################################

    /**
     * The prefix used when PRINTING the audit log as debug
     * output. This is typically only used in development.
     */
    private static final String AUDIT_LOG_PREFIX = "AUDIT LOG...";

    /**
     * This keeps track of the last database transaction that
     * was PRINTED, and is used to print a visual separator
     * between transactions for easier debugging. This is only
     * used in development.
     *
     * NOTE: hibernate may interleave database updates from
     * multiple transactions in a multithreaded environment.
     * This is relatively uncommon in the development environment
     * but it can still happen. The separator will print each
     * time the transaction uid changes.
     */
    private static String _lastPrintedTransactionUid = null;

    //##################################################
    //# variables
    //##################################################

    /**
     * The domain object being updated.
     * Each handler may process multiple fields/values,
     * but they will all belong to a single domain model.
     */
    private MyAbstractDaoDomain<?> _domain;

    /**
     * The persistent bundle that is being created to
     * record the changes.
     */
    private MyAuditBundle _bundle;

    //##################################################
    //# save / add
    //##################################################

    /**
     * @param id not used.
     */
    public boolean handleOnSave(
        Object entity,
        Serializable id,
        Object[] values,
        String[] fields,
        Type[] types)
    {
        if ( !installDomain(entity) )
            return true;

        validateDomain();
        installBundle(MyAuditBundleChangeType.Add);
        auditAdd(fields, types, values);
        printBundle();
        return true;
    }

    private void auditAdd(String[] fields, Type[] types, Object[] values)
    {
        createLog("uid", getDomainKey(), null);

        int n = values.length;
        for ( int i = 0; i < n; i++ )
        {
            String field = fields[i];
            Type type = types[i];
            Object value = values[i];

            auditAdd(field, type, value);
        }
    }

    private void auditAdd(String field, Type type, Object value)
    {
        if ( !auditsFieldType(type) )
            return;

        if ( value != null )
            createLog(field, value, null);
    }

    //##################################################
    //# flush / update
    //##################################################

    /**
     * @param id
     */
    public boolean handleOnFlushDirty(
        Object entity,
        Serializable id,
        Object[] currentValues,
        Object[] previousValues,
        String[] fields,
        Type[] types)
    {
        if ( !installDomain(entity) )
            return true;

        validateDomain();
        installBundle(MyAuditBundleChangeType.Update);
        auditUpdate(fields, types, currentValues, previousValues);
        printBundle();
        return true;
    }

    private void auditUpdate(String[] fields, Type[] types, Object[] newValues, Object[] oldValues)
    {
        touchUpdateTimes(fields, newValues);

        int n = newValues.length;
        for ( int i = 0; i < n; i++ )
        {
            String field = fields[i];
            Type type = types[i];
            Object newValue = newValues[i];
            Object oldValue = oldValues[i];

            auditUpdate(field, type, newValue, oldValue);
        }
    }

    private void auditUpdate(String field, Type type, Object newValue, Object oldValue)
    {
        boolean trackType = auditsFieldType(type);
        if ( !trackType )
            return;

        boolean matches = matches(newValue, oldValue);
        if ( matches )
            return;

        createLog(field, newValue, oldValue);
    }

    private void touchUpdateTimes(String[] fields, Object[] newValues)
    {
        if ( !(_domain instanceof MyBasicTimestampsIF) )
            return;

        if ( !getSession().areBasicTimestampsEnabledFor((MyBasicTimestampsIF)_domain) )
            return;

        KmTimestamp now = KmClock.getUtcTimestamp();
        MyUser user = MyGlobals.getCurrentUser();

        setState(_domain, fields, newValues, "updatedUtcTs", now);
        setState(_domain, fields, newValues, "updatedBy", user);
    }

    //##################################################
    //# delete
    //##################################################

    /**
     * @param id
     */
    public void handleOnDelete(
        Object entity,
        Serializable id,
        Object[] values,
        String[] fields,
        Type[] types)
    {
        if ( !installDomain(entity) )
            return;

        installBundle(MyAuditBundleChangeType.Delete);
        auditDelete(fields, types, values);
        printBundle();
    }

    private void auditDelete(String[] fields, Type[] types, Object[] values)
    {
        createLog("uid", null, getDomainKey());

        int n = values.length;
        for ( int i = 0; i < n; i++ )
        {
            String field = fields[i];
            Type type = types[i];
            Object oldValue = values[i];

            auditDelete(field, type, oldValue);
        }
    }

    private void auditDelete(String field, Type type, Object oldValue)
    {
        boolean trackType = auditsFieldType(type);
        if ( !trackType )
            return;

        Object newValue = null;

        boolean matches = matches(newValue, oldValue);
        if ( matches )
            return;

        createLog(field, newValue, oldValue);
    }

    //##################################################
    //# setup
    //##################################################

    private boolean installDomain(Object obj)
    {
        MyAbstractDaoDomain<?> e = toAuditableDomain(obj);
        if ( e == null )
            return false;

        _domain = e;
        return true;
    }

    private void installBundle(MyAuditBundleChangeType changeType)
    {
        String domainType = _domain.getMetaName();
        String domainUid = getDomainKey();
        String domainName = _domain.getAuditLogTitle();

        MyAuditBundle e;
        e = new MyAuditBundle();
        e.setTransactionUid(getTransactionUid());
        e.setUser(getCurrentUser());
        e.setChangeType(changeType);
        e.setDomainType(domainType);
        e.setDomainUid(domainUid);
        e.setDomainName(domainName);
        e.truncateDomainName(true);
        e.daoAttach();
        _bundle = e;
    }

    private void createLog(String field, Object newValue, Object oldValue)
    {
        String domainType = _domain.getMetaName();
        String domainName = _domain.getAuditLogTitle();

        if ( MyAuditLogInfo.isFieldDisabled(domainType, field) )
            return;

        if ( MyAuditLogInfo.isFieldMasked(domainType, field) )
        {
            newValue = "***";
            oldValue = "***";
        }

        MyAuditLogType changeType = getLogChangeType();

        MyUser user = getCurrentUser();

        MyAuditLog log;
        log = _bundle.addLog();
        log.setTransactionUid(getTransactionUid());
        log.setUser(user);
        log.setType(changeType);
        log.setDomainType(domainType);
        log.setDomainName(domainName);
        log.setDomainUid(getDomainKey());
        log.setFieldName(field);
        log.setNewValue(formatValue(newValue));
        log.setOldValue(formatValue(oldValue));

        applyFieldValueTo(log, newValue);

        log.truncateDomainName(true);
        log.truncateFieldName(true);
        log.truncateNewValue(true);
        log.truncateOldValue(true);
        log.truncateStringValue(true);

        log.daoAttach();
    }

    /**
     * Format a short human readable string for an arbitrary object.
     */
    private String formatValue(Object value)
    {
        String s = _formatValue(value);

        if ( s == null )
            return NULL_VALUE;

        if ( s.length() == 0 )
            return EMPTY_VALUE;

        return s;
    }

    private String _formatValue(Object value)
    {
        if ( value == null )
            return null;

        if ( value instanceof Boolean )
            return value.toString();

        if ( value instanceof KmCost )
            return value.toString();

        if ( value instanceof KmDate )
            return ((KmDate)value).format_mm_dd_yy();

        if ( value instanceof KmDayFrequency )
            return value.toString();

        if ( value instanceof Double )
            return value.toString();

        if ( value instanceof KmDuration )
            return ((KmDuration)value).format();

        if ( value instanceof KmHtmlColor )
            return value.toString();

        if ( value instanceof Integer )
            return value.toString();

        if ( value instanceof KmKilogram )
            return value.toString();

        if ( value instanceof Long )
            return value.toString();

        if ( value instanceof KmMoney )
            return ((KmMoney)value).format();

        if ( value instanceof KmQuantity )
            return ((KmQuantity)value).format();

        if ( value instanceof KmRate )
            return value.toString();

        if ( value instanceof String )
            return value.toString();

        if ( value instanceof KmTime )
            return value.toString();

        if ( value instanceof KmTimestamp )
            return ((KmTimestamp)value).format_m_d_yyyy_hh_mm_ss();

        if ( value instanceof MyAbstractDaoDomain )
            return ((MyAbstractDaoDomain<?>)value).getAuditLogTitle();

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

        if ( value instanceof MyAbstractDaoDomain )
        {
            log.setUidValue(((MyAbstractDaoDomain<?>)value).formatPrimaryKey());
            return;
        }
    }

    //##################################################
    //# print
    //##################################################

    private void printBundle()
    {
        if ( !printsAuditLog() )
            return;

        printTransactionLine();
        printBundleHeader();

        KmList<MyAuditLog> v = _bundle.getLogs().toList(e -> e.getUid());
        for ( MyAuditLog e : v )
            printLog(e);
    }

    private boolean printsAuditLog()
    {
        return MyGlobals.getProperties().getPrintAuditLog();
    }

    private void printTransactionLine()
    {
        String txnUid = _bundle.getTransactionUid();
        if ( Kmu.isEqual(txnUid, _lastPrintedTransactionUid) )
            return;

        _lastPrintedTransactionUid = txnUid;
        KmLog.printfln("%s txn %s ==============================", AUDIT_LOG_PREFIX, txnUid);
    }

    private void printBundleHeader()
    {
        KmLog.printfln("%s bundle %s ", AUDIT_LOG_PREFIX, _bundle.getMessage());
    }

    private void printLog(MyAuditLog log)
    {
        KmLog.printfln("%s field %s", AUDIT_LOG_PREFIX, log.formatMessage());
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

    private String getDomainKey()
    {
        return _domain.formatPrimaryKey();
    }

    private void validateDomain()
    {
        _domain.validateAndCheck();
    }

    private MyAbstractDaoDomain<?> toAuditableDomain(Object obj)
    {
        if ( !(obj instanceof MyAbstractDaoDomain) )
            return null;

        MyAbstractDaoDomain<?> e = (MyAbstractDaoDomain<?>)obj;

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

    private void setState(
        Object domain,
        String[] fields,
        Object[] values,
        String field,
        Object value)
    {
        int i = indexOf(fields, field);
        if ( i >= 0 )
            values[i] = value;
        else
            KmLog.warnTrace("Unknown property: %s.%s.", domain.getClass().getName(), field);
    }

    private int indexOf(String[] arr, String s)
    {
        int n = arr.length;
        for ( int i = 0; i < n; i++ )
            if ( arr[i].equals(s) )
                return i;

        return -1;
    }

    private MyAuditLogType getLogChangeType()
    {
        MyAuditBundleChangeType type = _bundle.getChangeType();
        switch ( type )
        {
            case Add:
                return MyAuditLogType.Add;

            case Update:
                return MyAuditLogType.Update;

            case Delete:
                return MyAuditLogType.Delete;
        }
        throw Kmu.newEnumError(type);
    }

}
