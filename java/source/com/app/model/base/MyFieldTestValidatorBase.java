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
 * Validation rules for fieldTest.
 */
public class MyFieldTestValidatorBase
    extends MyDomainValidator<MyFieldTest>
{
    //##################################################
    //# static
    //##################################################

    public static final MyFieldTestValidator instance = new MyFieldTestValidator();

    //##################################################
    //# variables
    //##################################################

    private KmBooleanValidator booleanTestValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmDateValidator dateTestValidator;
    private KmDayFrequencyValidator dayFrequencyValidator;
    private KmDoubleValidator doubleTestValidator;
    private KmDurationValidator durationValidator;
    private KmIntegerValidator integerValueValidator;
    private KmLongValidator longTestValidator;
    private KmMoneyValidator moneyTestValidator;
    private KmStringValidator nameValueValidator;
    private KmStringValidator pinNumber1Validator;
    private KmStringValidator pinNumber2Validator;
    private KmTimestampValidator timestampTestValidator;
    private KmStringValidator uidValidator;
    private KmTimestampValidator updatedUtcTsValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyFieldTestValidatorBase()
    {
        super();
        booleanTestValidator = newBooleanTestValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        dateTestValidator = newDateTestValidator();
        dayFrequencyValidator = newDayFrequencyValidator();
        doubleTestValidator = newDoubleTestValidator();
        durationValidator = newDurationValidator();
        integerValueValidator = newIntegerValueValidator();
        longTestValidator = newLongTestValidator();
        moneyTestValidator = newMoneyTestValidator();
        nameValueValidator = newNameValueValidator();
        pinNumber1Validator = newPinNumber1Validator();
        pinNumber2Validator = newPinNumber2Validator();
        timestampTestValidator = newTimestampTestValidator();
        uidValidator = newUidValidator();
        updatedUtcTsValidator = newUpdatedUtcTsValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmBooleanValidator getBooleanTestValidator()
    {
        return booleanTestValidator;
    }

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmDateValidator getDateTestValidator()
    {
        return dateTestValidator;
    }

    public KmDayFrequencyValidator getDayFrequencyValidator()
    {
        return dayFrequencyValidator;
    }

    public KmDoubleValidator getDoubleTestValidator()
    {
        return doubleTestValidator;
    }

    public KmDurationValidator getDurationValidator()
    {
        return durationValidator;
    }

    public KmIntegerValidator getIntegerValueValidator()
    {
        return integerValueValidator;
    }

    public KmLongValidator getLongTestValidator()
    {
        return longTestValidator;
    }

    public KmMoneyValidator getMoneyTestValidator()
    {
        return moneyTestValidator;
    }

    public KmStringValidator getNameValueValidator()
    {
        return nameValueValidator;
    }

    public KmStringValidator getPinNumber1Validator()
    {
        return pinNumber1Validator;
    }

    public KmStringValidator getPinNumber2Validator()
    {
        return pinNumber2Validator;
    }

    public KmTimestampValidator getTimestampTestValidator()
    {
        return timestampTestValidator;
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
    public void convertOnly(MyFieldTest value)
    {
        // fields...
        value.setBooleanTest(booleanTestValidator.convert(value.getBooleanTest()));
        value.setCreatedUtcTs(createdUtcTsValidator.convert(value.getCreatedUtcTs()));
        value.setDateTest(dateTestValidator.convert(value.getDateTest()));
        value.setDayFrequency(dayFrequencyValidator.convert(value.getDayFrequency()));
        value.setDoubleTest(doubleTestValidator.convert(value.getDoubleTest()));
        value.setDuration(durationValidator.convert(value.getDuration()));
        value.setIntegerValue(integerValueValidator.convert(value.getIntegerValue()));
        value.setLongTest(longTestValidator.convert(value.getLongTest()));
        value.setMoneyTest(moneyTestValidator.convert(value.getMoneyTest()));
        value.setNameValue(nameValueValidator.convert(value.getNameValue()));
        value.setPinNumber1(pinNumber1Validator.convert(value.getPinNumber1()));
        value.setPinNumber2(pinNumber2Validator.convert(value.getPinNumber2()));
        value.setTimestampTest(timestampTestValidator.convert(value.getTimestampTest()));
        value.setUid(uidValidator.convert(value.getUid()));
        value.setUpdatedUtcTs(updatedUtcTsValidator.convert(value.getUpdatedUtcTs()));
        value.setLockVersion(lockVersionValidator.convert(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyFieldTest value, KmErrorList errors)
    {
        // fields...
        booleanTestValidator.validateOn(value.getBooleanTest(), errors);
        createdUtcTsValidator.validateOn(value.getCreatedUtcTs(), errors);
        dateTestValidator.validateOn(value.getDateTest(), errors);
        dayFrequencyValidator.validateOn(value.getDayFrequency(), errors);
        doubleTestValidator.validateOn(value.getDoubleTest(), errors);
        durationValidator.validateOn(value.getDuration(), errors);
        integerValueValidator.validateOn(value.getIntegerValue(), errors);
        longTestValidator.validateOn(value.getLongTest(), errors);
        moneyTestValidator.validateOn(value.getMoneyTest(), errors);
        nameValueValidator.validateOn(value.getNameValue(), errors);
        pinNumber1Validator.validateOn(value.getPinNumber1(), errors);
        pinNumber2Validator.validateOn(value.getPinNumber2(), errors);
        timestampTestValidator.validateOn(value.getTimestampTest(), errors);
        uidValidator.validateOn(value.getUid(), errors);
        updatedUtcTsValidator.validateOn(value.getUpdatedUtcTs(), errors);
        lockVersionValidator.validateOn(value.getLockVersion(), errors);
        // required associations...
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmBooleanValidator newBooleanTestValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModelName("fieldTest");
        e.setFieldName("booleanTest");
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("fieldTest");
        e.setFieldName("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmDateValidator newDateTestValidator()
    {
        KmDateValidator e;
        e = new KmDateValidator();
        e.setModelName("fieldTest");
        e.setFieldName("dateTest");
        return e;
    }

    public KmDayFrequencyValidator newDayFrequencyValidator()
    {
        KmDayFrequencyValidator e;
        e = new KmDayFrequencyValidator();
        e.setModelName("fieldTest");
        e.setFieldName("dayFrequency");
        return e;
    }

    public KmDoubleValidator newDoubleTestValidator()
    {
        KmDoubleValidator e;
        e = new KmDoubleValidator();
        e.setAllDigits(8);
        e.setRightDigits(2);
        e.setModelName("fieldTest");
        e.setFieldName("doubleTest");
        return e;
    }

    public KmDurationValidator newDurationValidator()
    {
        KmDurationValidator e;
        e = new KmDurationValidator();
        e.setModelName("fieldTest");
        e.setFieldName("duration");
        return e;
    }

    public KmIntegerValidator newIntegerValueValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("fieldTest");
        e.setFieldName("integerValue");
        return e;
    }

    public KmLongValidator newLongTestValidator()
    {
        KmLongValidator e;
        e = new KmLongValidator();
        e.setModelName("fieldTest");
        e.setFieldName("longTest");
        return e;
    }

    public KmMoneyValidator newMoneyTestValidator()
    {
        KmMoneyValidator e;
        e = new KmMoneyValidator();
        e.setModelName("fieldTest");
        e.setFieldName("moneyTest");
        return e;
    }

    public KmStringValidator newNameValueValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModelName("fieldTest");
        e.setFieldName("nameValue");
        return e;
    }

    public KmStringValidator newPinNumber1Validator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(5);
        e.setAllowsPrintable(true);
        e.setModelName("fieldTest");
        e.setFieldName("pinNumber1");
        return e;
    }

    public KmStringValidator newPinNumber2Validator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(5);
        e.setAllowsPrintable(true);
        e.setModelName("fieldTest");
        e.setFieldName("pinNumber2");
        return e;
    }

    public KmTimestampValidator newTimestampTestValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("fieldTest");
        e.setFieldName("timestampTest");
        return e;
    }

    public KmStringValidator newUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("fieldTest");
        e.setFieldName("uid");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newUpdatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("fieldTest");
        e.setFieldName("updatedUtcTs");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("fieldTest");
        e.setFieldName("lockVersion");
        e.setRequired();
        return e;
    }


}

