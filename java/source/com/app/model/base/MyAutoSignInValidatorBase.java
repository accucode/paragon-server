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
 * Validation rules for autoSignIn.
 */
public class MyAutoSignInValidatorBase
    extends MyDomainValidator<MyAutoSignIn>
{
    //##################################################
    //# static
    //##################################################

    public static final MyAutoSignInValidator instance = new MyAutoSignInValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator uidValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmTimestampValidator lastTouchedUtcTsValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyAutoSignInValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        lastTouchedUtcTsValidator = newLastTouchedUtcTsValidator();
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

    public KmTimestampValidator getLastTouchedUtcTsValidator()
    {
        return lastTouchedUtcTsValidator;
    }

    public KmIntegerValidator getLockVersionValidator()
    {
        return lockVersionValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyAutoSignIn value)
    {
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setCreatedUtcTs(createdUtcTsValidator.convertOnly(value.getCreatedUtcTs()));
        value.setLastTouchedUtcTs(lastTouchedUtcTsValidator.convertOnly(value.getLastTouchedUtcTs()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyAutoSignIn value, KmList<KmErrorIF> errors)
    {
        uidValidator.validateOnly(value.getUid(), errors);
        createdUtcTsValidator.validateOnly(value.getCreatedUtcTs(), errors);
        lastTouchedUtcTsValidator.validateOnly(value.getLastTouchedUtcTs(), errors);
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
        e.setModel("autoSignIn");
        e.setField("uid");
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("autoSignIn");
        e.setField("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newLastTouchedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("autoSignIn");
        e.setField("lastTouchedUtcTs");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("autoSignIn");
        e.setField("lockVersion");
        return e;
    }


}

