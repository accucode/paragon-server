//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import com.kodemore.collection.KmList;
import com.kodemore.exception.error.KmErrorIF;
import com.kodemore.validator.KmIntegerValidator;
import com.kodemore.validator.KmStringValidator;
import com.kodemore.validator.KmTimestampValidator;

import com.app.model.MyPerformanceLog;
import com.app.model.MyPerformanceLogValidator;
import com.app.model.core.MyDomainValidator;

/**
 * Validation rules for performanceLog.
 */
public class MyPerformanceLogValidatorBase
    extends MyDomainValidator<MyPerformanceLog>
{
    //##################################################
    //# static
    //##################################################

    public static final MyPerformanceLogValidator instance = new MyPerformanceLogValidator();

    //##################################################
    //# variables
    //##################################################

    private KmIntegerValidator idValidator;
    private KmStringValidator nameValidator;
    private KmTimestampValidator createdUtcTsValidator;
    private KmIntegerValidator durationMsValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyPerformanceLogValidatorBase()
    {
        super();
        idValidator = newIdValidator();
        nameValidator = newNameValidator();
        createdUtcTsValidator = newCreatedUtcTsValidator();
        durationMsValidator = newDurationMsValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmIntegerValidator getIdValidator()
    {
        return idValidator;
    }

    public KmStringValidator getNameValidator()
    {
        return nameValidator;
    }

    public KmTimestampValidator getCreatedUtcTsValidator()
    {
        return createdUtcTsValidator;
    }

    public KmIntegerValidator getDurationMsValidator()
    {
        return durationMsValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyPerformanceLog value)
    {
        value.setId(idValidator.convertOnly(value.getId()));
        value.setName(nameValidator.convertOnly(value.getName()));
        value.setCreatedUtcTs(createdUtcTsValidator.convertOnly(value.getCreatedUtcTs()));
        value.setDurationMs(durationMsValidator.convertOnly(value.getDurationMs()));
    }

    @Override
    public void validateOnly(MyPerformanceLog value, KmList<KmErrorIF> errors)
    {
        idValidator.validateOnly(value.getId(), errors);
        nameValidator.validateOnly(value.getName(), errors);
        createdUtcTsValidator.validateOnly(value.getCreatedUtcTs(), errors);
        durationMsValidator.validateOnly(value.getDurationMs(), errors);
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmIntegerValidator newIdValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("performanceLog");
        e.setField("id");
        return e;
    }

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setModel("performanceLog");
        e.setField("name");
        e.setRequired();
        return e;
    }

    public KmTimestampValidator newCreatedUtcTsValidator()
    {
        KmTimestampValidator e;
        e = new KmTimestampValidator();
        e.setModel("performanceLog");
        e.setField("createdUtcTs");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newDurationMsValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("performanceLog");
        e.setField("durationMs");
        e.setRequired();
        return e;
    }


}

