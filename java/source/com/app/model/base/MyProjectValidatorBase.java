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

    private KmStringValidator uidValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmTimestampValidator updatedUtcTsValidator;
    private KmStringValidator nameValidator;
    private KmStringValidator codeValidator;
    private KmStringValidator companyNameValidator;
    private KmStringValidator sendEmailFromValidator;
    private KmBooleanValidator activeValidator;
    private KmIntegerValidator catalogVersionValidator;
    private KmDayFrequencyValidator businessDaysValidator;
    private KmTimeValidator businessStartTimeValidator;
    private KmTimeValidator businessEndTimeValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyProjectValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        updatedUtcTsValidator = newUpdatedUtcTsValidator();
        nameValidator = newNameValidator();
        codeValidator = newCodeValidator();
        companyNameValidator = newCompanyNameValidator();
        sendEmailFromValidator = newSendEmailFromValidator();
        activeValidator = newActiveValidator();
        catalogVersionValidator = newCatalogVersionValidator();
        businessDaysValidator = newBusinessDaysValidator();
        businessStartTimeValidator = newBusinessStartTimeValidator();
        businessEndTimeValidator = newBusinessEndTimeValidator();
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

    public KmTimestampValidator getUpdatedUtcTsValidator()
    {
        return updatedUtcTsValidator;
    }

    public KmStringValidator getNameValidator()
    {
        return nameValidator;
    }

    public KmStringValidator getCodeValidator()
    {
        return codeValidator;
    }

    public KmStringValidator getCompanyNameValidator()
    {
        return companyNameValidator;
    }

    public KmStringValidator getSendEmailFromValidator()
    {
        return sendEmailFromValidator;
    }

    public KmBooleanValidator getActiveValidator()
    {
        return activeValidator;
    }

    public KmIntegerValidator getCatalogVersionValidator()
    {
        return catalogVersionValidator;
    }

    public KmDayFrequencyValidator getBusinessDaysValidator()
    {
        return businessDaysValidator;
    }

    public KmTimeValidator getBusinessStartTimeValidator()
    {
        return businessStartTimeValidator;
    }

    public KmTimeValidator getBusinessEndTimeValidator()
    {
        return businessEndTimeValidator;
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
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setCreatedUtcTs(createdUtcTsValidator.convertOnly(value.getCreatedUtcTs()));
        value.setUpdatedUtcTs(updatedUtcTsValidator.convertOnly(value.getUpdatedUtcTs()));
        value.setName(nameValidator.convertOnly(value.getName()));
        value.setCode(codeValidator.convertOnly(value.getCode()));
        value.setCompanyName(companyNameValidator.convertOnly(value.getCompanyName()));
        value.setSendEmailFrom(sendEmailFromValidator.convertOnly(value.getSendEmailFrom()));
        value.setActive(activeValidator.convertOnly(value.getActive()));
        value.setCatalogVersion(catalogVersionValidator.convertOnly(value.getCatalogVersion()));
        value.setBusinessDays(businessDaysValidator.convertOnly(value.getBusinessDays()));
        value.setBusinessStartTime(businessStartTimeValidator.convertOnly(value.getBusinessStartTime()));
        value.setBusinessEndTime(businessEndTimeValidator.convertOnly(value.getBusinessEndTime()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyProject value, KmList<KmErrorIF> errors)
    {
        // fields...
        uidValidator.validateOnly(value.getUid(), errors);
        createdUtcTsValidator.validateOnly(value.getCreatedUtcTs(), errors);
        updatedUtcTsValidator.validateOnly(value.getUpdatedUtcTs(), errors);
        nameValidator.validateOnly(value.getName(), errors);
        codeValidator.validateOnly(value.getCode(), errors);
        companyNameValidator.validateOnly(value.getCompanyName(), errors);
        sendEmailFromValidator.validateOnly(value.getSendEmailFrom(), errors);
        activeValidator.validateOnly(value.getActive(), errors);
        catalogVersionValidator.validateOnly(value.getCatalogVersion(), errors);
        businessDaysValidator.validateOnly(value.getBusinessDays(), errors);
        businessStartTimeValidator.validateOnly(value.getBusinessStartTime(), errors);
        businessEndTimeValidator.validateOnly(value.getBusinessEndTime(), errors);
        lockVersionValidator.validateOnly(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasTenant() )
            errors.add(new KmRequiredValidationError("project", "tenant"));
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
        e.setModel("project");
        e.setField("uid");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("project");
        e.setField("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newUpdatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("project");
        e.setField("updatedUtcTs");
        e.setRequired();
        return e;
    }

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("project");
        e.setField("name");
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
        e.setModel("project");
        e.setField("code");
        e.setRequired();
        return e;
    }

    public KmStringValidator newCompanyNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("project");
        e.setField("companyName");
        e.setRequired();
        return e;
    }

    public KmStringValidator newSendEmailFromValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("project");
        e.setField("sendEmailFrom");
        e.setRequired();
        return e;
    }

    public KmBooleanValidator newActiveValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModel("project");
        e.setField("active");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newCatalogVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("project");
        e.setField("catalogVersion");
        e.setRequired();
        return e;
    }

    public KmDayFrequencyValidator newBusinessDaysValidator()
    {
        KmDayFrequencyValidator e;
        e = new KmDayFrequencyValidator();
        e.setModel("project");
        e.setField("businessDays");
        return e;
    }

    public KmTimeValidator newBusinessStartTimeValidator()
    {
        KmTimeValidator e;
        e = new KmTimeValidator();
        e.setModel("project");
        e.setField("businessStartTime");
        e.setRequired();
        return e;
    }

    public KmTimeValidator newBusinessEndTimeValidator()
    {
        KmTimeValidator e;
        e = new KmTimeValidator();
        e.setModel("project");
        e.setField("businessEndTime");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("project");
        e.setField("lockVersion");
        return e;
    }


}

