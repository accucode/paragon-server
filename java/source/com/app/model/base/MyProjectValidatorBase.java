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
 * Validation rules for project.
 */
public class MyProjectValidatorBase
    extends MyDomainValidator<MyProject>
{
    //##################################################
    //# static
    //##################################################

    public static final MyProjectValidator instance = new MyProjectValidator();

    //##################################################
    //# variables
    //##################################################

    private KmBooleanValidator autoSiteNumberEnabledValidator;
    private KmIntegerValidator autoSiteNumberPaddingValidator;
    private KmStringValidator autoSiteNumberPrefixValidator;
    private KmDayFrequencyValidator businessDaysValidator;
    private KmTimeValidator businessEndTimeValidator;
    private KmTimeValidator businessStartTimeValidator;
    private KmStringValidator codeValidator;
    private KmStringValidator companyNameValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmStringValidator descriptionValidator;
    private KmBooleanValidator enabledValidator;
    private KmStringValidator nameValidator;
    private KmIntegerValidator nextAutoSiteNumberValidator;
    private KmStringValidator sendEmailFromValidator;
    private KmStringValidator timeZoneCodeValidator;
    private KmStringValidator uidValidator;
    private KmTimestampValidator updatedUtcTsValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyProjectValidatorBase()
    {
        super();
        autoSiteNumberEnabledValidator = newAutoSiteNumberEnabledValidator();
        autoSiteNumberPaddingValidator = newAutoSiteNumberPaddingValidator();
        autoSiteNumberPrefixValidator = newAutoSiteNumberPrefixValidator();
        businessDaysValidator = newBusinessDaysValidator();
        businessEndTimeValidator = newBusinessEndTimeValidator();
        businessStartTimeValidator = newBusinessStartTimeValidator();
        codeValidator = newCodeValidator();
        companyNameValidator = newCompanyNameValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        descriptionValidator = newDescriptionValidator();
        enabledValidator = newEnabledValidator();
        nameValidator = newNameValidator();
        nextAutoSiteNumberValidator = newNextAutoSiteNumberValidator();
        sendEmailFromValidator = newSendEmailFromValidator();
        timeZoneCodeValidator = newTimeZoneCodeValidator();
        uidValidator = newUidValidator();
        updatedUtcTsValidator = newUpdatedUtcTsValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmBooleanValidator getAutoSiteNumberEnabledValidator()
    {
        return autoSiteNumberEnabledValidator;
    }

    public KmIntegerValidator getAutoSiteNumberPaddingValidator()
    {
        return autoSiteNumberPaddingValidator;
    }

    public KmStringValidator getAutoSiteNumberPrefixValidator()
    {
        return autoSiteNumberPrefixValidator;
    }

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

    public KmStringValidator getCodeValidator()
    {
        return codeValidator;
    }

    public KmStringValidator getCompanyNameValidator()
    {
        return companyNameValidator;
    }

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmStringValidator getDescriptionValidator()
    {
        return descriptionValidator;
    }

    public KmBooleanValidator getEnabledValidator()
    {
        return enabledValidator;
    }

    public KmStringValidator getNameValidator()
    {
        return nameValidator;
    }

    public KmIntegerValidator getNextAutoSiteNumberValidator()
    {
        return nextAutoSiteNumberValidator;
    }

    public KmStringValidator getSendEmailFromValidator()
    {
        return sendEmailFromValidator;
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
    public void convertOnly(MyProject value)
    {
        // fields...
        value.setAutoSiteNumberEnabled(autoSiteNumberEnabledValidator.convert(value.getAutoSiteNumberEnabled()));
        value.setAutoSiteNumberPadding(autoSiteNumberPaddingValidator.convert(value.getAutoSiteNumberPadding()));
        value.setAutoSiteNumberPrefix(autoSiteNumberPrefixValidator.convert(value.getAutoSiteNumberPrefix()));
        value.setBusinessDays(businessDaysValidator.convert(value.getBusinessDays()));
        value.setBusinessEndTime(businessEndTimeValidator.convert(value.getBusinessEndTime()));
        value.setBusinessStartTime(businessStartTimeValidator.convert(value.getBusinessStartTime()));
        value.setCode(codeValidator.convert(value.getCode()));
        value.setCompanyName(companyNameValidator.convert(value.getCompanyName()));
        value.setCreatedUtcTs(createdUtcTsValidator.convert(value.getCreatedUtcTs()));
        value.setDescription(descriptionValidator.convert(value.getDescription()));
        value.setEnabled(enabledValidator.convert(value.getEnabled()));
        value.setName(nameValidator.convert(value.getName()));
        value.setNextAutoSiteNumber(nextAutoSiteNumberValidator.convert(value.getNextAutoSiteNumber()));
        value.setSendEmailFrom(sendEmailFromValidator.convert(value.getSendEmailFrom()));
        value.setTimeZoneCode(timeZoneCodeValidator.convert(value.getTimeZoneCode()));
        value.setUid(uidValidator.convert(value.getUid()));
        value.setUpdatedUtcTs(updatedUtcTsValidator.convert(value.getUpdatedUtcTs()));
        value.setLockVersion(lockVersionValidator.convert(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyProject value, KmErrorList errors)
    {
        // fields...
        autoSiteNumberEnabledValidator.validateOn(value.getAutoSiteNumberEnabled(), errors);
        autoSiteNumberPaddingValidator.validateOn(value.getAutoSiteNumberPadding(), errors);
        autoSiteNumberPrefixValidator.validateOn(value.getAutoSiteNumberPrefix(), errors);
        businessDaysValidator.validateOn(value.getBusinessDays(), errors);
        businessEndTimeValidator.validateOn(value.getBusinessEndTime(), errors);
        businessStartTimeValidator.validateOn(value.getBusinessStartTime(), errors);
        codeValidator.validateOn(value.getCode(), errors);
        companyNameValidator.validateOn(value.getCompanyName(), errors);
        createdUtcTsValidator.validateOn(value.getCreatedUtcTs(), errors);
        descriptionValidator.validateOn(value.getDescription(), errors);
        enabledValidator.validateOn(value.getEnabled(), errors);
        nameValidator.validateOn(value.getName(), errors);
        nextAutoSiteNumberValidator.validateOn(value.getNextAutoSiteNumber(), errors);
        sendEmailFromValidator.validateOn(value.getSendEmailFrom(), errors);
        timeZoneCodeValidator.validateOn(value.getTimeZoneCode(), errors);
        uidValidator.validateOn(value.getUid(), errors);
        updatedUtcTsValidator.validateOn(value.getUpdatedUtcTs(), errors);
        lockVersionValidator.validateOn(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasDefaultPriority() )
            errors.addRequiredField("project", "defaultPriority");
        if ( !value.hasSupervisor() )
            errors.addRequiredField("project", "supervisor");
        if ( !value.hasTenant() )
            errors.addRequiredField("project", "tenant");
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmBooleanValidator newAutoSiteNumberEnabledValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModelName("project");
        e.setFieldName("autoSiteNumberEnabled");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newAutoSiteNumberPaddingValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setMinimumValue(0);
        e.setModelName("project");
        e.setFieldName("autoSiteNumberPadding");
        e.setRequired();
        return e;
    }

    public KmStringValidator newAutoSiteNumberPrefixValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(5);
        e.setAllowsPrintable(true);
        e.setModelName("project");
        e.setFieldName("autoSiteNumberPrefix");
        return e;
    }

    public KmDayFrequencyValidator newBusinessDaysValidator()
    {
        KmDayFrequencyValidator e;
        e = new KmDayFrequencyValidator();
        e.setModelName("project");
        e.setFieldName("businessDays");
        return e;
    }

    public KmTimeValidator newBusinessEndTimeValidator()
    {
        KmTimeValidator e;
        e = new KmTimeValidator();
        e.setModelName("project");
        e.setFieldName("businessEndTime");
        e.setRequired();
        return e;
    }

    public KmTimeValidator newBusinessStartTimeValidator()
    {
        KmTimeValidator e;
        e = new KmTimeValidator();
        e.setModelName("project");
        e.setFieldName("businessStartTime");
        e.setRequired();
        return e;
    }

    public KmStringValidator newCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(5);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setForcesUpperCase(true);
        e.setStripsAllSpaces(true);
        e.setModelName("project");
        e.setFieldName("code");
        e.setRequired();
        return e;
    }

    public KmStringValidator newCompanyNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("project");
        e.setFieldName("companyName");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("project");
        e.setFieldName("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmStringValidator newDescriptionValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(1000);
        e.setAllowsPrintable(true);
        e.setAllowsWhitespace(true);
        e.setModelName("project");
        e.setFieldName("description");
        return e;
    }

    public KmBooleanValidator newEnabledValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModelName("project");
        e.setFieldName("enabled");
        e.setRequired();
        return e;
    }

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("project");
        e.setFieldName("name");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newNextAutoSiteNumberValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("project");
        e.setFieldName("nextAutoSiteNumber");
        e.setRequired();
        return e;
    }

    public KmStringValidator newSendEmailFromValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setModelName("project");
        e.setFieldName("sendEmailFrom");
        e.setRequired();
        return e;
    }

    public KmStringValidator newTimeZoneCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(40);
        e.setAllowsPrintable(true);
        e.setModelName("project");
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
        e.setModelName("project");
        e.setFieldName("uid");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newUpdatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("project");
        e.setFieldName("updatedUtcTs");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("project");
        e.setFieldName("lockVersion");
        e.setRequired();
        return e;
    }


}

