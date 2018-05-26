package com.app.ui.page.importer.base;

import com.kodemore.utility.KmResult;
import com.kodemore.utility.Kmu;
import com.kodemore.validator.KmBooleanValidator;
import com.kodemore.validator.KmValidator;

/**
 * A column that contains a boolean.
 */
public class MyImporterBooleanColumn
    extends MyImporterColumn<Boolean>
{
    //##################################################
    //# constructor
    //##################################################

    public MyImporterBooleanColumn(MyImporter e)
    {
        super(e);
    }

    //##################################################
    //# validator
    //##################################################

    @Override
    protected KmValidator<Boolean> newValidator()
    {
        return new KmBooleanValidator();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public KmResult<Boolean> getResult()
    {
        String s = getRawField();
        if ( Kmu.isEmpty(s) )
            return validateNull();

        Boolean value = getFormatter().parseBoolean(s);
        return value == null
            ? KmResult.createError("Cannot parse boolean.")
            : validate(value);
    }

    //##################################################
    //# sample
    //##################################################

    @Override
    public String getDefaultSample()
    {
        return getFormatter().formatBoolean(true);
    }
}
