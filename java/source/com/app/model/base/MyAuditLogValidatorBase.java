//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.kodemore.collection.*;
import com.kodemore.exception.*;
import com.kodemore.exception.error.*;
import com.kodemore.time.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.model.*;
import com.app.model.core.*;
import com.app.utility.*;

/**
 * Validation rules for auditLog.
 */
public class MyAuditLogValidatorBase
    extends MyDomainValidator<MyAuditLog>
{
    //##################################################
    //# static
    //##################################################

    public static final MyAuditLogValidator instance = new MyAuditLogValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator uidValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmStringValidator transactionUidValidator;
    private KmStringValidator userNameValidator;
    private KmStringValidator typeCodeValidator;
    private KmStringValidator domainTypeValidator;
    private KmStringValidator domainNameValidator;
    private KmStringValidator domainUidValidator;
    private KmStringValidator domainBundleUidValidator;
    private KmStringValidator fieldNameValidator;
    private KmStringValidator newValueValidator;
    private KmStringValidator oldValueValidator;
    private KmStringValidator stringValueValidator;
    private KmIntegerValidator integerValueValidator;
    private KmLongValidator longValueValidator;
    private KmDoubleValidator doubleValueValidator;
    private KmMoneyValidator moneyValueValidator;
    private KmBooleanValidator booleanValueValidator;
    private KmDateValidator dateValueValidator;
    private KmTimestampValidator timestampValueValidator;
    private KmStringValidator uidValueValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyAuditLogValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        transactionUidValidator = newTransactionUidValidator();
        userNameValidator = newUserNameValidator();
        typeCodeValidator = newTypeCodeValidator();
        domainTypeValidator = newDomainTypeValidator();
        domainNameValidator = newDomainNameValidator();
        domainUidValidator = newDomainUidValidator();
        domainBundleUidValidator = newDomainBundleUidValidator();
        fieldNameValidator = newFieldNameValidator();
        newValueValidator = newNewValueValidator();
        oldValueValidator = newOldValueValidator();
        stringValueValidator = newStringValueValidator();
        integerValueValidator = newIntegerValueValidator();
        longValueValidator = newLongValueValidator();
        doubleValueValidator = newDoubleValueValidator();
        moneyValueValidator = newMoneyValueValidator();
        booleanValueValidator = newBooleanValueValidator();
        dateValueValidator = newDateValueValidator();
        timestampValueValidator = newTimestampValueValidator();
        uidValueValidator = newUidValueValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmStringValidator getTransactionUidValidator()
    {
        return transactionUidValidator;
    }

    public KmStringValidator getUserNameValidator()
    {
        return userNameValidator;
    }

    public KmStringValidator getTypeCodeValidator()
    {
        return typeCodeValidator;
    }

    public KmStringValidator getDomainTypeValidator()
    {
        return domainTypeValidator;
    }

    public KmStringValidator getDomainNameValidator()
    {
        return domainNameValidator;
    }

    public KmStringValidator getDomainUidValidator()
    {
        return domainUidValidator;
    }

    public KmStringValidator getDomainBundleUidValidator()
    {
        return domainBundleUidValidator;
    }

    public KmStringValidator getFieldNameValidator()
    {
        return fieldNameValidator;
    }

    public KmStringValidator getNewValueValidator()
    {
        return newValueValidator;
    }

    public KmStringValidator getOldValueValidator()
    {
        return oldValueValidator;
    }

    public KmStringValidator getStringValueValidator()
    {
        return stringValueValidator;
    }

    public KmIntegerValidator getIntegerValueValidator()
    {
        return integerValueValidator;
    }

    public KmLongValidator getLongValueValidator()
    {
        return longValueValidator;
    }

    public KmDoubleValidator getDoubleValueValidator()
    {
        return doubleValueValidator;
    }

    public KmMoneyValidator getMoneyValueValidator()
    {
        return moneyValueValidator;
    }

    public KmBooleanValidator getBooleanValueValidator()
    {
        return booleanValueValidator;
    }

    public KmDateValidator getDateValueValidator()
    {
        return dateValueValidator;
    }

    public KmTimestampValidator getTimestampValueValidator()
    {
        return timestampValueValidator;
    }

    public KmStringValidator getUidValueValidator()
    {
        return uidValueValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyAuditLog value)
    {
        // fields...
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setCreatedUtcTs(createdUtcTsValidator.convertOnly(value.getCreatedUtcTs()));
        value.setTransactionUid(transactionUidValidator.convertOnly(value.getTransactionUid()));
        value.setUserName(userNameValidator.convertOnly(value.getUserName()));
        value.setTypeCode(typeCodeValidator.convertOnly(value.getTypeCode()));
        value.setDomainType(domainTypeValidator.convertOnly(value.getDomainType()));
        value.setDomainName(domainNameValidator.convertOnly(value.getDomainName()));
        value.setDomainUid(domainUidValidator.convertOnly(value.getDomainUid()));
        value.setDomainBundleUid(domainBundleUidValidator.convertOnly(value.getDomainBundleUid()));
        value.setFieldName(fieldNameValidator.convertOnly(value.getFieldName()));
        value.setNewValue(newValueValidator.convertOnly(value.getNewValue()));
        value.setOldValue(oldValueValidator.convertOnly(value.getOldValue()));
        value.setStringValue(stringValueValidator.convertOnly(value.getStringValue()));
        value.setIntegerValue(integerValueValidator.convertOnly(value.getIntegerValue()));
        value.setLongValue(longValueValidator.convertOnly(value.getLongValue()));
        value.setDoubleValue(doubleValueValidator.convertOnly(value.getDoubleValue()));
        value.setMoneyValue(moneyValueValidator.convertOnly(value.getMoneyValue()));
        value.setBooleanValue(booleanValueValidator.convertOnly(value.getBooleanValue()));
        value.setDateValue(dateValueValidator.convertOnly(value.getDateValue()));
        value.setTimestampValue(timestampValueValidator.convertOnly(value.getTimestampValue()));
        value.setUidValue(uidValueValidator.convertOnly(value.getUidValue()));
    }

    @Override
    public void validateOnly(MyAuditLog value, KmList<KmErrorIF> errors)
    {
        // fields...
        uidValidator.validateOnly(value.getUid(), errors);
        createdUtcTsValidator.validateOnly(value.getCreatedUtcTs(), errors);
        transactionUidValidator.validateOnly(value.getTransactionUid(), errors);
        userNameValidator.validateOnly(value.getUserName(), errors);
        typeCodeValidator.validateOnly(value.getTypeCode(), errors);
        domainTypeValidator.validateOnly(value.getDomainType(), errors);
        domainNameValidator.validateOnly(value.getDomainName(), errors);
        domainUidValidator.validateOnly(value.getDomainUid(), errors);
        domainBundleUidValidator.validateOnly(value.getDomainBundleUid(), errors);
        fieldNameValidator.validateOnly(value.getFieldName(), errors);
        newValueValidator.validateOnly(value.getNewValue(), errors);
        oldValueValidator.validateOnly(value.getOldValue(), errors);
        stringValueValidator.validateOnly(value.getStringValue(), errors);
        integerValueValidator.validateOnly(value.getIntegerValue(), errors);
        longValueValidator.validateOnly(value.getLongValue(), errors);
        doubleValueValidator.validateOnly(value.getDoubleValue(), errors);
        moneyValueValidator.validateOnly(value.getMoneyValue(), errors);
        booleanValueValidator.validateOnly(value.getBooleanValue(), errors);
        dateValueValidator.validateOnly(value.getDateValue(), errors);
        timestampValueValidator.validateOnly(value.getTimestampValue(), errors);
        uidValueValidator.validateOnly(value.getUidValue(), errors);
        // required associations...
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmStringValidator newUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModel("auditLog");
        e.setField("uid");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("auditLog");
        e.setField("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmStringValidator newTransactionUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModel("auditLog");
        e.setField("transactionUid");
        e.setRequired();
        return e;
    }

    public KmStringValidator newUserNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("auditLog");
        e.setField("userName");
        return e;
    }

    public KmStringValidator newTypeCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModel("auditLog");
        e.setField("typeCode");
        e.setRequired();
        return e;
    }

    public KmStringValidator newDomainTypeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("auditLog");
        e.setField("domainType");
        e.setRequired();
        return e;
    }

    public KmStringValidator newDomainNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("auditLog");
        e.setField("domainName");
        e.setRequired();
        return e;
    }

    public KmStringValidator newDomainUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModel("auditLog");
        e.setField("domainUid");
        e.setRequired();
        return e;
    }

    public KmStringValidator newDomainBundleUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModel("auditLog");
        e.setField("domainBundleUid");
        e.setRequired();
        return e;
    }

    public KmStringValidator newFieldNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("auditLog");
        e.setField("fieldName");
        e.setRequired();
        return e;
    }

    public KmStringValidator newNewValueValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setAllowsWhitespace(true);
        e.setModel("auditLog");
        e.setField("newValue");
        e.setRequired();
        return e;
    }

    public KmStringValidator newOldValueValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setAllowsWhitespace(true);
        e.setModel("auditLog");
        e.setField("oldValue");
        e.setRequired();
        return e;
    }

    public KmStringValidator newStringValueValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(1000);
        e.setAllowsPrintable(true);
        e.setAllowsWhitespace(true);
        e.setModel("auditLog");
        e.setField("stringValue");
        return e;
    }

    public KmIntegerValidator newIntegerValueValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("auditLog");
        e.setField("integerValue");
        return e;
    }

    public KmLongValidator newLongValueValidator()
    {
        KmLongValidator e;
        e = new KmLongValidator();
        e.setModel("auditLog");
        e.setField("longValue");
        return e;
    }

    public KmDoubleValidator newDoubleValueValidator()
    {
        KmDoubleValidator e;
        e = new KmDoubleValidator();
        e.setAllDigits(8);
        e.setRightDigits(2);
        e.setModel("auditLog");
        e.setField("doubleValue");
        return e;
    }

    public KmMoneyValidator newMoneyValueValidator()
    {
        KmMoneyValidator e;
        e = new KmMoneyValidator();
        e.setModel("auditLog");
        e.setField("moneyValue");
        return e;
    }

    public KmBooleanValidator newBooleanValueValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModel("auditLog");
        e.setField("booleanValue");
        return e;
    }

    public KmDateValidator newDateValueValidator()
    {
        KmDateValidator e;
        e = new KmDateValidator();
        e.setModel("auditLog");
        e.setField("dateValue");
        return e;
    }

    public KmTimestampValidator newTimestampValueValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("auditLog");
        e.setField("timestampValue");
        return e;
    }

    public KmStringValidator newUidValueValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModel("auditLog");
        e.setField("uidValue");
        return e;
    }


}

