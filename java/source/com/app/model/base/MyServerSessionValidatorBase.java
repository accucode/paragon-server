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

    private KmBooleanValidator activeValidator;
    private KmTimestampValidator closedUtcTsValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmTimestampValidator lastTouchedUtcTsValidator;
    private KmStringValidator uidValidator;
    private KmStringValidator versionValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyServerSessionValidatorBase()
    {
        super();
        activeValidator = newActiveValidator();
        closedUtcTsValidator = newClosedUtcTsValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        lastTouchedUtcTsValidator = newLastTouchedUtcTsValidator();
        uidValidator = newUidValidator();
        versionValidator = newVersionValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmBooleanValidator getActiveValidator()
    {
        return activeValidator;
    }

    public KmTimestampValidator getClosedUtcTsValidator()
    {
        return closedUtcTsValidator;
    }

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
        value.setActive(activeValidator.convert(value.getActive()));
        value.setClosedUtcTs(closedUtcTsValidator.convert(value.getClosedUtcTs()));
        value.setCreatedUtcTs(createdUtcTsValidator.convert(value.getCreatedUtcTs()));
        value.setLastTouchedUtcTs(lastTouchedUtcTsValidator.convert(value.getLastTouchedUtcTs()));
        value.setUid(uidValidator.convert(value.getUid()));
        value.setVersion(versionValidator.convert(value.getVersion()));
        value.setLockVersion(lockVersionValidator.convert(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyServerSession value, KmErrorList errors)
    {
        // fields...
        activeValidator.validateOn(value.getActive(), errors);
        closedUtcTsValidator.validateOn(value.getClosedUtcTs(), errors);
        createdUtcTsValidator.validateOn(value.getCreatedUtcTs(), errors);
        lastTouchedUtcTsValidator.validateOn(value.getLastTouchedUtcTs(), errors);
        uidValidator.validateOn(value.getUid(), errors);
        versionValidator.validateOn(value.getVersion(), errors);
        lockVersionValidator.validateOn(value.getLockVersion(), errors);
        // required associations...
        if ( !value.hasTenant() )
            errors.addRequiredField("serverSession", "tenant");
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmBooleanValidator newActiveValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModelName("serverSession");
        e.setFieldName("active");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newClosedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("serverSession");
        e.setFieldName("closedUtcTs");
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("serverSession");
        e.setFieldName("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newLastTouchedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("serverSession");
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
        e.setModelName("serverSession");
        e.setFieldName("uid");
        e.setRequired();
        return e;
    }

    public KmStringValidator newVersionValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("serverSession");
        e.setFieldName("version");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("serverSession");
        e.setFieldName("lockVersion");
        e.setRequired();
        return e;
    }


}

