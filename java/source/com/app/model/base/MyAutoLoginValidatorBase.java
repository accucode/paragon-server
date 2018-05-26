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
 * Validation rules for autoLogin.
 */
public class MyAutoLoginValidatorBase
    extends MyDomainValidator<MyAutoLogin>
{
    //##################################################
    //# static
    //##################################################

    public static final MyAutoLoginValidator instance = new MyAutoLoginValidator();

    //##################################################
    //# variables
    //##################################################

    private KmTimestampValidator createdUtcTsValidator;
    private KmTimestampValidator lastTouchedUtcTsValidator;
    private KmStringValidator uidValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyAutoLoginValidatorBase()
    {
        super();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        lastTouchedUtcTsValidator = newLastTouchedUtcTsValidator();
        uidValidator = newUidValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmTimestampValidator getLastTouchedUtcTsValidator()
    {
        return lastTouchedUtcTsValidator;
    }

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmIntegerValidator getLockVersionValidator()
    {
        return lockVersionValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyAutoLogin value)
    {
        // fields...
        value.setCreatedUtcTs(createdUtcTsValidator.convert(value.getCreatedUtcTs()));
        value.setLastTouchedUtcTs(lastTouchedUtcTsValidator.convert(value.getLastTouchedUtcTs()));
        value.setUid(uidValidator.convert(value.getUid()));
        value.setLockVersion(lockVersionValidator.convert(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyAutoLogin value, KmErrorList errors)
    {
        // fields...
        createdUtcTsValidator.validateOn(value.getCreatedUtcTs(), errors);
        lastTouchedUtcTsValidator.validateOn(value.getLastTouchedUtcTs(), errors);
        uidValidator.validateOn(value.getUid(), errors);
        lockVersionValidator.validateOn(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasUser() )
            errors.addRequiredField("autoLogin", "user");
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("autoLogin");
        e.setFieldName("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newLastTouchedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("autoLogin");
        e.setFieldName("lastTouchedUtcTs");
        e.setRequired();
        return e;
    }

    public KmStringValidator newUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("autoLogin");
        e.setFieldName("uid");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("autoLogin");
        e.setFieldName("lockVersion");
        e.setRequired();
        return e;
    }


}

