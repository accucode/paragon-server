package com.app.model;

import com.app.model.base.MyOrderNumberBase;

public class MyOrderNumber
    extends MyOrderNumberBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyOrderNumber()
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
