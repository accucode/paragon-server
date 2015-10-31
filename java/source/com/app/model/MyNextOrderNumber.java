package com.app.model;

import com.app.model.base.MyNextOrderNumberBase;

public class MyNextOrderNumber
    extends MyNextOrderNumberBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyNextOrderNumber()
    {
        super();
    }

    //##################################################
    //# convenience
    //##################################################

    public void incrementNextNumberBy(int n)
    {
        setNextNumber(getNextNumber() + n);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getDate().format_mm_dd_yy() + " " + getNextNumber();
    }

}
