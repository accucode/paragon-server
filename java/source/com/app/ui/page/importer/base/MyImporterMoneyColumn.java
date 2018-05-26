package com.app.ui.page.importer.base;

import com.kodemore.types.KmMoney;
import com.kodemore.utility.KmResult;
import com.kodemore.utility.Kmu;
import com.kodemore.validator.KmMoneyValidator;
import com.kodemore.validator.KmValidator;

/**
 * A column that contains a money.
 */
public class MyImporterMoneyColumn
    extends MyImporterColumn<KmMoney>
{
    //##################################################
    //# constructor
    //##################################################

    public MyImporterMoneyColumn(MyImporter e)
    {
        super(e);
    }

    //##################################################
    //# validator
    //##################################################

    @Override
    protected KmValidator<KmMoney> newValidator()
    {
        return new KmMoneyValidator();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public KmResult<KmMoney> getResult()
    {
        String s = getRawField();
        if ( Kmu.isEmpty(s) )
            return validateNull();

        KmMoney value = getFormatter().parseMoney(s);
        return value == null
            ? KmResult.createError("Cannot parse money.")
            : validate(value);
    }

    //##################################################
    //# sample
    //##################################################

    @Override
    public String getDefaultSample()
    {
        return getFormatter().formatMoney(new KmMoney(12.03));
    }

}
