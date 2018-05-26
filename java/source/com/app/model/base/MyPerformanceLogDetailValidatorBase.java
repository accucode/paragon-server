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
 * Validation rules for performanceLogDetail.
 */
public class MyPerformanceLogDetailValidatorBase
    extends MyDomainValidator<MyPerformanceLogDetail>
{
    //##################################################
    //# static
    //##################################################

    public static final MyPerformanceLogDetailValidator instance = new MyPerformanceLogDetailValidator();

    //##################################################
    //# variables
    //##################################################

    private KmTimestampValidator createdUtcTsValidator;
    private KmIntegerValidator durationMsValidator;
    private KmStringValidator nameValidator;
    private KmStringValidator uidValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyPerformanceLogDetailValidatorBase()
    {
        super();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        durationMsValidator = newDurationMsValidator();
        nameValidator = newNameValidator();
        uidValidator = newUidValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmIntegerValidator getDurationMsValidator()
    {
        return durationMsValidator;
    }

    public KmStringValidator getNameValidator()
    {
        return nameValidator;
    }

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyPerformanceLogDetail value)
    {
        // fields...
        value.setCreatedUtcTs(createdUtcTsValidator.convert(value.getCreatedUtcTs()));
        value.setDurationMs(durationMsValidator.convert(value.getDurationMs()));
        value.setName(nameValidator.convert(value.getName()));
        value.setUid(uidValidator.convert(value.getUid()));
    }

    @Override
    public void validateOnly(MyPerformanceLogDetail value, KmErrorList errors)
    {
        // fields...
        createdUtcTsValidator.validateOn(value.getCreatedUtcTs(), errors);
        durationMsValidator.validateOn(value.getDurationMs(), errors);
        nameValidator.validateOn(value.getName(), errors);
        uidValidator.validateOn(value.getUid(), errors);
        // required associations...
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModelName("performanceLogDetail");
        e.setFieldName("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newDurationMsValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("performanceLogDetail");
        e.setFieldName("durationMs");
        e.setRequired();
        return e;
    }

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setModelName("performanceLogDetail");
        e.setFieldName("name");
        e.setRequired();
        return e;
    }

    public KmStringValidator newUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("performanceLogDetail");
        e.setFieldName("uid");
        e.setRequired();
        return e;
    }


}

