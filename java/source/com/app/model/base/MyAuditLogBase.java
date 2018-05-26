//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import java.util.*;

import com.kodemore.collection.*;
import com.kodemore.domain.*;
import com.kodemore.exception.*;
import com.kodemore.servlet.encoder.*;
import com.kodemore.servlet.utility.*;
import com.kodemore.time.*;
import com.kodemore.types.*;
import com.kodemore.utility.*;

import com.app.finder.*;
import com.app.model.*;
import com.app.model.core.*;
import com.app.model.meta.*;
import com.app.model.support.*;
import com.app.ui.dashboard.core.*;
import com.app.utility.*;

@SuppressWarnings("all")
public abstract class MyAuditLogBase
    extends MyAbstractDaoDomain<MyAuditLog>
    implements KmUidDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaAuditLog Meta = MyMetaAuditLog.instance;
    public static final MyAuditLogTools Tools = MyAuditLogTools.instance;
    public static final MyAuditLogValidator Validator = MyAuditLogValidator.instance;
    public static final MyAuditLogFinder Finder = MyAuditLogFinder.instance;

    //##################################################
    //# variables
    //##################################################

    private Boolean booleanValue;
    private KmTimestamp createdUtcTs;
    private KmDate dateValue;
    private String domainName;
    private String domainType;
    private String domainUid;
    private Double doubleValue;
    private String fieldName;
    private Integer integerValue;
    private Long longValue;
    private KmMoney moneyValue;
    private String newValue;
    private String oldValue;
    private String stringValue;
    private KmTimestamp timestampValue;
    private String transactionUid;
    private String typeCode;
    private String uid;
    private String uidValue;
    private String userName;
    private MyAuditBundle bundle;
    private MyUser user;

    //##################################################
    //# constructor
    //##################################################

    public MyAuditLogBase()
    {
        super();
        setCreatedUtcTs(nowUtc());
        setUid(newUid());
    }

    //##################################################
    //# field (auditLogTitle)
    //##################################################

    public abstract String getAuditLogTitle();

    public boolean hasAuditLogTitle()
    {
        return Kmu.hasValue(getAuditLogTitle());
    }

    public boolean hasAuditLogTitle(String e)
    {
        return Kmu.isEqualIgnoreCase(getAuditLogTitle(), e);
    }

    //##################################################
    //# field (booleanValue)
    //##################################################

    public Boolean getBooleanValue()
    {
        return booleanValue;
    }

    public void setBooleanValue(Boolean e)
    {
        e = Validator.getBooleanValueValidator().convert(e);
        booleanValue = e;
    }

    public void clearBooleanValue()
    {
        setBooleanValue(null);
    }

    public boolean hasBooleanValue()
    {
        return getBooleanValue() != null;
    }

    public boolean hasBooleanValue(Boolean e)
    {
        return Kmu.isEqual(getBooleanValue(), e);
    }

    public boolean isBooleanValue()
    {
        if ( getBooleanValue() == null )
            return false;
        return getBooleanValue();
    }

    public boolean isBooleanValue(Boolean b)
    {
        return Kmu.isEqual(getBooleanValue(), b);
    }

    public void toggleBooleanValue()
    {
        setBooleanValue(!getBooleanValue());
    }

    //##################################################
    //# field (createdUtcTs)
    //##################################################

    public KmTimestamp getCreatedUtcTs()
    {
        return createdUtcTs;
    }

    public void setCreatedUtcTs(KmTimestamp e)
    {
        e = Validator.getCreatedUtcTsValidator().convert(e);
        createdUtcTs = e;
    }

    public void clearCreatedUtcTs()
    {
        setCreatedUtcTs(null);
    }

    public boolean hasCreatedUtcTs()
    {
        return getCreatedUtcTs() != null;
    }

    public boolean hasCreatedUtcTs(KmTimestamp e)
    {
        return Kmu.isEqual(getCreatedUtcTs(), e);
    }

    //##################################################
    //# field (dateValue)
    //##################################################

    public KmDate getDateValue()
    {
        return dateValue;
    }

    public void setDateValue(KmDate e)
    {
        e = Validator.getDateValueValidator().convert(e);
        dateValue = e;
    }

    public void clearDateValue()
    {
        setDateValue(null);
    }

    public boolean hasDateValue()
    {
        return getDateValue() != null;
    }

    public boolean hasDateValue(KmDate e)
    {
        return Kmu.isEqual(getDateValue(), e);
    }

    //##################################################
    //# field (domainName)
    //##################################################

    public String getDomainName()
    {
        return domainName;
    }

    public void setDomainName(String e)
    {
        e = Validator.getDomainNameValidator().convert(e);
        domainName = e;
    }

    public void clearDomainName()
    {
        setDomainName(null);
    }

    public boolean hasDomainName()
    {
        return Kmu.hasValue(getDomainName());
    }

    public boolean hasDomainName(String e)
    {
        return Kmu.isEqualIgnoreCase(getDomainName(), e);
    }

    public void truncateDomainName()
    {
        truncateDomainName(false);
    }

    public void truncateDomainName(boolean ellipses)
    {
        domainName = Kmu.truncate(domainName, 50, ellipses);
    }

    //##################################################
    //# field (domainSubtitle)
    //##################################################

    public abstract String getDomainSubtitle();

    public boolean hasDomainSubtitle()
    {
        return Kmu.hasValue(getDomainSubtitle());
    }

    public boolean hasDomainSubtitle(String e)
    {
        return Kmu.isEqualIgnoreCase(getDomainSubtitle(), e);
    }

    //##################################################
    //# field (domainTitle)
    //##################################################

    public abstract String getDomainTitle();

    public boolean hasDomainTitle()
    {
        return Kmu.hasValue(getDomainTitle());
    }

    public boolean hasDomainTitle(String e)
    {
        return Kmu.isEqualIgnoreCase(getDomainTitle(), e);
    }

    //##################################################
    //# field (domainType)
    //##################################################

    public String getDomainType()
    {
        return domainType;
    }

    public void setDomainType(String e)
    {
        e = Validator.getDomainTypeValidator().convert(e);
        domainType = e;
    }

    public void clearDomainType()
    {
        setDomainType(null);
    }

    public boolean hasDomainType()
    {
        return Kmu.hasValue(getDomainType());
    }

    public boolean hasDomainType(String e)
    {
        return Kmu.isEqualIgnoreCase(getDomainType(), e);
    }

    public void truncateDomainType()
    {
        truncateDomainType(false);
    }

    public void truncateDomainType(boolean ellipses)
    {
        domainType = Kmu.truncate(domainType, 50, ellipses);
    }

    //##################################################
    //# field (domainTypeLabel)
    //##################################################

    public abstract String getDomainTypeLabel();

    public boolean hasDomainTypeLabel()
    {
        return Kmu.hasValue(getDomainTypeLabel());
    }

    public boolean hasDomainTypeLabel(String e)
    {
        return Kmu.isEqualIgnoreCase(getDomainTypeLabel(), e);
    }

    //##################################################
    //# field (domainUid)
    //##################################################

    public String getDomainUid()
    {
        return domainUid;
    }

    public void setDomainUid(String e)
    {
        e = Validator.getDomainUidValidator().convert(e);
        domainUid = e;
    }

    public void clearDomainUid()
    {
        setDomainUid(null);
    }

    public boolean hasDomainUid()
    {
        return Kmu.hasValue(getDomainUid());
    }

    public boolean hasDomainUid(String e)
    {
        return Kmu.isEqualIgnoreCase(getDomainUid(), e);
    }

    public void truncateDomainUid()
    {
        truncateDomainUid(false);
    }

    public void truncateDomainUid(boolean ellipses)
    {
        domainUid = Kmu.truncate(domainUid, 30, ellipses);
    }

    //##################################################
    //# field (doubleValue)
    //##################################################

    public Double getDoubleValue()
    {
        return doubleValue;
    }

    public void setDoubleValue(Double e)
    {
        e = Validator.getDoubleValueValidator().convert(e);
        doubleValue = e;
    }

    public void clearDoubleValue()
    {
        setDoubleValue(null);
    }

    public boolean hasDoubleValue()
    {
        return getDoubleValue() != null;
    }

    public boolean hasDoubleValue(Double e)
    {
        return Kmu.isEqual(getDoubleValue(), e);
    }

    //##################################################
    //# field (fieldName)
    //##################################################

    public String getFieldName()
    {
        return fieldName;
    }

    public void setFieldName(String e)
    {
        e = Validator.getFieldNameValidator().convert(e);
        fieldName = e;
    }

    public void clearFieldName()
    {
        setFieldName(null);
    }

    public boolean hasFieldName()
    {
        return Kmu.hasValue(getFieldName());
    }

    public boolean hasFieldName(String e)
    {
        return Kmu.isEqualIgnoreCase(getFieldName(), e);
    }

    public void truncateFieldName()
    {
        truncateFieldName(false);
    }

    public void truncateFieldName(boolean ellipses)
    {
        fieldName = Kmu.truncate(fieldName, 50, ellipses);
    }

    //##################################################
    //# field (fieldNameLabel)
    //##################################################

    public abstract String getFieldNameLabel();

    public boolean hasFieldNameLabel()
    {
        return Kmu.hasValue(getFieldNameLabel());
    }

    public boolean hasFieldNameLabel(String e)
    {
        return Kmu.isEqualIgnoreCase(getFieldNameLabel(), e);
    }

    //##################################################
    //# field (integerValue)
    //##################################################

    public Integer getIntegerValue()
    {
        return integerValue;
    }

    public void setIntegerValue(Integer e)
    {
        e = Validator.getIntegerValueValidator().convert(e);
        integerValue = e;
    }

    public void clearIntegerValue()
    {
        setIntegerValue(null);
    }

    public boolean hasIntegerValue()
    {
        return getIntegerValue() != null;
    }

    public boolean hasIntegerValue(Integer e)
    {
        return Kmu.isEqual(getIntegerValue(), e);
    }

    //##################################################
    //# field (longValue)
    //##################################################

    public Long getLongValue()
    {
        return longValue;
    }

    public void setLongValue(Long e)
    {
        e = Validator.getLongValueValidator().convert(e);
        longValue = e;
    }

    public void clearLongValue()
    {
        setLongValue(null);
    }

    public boolean hasLongValue()
    {
        return getLongValue() != null;
    }

    public boolean hasLongValue(Long e)
    {
        return Kmu.isEqual(getLongValue(), e);
    }

    //##################################################
    //# field (moneyValue)
    //##################################################

    public KmMoney getMoneyValue()
    {
        return moneyValue;
    }

    public void setMoneyValue(KmMoney e)
    {
        e = Validator.getMoneyValueValidator().convert(e);
        moneyValue = e;
    }

    public void clearMoneyValue()
    {
        setMoneyValue(null);
    }

    public boolean hasMoneyValue()
    {
        return getMoneyValue() != null;
    }

    public boolean hasMoneyValue(KmMoney e)
    {
        return Kmu.isEqual(getMoneyValue(), e);
    }

    //##################################################
    //# field (newValue)
    //##################################################

    public String getNewValue()
    {
        return newValue;
    }

    public void setNewValue(String e)
    {
        e = Validator.getNewValueValidator().convert(e);
        newValue = e;
    }

    public void clearNewValue()
    {
        setNewValue(null);
    }

    public boolean hasNewValue()
    {
        return Kmu.hasValue(getNewValue());
    }

    public boolean hasNewValue(String e)
    {
        return Kmu.isEqualIgnoreCase(getNewValue(), e);
    }

    public void truncateNewValue()
    {
        truncateNewValue(false);
    }

    public void truncateNewValue(boolean ellipses)
    {
        newValue = Kmu.truncate(newValue, 100, ellipses);
    }

    //##################################################
    //# field (oldValue)
    //##################################################

    public String getOldValue()
    {
        return oldValue;
    }

    public void setOldValue(String e)
    {
        e = Validator.getOldValueValidator().convert(e);
        oldValue = e;
    }

    public void clearOldValue()
    {
        setOldValue(null);
    }

    public boolean hasOldValue()
    {
        return Kmu.hasValue(getOldValue());
    }

    public boolean hasOldValue(String e)
    {
        return Kmu.isEqualIgnoreCase(getOldValue(), e);
    }

    public void truncateOldValue()
    {
        truncateOldValue(false);
    }

    public void truncateOldValue(boolean ellipses)
    {
        oldValue = Kmu.truncate(oldValue, 100, ellipses);
    }

    //##################################################
    //# field (stringValue)
    //##################################################

    public String getStringValue()
    {
        return stringValue;
    }

    public void setStringValue(String e)
    {
        e = Validator.getStringValueValidator().convert(e);
        stringValue = e;
    }

    public void clearStringValue()
    {
        setStringValue(null);
    }

    public boolean hasStringValue()
    {
        return Kmu.hasValue(getStringValue());
    }

    public boolean hasStringValue(String e)
    {
        return Kmu.isEqualIgnoreCase(getStringValue(), e);
    }

    public void truncateStringValue()
    {
        truncateStringValue(false);
    }

    public void truncateStringValue(boolean ellipses)
    {
        stringValue = Kmu.truncate(stringValue, 1000, ellipses);
    }

    //##################################################
    //# field (timestampValue)
    //##################################################

    public KmTimestamp getTimestampValue()
    {
        return timestampValue;
    }

    public void setTimestampValue(KmTimestamp e)
    {
        e = Validator.getTimestampValueValidator().convert(e);
        timestampValue = e;
    }

    public void clearTimestampValue()
    {
        setTimestampValue(null);
    }

    public boolean hasTimestampValue()
    {
        return getTimestampValue() != null;
    }

    public boolean hasTimestampValue(KmTimestamp e)
    {
        return Kmu.isEqual(getTimestampValue(), e);
    }

    //##################################################
    //# field (transactionUid)
    //##################################################

    public String getTransactionUid()
    {
        return transactionUid;
    }

    public void setTransactionUid(String e)
    {
        e = Validator.getTransactionUidValidator().convert(e);
        transactionUid = e;
    }

    public void clearTransactionUid()
    {
        setTransactionUid(null);
    }

    public boolean hasTransactionUid()
    {
        return Kmu.hasValue(getTransactionUid());
    }

    public boolean hasTransactionUid(String e)
    {
        return Kmu.isEqualIgnoreCase(getTransactionUid(), e);
    }

    public void truncateTransactionUid()
    {
        truncateTransactionUid(false);
    }

    public void truncateTransactionUid(boolean ellipses)
    {
        transactionUid = Kmu.truncate(transactionUid, 30, ellipses);
    }

    //##################################################
    //# field (typeCode)
    //##################################################

    public String getTypeCode()
    {
        return typeCode;
    }

    public void setTypeCode(String e)
    {
        e = Validator.getTypeCodeValidator().convert(e);
        typeCode = e;
    }

    public void clearTypeCode()
    {
        setTypeCode(null);
    }

    public boolean hasTypeCode()
    {
        return Kmu.hasValue(getTypeCode());
    }

    public boolean hasTypeCode(String e)
    {
        return Kmu.isEqualIgnoreCase(getTypeCode(), e);
    }

    public void truncateTypeCode()
    {
        truncateTypeCode(false);
    }

    public void truncateTypeCode(boolean ellipses)
    {
        typeCode = Kmu.truncate(typeCode, 30, ellipses);
    }

    public MyAuditLogType getType()
    {
        return MyAuditLogType.findCode(getTypeCode());
    }

    public void setType(MyAuditLogType e)
    {
        if ( e == null )
            setTypeCode(null);
        else
            setTypeCode(e.getCode());
    }

    public boolean hasType()
    {
        return getType() != null;
    }

    public boolean hasType(MyAuditLogType e)
    {
        return getType() == e;
    }

    public void setTypeAdd()
    {
        setType(MyAuditLogType.Add);
    }

    public boolean isTypeAdd()
    {
        return hasType(MyAuditLogType.Add);
    }

    public void setTypeUpdate()
    {
        setType(MyAuditLogType.Update);
    }

    public boolean isTypeUpdate()
    {
        return hasType(MyAuditLogType.Update);
    }

    public void setTypeDelete()
    {
        setType(MyAuditLogType.Delete);
    }

    public boolean isTypeDelete()
    {
        return hasType(MyAuditLogType.Delete);
    }

    //##################################################
    //# field (uid)
    //##################################################

    public String getUid()
    {
        return uid;
    }

    public void setUid(String e)
    {
        e = Validator.getUidValidator().convert(e);
        uid = e;
    }

    public void clearUid()
    {
        setUid(null);
    }

    public boolean hasUid()
    {
        return Kmu.hasValue(getUid());
    }

    public boolean hasUid(String e)
    {
        return Kmu.isEqualIgnoreCase(getUid(), e);
    }

    public void truncateUid()
    {
        truncateUid(false);
    }

    public void truncateUid(boolean ellipses)
    {
        uid = Kmu.truncate(uid, 30, ellipses);
    }

    //##################################################
    //# field (uidValue)
    //##################################################

    public String getUidValue()
    {
        return uidValue;
    }

    public void setUidValue(String e)
    {
        e = Validator.getUidValueValidator().convert(e);
        uidValue = e;
    }

    public void clearUidValue()
    {
        setUidValue(null);
    }

    public boolean hasUidValue()
    {
        return Kmu.hasValue(getUidValue());
    }

    public boolean hasUidValue(String e)
    {
        return Kmu.isEqualIgnoreCase(getUidValue(), e);
    }

    public void truncateUidValue()
    {
        truncateUidValue(false);
    }

    public void truncateUidValue(boolean ellipses)
    {
        uidValue = Kmu.truncate(uidValue, 30, ellipses);
    }

    //##################################################
    //# field (userName)
    //##################################################

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String e)
    {
        e = Validator.getUserNameValidator().convert(e);
        userName = e;
    }

    public void clearUserName()
    {
        setUserName(null);
    }

    public boolean hasUserName()
    {
        return Kmu.hasValue(getUserName());
    }

    public boolean hasUserName(String e)
    {
        return Kmu.isEqualIgnoreCase(getUserName(), e);
    }

    public void truncateUserName()
    {
        truncateUserName(false);
    }

    public void truncateUserName(boolean ellipses)
    {
        userName = Kmu.truncate(userName, 50, ellipses);
    }

    //##################################################
    //# field (typeName)
    //##################################################

    public final String getTypeName()
    {
        return KmEnumIF.getLabelFor(getType());
    }

    public boolean hasTypeName()
    {
        return Kmu.hasValue(getTypeName());
    }

    public boolean hasTypeName(String e)
    {
        return Kmu.isEqualIgnoreCase(getTypeName(), e);
    }

    //##################################################
    //# field (createdLocalTs)
    //##################################################

    public final KmTimestamp getCreatedLocalTs()
    {
        return KmTimestampUtility.toLocal(getCreatedUtcTs());
    }

    public boolean hasCreatedLocalTs()
    {
        return getCreatedLocalTs() != null;
    }

    public boolean hasCreatedLocalTs(KmTimestamp e)
    {
        return Kmu.isEqual(getCreatedLocalTs(), e);
    }

    //##################################################
    //# field (createdLocalTsMessage)
    //##################################################

    public final String getCreatedLocalTsMessage()
    {
        return KmTimestampUtility.formatLocalMessage(getCreatedUtcTs());
    }

    public boolean hasCreatedLocalTsMessage()
    {
        return Kmu.hasValue(getCreatedLocalTsMessage());
    }

    public boolean hasCreatedLocalTsMessage(String e)
    {
        return Kmu.isEqualIgnoreCase(getCreatedLocalTsMessage(), e);
    }

    //##################################################
    //# field (createdLocalDate)
    //##################################################

    public final KmDate getCreatedLocalDate()
    {
        return KmTimestampUtility.getDate(getCreatedLocalTs());
    }

    public boolean hasCreatedLocalDate()
    {
        return getCreatedLocalDate() != null;
    }

    public boolean hasCreatedLocalDate(KmDate e)
    {
        return Kmu.isEqual(getCreatedLocalDate(), e);
    }

    //##################################################
    //# field (createdLocalTime)
    //##################################################

    public final KmTime getCreatedLocalTime()
    {
        return KmTimestampUtility.getTime(getCreatedLocalTs());
    }

    public boolean hasCreatedLocalTime()
    {
        return getCreatedLocalTime() != null;
    }

    public boolean hasCreatedLocalTime(KmTime e)
    {
        return Kmu.isEqual(getCreatedLocalTime(), e);
    }

    //##################################################
    //# bundle
    //##################################################

    public MyAuditBundle getBundle()
    {
        return bundle;
    }

    public void setBundle(MyAuditBundle e)
    {
        bundle = e;
    }

    public void _setBundle(MyAuditBundle e)
    {
        bundle = e;
    }

    public void clearBundle()
    {
        setBundle(null);
    }

    public boolean hasBundle()
    {
        return getBundle() != null;
    }

    public boolean hasBundle(MyAuditBundle e)
    {
        return Kmu.isEqual(getBundle(), e);
    }

    //##################################################
    //# user
    //##################################################

    public MyUser getUser()
    {
        return user;
    }

    public void setUser(MyUser e)
    {
        user = e;
        updateUserName();
    }

    public void _setUser(MyUser e)
    {
        user = e;
    }

    public void clearUser()
    {
        setUser(null);
    }

    public boolean hasUser()
    {
        return getUser() != null;
    }

    public boolean hasUser(MyUser e)
    {
        return Kmu.isEqual(getUser(), e);
    }


    //##################################################
    //# on change
    //##################################################

    protected abstract void updateUserName();

    //##################################################
    //# validate
    //##################################################

    @Override
    protected final MyAuditLogValidator getValidator()
    {
        return Validator;
    }

    @Override
    protected final MyAuditLog asSubclass()
    {
        return (MyAuditLog)this;
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public final MyAuditLog getCopy()
    {
        return (MyAuditLog)super.getCopy();
    }

    @Override
    public void postCopy()
    {
        super.postCopy();
        uid = newUid();
        bundle = null;
    }

    /**
     * Get a copy of this model without any associations or collections.
     * The primary key and lock version are not copied.
     * The basic timestamps are reset.
     */
    public final MyAuditLog getBasicCopy()
    {
        MyAuditLog e;
        e = new MyAuditLog();
        applyEditableFieldsTo(e);
        return e;
    }

    /**
     * Apply the editable fields TO another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsTo(MyAuditLog e)
    {
        e.setBooleanValue(getBooleanValue());
        e.setCreatedUtcTs(getCreatedUtcTs());
        e.setDateValue(getDateValue());
        e.setDomainName(getDomainName());
        e.setDomainType(getDomainType());
        e.setDomainUid(getDomainUid());
        e.setDoubleValue(getDoubleValue());
        e.setFieldName(getFieldName());
        e.setIntegerValue(getIntegerValue());
        e.setLongValue(getLongValue());
        e.setMoneyValue(getMoneyValue());
        e.setNewValue(getNewValue());
        e.setOldValue(getOldValue());
        e.setStringValue(getStringValue());
        e.setTimestampValue(getTimestampValue());
        e.setTransactionUid(getTransactionUid());
        e.setTypeCode(getTypeCode());
        e.setUidValue(getUidValue());
        e.setUserName(getUserName());
    }

    /**
     * Apply the editable fields FROM another model.
     * The primary key and lock version are not applied.
     * Associations and collections are NOT applied.
     */
    public final void applyEditableFieldsFrom(MyAuditLog e)
    {
        setBooleanValue(e.getBooleanValue());
        setCreatedUtcTs(e.getCreatedUtcTs());
        setDateValue(e.getDateValue());
        setDomainName(e.getDomainName());
        setDomainType(e.getDomainType());
        setDomainUid(e.getDomainUid());
        setDoubleValue(e.getDoubleValue());
        setFieldName(e.getFieldName());
        setIntegerValue(e.getIntegerValue());
        setLongValue(e.getLongValue());
        setMoneyValue(e.getMoneyValue());
        setNewValue(e.getNewValue());
        setOldValue(e.getOldValue());
        setStringValue(e.getStringValue());
        setTimestampValue(e.getTimestampValue());
        setTransactionUid(e.getTransactionUid());
        setTypeCode(e.getTypeCode());
        setUidValue(e.getUidValue());
        setUserName(e.getUserName());
    }

    //##################################################
    //# compare
    //##################################################

    @Override
    public boolean equals(Object o)
    {
        if ( !(o instanceof MyAuditLogBase) )
            return false;

        MyAuditLogBase e = (MyAuditLogBase)o;
        return Kmu.isEqual(getUid(), e.getUid());
    }

    @Override
    public int hashCode()
    {
        return Kmu.getHashCode(getUid());
    }

    public boolean isSame(MyAuditLog e)
    {
        if ( !Kmu.isEqual(getUid(), e.getUid()) ) return false;
        return isSameIgnoringKey(e);
    }

    public boolean isSameIgnoringKey(MyAuditLog e)
    {
        if ( !Kmu.isEqual(getAuditLogTitle(), e.getAuditLogTitle()) ) return false;
        if ( !Kmu.isEqual(getBooleanValue(), e.getBooleanValue()) ) return false;
        if ( !Kmu.isEqual(getCreatedUtcTs(), e.getCreatedUtcTs()) ) return false;
        if ( !Kmu.isEqual(getDateValue(), e.getDateValue()) ) return false;
        if ( !Kmu.isEqual(getDomainName(), e.getDomainName()) ) return false;
        if ( !Kmu.isEqual(getDomainSubtitle(), e.getDomainSubtitle()) ) return false;
        if ( !Kmu.isEqual(getDomainTitle(), e.getDomainTitle()) ) return false;
        if ( !Kmu.isEqual(getDomainType(), e.getDomainType()) ) return false;
        if ( !Kmu.isEqual(getDomainTypeLabel(), e.getDomainTypeLabel()) ) return false;
        if ( !Kmu.isEqual(getDomainUid(), e.getDomainUid()) ) return false;
        if ( !Kmu.isEqual(getDoubleValue(), e.getDoubleValue()) ) return false;
        if ( !Kmu.isEqual(getFieldName(), e.getFieldName()) ) return false;
        if ( !Kmu.isEqual(getFieldNameLabel(), e.getFieldNameLabel()) ) return false;
        if ( !Kmu.isEqual(getIntegerValue(), e.getIntegerValue()) ) return false;
        if ( !Kmu.isEqual(getLongValue(), e.getLongValue()) ) return false;
        if ( !Kmu.isEqual(getMoneyValue(), e.getMoneyValue()) ) return false;
        if ( !Kmu.isEqual(getNewValue(), e.getNewValue()) ) return false;
        if ( !Kmu.isEqual(getOldValue(), e.getOldValue()) ) return false;
        if ( !Kmu.isEqual(getStringValue(), e.getStringValue()) ) return false;
        if ( !Kmu.isEqual(getTimestampValue(), e.getTimestampValue()) ) return false;
        if ( !Kmu.isEqual(getTransactionUid(), e.getTransactionUid()) ) return false;
        if ( !Kmu.isEqual(getTypeCode(), e.getTypeCode()) ) return false;
        if ( !Kmu.isEqual(getUidValue(), e.getUidValue()) ) return false;
        if ( !Kmu.isEqual(getUserName(), e.getUserName()) ) return false;
        if ( !Kmu.isEqual(getTypeName(), e.getTypeName()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTs(), e.getCreatedLocalTs()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTsMessage(), e.getCreatedLocalTsMessage()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalDate(), e.getCreatedLocalDate()) ) return false;
        if ( !Kmu.isEqual(getCreatedLocalTime(), e.getCreatedLocalTime()) ) return false;
        return true;
    }

    public boolean isDifferent(MyAuditLog e)
    {
        return !isSame(e);
    }

    public boolean isDifferentIgnoringKey(MyAuditLog e)
    {
        return !isSameIgnoringKey(e);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        StringBuilder out;
        out = new StringBuilder();
        out.append("MyAuditLog");
        out.append("(");
        out.append("Uid=");
        out.append(uid);
        out.append(")");
        return out.toString();
    }

    public void printFields()
    {
        System.out.println(this);
        System.out.println("    BooleanValue = " + booleanValue);
        System.out.println("    CreatedUtcTs = " + createdUtcTs);
        System.out.println("    DateValue = " + dateValue);
        System.out.println("    DomainName = " + domainName);
        System.out.println("    DomainType = " + domainType);
        System.out.println("    DomainUid = " + domainUid);
        System.out.println("    DoubleValue = " + doubleValue);
        System.out.println("    FieldName = " + fieldName);
        System.out.println("    IntegerValue = " + integerValue);
        System.out.println("    LongValue = " + longValue);
        System.out.println("    MoneyValue = " + moneyValue);
        System.out.println("    NewValue = " + newValue);
        System.out.println("    OldValue = " + oldValue);
        System.out.println("    StringValue = " + stringValue);
        System.out.println("    TimestampValue = " + timestampValue);
        System.out.println("    TransactionUid = " + transactionUid);
        System.out.println("    TypeCode = " + typeCode);
        System.out.println("    Uid = " + uid);
        System.out.println("    UidValue = " + uidValue);
        System.out.println("    UserName = " + userName);
    }

    /**
     * Format the primary key fields in a comma separated list.  The format
     * is intended to be suitable for display to users.
     */
    @Override
    public String formatPrimaryKey()
    {
        return uid;
    }


    //##################################################
    //# convenience
    //##################################################

    @Override
    public String getMetaName()
    {
        return Meta.getName();
    }

}
