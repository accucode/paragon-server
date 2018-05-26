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
 * Validation rules for blurb.
 */
public class MyBlurbValidatorBase
    extends MyDomainValidator<MyBlurb>
{
    //##################################################
    //# static
    //##################################################

    public static final MyBlurbValidator instance = new MyBlurbValidator();

    //##################################################
    //# variables
    //##################################################

    private KmTimestampValidator createdUtcTsValidator;
    private KmBooleanValidator enabledValidator;
    private KmStringValidator messageHtmlValidator;
    private KmStringValidator nameValidator;
    private KmStringValidator ownerTypeCodeValidator;
    private KmStringValidator uidValidator;
    private KmTimestampValidator updatedUtcTsValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyBlurbValidatorBase()
    {
        super();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        enabledValidator = newEnabledValidator();
        messageHtmlValidator = newMessageHtmlValidator();
        nameValidator = newNameValidator();
        ownerTypeCodeValidator = newOwnerTypeCodeValidator();
        uidValidator = newUidValidator();
        updatedUtcTsValidator = newUpdatedUtcTsValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmBooleanValidator getEnabledValidator()
    {
        return enabledValidator;
    }

    public KmStringValidator getMessageHtmlValidator()
    {
        return messageHtmlValidator;
    }

    public KmStringValidator getNameValidator()
    {
        return nameValidator;
    }

    public KmStringValidator getOwnerTypeCodeValidator()
    {
        return ownerTypeCodeValidator;
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
    public void convertOnly(MyBlurb value)
    {
        // fields...
        value.setCreatedUtcTs(createdUtcTsValidator.convert(value.getCreatedUtcTs()));
        value.setEnabled(enabledValidator.convert(value.getEnabled()));
        value.setMessageHtml(messageHtmlValidator.convert(value.getMessageHtml()));
        value.setName(nameValidator.convert(value.getName()));
        value.setOwnerTypeCode(ownerTypeCodeValidator.convert(value.getOwnerTypeCode()));
        value.setUid(uidValidator.convert(value.getUid()));
        value.setUpdatedUtcTs(updatedUtcTsValidator.convert(value.getUpdatedUtcTs()));
        value.setLockVersion(lockVersionValidator.convert(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyBlurb value, KmErrorList errors)
    {
        // fields...
        createdUtcTsValidator.validateOn(value.getCreatedUtcTs(), errors);
        enabledValidator.validateOn(value.getEnabled(), errors);
        messageHtmlValidator.validateOn(value.getMessageHtml(), errors);
        nameValidator.validateOn(value.getName(), errors);
        ownerTypeCodeValidator.validateOn(value.getOwnerTypeCode(), errors);
        uidValidator.validateOn(value.getUid(), errors);
        updatedUtcTsValidator.validateOn(value.getUpdatedUtcTs(), errors);
        lockVersionValidator.validateOn(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasProject() )
            errors.addRequiredField("blurb", "project");
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("blurb");
        e.setFieldName("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmBooleanValidator newEnabledValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModelName("blurb");
        e.setFieldName("enabled");
        e.setRequired();
        return e;
    }

    public KmStringValidator newMessageHtmlValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50000);
        e.setAllowsPrintable(true);
        e.setAllowsWhitespace(true);
        e.setModelName("blurb");
        e.setFieldName("messageHtml");
        return e;
    }

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("blurb");
        e.setFieldName("name");
        e.setRequired();
        return e;
    }

    public KmStringValidator newOwnerTypeCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModelName("blurb");
        e.setFieldName("ownerTypeCode");
        e.setRequired();
        return e;
    }

    public KmStringValidator newUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("blurb");
        e.setFieldName("uid");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newUpdatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("blurb");
        e.setFieldName("updatedUtcTs");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("blurb");
        e.setFieldName("lockVersion");
        e.setRequired();
        return e;
    }


}

