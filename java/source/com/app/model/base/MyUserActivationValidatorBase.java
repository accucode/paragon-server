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
 * Validation rules for userActivation.
 */
public class MyUserActivationValidatorBase
    extends MyDomainValidator<MyUserActivation>
{
    //##################################################
    //# static
    //##################################################

    public static final MyUserActivationValidator instance = new MyUserActivationValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator uidValidator;
    private KmStringValidator emailValidator;
    private KmStringValidator tokenValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmTimestampValidator expirationUtcTsValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyUserActivationValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        emailValidator = newEmailValidator();
        tokenValidator = newTokenValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        expirationUtcTsValidator = newExpirationUtcTsValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmStringValidator getEmailValidator()
    {
        return emailValidator;
    }

    public KmStringValidator getTokenValidator()
    {
        return tokenValidator;
    }

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmTimestampValidator getExpirationUtcTsValidator()
    {
        return expirationUtcTsValidator;
    }

    public KmIntegerValidator getLockVersionValidator()
    {
        return lockVersionValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyUserActivation value)
    {
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setEmail(emailValidator.convertOnly(value.getEmail()));
        value.setToken(tokenValidator.convertOnly(value.getToken()));
        value.setCreatedUtcTs(createdUtcTsValidator.convertOnly(value.getCreatedUtcTs()));
        value.setExpirationUtcTs(expirationUtcTsValidator.convertOnly(value.getExpirationUtcTs()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyUserActivation value, KmList<KmErrorIF> errors)
    {
        uidValidator.validateOnly(value.getUid(), errors);
        emailValidator.validateOnly(value.getEmail(), errors);
        tokenValidator.validateOnly(value.getToken(), errors);
        createdUtcTsValidator.validateOnly(value.getCreatedUtcTs(), errors);
        expirationUtcTsValidator.validateOnly(value.getExpirationUtcTs(), errors);
        lockVersionValidator.validateOnly(value.getLockVersion(), errors);
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
        e.setModel("userActivation");
        e.setField("uid");
        e.setRequired();
        return e;
    }

    public KmStringValidator newEmailValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("userActivation");
        e.setField("email");
        e.setRequired();
        return e;
    }

    public KmStringValidator newTokenValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModel("userActivation");
        e.setField("token");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("userActivation");
        e.setField("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newExpirationUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("userActivation");
        e.setField("expirationUtcTs");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("userActivation");
        e.setField("lockVersion");
        return e;
    }


}

