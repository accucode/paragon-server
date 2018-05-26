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
 * Validation rules for performanceLogSummary.
 */
public class MyPerformanceLogSummaryValidatorBase
    extends MyDomainValidator<MyPerformanceLogSummary>
{
    //##################################################
    //# static
    //##################################################

    public static final MyPerformanceLogSummaryValidator instance = new MyPerformanceLogSummaryValidator();

    //##################################################
    //# variables
    //##################################################

    private KmIntegerValidator averageMsValidator;
    private KmIntegerValidator countValidator;
    private KmIntegerValidator maximumMsValidator;
    private KmIntegerValidator minimumMsValidator;
    private KmStringValidator nameValidator;
    private KmIntegerValidator totalMsValidator;
    private KmStringValidator uidValidator;
    private KmDateValidator utcDateValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyPerformanceLogSummaryValidatorBase()
    {
        super();
        averageMsValidator = newAverageMsValidator();
        countValidator = newCountValidator();
        maximumMsValidator = newMaximumMsValidator();
        minimumMsValidator = newMinimumMsValidator();
        nameValidator = newNameValidator();
        totalMsValidator = newTotalMsValidator();
        uidValidator = newUidValidator();
        utcDateValidator = newUtcDateValidator();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmIntegerValidator getAverageMsValidator()
    {
        return averageMsValidator;
    }

    public KmIntegerValidator getCountValidator()
    {
        return countValidator;
    }

    public KmIntegerValidator getMaximumMsValidator()
    {
        return maximumMsValidator;
    }

    public KmIntegerValidator getMinimumMsValidator()
    {
        return minimumMsValidator;
    }

    public KmStringValidator getNameValidator()
    {
        return nameValidator;
    }

    public KmIntegerValidator getTotalMsValidator()
    {
        return totalMsValidator;
    }

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmDateValidator getUtcDateValidator()
    {
        return utcDateValidator;
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void convertOnly(MyPerformanceLogSummary value)
    {
        // fields...
        value.setAverageMs(averageMsValidator.convert(value.getAverageMs()));
        value.setCount(countValidator.convert(value.getCount()));
        value.setMaximumMs(maximumMsValidator.convert(value.getMaximumMs()));
        value.setMinimumMs(minimumMsValidator.convert(value.getMinimumMs()));
        value.setName(nameValidator.convert(value.getName()));
        value.setTotalMs(totalMsValidator.convert(value.getTotalMs()));
        value.setUid(uidValidator.convert(value.getUid()));
        value.setUtcDate(utcDateValidator.convert(value.getUtcDate()));
    }

    @Override
    public void validateOnly(MyPerformanceLogSummary value, KmErrorList errors)
    {
        // fields...
        averageMsValidator.validateOn(value.getAverageMs(), errors);
        countValidator.validateOn(value.getCount(), errors);
        maximumMsValidator.validateOn(value.getMaximumMs(), errors);
        minimumMsValidator.validateOn(value.getMinimumMs(), errors);
        nameValidator.validateOn(value.getName(), errors);
        totalMsValidator.validateOn(value.getTotalMs(), errors);
        uidValidator.validateOn(value.getUid(), errors);
        utcDateValidator.validateOn(value.getUtcDate(), errors);
        // required associations...
    }

    //##################################################
    //# instance creation
    //##################################################

    public KmIntegerValidator newAverageMsValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("performanceLogSummary");
        e.setFieldName("averageMs");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newCountValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("performanceLogSummary");
        e.setFieldName("count");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newMaximumMsValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("performanceLogSummary");
        e.setFieldName("maximumMs");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newMinimumMsValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("performanceLogSummary");
        e.setFieldName("minimumMs");
        e.setRequired();
        return e;
    }

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setModelName("performanceLogSummary");
        e.setFieldName("name");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newTotalMsValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModelName("performanceLogSummary");
        e.setFieldName("totalMs");
        e.setRequired();
        return e;
    }

    public KmStringValidator newUidValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(30);
        e.setAllowsPrintable(true);
        e.setModelName("performanceLogSummary");
        e.setFieldName("uid");
        e.setRequired();
        return e;
    }

    public KmDateValidator newUtcDateValidator()
    {
        KmDateValidator e;
        e = new KmDateValidator();
        e.setModelName("performanceLogSummary");
        e.setFieldName("utcDate");
        e.setRequired();
        return e;
    }


}

