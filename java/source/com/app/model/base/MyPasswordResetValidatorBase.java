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
 * Validation rules for passwordReset.
 */
public class MyPasswordResetValidatorBase
    extends MyDomainValidator<MyPasswordReset>
{
    //##################################################
    //# static
    //##################################################

    public static final MyPasswordResetValidator instance = new MyPasswordResetValidator();

    //##################################################
    //# variables
    //##################################################

    private KmTimestampValidator createdUtcTsValidator;
    private KmStringValidator emailValidator;
    private KmTimestampValidator expirationUtcTsValidator;
    private KmStringValidator tokenValidator;
    private KmStringValidator uidValidator;
    private KmTimestampValidator updatedUtcTsValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyPasswordResetValidatorBase()
    {
        super();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        emailValidator = newEmailValidator();
        expirationUtcTsValidator = newExpirationUtcTsValidator();
        tokenValidator = newTokenValidator();
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

    public KmStringValidator getEmailValidator()
    {
        return emailValidator;
    }

    public KmTimestampValidator getExpirationUtcTsValidator()
    {
        return expirationUtcTsValidator;
    }

    public KmStringValidator getTokenValidator()
    {
        return tokenValidator;
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
    public void convertOnly(MyPasswordReset value)
    {
        // fields...
        value.setCreatedUtcTs(createdUtcTsValidator.convert(value.getCreatedUtcTs()));
        value.setEmail(emailValidator.convert(value.getEmail()));
        value.setExpirationUtcTs(expirationUtcTsValidator.convert(value.getExpirationUtcTs()));
        value.setToken(tokenValidator.convert(value.getToken()));
        value.setUid(uidValidator.convert(value.getUid()));
        value.setUpdatedUtcTs(updatedUtcTsValidator.convert(value.getUpdatedUtcTs()));
        value.setLockVersion(lockVersionValidator.convert(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyPasswordReset value, KmErrorList errors)
    {
        // fields...
        createdUtcTsValidator.validateOn(value.getCreatedUtcTs(), errors);
        emailValidator.validateOn(value.getEmail(), errors);
        expirationUtcTsValidator.validateOn(value.getExpirationUtcTs(), errors);
        tokenValidator.validateOn(value.getToken(), errors);
        uidValidator.validateOn(value.getUid(), errors);
        updatedUtcTsValidator.validateOn(value.getUpdatedUtcTs(), errors);
        lockVersionValidator.validateOn(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasTenant() )
            errors.addRequiredField("passwordReset", "tenant");
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("passwordReset");
        e.setFieldName("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmStringValidator newEmailValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsLetters(true);
        e.setAllowsDigits(true);
        e.setAllowsSymbols(true);
        e.setModelName("passwordReset");
        e.setFieldName("email");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newExpirationUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("passwordReset");
        e.setFieldName("expirationUtcTs");
        e.setRequired();
        return e;
    }

    public KmStringValidator newTokenValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("passwordReset");
        e.setFieldName("token");
        e.setRequired();
        return e;
    }

    public KmStringValidator newUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("passwordReset");
        e.setFieldName("uid");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newUpdatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("passwordReset");
        e.setFieldName("updatedUtcTs");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("passwordReset");
        e.setFieldName("lockVersion");
        e.setRequired();
        return e;
    }


}

