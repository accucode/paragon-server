package com.app.filter.value;

import com.kodemore.utility.KmEnumIF;
import com.kodemore.utility.Kmu;

public class MyFilterBooleanValue
    extends MyFilterValue<Boolean>
{
    //##################################################
    //# constructor
    //##################################################

    public MyFilterBooleanValue(KmEnumIF e)
    {
        super(e);
    }

    //##################################################
    //# value
    //##################################################

    @Override
    public Boolean getValue()
    {
        return Kmu.parseBoolean(getStringValue());
    }

    @Override
    public void setValue(Boolean e)
    {
        setStringValue(Kmu.formatBoolean(e, "true", "false", null));
    }
}
