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
 * Validation rules for settings.
 */
public class MySettingsValidatorBase
    extends MyDomainValidator<MySettings>
{
    //##################################################
    //# static
    //##################################################

    public static final MySettingsValidator instance = new MySettingsValidator();

    //##################################################
    //# variables
    //##################################################

    private KmIntegerValidator codeValidator;
    private KmStringValidator someMessageValidator;
    private KmIntegerValidator lockVersionValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MySettingsValidatorBase()
    {
        super();
        codeValidator = newCodeValidator();
        someMessageValidator = newSomeMessageValidator();
        lockVersionValidator = newLockVersionValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmIntegerValidator getCodeValidator()
    {
        return codeValidator;
    }

    public KmStringValidator getSomeMessageValidator()
    {
        return someMessageValidator;
    }

    public KmIntegerValidator getLockVersionValidator()
    {
        return lockVersionValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MySettings value)
    {
        // fields...
        value.setCode(codeValidator.convert(value.getCode()));
        value.setSomeMessage(someMessageValidator.convert(value.getSomeMessage()));
        value.setLockVersion(lockVersionValidator.convert(value.getLockVersion()));
    }

    @Override
    public void validateOnly(MySettings value, KmErrorList errors)
    {
        // fields...
        codeValidator.validateOn(value.getCode(), errors);
        someMessageValidator.validateOn(value.getSomeMessage(), errors);
        lockVersionValidator.validateOn(value.getLockVersion(), errors);
        // required associations...
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmIntegerValidator newCodeValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("settings");
        e.setFieldName("code");
        e.setRequired();
        return e;
    }

    public KmStringValidator newSomeMessageValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setModelName("settings");
        e.setFieldName("someMessage");
        return e;
    }

    public KmIntegerValidator newLockVersionValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("settings");
        e.setFieldName("lockVersion");
        e.setRequired();
        return e;
    }


}

