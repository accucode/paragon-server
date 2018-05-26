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
 * Validation rules for emailTemplate.
 */
public class MyEmailTemplateValidatorBase
    extends MyDomainValidator<MyEmailTemplate>
{
    //##################################################
    //# static
    //##################################################

    public static final MyEmailTemplateValidator instance = new MyEmailTemplateValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator bodyHtmlValidator;
    private KmStringValidator contextTypeCodeValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmBooleanValidator enabledValidator;
    private KmStringValidator nameValidator;
    private KmStringValidator subjectTextValidator;
    private KmStringValidator uidValidator;
    private KmTimestampValidator updatedUtcTsValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyEmailTemplateValidatorBase()
    {
        super();
        bodyHtmlValidator = newBodyHtmlValidator();
        contextTypeCodeValidator = newContextTypeCodeValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        enabledValidator = newEnabledValidator();
        nameValidator = newNameValidator();
        subjectTextValidator = newSubjectTextValidator();
        uidValidator = newUidValidator();
        updatedUtcTsValidator = newUpdatedUtcTsValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getBodyHtmlValidator()
    {
        return bodyHtmlValidator;
    }

    public KmStringValidator getContextTypeCodeValidator()
    {
        return contextTypeCodeValidator;
    }

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmBooleanValidator getEnabledValidator()
    {
        return enabledValidator;
    }

    public KmStringValidator getNameValidator()
    {
        return nameValidator;
    }

    public KmStringValidator getSubjectTextValidator()
    {
        return subjectTextValidator;
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
    public void convertOnly(MyEmailTemplate value)
    {
        // fields...
        value.setBodyHtml(bodyHtmlValidator.convert(value.getBodyHtml()));
        value.setContextTypeCode(contextTypeCodeValidator.convert(value.getContextTypeCode()));
        value.setCreatedUtcTs(createdUtcTsValidator.convert(value.getCreatedUtcTs()));
        value.setEnabled(enabledValidator.convert(value.getEnabled()));
        value.setName(nameValidator.convert(value.getName()));
        value.setSubjectText(subjectTextValidator.convert(value.getSubjectText()));
        value.setUid(uidValidator.convert(value.getUid()));
        value.setUpdatedUtcTs(updatedUtcTsValidator.convert(value.getUpdatedUtcTs()));
        value.setLockVersion(lockVersionValidator.convert(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyEmailTemplate value, KmErrorList errors)
    {
        // fields...
        bodyHtmlValidator.validateOn(value.getBodyHtml(), errors);
        contextTypeCodeValidator.validateOn(value.getContextTypeCode(), errors);
        createdUtcTsValidator.validateOn(value.getCreatedUtcTs(), errors);
        enabledValidator.validateOn(value.getEnabled(), errors);
        nameValidator.validateOn(value.getName(), errors);
        subjectTextValidator.validateOn(value.getSubjectText(), errors);
        uidValidator.validateOn(value.getUid(), errors);
        updatedUtcTsValidator.validateOn(value.getUpdatedUtcTs(), errors);
        lockVersionValidator.validateOn(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasProject() )
            errors.addRequiredField("emailTemplate", "project");
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmStringValidator newBodyHtmlValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50000);
        e.setAllowsPrintable(true);
        e.setAllowsWhitespace(true);
        e.setModelName("emailTemplate");
        e.setFieldName("bodyHtml");
        return e;
    }

    public KmStringValidator newContextTypeCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModelName("emailTemplate");
        e.setFieldName("contextTypeCode");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("emailTemplate");
        e.setFieldName("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmBooleanValidator newEnabledValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModelName("emailTemplate");
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
        e.setModelName("emailTemplate");
        e.setFieldName("name");
        e.setRequired();
        return e;
    }

    public KmStringValidator newSubjectTextValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(200);
        e.setAllowsPrintable(true);
        e.setModelName("emailTemplate");
        e.setFieldName("subjectText");
        return e;
    }

    public KmStringValidator newUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("emailTemplate");
        e.setFieldName("uid");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newUpdatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("emailTemplate");
        e.setFieldName("updatedUtcTs");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("emailTemplate");
        e.setFieldName("lockVersion");
        e.setRequired();
        return e;
    }


}

