package com.app.model;

import com.app.model.base.MyPowerTypeBase;

public class MyPowerType
    extends MyPowerTypeBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyPowerType()
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
