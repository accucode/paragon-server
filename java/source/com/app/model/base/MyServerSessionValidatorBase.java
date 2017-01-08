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
 * Validation rules for serverSession.
 */
public class MyServerSessionValidatorBase
    extends MyDomainValidator<MyServerSession>
{
    //##################################################
    //# static
    //##################################################

    public static final MyServerSessionValidator instance = new MyServerSessionValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator uidValidator;
    private KmBooleanValidator activeValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmTimestampValidator closedUtcTsValidator;
    private KmTimestampValidator lastTouchedUtcTsValidator;
    private KmStringValidator versionValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyServerSessionValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        activeValidator = newActiveValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        closedUtcTsValidator = newClosedUtcTsValidator();
        lastTouchedUtcTsValidator = newLastTouchedUtcTsValidator();
        versionValidator = newVersionValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmBooleanValidator getActiveValidator()
    {
        return activeValidator;
    }

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmTimestampValidator getClosedUtcTsValidator()
    {
        return closedUtcTsValidator;
    }

    public KmTimestampValidator getLastTouchedUtcTsValidator()
    {
        return lastTouchedUtcTsValidator;
    }

    public KmStringValidator getVersionValidator()
    {
        return versionValidator;
    }

    public KmIntegerValidator getLockVersionValidator()
    {
        return lockVersionValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyServerSession value)
    {
        // fields...
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setActive(activeValidator.convertOnly(value.getActive()));
        value.setCreatedUtcTs(createdUtcTsValidator.convertOnly(value.getCreatedUtcTs()));
        value.setClosedUtcTs(closedUtcTsValidator.convertOnly(value.getClosedUtcTs()));
        value.setLastTouchedUtcTs(lastTouchedUtcTsValidator.convertOnly(value.getLastTouchedUtcTs()));
        value.setVersion(versionValidator.convertOnly(value.getVersion()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyServerSession value, KmList<KmErrorIF> errors)
    {
        // fields...
        uidValidator.validateOnly(value.getUid(), errors);
        activeValidator.validateOnly(value.getActive(), errors);
        createdUtcTsValidator.validateOnly(value.getCreatedUtcTs(), errors);
        closedUtcTsValidator.validateOnly(value.getClosedUtcTs(), errors);
        lastTouchedUtcTsValidator.validateOnly(value.getLastTouchedUtcTs(), errors);
        versionValidator.validateOnly(value.getVersion(), errors);
        lockVersionValidator.validateOnly(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasTenant() )
            errors.add(new KmRequiredValidationError("serverSession", "tenant"));
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
        e.setModel("serverSession");
        e.setField("uid");
        e.setRequired();
        return e;
    }

    public KmBooleanValidator newActiveValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModel("serverSession");
        e.setField("active");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("serverSession");
        e.setField("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newClosedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("serverSession");
        e.setField("closedUtcTs");
        return e;
    }

    public KmTimestampValidator newLastTouchedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("serverSession");
        e.setField("lastTouchedUtcTs");
        e.setRequired();
        return e;
    }

    public KmStringValidator newVersionValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("serverSession");
        e.setField("version");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("serverSession");
        e.setField("lockVersion");
        return e;
    }


}

