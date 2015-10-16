package com.app.model;

import com.app.model.base.MyPerformanceLogDetailBase;

public class MyPerformanceLogDetail
    extends MyPerformanceLogDetailBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyPerformanceLogDetail()
    {
        super();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getName();
    }

}
