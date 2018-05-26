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
    private KmStringValidator hostAddressValidator;
    private KmStringValidator hostNameValidator;
    private KmTimestampValidator lastEndUtcTsValidator;
    private KmTimestampValidator lastStartUtcTsValidator;
    private KmTimestampValidator lastTouchUtcTsValidator;
    private KmStringValidator ownerUidValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyThreadTopicValidatorBase()
    {
        super();
        codeValidator = newCodeValidator();
        hostAddressValidator = newHostAddressValidator();
        hostNameValidator = newHostNameValidator();
        lastEndUtcTsValidator = newLastEndUtcTsValidator();
        lastStartUtcTsValidator = newLastStartUtcTsValidator();
        lastTouchUtcTsValidator = newLastTouchUtcTsValidator();
        ownerUidValidator = newOwnerUidValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getCodeValidator()
    {
        return codeValidator;
    }

    public KmStringValidator getHostAddressValidator()
    {
        return hostAddressValidator;
    }

    public KmStringValidator getHostNameValidator()
    {
        return hostNameValidator;
    }

    public KmTimestampValidator getLastEndUtcTsValidator()
    {
        return lastEndUtcTsValidator;
    }

    public KmTimestampValidator getLastStartUtcTsValidator()
    {
        return lastStartUtcTsValidator;
    }

    public KmTimestampValidator getLastTouchUtcTsValidator()
    {
        return lastTouchUtcTsValidator;
    }

    public KmStringValidator getOwnerUidValidator()
    {
        return ownerUidValidator;
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
        value.setCode(codeValidator.convert(value.getCode()));
        value.setHostAddress(hostAddressValidator.convert(value.getHostAddress()));
        value.setHostName(hostNameValidator.convert(value.getHostName()));
        value.setLastEndUtcTs(lastEndUtcTsValidator.convert(value.getLastEndUtcTs()));
        value.setLastStartUtcTs(lastStartUtcTsValidator.convert(value.getLastStartUtcTs()));
        value.setLastTouchUtcTs(lastTouchUtcTsValidator.convert(value.getLastTouchUtcTs()));
        value.setOwnerUid(ownerUidValidator.convert(value.getOwnerUid()));
        value.setLockVersion(lockVersionValidator.convert(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyThreadTopic value, KmErrorList errors)
    {
        // fields...
        codeValidator.validateOn(value.getCode(), errors);
        hostAddressValidator.validateOn(value.getHostAddress(), errors);
        hostNameValidator.validateOn(value.getHostName(), errors);
        lastEndUtcTsValidator.validateOn(value.getLastEndUtcTs(), errors);
        lastStartUtcTsValidator.validateOn(value.getLastStartUtcTs(), errors);
        lastTouchUtcTsValidator.validateOn(value.getLastTouchUtcTs(), errors);
        ownerUidValidator.validateOn(value.getOwnerUid(), errors);
        lockVersionValidator.validateOn(value.getLockVersion(), errors);
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
        e.setModelName("threadTopic");
        e.setFieldName("code");
        e.setRequired();
        return e;
    }

    public KmStringValidator newHostAddressValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("threadTopic");
        e.setFieldName("hostAddress");
        return e;
    }

    public KmStringValidator newHostNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("threadTopic");
        e.setFieldName("hostName");
        return e;
    }

    public KmTimestampValidator newLastEndUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("threadTopic");
        e.setFieldName("lastEndUtcTs");
        return e;
    }

    public KmTimestampValidator newLastStartUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("threadTopic");
        e.setFieldName("lastStartUtcTs");
        return e;
    }

    public KmTimestampValidator newLastTouchUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("threadTopic");
        e.setFieldName("lastTouchUtcTs");
        return e;
    }

    public KmStringValidator newOwnerUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("threadTopic");
        e.setFieldName("ownerUid");
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("threadTopic");
        e.setFieldName("lockVersion");
        e.setRequired();
        return e;
    }


}

