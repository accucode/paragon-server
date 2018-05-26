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

    private KmDayFrequencyValidator businessDaysValidator;
    private KmTimeValidator businessEndTimeValidator;
    private KmTimeValidator businessStartTimeValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmStringValidator hostnameValidator;
    private KmStringValidator memoValidator;
    private KmStringValidator nameValidator;
    private KmStringValidator themeCodeValidator;
    private KmStringValidator timeZoneCodeValidator;
    private KmStringValidator uidValidator;
    private KmTimestampValidator updatedUtcTsValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyTenantValidatorBase()
    {
        super();
        businessDaysValidator = newBusinessDaysValidator();
        businessEndTimeValidator = newBusinessEndTimeValidator();
        businessStartTimeValidator = newBusinessStartTimeValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        hostnameValidator = newHostnameValidator();
        memoValidator = newMemoValidator();
        nameValidator = newNameValidator();
        themeCodeValidator = newThemeCodeValidator();
        timeZoneCodeValidator = newTimeZoneCodeValidator();
        uidValidator = newUidValidator();
        updatedUtcTsValidator = newUpdatedUtcTsValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmDayFrequencyValidator getBusinessDaysValidator()
    {
        return businessDaysValidator;
    }

    public KmTimeValidator getBusinessEndTimeValidator()
    {
        return businessEndTimeValidator;
    }

    public KmTimeValidator getBusinessStartTimeValidator()
    {
        return businessStartTimeValidator;
    }

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmStringValidator getHostnameValidator()
    {
        return hostnameValidator;
    }

    public KmStringValidator getMemoValidator()
    {
        return memoValidator;
    }

    public KmStringValidator getNameValidator()
    {
        return nameValidator;
    }

    public KmStringValidator getThemeCodeValidator()
    {
        return themeCodeValidator;
    }

    public KmStringValidator getTimeZoneCodeValidator()
    {
        return timeZoneCodeValidator;
    }

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmTimestampValidator getUpdatedUtcTsValidator()
    {
        return updatedUtcTsValidator;
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
        value.setBusinessDays(businessDaysValidator.convert(value.getBusinessDays()));
        value.setBusinessEndTime(businessEndTimeValidator.convert(value.getBusinessEndTime()));
        value.setBusinessStartTime(businessStartTimeValidator.convert(value.getBusinessStartTime()));
        value.setCreatedUtcTs(createdUtcTsValidator.convert(value.getCreatedUtcTs()));
        value.setHostname(hostnameValidator.convert(value.getHostname()));
        value.setMemo(memoValidator.convert(value.getMemo()));
        value.setName(nameValidator.convert(value.getName()));
        value.setThemeCode(themeCodeValidator.convert(value.getThemeCode()));
        value.setTimeZoneCode(timeZoneCodeValidator.convert(value.getTimeZoneCode()));
        value.setUid(uidValidator.convert(value.getUid()));
        value.setUpdatedUtcTs(updatedUtcTsValidator.convert(value.getUpdatedUtcTs()));
        value.setLockVersion(lockVersionValidator.convert(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyTenant value, KmErrorList errors)
    {
        // fields...
        businessDaysValidator.validateOn(value.getBusinessDays(), errors);
        businessEndTimeValidator.validateOn(value.getBusinessEndTime(), errors);
        businessStartTimeValidator.validateOn(value.getBusinessStartTime(), errors);
        createdUtcTsValidator.validateOn(value.getCreatedUtcTs(), errors);
        hostnameValidator.validateOn(value.getHostname(), errors);
        memoValidator.validateOn(value.getMemo(), errors);
        nameValidator.validateOn(value.getName(), errors);
        themeCodeValidator.validateOn(value.getThemeCode(), errors);
        timeZoneCodeValidator.validateOn(value.getTimeZoneCode(), errors);
        uidValidator.validateOn(value.getUid(), errors);
        updatedUtcTsValidator.validateOn(value.getUpdatedUtcTs(), errors);
        lockVersionValidator.validateOn(value.getLockVersion(), errors);
        // required associations...
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmDayFrequencyValidator newBusinessDaysValidator()
    {
        KmDayFrequencyValidator e;
        e = new KmDayFrequencyValidator();
        e.setModelName("tenant");
        e.setFieldName("businessDays");
        return e;
    }

    public KmTimeValidator newBusinessEndTimeValidator()
    {
        KmTimeValidator e;
        e = new KmTimeValidator();
        e.setModelName("tenant");
        e.setFieldName("businessEndTime");
        e.setRequired();
        return e;
    }

    public KmTimeValidator newBusinessStartTimeValidator()
    {
        KmTimeValidator e;
        e = new KmTimeValidator();
        e.setModelName("tenant");
        e.setFieldName("businessStartTime");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("tenant");
        e.setFieldName("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmStringValidator newHostnameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("tenant");
        e.setFieldName("hostname");
        e.setRequired();
        return e;
    }

    public KmStringValidator newMemoValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(1000);
        e.setAllowsPrintable(true);
        e.setAllowsWhitespace(true);
        e.setModelName("tenant");
        e.setFieldName("memo");
        return e;
    }

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("tenant");
        e.setFieldName("name");
        e.setRequired();
        return e;
    }

    public KmStringValidator newThemeCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("tenant");
        e.setFieldName("themeCode");
        e.setRequired();
        return e;
    }

    public KmStringValidator newTimeZoneCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(40);
        e.setAllowsPrintable(true);
        e.setModelName("tenant");
        e.setFieldName("timeZoneCode");
        e.setRequired();
        return e;
    }

    public KmStringValidator newUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("tenant");
        e.setFieldName("uid");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newUpdatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("tenant");
        e.setFieldName("updatedUtcTs");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("tenant");
        e.setFieldName("lockVersion");
        e.setRequired();
        return e;
    }


}

