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

    private KmStringValidator uidValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmTimestampValidator sentUtcTsValidator;
    private KmStringValidator subjectValidator;
    private KmStringValidator fromAddressValidator;
    private KmStringValidator statusCodeValidator;
    private KmStringValidator errorNotesValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyEmailValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        sentUtcTsValidator = newSentUtcTsValidator();
        subjectValidator = newSubjectValidator();
        fromAddressValidator = newFromAddressValidator();
        statusCodeValidator = newStatusCodeValidator();
        errorNotesValidator = newErrorNotesValidator();
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

    public KmTimestampValidator getSentUtcTsValidator()
    {
        return sentUtcTsValidator;
    }

    public KmStringValidator getSubjectValidator()
    {
        return subjectValidator;
    }

    public KmStringValidator getFromAddressValidator()
    {
        return fromAddressValidator;
    }

    public KmStringValidator getStatusCodeValidator()
    {
        return statusCodeValidator;
    }

    public KmStringValidator getErrorNotesValidator()
    {
        return errorNotesValidator;
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
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setCreatedUtcTs(createdUtcTsValidator.convertOnly(value.getCreatedUtcTs()));
        value.setSentUtcTs(sentUtcTsValidator.convertOnly(value.getSentUtcTs()));
        value.setSubject(subjectValidator.convertOnly(value.getSubject()));
        value.setFromAddress(fromAddressValidator.convertOnly(value.getFromAddress()));
        value.setStatusCode(statusCodeValidator.convertOnly(value.getStatusCode()));
        value.setErrorNotes(errorNotesValidator.convertOnly(value.getErrorNotes()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyEmail value, KmList<KmErrorIF> errors)
    {
        // fields...
        uidValidator.validateOnly(value.getUid(), errors);
        createdUtcTsValidator.validateOnly(value.getCreatedUtcTs(), errors);
        sentUtcTsValidator.validateOnly(value.getSentUtcTs(), errors);
        subjectValidator.validateOnly(value.getSubject(), errors);
        fromAddressValidator.validateOnly(value.getFromAddress(), errors);
        statusCodeValidator.validateOnly(value.getStatusCode(), errors);
        errorNotesValidator.validateOnly(value.getErrorNotes(), errors);
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
        e.setModel("email");
        e.setField("uid");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("email");
        e.setField("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newSentUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("email");
        e.setField("sentUtcTs");
        return e;
    }

    public KmStringValidator newSubjectValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setModel("email");
        e.setField("subject");
        return e;
    }

    public KmStringValidator newFromAddressValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("email");
        e.setField("fromAddress");
        return e;
    }

    public KmStringValidator newStatusCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(1);
        e.setAllowsLetters(true);
        e.setForcesUpperCase(true);
        e.setStripsAllSpaces(true);
        e.setModel("email");
        e.setField("statusCode");
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
        e.setModel("email");
        e.setField("errorNotes");
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("email");
        e.setField("lockVersion");
        return e;
    }


}

