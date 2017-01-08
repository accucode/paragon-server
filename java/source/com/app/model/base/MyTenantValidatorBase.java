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
 * Validation rules for tenant.
 */
public class MyTenantValidatorBase
    extends MyDomainValidator<MyTenant>
{
    //##################################################
    //# static
    //##################################################

    public static final MyTenantValidator instance = new MyTenantValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator uidValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmStringValidator nameValidator;
    private KmStringValidator hostnameValidator;
    private KmStringValidator themeCodeValidator;
    private KmStringValidator intacctCompanyIdValidator;
    private KmStringValidator intacctUserIdValidator;
    private KmStringValidator intacctUserPasswordValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyTenantValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        nameValidator = newNameValidator();
        hostnameValidator = newHostnameValidator();
        themeCodeValidator = newThemeCodeValidator();
        intacctCompanyIdValidator = newIntacctCompanyIdValidator();
        intacctUserIdValidator = newIntacctUserIdValidator();
        intacctUserPasswordValidator = newIntacctUserPasswordValidator();
        lockVersionValidator = newLockVersionValidator();
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

    public KmStringValidator getNameValidator()
    {
        return nameValidator;
    }

    public KmStringValidator getHostnameValidator()
    {
        return hostnameValidator;
    }

    public KmStringValidator getThemeCodeValidator()
    {
        return themeCodeValidator;
    }

    public KmStringValidator getIntacctCompanyIdValidator()
    {
        return intacctCompanyIdValidator;
    }

    public KmStringValidator getIntacctUserIdValidator()
    {
        return intacctUserIdValidator;
    }

    public KmStringValidator getIntacctUserPasswordValidator()
    {
        return intacctUserPasswordValidator;
    }

    public KmIntegerValidator getLockVersionValidator()
    {
        return lockVersionValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyTenant value)
    {
        // fields...
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setCreatedUtcTs(createdUtcTsValidator.convertOnly(value.getCreatedUtcTs()));
        value.setName(nameValidator.convertOnly(value.getName()));
        value.setHostname(hostnameValidator.convertOnly(value.getHostname()));
        value.setThemeCode(themeCodeValidator.convertOnly(value.getThemeCode()));
        value.setIntacctCompanyId(intacctCompanyIdValidator.convertOnly(value.getIntacctCompanyId()));
        value.setIntacctUserId(intacctUserIdValidator.convertOnly(value.getIntacctUserId()));
        value.setIntacctUserPassword(intacctUserPasswordValidator.convertOnly(value.getIntacctUserPassword()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyTenant value, KmList<KmErrorIF> errors)
    {
        // fields...
        uidValidator.validateOnly(value.getUid(), errors);
        createdUtcTsValidator.validateOnly(value.getCreatedUtcTs(), errors);
        nameValidator.validateOnly(value.getName(), errors);
        hostnameValidator.validateOnly(value.getHostname(), errors);
        themeCodeValidator.validateOnly(value.getThemeCode(), errors);
        intacctCompanyIdValidator.validateOnly(value.getIntacctCompanyId(), errors);
        intacctUserIdValidator.validateOnly(value.getIntacctUserId(), errors);
        intacctUserPasswordValidator.validateOnly(value.getIntacctUserPassword(), errors);
        lockVersionValidator.validateOnly(value.getLockVersion(), errors);
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
        e.setModel("tenant");
        e.setField("uid");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("tenant");
        e.setField("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("tenant");
        e.setField("name");
        e.setRequired();
        return e;
    }

    public KmStringValidator newHostnameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("tenant");
        e.setField("hostname");
        e.setRequired();
        return e;
    }

    public KmStringValidator newThemeCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("tenant");
        e.setField("themeCode");
        e.setRequired();
        return e;
    }

    public KmStringValidator newIntacctCompanyIdValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("tenant");
        e.setField("intacctCompanyId");
        return e;
    }

    public KmStringValidator newIntacctUserIdValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("tenant");
        e.setField("intacctUserId");
        return e;
    }

    public KmStringValidator newIntacctUserPasswordValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("tenant");
        e.setField("intacctUserPassword");
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("tenant");
        e.setField("lockVersion");
        return e;
    }


}

