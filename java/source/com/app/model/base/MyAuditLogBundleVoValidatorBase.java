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
 * Validation rules for auditLogBundleVo.
 */
public class MyAuditLogBundleVoValidatorBase
    extends MyDomainValidator<MyAuditLogBundleVo>
{
    //##################################################
    //# static
    //##################################################

    public static final MyAuditLogBundleVoValidator instance = new MyAuditLogBundleVoValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator transactionUidValidator;
    private KmStringValidator userNameValidator;
    private KmStringValidator typeCodeValidator;
    private KmTimestampValidator logUtcTsValidator;
    private KmStringValidator domainTypeValidator;
    private KmStringValidator domainNameValidator;
    private KmStringValidator domainUidValidator;
    private KmStringValidator domainBundleUidValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyAuditLogBundleVoValidatorBase()
    {
        super();
        transactionUidValidator = newTransactionUidValidator();
        userNameValidator = newUserNameValidator();
        typeCodeValidator = newTypeCodeValidator();
        logUtcTsValidator = newLogUtcTsValidator();
        domainTypeValidator = newDomainTypeValidator();
        domainNameValidator = newDomainNameValidator();
        domainUidValidator = newDomainUidValidator();
        domainBundleUidValidator = newDomainBundleUidValidator();
    }

    //##################################################
    //# accessing
    //##################################################

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

    public KmTimestampValidator getLogUtcTsValidator()
    {
        return logUtcTsValidator;
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

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyAuditLogBundleVo value)
    {
        // fields...
        value.setTransactionUid(transactionUidValidator.convertOnly(value.getTransactionUid()));
        value.setUserName(userNameValidator.convertOnly(value.getUserName()));
        value.setTypeCode(typeCodeValidator.convertOnly(value.getTypeCode()));
        value.setLogUtcTs(logUtcTsValidator.convertOnly(value.getLogUtcTs()));
        value.setDomainType(domainTypeValidator.convertOnly(value.getDomainType()));
        value.setDomainName(domainNameValidator.convertOnly(value.getDomainName()));
        value.setDomainUid(domainUidValidator.convertOnly(value.getDomainUid()));
        value.setDomainBundleUid(domainBundleUidValidator.convertOnly(value.getDomainBundleUid()));
    }

    @Override
    public void validateOnly(MyAuditLogBundleVo value, KmList<KmErrorIF> errors)
    {
        // fields...
        transactionUidValidator.validateOnly(value.getTransactionUid(), errors);
        userNameValidator.validateOnly(value.getUserName(), errors);
        typeCodeValidator.validateOnly(value.getTypeCode(), errors);
        logUtcTsValidator.validateOnly(value.getLogUtcTs(), errors);
        domainTypeValidator.validateOnly(value.getDomainType(), errors);
        domainNameValidator.validateOnly(value.getDomainName(), errors);
        domainUidValidator.validateOnly(value.getDomainUid(), errors);
        domainBundleUidValidator.validateOnly(value.getDomainBundleUid(), errors);
        // required associations...
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmStringValidator newTransactionUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModel("auditLogBundleVo");
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
        e.setModel("auditLogBundleVo");
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
        e.setModel("auditLogBundleVo");
        e.setField("typeCode");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newLogUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("auditLogBundleVo");
        e.setField("logUtcTs");
        e.setRequired();
        return e;
    }

    public KmStringValidator newDomainTypeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("auditLogBundleVo");
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
        e.setModel("auditLogBundleVo");
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
        e.setModel("auditLogBundleVo");
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
        e.setModel("auditLogBundleVo");
        e.setField("domainBundleUid");
        e.setRequired();
        return e;
    }


}

