package com.app.ui.page.importer.base;

import com.kodemore.utility.KmResult;
import com.kodemore.validator.KmStringValidator;
import com.kodemore.validator.KmValidator;

/**
 * A column that contains unformatted string (text) data.
 */
public class MyImporterStringColumn
    extends MyImporterColumn<String>
{
    //##################################################
    //# constructor
    //##################################################

    public MyImporterStringColumn(MyImporter e)
    {
        super(e);
    }

    //##################################################
    //# validator
    //##################################################

    @Override
    protected KmValidator<String> newValidator()
    {
        return new KmStringValidator();
    }

    public void allowAll()
    {
        KmStringValidator e = (KmStringValidator)getValidator();
        if ( e == null )
        {
            e = new KmStringValidator();
            setValidator(e);
        }
        e.allowAll();
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public KmResult<String> getResult()
    {
        String value = getRawField();
        return validate(value);
    }

    //##################################################
    //# sample
    //##################################################

    @Override
    public String getDefaultSample()
    {
        return "Text";
    }

}
