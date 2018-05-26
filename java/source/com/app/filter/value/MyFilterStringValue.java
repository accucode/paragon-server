package com.app.filter.value;

import com.kodemore.utility.KmEnumIF;

public class MyFilterStringValue
    extends MyFilterValue<String>
{
    //##################################################
    //# constructor
    //##################################################

    public MyFilterStringValue(KmEnumIF e)
    {
        super(e);
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public String getValue()
    {
        return getStringValue();
    }

    @Override
    public void setValue(String e)
    {
        setStringValue(e);
    }
}
