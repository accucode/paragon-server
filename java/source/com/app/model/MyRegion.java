package com.app.model;

import com.app.model.base.MyRegionBase;

public class MyRegion
    extends MyRegionBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyRegion()
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
