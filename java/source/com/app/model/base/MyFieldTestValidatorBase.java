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

    private KmStringValidator uidValidator;
    private KmStringValidator nameValueValidator;
    private KmIntegerValidator integerValueValidator;
    private KmLongValidator longTestValidator;
    private KmDoubleValidator doubleTestValidator;
    private KmMoneyValidator moneyTestValidator;
    private KmBooleanValidator booleanTestValidator;
    private KmDateValidator dateTestValidator;
    private KmTimestampValidator timestampTestValidator;
    private KmStringValidator pinNumber1Validator;
    private KmStringValidator pinNumber2Validator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyFieldTestValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        nameValueValidator = newNameValueValidator();
        integerValueValidator = newIntegerValueValidator();
        longTestValidator = newLongTestValidator();
        doubleTestValidator = newDoubleTestValidator();
        moneyTestValidator = newMoneyTestValidator();
        booleanTestValidator = newBooleanTestValidator();
        dateTestValidator = newDateTestValidator();
        timestampTestValidator = newTimestampTestValidator();
        pinNumber1Validator = newPinNumber1Validator();
        pinNumber2Validator = newPinNumber2Validator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmStringValidator getNameValueValidator()
    {
        return nameValueValidator;
    }

    public KmIntegerValidator getIntegerValueValidator()
    {
        return integerValueValidator;
    }

    public KmLongValidator getLongTestValidator()
    {
        return longTestValidator;
    }

    public KmDoubleValidator getDoubleTestValidator()
    {
        return doubleTestValidator;
    }

    public KmMoneyValidator getMoneyTestValidator()
    {
        return moneyTestValidator;
    }

    public KmBooleanValidator getBooleanTestValidator()
    {
        return booleanTestValidator;
    }

    public KmDateValidator getDateTestValidator()
    {
        return dateTestValidator;
    }

    public KmTimestampValidator getTimestampTestValidator()
    {
        return timestampTestValidator;
    }

    public KmStringValidator getPinNumber1Validator()
    {
        return pinNumber1Validator;
    }

    public KmStringValidator getPinNumber2Validator()
    {
        return pinNumber2Validator;
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
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setNameValue(nameValueValidator.convertOnly(value.getNameValue()));
        value.setIntegerValue(integerValueValidator.convertOnly(value.getIntegerValue()));
        value.setLongTest(longTestValidator.convertOnly(value.getLongTest()));
        value.setDoubleTest(doubleTestValidator.convertOnly(value.getDoubleTest()));
        value.setMoneyTest(moneyTestValidator.convertOnly(value.getMoneyTest()));
        value.setBooleanTest(booleanTestValidator.convertOnly(value.getBooleanTest()));
        value.setDateTest(dateTestValidator.convertOnly(value.getDateTest()));
        value.setTimestampTest(timestampTestValidator.convertOnly(value.getTimestampTest()));
        value.setPinNumber1(pinNumber1Validator.convertOnly(value.getPinNumber1()));
        value.setPinNumber2(pinNumber2Validator.convertOnly(value.getPinNumber2()));
        value.setLockVersion(lockVersionValidator.convertOnly(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MyFieldTest value, KmList<KmErrorIF> errors)
    {
        // fields...
        uidValidator.validateOnly(value.getUid(), errors);
        nameValueValidator.validateOnly(value.getNameValue(), errors);
        integerValueValidator.validateOnly(value.getIntegerValue(), errors);
        longTestValidator.validateOnly(value.getLongTest(), errors);
        doubleTestValidator.validateOnly(value.getDoubleTest(), errors);
        moneyTestValidator.validateOnly(value.getMoneyTest(), errors);
        booleanTestValidator.validateOnly(value.getBooleanTest(), errors);
        dateTestValidator.validateOnly(value.getDateTest(), errors);
        timestampTestValidator.validateOnly(value.getTimestampTest(), errors);
        pinNumber1Validator.validateOnly(value.getPinNumber1(), errors);
        pinNumber2Validator.validateOnly(value.getPinNumber2(), errors);
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
        e.setModel("fieldTest");
        e.setField("uid");
        e.setRequired();
        return e;
    }

    public KmStringValidator newNameValueValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(50);
        e.setAllowsPrintable(true);
        e.setModel("fieldTest");
        e.setField("nameValue");
        return e;
    }

    public KmIntegerValidator newIntegerValueValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("fieldTest");
        e.setField("integerValue");
        return e;
    }

    public KmLongValidator newLongTestValidator()
    {
        KmLongValidator e;
        e = new KmLongValidator();
        e.setModel("fieldTest");
        e.setField("longTest");
        return e;
    }

    public KmDoubleValidator newDoubleTestValidator()
    {
        KmDoubleValidator e;
        e = new KmDoubleValidator();
        e.setAllDigits(8);
        e.setRightDigits(2);
        e.setModel("fieldTest");
        e.setField("doubleTest");
        return e;
    }

    public KmMoneyValidator newMoneyTestValidator()
    {
        KmMoneyValidator e;
        e = new KmMoneyValidator();
        e.setModel("fieldTest");
        e.setField("moneyTest");
        return e;
    }

    public KmBooleanValidator newBooleanTestValidator()
    {
        KmBooleanValidator e;
        e = new KmBooleanValidator();
        e.setModel("fieldTest");
        e.setField("booleanTest");
        return e;
    }

    public KmDateValidator newDateTestValidator()
    {
        KmDateValidator e;
        e = new KmDateValidator();
        e.setModel("fieldTest");
        e.setField("dateTest");
        return e;
    }

    public KmTimestampValidator newTimestampTestValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("fieldTest");
        e.setField("timestampTest");
        return e;
    }

    public KmStringValidator newPinNumber1Validator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(5);
        e.setAllowsPrintable(true);
        e.setModel("fieldTest");
        e.setField("pinNumber1");
        return e;
    }

    public KmStringValidator newPinNumber2Validator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(5);
        e.setAllowsPrintable(true);
        e.setModel("fieldTest");
        e.setField("pinNumber2");
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("fieldTest");
        e.setField("lockVersion");
        return e;
    }


}

