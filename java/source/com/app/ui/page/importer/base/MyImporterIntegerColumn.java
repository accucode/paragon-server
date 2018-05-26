package com.app.ui.page.importer.base;

import com.kodemore.utility.KmResult;
import com.kodemore.utility.Kmu;
import com.kodemore.validator.KmIntegerValidator;
import com.kodemore.validator.KmValidator;

/**
 * A column that contains an integer.
 */
public class MyImporterIntegerColumn
    extends MyImporterColumn<Integer>
{
    //##################################################
    //# constructor
    //##################################################

    public MyImporterIntegerColumn(MyImporter e)
    {
        super(e);
    }

    //##################################################
    //# validator
    //##################################################

    @Override
    protected KmValidator<Integer> newValidator()
    {
        return new KmIntegerValidator();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public KmResult<Integer> getResult()
    {
        String s = getRawField();
        if ( Kmu.isEmpty(s) )
            return validateNull();

        Integer value = getFormatter().parseInteger(s);
        return value == null
            ? KmResult.createError("Cannot parse integer.")
            : validate(value);
    }

    //##################################################
    //# sample
    //##################################################

    @Override
    public String getDefaultSample()
    {
        return getFormatter().formatInteger(2431);
    }

}
