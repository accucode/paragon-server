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
 * Validation rules for threadTopic.
 */
public class MyThreadTopicValidatorBase
    extends MyDomainValidator<MyThreadTopic>
{
    //##################################################
    //# static
    //##################################################

    public static final MyThreadTopicValidator instance = new MyThreadTopicValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator codeValidator;
    private KmStringValidator ownerUidValidator;
    private KmStringValidator hostNameValidator;
    private KmStringValidator hostAddressValidator;
    private KmTimestampValidator lastStartUtcTsValidator;
    private KmTimestampValidator lastEndUtcTsValidator;
    private KmTimestampValidator lastTouchUtcTsValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyThreadTopicValidatorBase()
    {
        super();
        codeValidator = newCodeValidator();
        ownerUidValidator = newOwnerUidValidator();
        hostNameValidator = newHostNameValidator();
        hostAddressValidator = newHostAddressValidator();
        lastStartUtcTsValidator = newLastStartUtcTsValidator();
        lastEndUtcTsValidator = newLastEndUtcTsValidator();
        lastTouchUtcTsValidator = newLastTouchUtcTsValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getCodeValidator()
    {
        return codeValidator;
    }

    public KmStringValidator getOwnerUidValidator()
    {
        return ownerUidValidator;
    }

    public KmStringValidator getHostNameValidator()
    {
        return hostNameValidator;
    }

    public KmStringValidator getHostAddressValidator()
    {
        return hostAddressValidator;
    }

    public KmTimestampValidator getLastStartUtcTsValidator()
    {
        return lastStartUtcTsValidator;
    }

    public KmTimestampValidator getLastEndUtcTsValidator()
    {
        return lastEndUtcTsValidator;
    }

    public KmTimestampValidator getLastTouchUtcTsValidator()
    {
        return lastTouchUtcTsValidator;
    }

    public KmIntegerValidator getLockVersionValidator()
    {
        return lockVersionValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyThreadTopic value)
    {
        // fields...
        value.setCode(codeValidator.convertOnly(value.getCode()));
        value.setOwnerUid(ownerUidValidator.convertOnly(value.getOwnerUid()));
        value.setHostName(hostNameValidator.convertOnly(value.getHostName()));
        value.setHostAddress(hostAddressValidator.convertOnly(value.getHostAddress()));
        value.setLastStartUtcTs(lastStartUtcTsValidator.convertOnly(value.getLastStartUtcTs()));
        value.setLastEndUtcTs(lastEndUtcTsValidator.convertOnly(value.getLastEndUtcTs()));
        value.setLastTouchUtcTs(lastTouchUtcTsValidator.convertOnly(value.getLastTouchUtcTs()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyThreadTopic value, KmList<KmErrorIF> errors)
    {
        // fields...
        codeValidator.validateOnly(value.getCode(), errors);
        ownerUidValidator.validateOnly(value.getOwnerUid(), errors);
        hostNameValidator.validateOnly(value.getHostName(), errors);
        hostAddressValidator.validateOnly(value.getHostAddress(), errors);
        lastStartUtcTsValidator.validateOnly(value.getLastStartUtcTs(), errors);
        lastEndUtcTsValidator.validateOnly(value.getLastEndUtcTs(), errors);
        lastTouchUtcTsValidator.validateOnly(value.getLastTouchUtcTs(), errors);
        lockVersionValidator.validateOnly(value.getLockVersion(), errors);
        // required associations...
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmStringValidator newCodeValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("threadTopic");
        e.setField("code");
        e.setRequired();
        return e;
    }

    public KmStringValidator newOwnerUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModel("threadTopic");
        e.setField("ownerUid");
        return e;
    }

    public KmStringValidator newHostNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("threadTopic");
        e.setField("hostName");
        return e;
    }

    public KmStringValidator newHostAddressValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("threadTopic");
        e.setField("hostAddress");
        return e;
    }

    public KmTimestampValidator newLastStartUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("threadTopic");
        e.setField("lastStartUtcTs");
        return e;
    }

    public KmTimestampValidator newLastEndUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("threadTopic");
        e.setField("lastEndUtcTs");
        return e;
    }

    public KmTimestampValidator newLastTouchUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("threadTopic");
        e.setField("lastTouchUtcTs");
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("threadTopic");
        e.setField("lockVersion");
        return e;
    }


}

