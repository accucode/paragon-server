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
 * Validation rules for note.
 */
public class MyNoteValidatorBase
    extends MyDomainValidator<MyNote>
{
    //##################################################
    //# static
    //##################################################

    public static final MyNoteValidator instance = new MyNoteValidator();

    //##################################################
    //# variables
    //##################################################

    private KmTimestampValidator createdUtcTsValidator;
    private KmStringValidator messageValidator;
    private KmStringValidator ownerTypeCodeValidator;
    private KmStringValidator sourceTypeCodeValidator;
    private KmStringValidator uidValidator;
    private KmTimestampValidator updatedUtcTsValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyNoteValidatorBase()
    {
        super();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        messageValidator = newMessageValidator();
        ownerTypeCodeValidator = newOwnerTypeCodeValidator();
        sourceTypeCodeValidator = newSourceTypeCodeValidator();
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

    public KmStringValidator getMessageValidator()
    {
        return messageValidator;
    }

    public KmStringValidator getOwnerTypeCodeValidator()
    {
        return ownerTypeCodeValidator;
    }

    public KmStringValidator getSourceTypeCodeValidator()
    {
        return sourceTypeCodeValidator;
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
    public void convertOnly(MyNote value)
    {
        // fields...
        value.setCreatedUtcTs(createdUtcTsValidator.convert(value.getCreatedUtcTs()));
        value.setMessage(messageValidator.convert(value.getMessage()));
        value.setOwnerTypeCode(ownerTypeCodeValidator.convert(value.getOwnerTypeCode()));
        value.setSourceTypeCode(sourceTypeCodeValidator.convert(value.getSourceTypeCode()));
        value.setUid(uidValidator.convert(value.getUid()));
        value.setUpdatedUtcTs(updatedUtcTsValidator.convert(value.getUpdatedUtcTs()));
        value.setLockVersion(lockVersionValidator.convert(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyNote value, KmErrorList errors)
    {
        // fields...
        createdUtcTsValidator.validateOn(value.getCreatedUtcTs(), errors);
        messageValidator.validateOn(value.getMessage(), errors);
        ownerTypeCodeValidator.validateOn(value.getOwnerTypeCode(), errors);
        sourceTypeCodeValidator.validateOn(value.getSourceTypeCode(), errors);
        uidValidator.validateOn(value.getUid(), errors);
        updatedUtcTsValidator.validateOn(value.getUpdatedUtcTs(), errors);
        lockVersionValidator.validateOn(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasProject() )
            errors.addRequiredField("note", "project");
        if ( !value.hasTenant() )
            errors.addRequiredField("note", "tenant");
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("note");
        e.setFieldName("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmStringValidator newMessageValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(1000);
        e.setAllowsPrintable(true);
        e.setAllowsWhitespace(true);
        e.setModelName("note");
        e.setFieldName("message");
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
        e.setModelName("note");
        e.setFieldName("ownerTypeCode");
        e.setRequired();
        return e;
    }

    public KmStringValidator newSourceTypeCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModelName("note");
        e.setFieldName("sourceTypeCode");
        e.setRequired();
        return e;
    }

    public KmStringValidator newUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("note");
        e.setFieldName("uid");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newUpdatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("note");
        e.setFieldName("updatedUtcTs");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("note");
        e.setFieldName("lockVersion");
        e.setRequired();
        return e;
    }


}

