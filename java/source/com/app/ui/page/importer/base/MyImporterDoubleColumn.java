package com.app.ui.page.importer.base;

import com.kodemore.utility.KmResult;
import com.kodemore.utility.Kmu;
import com.kodemore.validator.KmDoubleValidator;
import com.kodemore.validator.KmValidator;

/**
 * A column that contains an double.
 */
public class MyImporterDoubleColumn
    extends MyImporterColumn<Double>
{
    //##################################################
    //# constructor
    //##################################################

    public MyImporterDoubleColumn(MyImporter e)
    {
        super(e);
    }

    //##################################################
    //# validator
    //##################################################

    @Override
    protected KmValidator<Double> newValidator()
    {
        return new KmDoubleValidator();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public KmResult<Double> getResult()
    {
        String s = getRawField();
        if ( Kmu.isEmpty(s) )
            return validateNull();

        Double value = getFormatter().parseDouble(s);
        return value == null
            ? KmResult.createError("Cannot parse double.")
            : validate(value);
    }

    //##################################################
    //# sample
    //##################################################

    @Override
    public String getDefaultSample()
    {
        return getFormatter().formatDouble(2431.25);
    }

}
