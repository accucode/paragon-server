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

import com.app.model.MyPerformanceLogSummaryVo;
import com.app.model.MyPerformanceLogSummaryVoValidator;
import com.app.model.core.MyDomainValidator;

/**
 * Validation rules for performanceLogSummaryVo.
 */
public class MyPerformanceLogSummaryVoValidatorBase
    extends MyDomainValidator<MyPerformanceLogSummaryVo>
{
    //##################################################
    //# static
    //##################################################

    public static final MyPerformanceLogSummaryVoValidator instance = new MyPerformanceLogSummaryVoValidator();

    //##################################################
    //# variables
    //##################################################

    private KmStringValidator nameValidator;
    private KmIntegerValidator countValidator;
    private KmIntegerValidator minimumMsValidator;
    private KmIntegerValidator maximumMsValidator;
    private KmIntegerValidator averageMsValidator;
    private KmIntegerValidator totalMsValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyPerformanceLogSummaryVoValidatorBase()
    {
        super();
        nameValidator = newNameValidator();
        countValidator = newCountValidator();
        minimumMsValidator = newMinimumMsValidator();
        maximumMsValidator = newMaximumMsValidator();
        averageMsValidator = newAverageMsValidator();
        totalMsValidator = newTotalMsValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmStringValidator getNameValidator()
    {
        return nameValidator;
    }

    public KmIntegerValidator getCountValidator()
    {
        return countValidator;
    }

    public KmIntegerValidator getMinimumMsValidator()
    {
        return minimumMsValidator;
    }

    public KmIntegerValidator getMaximumMsValidator()
    {
        return maximumMsValidator;
    }

    public KmIntegerValidator getAverageMsValidator()
    {
        return averageMsValidator;
    }

    public KmIntegerValidator getTotalMsValidator()
    {
        return totalMsValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyPerformanceLogSummaryVo value)
    {
        value.setName(nameValidator.convertOnly(value.getName()));
        value.setCount(countValidator.convertOnly(value.getCount()));
        value.setMinimumMs(minimumMsValidator.convertOnly(value.getMinimumMs()));
        value.setMaximumMs(maximumMsValidator.convertOnly(value.getMaximumMs()));
        value.setAverageMs(averageMsValidator.convertOnly(value.getAverageMs()));
        value.setTotalMs(totalMsValidator.convertOnly(value.getTotalMs()));
    }

    @Override
    public void validateOnly(MyPerformanceLogSummaryVo value, KmList<KmErrorIF> errors)
    {
        nameValidator.validateOnly(value.getName(), errors);
        countValidator.validateOnly(value.getCount(), errors);
        minimumMsValidator.validateOnly(value.getMinimumMs(), errors);
        maximumMsValidator.validateOnly(value.getMaximumMs(), errors);
        averageMsValidator.validateOnly(value.getAverageMs(), errors);
        totalMsValidator.validateOnly(value.getTotalMs(), errors);
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setModel("performanceLogSummaryVo");
        e.setField("name");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newCountValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("performanceLogSummaryVo");
        e.setField("count");
        return e;
    }

    public KmIntegerValidator newMinimumMsValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("performanceLogSummaryVo");
        e.setField("minimumMs");
        return e;
    }

    public KmIntegerValidator newMaximumMsValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("performanceLogSummaryVo");
        e.setField("maximumMs");
        return e;
    }

    public KmIntegerValidator newAverageMsValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("performanceLogSummaryVo");
        e.setField("averageMs");
        return e;
    }

    public KmIntegerValidator newTotalMsValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("performanceLogSummaryVo");
        e.setField("totalMs");
        return e;
    }


}

