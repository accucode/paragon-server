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
 * Validation rules for auditBundle.
 */
public class MyAuditBundleValidatorBase
    extends MyDomainValidator<MyAuditBundle>
{
    //##################################################
    //# static
    //##################################################

    public static final MyAuditBundleValidator instance = new MyAuditBundleValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator changeTypeCodeValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmStringValidator domainNameValidator;
    private KmStringValidator domainTypeValidator;
    private KmStringValidator domainUidValidator;
    private KmStringValidator transactionUidValidator;
    private KmStringValidator uidValidator;
    private KmStringValidator userNameValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyAuditBundleValidatorBase()
    {
        super();
        changeTypeCodeValidator = newChangeTypeCodeValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        domainNameValidator = newDomainNameValidator();
        domainTypeValidator = newDomainTypeValidator();
        domainUidValidator = newDomainUidValidator();
        transactionUidValidator = newTransactionUidValidator();
        uidValidator = newUidValidator();
        userNameValidator = newUserNameValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getChangeTypeCodeValidator()
    {
        return changeTypeCodeValidator;
    }

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
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

    public KmStringValidator getTransactionUidValidator()
    {
        return transactionUidValidator;
    }

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmStringValidator getUserNameValidator()
    {
        return userNameValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyAuditBundle value)
    {
        // fields...
        value.setChangeTypeCode(changeTypeCodeValidator.convert(value.getChangeTypeCode()));
        value.setCreatedUtcTs(createdUtcTsValidator.convert(value.getCreatedUtcTs()));
        value.setDomainName(domainNameValidator.convert(value.getDomainName()));
        value.setDomainType(domainTypeValidator.convert(value.getDomainType()));
        value.setDomainUid(domainUidValidator.convert(value.getDomainUid()));
        value.setTransactionUid(transactionUidValidator.convert(value.getTransactionUid()));
        value.setUid(uidValidator.convert(value.getUid()));
        value.setUserName(userNameValidator.convert(value.getUserName()));
    }

    @Override
    public void validateOnly(MyAuditBundle value, KmErrorList errors)
    {
        // fields...
        changeTypeCodeValidator.validateOn(value.getChangeTypeCode(), errors);
        createdUtcTsValidator.validateOn(value.getCreatedUtcTs(), errors);
        domainNameValidator.validateOn(value.getDomainName(), errors);
        domainTypeValidator.validateOn(value.getDomainType(), errors);
        domainUidValidator.validateOn(value.getDomainUid(), errors);
        transactionUidValidator.validateOn(value.getTransactionUid(), errors);
        uidValidator.validateOn(value.getUid(), errors);
        userNameValidator.validateOn(value.getUserName(), errors);
        // required associations...
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmStringValidator newChangeTypeCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModelName("auditBundle");
        e.setFieldName("changeTypeCode");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("auditBundle");
        e.setFieldName("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmStringValidator newDomainNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("auditBundle");
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
        e.setModelName("auditBundle");
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
        e.setModelName("auditBundle");
        e.setFieldName("domainUid");
        e.setRequired();
        return e;
    }

    public KmStringValidator newTransactionUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("auditBundle");
        e.setFieldName("transactionUid");
        e.setRequired();
        return e;
    }

    public KmStringValidator newUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("auditBundle");
        e.setFieldName("uid");
        e.setRequired();
        return e;
    }

    public KmStringValidator newUserNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("auditBundle");
        e.setFieldName("userName");
        return e;
    }


}

