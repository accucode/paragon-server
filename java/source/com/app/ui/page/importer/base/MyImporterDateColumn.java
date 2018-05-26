package com.app.ui.page.importer.base;

import com.kodemore.time.KmDate;
import com.kodemore.utility.KmResult;
import com.kodemore.utility.Kmu;
import com.kodemore.validator.KmDateValidator;
import com.kodemore.validator.KmValidator;

/**
 * A column that contains a date.
 */
public class MyImporterDateColumn
    extends MyImporterColumn<KmDate>
{
    //##################################################
    //# constructor
    //##################################################

    public MyImporterDateColumn(MyImporter e)
    {
        super(e);
    }

    //##################################################
    //# validator
    //##################################################

    @Override
    protected KmValidator<KmDate> newValidator()
    {
        return new KmDateValidator();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public KmResult<KmDate> getResult()
    {
        String s = getRawField();
        if ( Kmu.isEmpty(s) )
            return validateNull();

        KmDate value = getFormatter().parseDate(s);
        return value == null
            ? KmResult.createError("Cannot parse date.")
            : validate(value);
    }

    //##################################################
    //# sample
    //##################################################

    @Override
    public String getDefaultSample()
    {
        return getFormatter().formatDate(KmDate.fromYearMonthDay(2015, 1, 31));
    }

}
