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
import com.kodemore.exception.*;
import com.kodemore.servlet.encoder.*;
import com.kodemore.servlet.utility.*;
import com.kodemore.time.*;
import com.kodemore.types.*;
import com.kodemore.utility.*;

import com.app.model.*;
import com.app.model.core.*;
import com.app.model.meta.*;
import com.app.utility.*;

public abstract class MyAuditLogBase
    extends MyAbstractDomain
    implements MyDomainIF
{
    //##################################################
    //# static
    //##################################################

    public static final MyMetaAuditLog Meta = MyMetaAuditLog.instance;
    public static final MyAuditLogTools Tools = MyAuditLogTools.instance;
    public static final MyAuditLogValidator Validator = MyAuditLogValidator.instance;

    //##################################################
    //# variables
    //##################################################

    private String uid;
    private String transactionUid;
    private String userName;
    private String typeCode;
    private KmTimestamp utcTs;
    private String modelName;
    private String modelUid;
    private String fieldName;
    private String newValue;
    private String oldValue;
    private String stringValue;
    private Integer integerValue;
    private Long longValue;
    private Double doubleValue;
    private KmMoney moneyValue;
    private Boolean booleanValue;
    private KmDate dateValue;
    private KmTimestamp timestampValue;
    private String uidValue;
    private MyUser user;

    //##################################################
    //# constructor
    //##################################################

    public MyAuditLogBase()
    {
        super();
        setUid(newUid());
        setUtcTs(getNowUtc());
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
        checkReadOnly();
        e = Validator.getUidValidator().convertOnly(e);
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
    //# field (transactionUid)
    //##################################################

    public String getTransactionUid()
    {
        return transactionUid;
    }

    public void setTransactionUid(String e)
    {
        checkReadOnly();
        e = Validator.getTransactionUidValidator().convertOnly(e);
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
    //# field (userName)
    //##################################################

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String e)
    {
        checkReadOnly();
        e = Validator.getUserNameValidator().convertOnly(e);
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
    //# field (typeCode)
    //##################################################

    public String getTypeCode()
    {
        return typeCode;
    }

    public void setTypeCode(String e)
    {
        checkReadOnly();
        e = Validator.getTypeCodeValidator().convertOnly(e);
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
        typeCode = Kmu.truncate(typeCode, 1, ellipses);
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

    public boolean isNotTypeAdd()
    {
        return !isTypeAdd();
    }

    public void setTypeUpdate()
    {
        setType(MyAuditLogType.Update);
    }

    public boolean isTypeUpdate()
    {
        return hasType(MyAuditLogType.Update);
    }

    public boolean isNotTypeUpdate()
    {
        return !isTypeUpdate();
    }

    public void setTypeDelete()
    {
        setType(MyAuditLogType.Delete);
    }

    public boolean isTypeDelete()
    {
        return hasType(MyAuditLogType.Delete);
    }

    public boolean isNotTypeDelete()
    {
        return !isTypeDelete();
    }

    //##################################################
    //# field (utcTs)
    //##################################################

    public KmTimestamp getUtcTs()
    {
        return utcTs;
    }

    public void setUtcTs(KmTimestamp e)
    {
        checkReadOnly();
        e = Validator.getUtcTsValidator().convertOnly(e);
        utcTs = e;
    }

    public void clearUtcTs()
    {
        setUtcTs(null);
    }

    public boolean hasUtcTs()
    {
        return getUtcTs() != null;
    }

    public boolean hasUtcTs(KmTimestamp e)
    {
        return Kmu.isEqual(getUtcTs(), e);
    }

    //##################################################
    //# field (modelName)
    //##################################################

    public String getModelName()
    {
        return modelName;
    }

    public void setModelName(String e)
    {
        checkReadOnly();
        e = Validator.getModelNameValidator().convertOnly(e);
        modelName = e;
    }

    public void clearModelName()
    {
        setModelName(null);
    }

    public boolean hasModelName()
    {
        return Kmu.hasValue(getModelName());
    }

    public boolean hasModelName(String e)
    {
        return Kmu.isEqualIgnoreCase(getModelName(), e);
    }

    public void truncateModelName()
    {
        truncateModelName(false);
    }

    public void truncateModelName(boolean ellipses)
    {
        modelName = Kmu.truncate(modelName, 50, ellipses);
    }

    //##################################################
    //# field (modelUid)
    //##################################################

    public String getModelUid()
    {
        return modelUid;
    }

    public void setModelUid(String e)
    {
        checkReadOnly();
        e = Validator.getModelUidValidator().convertOnly(e);
        modelUid = e;
    }

    public void clearModelUid()
    {
        setModelUid(null);
    }

    public boolean hasModelUid()
    {
        return Kmu.hasValue(getModelUid());
    }

    public boolean hasModelUid(String e)
    {
        return Kmu.isEqualIgnoreCase(getModelUid(), e);
    }

    public void truncateModelUid()
    {
        truncateModelUid(false);
    }

    public void truncateModelUid(boolean ellipses)
    {
        modelUid = Kmu.truncate(modelUid, 30, ellipses);
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
        checkReadOnly();
        e = Validator.getFieldNameValidator().convertOnly(e);
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
    //# field (newValue)
    //##################################################

    public String getNewValue()
    {
        return newValue;
    }

    public void setNewValue(String e)
    {
        checkReadOnly();
        e = Validator.getNewValueValidator().convertOnly(e);
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
        newValue = Kmu.truncate(newValue, 50, ellipses);
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
        checkReadOnly();
        e = Validator.getOldValueValidator().convertOnly(e);
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
        oldValue = Kmu.truncate(oldValue, 50, ellipses);
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
        checkReadOnly();
        e = Validator.getStringValueValidator().convertOnly(e);
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
    //# field (integerValue)
    //##################################################

    public Integer getIntegerValue()
    {
        return integerValue;
    }

    public void setIntegerValue(Integer e)
    {
        checkReadOnly();
        e = Validator.getIntegerValueValidator().convertOnly(e);
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
        checkReadOnly();
        e = Validator.getLongValueValidator().convertOnly(e);
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
    //# field (doubleValue)
    //##################################################

    public Double getDoubleValue()
    {
        return doubleValue;
    }

    public void setDoubleValue(Double e)
    {
        checkReadOnly();
        e = Validator.getDoubleValueValidator().convertOnly(e);
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
    //# field (moneyValue)
    //##################################################

    public KmMoney getMoneyValue()
    {
        return moneyValue;
    }

    public void setMoneyValue(KmMoney e)
    {
        checkReadOnly();
        e = Validator.getMoneyValueValidator().convertOnly(e);
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
    //# field (booleanValue)
    //##################################################

    public Boolean getBooleanValue()
    {
        return booleanValue;
    }

    public void setBooleanValue(Boolean e)
    {
        checkReadOnly();
        e = Validator.getBooleanValueValidator().convertOnly(e);
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

    public boolean isNotBooleanValue()
    {
        return !isBooleanValue();
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
    //# field (dateValue)
    //##################################################

    public KmDate getDateValue()
    {
        return dateValue;
    }

    public void setDateValue(KmDate e)
    {
        checkReadOnly();
        e = Validator.getDateValueValidator().convertOnly(e);
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
    //# field (timestampValue)
    //##################################################

    public KmTimestamp getTimestampValue()
    {
        return timestampValue;
    }

    public void setTimestampValue(KmTimestamp e)
    {
        checkReadOnly();
        e = Validator.getTimestampValueValidator().convertOnly(e);
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
    //# field (uidValue)
    //##################################################

    public String getUidValue()
    {
        return uidValue;
    }

    public void setUidValue(String e)
    {
        checkReadOnly();
        e = Validator.getUidValueValidator().convertOnly(e);
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
    //# field (typeName)
    //##################################################

    public final String getTypeName()
    {
        return Kmu.getName(getType());
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
    //# user
    //##################################################

    public MyUser getUser()
    {
        return user;
    }

    public void setUser(MyUser e)
    {
        checkReadOnly();
        user = e;
        updateUserName();
    }

    public void _setUser(MyUser e)
    {
        checkReadOnly();
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
    public void validate()
    {
        Validator.validate((MyAuditLog)this);
    }

    @Override
    public void validateWarn()
    {
        Validator.validateWarn((MyAuditLog)this);
    }

    public boolean isValid()
    {
        return Validator.isValid((MyAuditLog)this);
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
        uid = null;
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
        if ( !Kmu.isEqual(getTransactionUid(), e.getTransactionUid()) ) return false;
        if ( !Kmu.isEqual(getUserName(), e.getUserName()) ) return false;
        if ( !Kmu.isEqual(getTypeCode(), e.getTypeCode()) ) return false;
        if ( !Kmu.isEqual(getUtcTs(), e.getUtcTs()) ) return false;
        if ( !Kmu.isEqual(getModelName(), e.getModelName()) ) return false;
        if ( !Kmu.isEqual(getModelUid(), e.getModelUid()) ) return false;
        if ( !Kmu.isEqual(getFieldName(), e.getFieldName()) ) return false;
        if ( !Kmu.isEqual(getNewValue(), e.getNewValue()) ) return false;
        if ( !Kmu.isEqual(getOldValue(), e.getOldValue()) ) return false;
        if ( !Kmu.isEqual(getStringValue(), e.getStringValue()) ) return false;
        if ( !Kmu.isEqual(getIntegerValue(), e.getIntegerValue()) ) return false;
        if ( !Kmu.isEqual(getLongValue(), e.getLongValue()) ) return false;
        if ( !Kmu.isEqual(getDoubleValue(), e.getDoubleValue()) ) return false;
        if ( !Kmu.isEqual(getMoneyValue(), e.getMoneyValue()) ) return false;
        if ( !Kmu.isEqual(getBooleanValue(), e.getBooleanValue()) ) return false;
        if ( !Kmu.isEqual(getDateValue(), e.getDateValue()) ) return false;
        if ( !Kmu.isEqual(getTimestampValue(), e.getTimestampValue()) ) return false;
        if ( !Kmu.isEqual(getUidValue(), e.getUidValue()) ) return false;
        if ( !Kmu.isEqual(getTypeName(), e.getTypeName()) ) return false;
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
        System.out.println("    Uid = " + uid);
        System.out.println("    TransactionUid = " + transactionUid);
        System.out.println("    UserName = " + userName);
        System.out.println("    TypeCode = " + typeCode);
        System.out.println("    UtcTs = " + utcTs);
        System.out.println("    ModelName = " + modelName);
        System.out.println("    ModelUid = " + modelUid);
        System.out.println("    FieldName = " + fieldName);
        System.out.println("    NewValue = " + newValue);
        System.out.println("    OldValue = " + oldValue);
        System.out.println("    StringValue = " + stringValue);
        System.out.println("    IntegerValue = " + integerValue);
        System.out.println("    LongValue = " + longValue);
        System.out.println("    DoubleValue = " + doubleValue);
        System.out.println("    MoneyValue = " + moneyValue);
        System.out.println("    BooleanValue = " + booleanValue);
        System.out.println("    DateValue = " + dateValue);
        System.out.println("    TimestampValue = " + timestampValue);
        System.out.println("    UidValue = " + uidValue);
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
