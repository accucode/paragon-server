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
import com.kodemore.types.*;
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

    private KmBooleanValidator booleanValueValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmDateValidator dateValueValidator;
    private KmStringValidator domainNameValidator;
    private KmStringValidator domainTypeValidator;
    private KmStringValidator domainUidValidator;
    private KmDoubleValidator doubleValueValidator;
    private KmStringValidator fieldNameValidator;
    private KmIntegerValidator integerValueValidator;
    private KmLongValidator longValueValidator;
    private KmMoneyValidator moneyValueValidator;
    private KmStringValidator newValueValidator;
    private KmStringValidator oldValueValidator;
    private KmStringValidator stringValueValidator;
    private KmTimestampValidator timestampValueValidator;
    private KmStringValidator transactionUidValidator;
    private KmStringValidator typeCodeValidator;
    private KmStringValidator uidValidator;
    private KmStringValidator uidValueValidator;
    private KmStringValidator userNameValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyAuditLogValidatorBase()
    {
        super();
        booleanValueValidator = newBooleanValueValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        dateValueValidator = newDateValueValidator();
        domainNameValidator = newDomainNameValidator();
        domainTypeValidator = newDomainTypeValidator();
        domainUidValidator = newDomainUidValidator();
        doubleValueValidator = newDoubleValueValidator();
        fieldNameValidator = newFieldNameValidator();
        integerValueValidator = newIntegerValueValidator();
        longValueValidator = newLongValueValidator();
        moneyValueValidator = newMoneyValueValidator();
        newValueValidator = newNewValueValidator();
        oldValueValidator = newOldValueValidator();
        stringValueValidator = newStringValueValidator();
        timestampValueValidator = newTimestampValueValidator();
        transactionUidValidator = newTransactionUidValidator();
        typeCodeValidator = newTypeCodeValidator();
        uidValidator = newUidValidator();
        uidValueValidator = newUidValueValidator();
        userNameValidator = newUserNameValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmBooleanValidator getBooleanValueValidator()
    {
        return booleanValueValidator;
    }

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmDateValidator getDateValueValidator()
    {
        return dateValueValidator;
    }

    public KmStringValidator getDomainNameValidator()
    {
        return domainNameValidator;
    }

    public KmStringValidator getDomainTypeValidator()
    {
        return domainTypeValidator;
    }

    public KmStringValidator getDomainUidValidator()
    {
        return domainUidValidator;
    }

    public KmDoubleValidator getDoubleValueValidator()
    {
        return doubleValueValidator;
    }

    public KmStringValidator getFieldNameValidator()
    {
        return fieldNameValidator;
    }

    public KmIntegerValidator getIntegerValueValidator()
    {
        return integerValueValidator;
    }

    public KmLongValidator getLongValueValidator()
    {
        return longValueValidator;
    }

    public KmMoneyValidator getMoneyValueValidator()
    {
        return moneyValueValidator;
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

    public KmTimestampValidator getTimestampValueValidator()
    {
        return timestampValueValidator;
    }

    public KmStringValidator getTransactionUidValidator()
    {
        return transactionUidValidator;
    }

    public KmStringValidator getTypeCodeValidator()
    {
        return typeCodeValidator;
    }

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmStringValidator getUidValueValidator()
    {
        return uidValueValidator;
    }

    public KmStringValidator getUserNameValidator()
    {
        return userNameValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyAuditLog value)
    {
        // fields...
        value.setBooleanValue(booleanValueValidator.convert(value.getBooleanValue()));
        value.setCreatedUtcTs(createdUtcTsValidator.convert(value.getCreatedUtcTs()));
        value.setDateValue(dateValueValidator.convert(value.getDateValue()));
        value.setDomainName(domainNameValidator.convert(value.getDomainName()));
        value.setDomainType(domainTypeValidator.convert(value.getDomainType()));
        value.setDomainUid(domainUidValidator.convert(value.getDomainUid()));
        value.setDoubleValue(doubleValueValidator.convert(value.getDoubleValue()));
        value.setFieldName(fieldNameValidator.convert(value.getFieldName()));
        value.setIntegerValue(integerValueValidator.convert(value.getIntegerValue()));
        value.setLongValue(longValueValidator.convert(value.getLongValue()));
        value.setMoneyValue(moneyValueValidator.convert(value.getMoneyValue()));
        value.setNewValue(newValueValidator.convert(value.getNewValue()));
        value.setOldValue(oldValueValidator.convert(value.getOldValue()));
        value.setStringValue(stringValueValidator.convert(value.getStringValue()));
        value.setTimestampValue(timestampValueValidator.convert(value.getTimestampValue()));
        value.setTransactionUid(transactionUidValidator.convert(value.getTransactionUid()));
        value.setTypeCode(typeCodeValidator.convert(value.getTypeCode()));
        value.setUid(uidValidator.convert(value.getUid()));
        value.setUidValue(uidValueValidator.convert(value.getUidValue()));
        value.setUserName(userNameValidator.convert(value.getUserName()));
    }

    @Override
    public void validateOnly(MyAuditLog value, KmErrorList errors)
    {
        // fields...
        booleanValueValidator.validateOn(value.getBooleanValue(), errors);
        createdUtcTsValidator.validateOn(value.getCreatedUtcTs(), errors);
        dateValueValidator.validateOn(value.getDateValue(), errors);
        domainNameValidator.validateOn(value.getDomainName(), errors);
        domainTypeValidator.validateOn(value.getDomainType(), errors);
        domainUidValidator.validateOn(value.getDomainUid(), errors);
        doubleValueValidator.validateOn(value.getDoubleValue(), errors);
        fieldNameValidator.validateOn(value.getFieldName(), errors);
        integerValueValidator.validateOn(value.getIntegerValue(), errors);
        longValueValidator.validateOn(value.getLongValue(), errors);
        moneyValueValidator.validateOn(value.getMoneyValue(), errors);
        newValueValidator.validateOn(value.getNewValue(), errors);
        oldValueValidator.validateOn(value.getOldValue(), errors);
        stringValueValidator.validateOn(value.getStringValue(), errors);
        timestampValueValidator.validateOn(value.getTimestampValue(), errors);
        transactionUidValidator.validateOn(value.getTransactionUid(), errors);
        typeCodeValidator.validateOn(value.getTypeCode(), errors);
        uidValidator.validateOn(value.getUid(), errors);
        uidValueValidator.validateOn(value.getUidValue(), errors);
        userNameValidator.validateOn(value.getUserName(), errors);
        // required associations...
        if ( !value.hasBundle() )
            errors.addRequiredField("auditLog", "bundle");
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmBooleanValidator newBooleanValueValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModelName("auditLog");
        e.setFieldName("booleanValue");
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("auditLog");
        e.setFieldName("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmDateValidator newDateValueValidator()
    {
        KmDateValidator e;
        e = new KmDateValidator();
        e.setModelName("auditLog");
        e.setFieldName("dateValue");
        return e;
    }

    public KmStringValidator newDomainNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("auditLog");
        e.setFieldName("domainName");
        e.setRequired();
        return e;
    }

    public KmStringValidator newDomainTypeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("auditLog");
        e.setFieldName("domainType");
        e.setRequired();
        return e;
    }

    public KmStringValidator newDomainUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("auditLog");
        e.setFieldName("domainUid");
        e.setRequired();
        return e;
    }

    public KmDoubleValidator newDoubleValueValidator()
    {
        KmDoubleValidator e;
        e = new KmDoubleValidator();
        e.setAllDigits(8);
        e.setRightDigits(2);
        e.setModelName("auditLog");
        e.setFieldName("doubleValue");
        return e;
    }

    public KmStringValidator newFieldNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("auditLog");
        e.setFieldName("fieldName");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newIntegerValueValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("auditLog");
        e.setFieldName("integerValue");
        return e;
    }

    public KmLongValidator newLongValueValidator()
    {
        KmLongValidator e;
        e = new KmLongValidator();
        e.setModelName("auditLog");
        e.setFieldName("longValue");
        return e;
    }

    public KmMoneyValidator newMoneyValueValidator()
    {
        KmMoneyValidator e;
        e = new KmMoneyValidator();
        e.setModelName("auditLog");
        e.setFieldName("moneyValue");
        return e;
    }

    public KmStringValidator newNewValueValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setAllowsWhitespace(true);
        e.setModelName("auditLog");
        e.setFieldName("newValue");
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
        e.setModelName("auditLog");
        e.setFieldName("oldValue");
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
        e.setModelName("auditLog");
        e.setFieldName("stringValue");
        return e;
    }

    public KmTimestampValidator newTimestampValueValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("auditLog");
        e.setFieldName("timestampValue");
        return e;
    }

    public KmStringValidator newTransactionUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("auditLog");
        e.setFieldName("transactionUid");
        e.setRequired();
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
        e.setModelName("auditLog");
        e.setFieldName("typeCode");
        e.setRequired();
        return e;
    }

    public KmStringValidator newUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("auditLog");
        e.setFieldName("uid");
        e.setRequired();
        return e;
    }

    public KmStringValidator newUidValueValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("auditLog");
        e.setFieldName("uidValue");
        return e;
    }

    public KmStringValidator newUserNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("auditLog");
        e.setFieldName("userName");
        return e;
    }


}

