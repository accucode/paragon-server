package com.app.ui.page.importer.base;

import com.kodemore.types.KmQuantity;
import com.kodemore.utility.KmResult;
import com.kodemore.utility.Kmu;
import com.kodemore.validator.KmQuantityValidator;
import com.kodemore.validator.KmValidator;

/**
 * A column that contains a quantity.
 */
public class MyImporterQuantityColumn
    extends MyImporterColumn<KmQuantity>
{
    //##################################################
    //# constructor
    //##################################################

    public MyImporterQuantityColumn(MyImporter e)
    {
        super(e);
    }

    //##################################################
    //# validator
    //##################################################

    @Override
    protected KmValidator<KmQuantity> newValidator()
    {
        return new KmQuantityValidator();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public KmResult<KmQuantity> getResult()
    {
        String s = getRawField();
        if ( Kmu.isEmpty(s) )
            return validateNull();

        KmQuantity value = getFormatter().parseQuantity(s);
        return value == null
            ? KmResult.createError("Cannot parse quantity.")
            : validate(value);
    }

    //##################################################
    //# sample
    //##################################################

    @Override
    public String getDefaultSample()
    {
        return getFormatter().formatQuantity(new KmQuantity(5.0125));
    }

}
