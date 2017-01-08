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

    private KmStringValidator uidValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmStringValidator nameValidator;
    private KmIntegerValidator durationMsValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyPerformanceLogDetailValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        nameValidator = newNameValidator();
        durationMsValidator = newDurationMsValidator();
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

    public KmStringValidator getNameValidator()
    {
        return nameValidator;
    }

    public KmIntegerValidator getDurationMsValidator()
    {
        return durationMsValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyPerformanceLogDetail value)
    {
        // fields...
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setCreatedUtcTs(createdUtcTsValidator.convertOnly(value.getCreatedUtcTs()));
        value.setName(nameValidator.convertOnly(value.getName()));
        value.setDurationMs(durationMsValidator.convertOnly(value.getDurationMs()));
    }

    @Override
    public void validateOnly(MyPerformanceLogDetail value, KmList<KmErrorIF> errors)
    {
        // fields...
        uidValidator.validateOnly(value.getUid(), errors);
        createdUtcTsValidator.validateOnly(value.getCreatedUtcTs(), errors);
        nameValidator.validateOnly(value.getName(), errors);
        durationMsValidator.validateOnly(value.getDurationMs(), errors);
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
        e.setModel("performanceLogDetail");
        e.setField("uid");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("performanceLogDetail");
        e.setField("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setModel("performanceLogDetail");
        e.setField("name");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newDurationMsValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("performanceLogDetail");
        e.setField("durationMs");
        e.setRequired();
        return e;
    }


}

