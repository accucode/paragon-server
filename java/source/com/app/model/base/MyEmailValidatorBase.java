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
 * Validation rules for email.
 */
public class MyEmailValidatorBase
    extends MyDomainValidator<MyEmail>
{
    //##################################################
    //# static
    //##################################################

    public static final MyEmailValidator instance = new MyEmailValidator();

    //##################################################
    //# variables
    //##################################################

    private KmTimestampValidator createdUtcTsValidator;
    private KmStringValidator errorNotesValidator;
    private KmStringValidator fromAddressValidator;
    private KmTimestampValidator sentUtcTsValidator;
    private KmStringValidator statusCodeValidator;
    private KmStringValidator subjectValidator;
    private KmStringValidator uidValidator;
    private KmTimestampValidator updatedUtcTsValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyEmailValidatorBase()
    {
        super();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        errorNotesValidator = newErrorNotesValidator();
        fromAddressValidator = newFromAddressValidator();
        sentUtcTsValidator = newSentUtcTsValidator();
        statusCodeValidator = newStatusCodeValidator();
        subjectValidator = newSubjectValidator();
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

    public KmStringValidator getErrorNotesValidator()
    {
        return errorNotesValidator;
    }

    public KmStringValidator getFromAddressValidator()
    {
        return fromAddressValidator;
    }

    public KmTimestampValidator getSentUtcTsValidator()
    {
        return sentUtcTsValidator;
    }

    public KmStringValidator getStatusCodeValidator()
    {
        return statusCodeValidator;
    }

    public KmStringValidator getSubjectValidator()
    {
        return subjectValidator;
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
    public void convertOnly(MyEmail value)
    {
        // fields...
        value.setCreatedUtcTs(createdUtcTsValidator.convert(value.getCreatedUtcTs()));
        value.setErrorNotes(errorNotesValidator.convert(value.getErrorNotes()));
        value.setFromAddress(fromAddressValidator.convert(value.getFromAddress()));
        value.setSentUtcTs(sentUtcTsValidator.convert(value.getSentUtcTs()));
        value.setStatusCode(statusCodeValidator.convert(value.getStatusCode()));
        value.setSubject(subjectValidator.convert(value.getSubject()));
        value.setUid(uidValidator.convert(value.getUid()));
        value.setUpdatedUtcTs(updatedUtcTsValidator.convert(value.getUpdatedUtcTs()));
        value.setLockVersion(lockVersionValidator.convert(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyEmail value, KmErrorList errors)
    {
        // fields...
        createdUtcTsValidator.validateOn(value.getCreatedUtcTs(), errors);
        errorNotesValidator.validateOn(value.getErrorNotes(), errors);
        fromAddressValidator.validateOn(value.getFromAddress(), errors);
        sentUtcTsValidator.validateOn(value.getSentUtcTs(), errors);
        statusCodeValidator.validateOn(value.getStatusCode(), errors);
        subjectValidator.validateOn(value.getSubject(), errors);
        uidValidator.validateOn(value.getUid(), errors);
        updatedUtcTsValidator.validateOn(value.getUpdatedUtcTs(), errors);
        lockVersionValidator.validateOn(value.getLockVersion(), errors);
        // required associations...
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("email");
        e.setFieldName("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmStringValidator newErrorNotesValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setAllowsWhitespace(true);
        e.setModelName("email");
        e.setFieldName("errorNotes");
        return e;
    }

    public KmStringValidator newFromAddressValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setModelName("email");
        e.setFieldName("fromAddress");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newSentUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("email");
        e.setFieldName("sentUtcTs");
        return e;
    }

    public KmStringValidator newStatusCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setStripsAllSpaces(true);
        e.setModelName("email");
        e.setFieldName("statusCode");
        e.setRequired();
        return e;
    }

    public KmStringValidator newSubjectValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(200);
        e.setAllowsPrintable(true);
        e.setModelName("email");
        e.setFieldName("subject");
        e.setRequired();
        return e;
    }

    public KmStringValidator newUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("email");
        e.setFieldName("uid");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newUpdatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("email");
        e.setFieldName("updatedUtcTs");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("email");
        e.setFieldName("lockVersion");
        e.setRequired();
        return e;
    }


}

