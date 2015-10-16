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

    private KmStringValidator uidValidator;
    private KmDateValidator utcDateValidator;
    private KmStringValidator nameValidator;
    private KmIntegerValidator countValidator;
    private KmIntegerValidator minimumMsValidator;
    private KmIntegerValidator maximumMsValidator;
    private KmIntegerValidator averageMsValidator;
    private KmIntegerValidator totalMsValidator;

    //##################################################
    //# constructor
    //##################################################

    protected MyPerformanceLogSummaryValidatorBase()
    {
        super();
        uidValidator = newUidValidator();
        utcDateValidator = newUtcDateValidator();
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

    public KmStringValidator getUidValidator()
    {
        return uidValidator;
    }

    public KmDateValidator getUtcDateValidator()
    {
        return utcDateValidator;
    }

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
    public void convertOnly(MyPerformanceLogSummary value)
    {
        // fields...
        value.setUid(uidValidator.convertOnly(value.getUid()));
        value.setUtcDate(utcDateValidator.convertOnly(value.getUtcDate()));
        value.setName(nameValidator.convertOnly(value.getName()));
        value.setCount(countValidator.convertOnly(value.getCount()));
        value.setMinimumMs(minimumMsValidator.convertOnly(value.getMinimumMs()));
        value.setMaximumMs(maximumMsValidator.convertOnly(value.getMaximumMs()));
        value.setAverageMs(averageMsValidator.convertOnly(value.getAverageMs()));
        value.setTotalMs(totalMsValidator.convertOnly(value.getTotalMs()));
    }

    @Override
    public void validateOnly(MyPerformanceLogSummary value, KmList<KmErrorIF> errors)
    {
        // fields...
        uidValidator.validateOnly(value.getUid(), errors);
        utcDateValidator.validateOnly(value.getUtcDate(), errors);
        nameValidator.validateOnly(value.getName(), errors);
        countValidator.validateOnly(value.getCount(), errors);
        minimumMsValidator.validateOnly(value.getMinimumMs(), errors);
        maximumMsValidator.validateOnly(value.getMaximumMs(), errors);
        averageMsValidator.validateOnly(value.getAverageMs(), errors);
        totalMsValidator.validateOnly(value.getTotalMs(), errors);
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
        e.setModel("performanceLogSummary");
        e.setField("uid");
        return e;
    }

    public KmDateValidator newUtcDateValidator()
    {
        KmDateValidator e;
        e = new KmDateValidator();
        e.setModel("performanceLogSummary");
        e.setField("utcDate");
        e.setRequired();
        return e;
    }

    public KmStringValidator newNameValidator()
    {
        KmStringValidator e;
        e = new KmStringValidator();
        e.setMaximumLength(100);
        e.setAllowsPrintable(true);
        e.setModel("performanceLogSummary");
        e.setField("name");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newCountValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("performanceLogSummary");
        e.setField("count");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newMinimumMsValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("performanceLogSummary");
        e.setField("minimumMs");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newMaximumMsValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("performanceLogSummary");
        e.setField("maximumMs");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newAverageMsValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("performanceLogSummary");
        e.setField("averageMs");
        e.setRequired();
        return e;
    }

    public KmIntegerValidator newTotalMsValidator()
    {
        KmIntegerValidator e;
        e = new KmIntegerValidator();
        e.setModel("performanceLogSummary");
        e.setField("totalMs");
        e.setRequired();
        return e;
    }


}

