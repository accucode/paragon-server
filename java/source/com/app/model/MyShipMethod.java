package com.app.model;

import com.app.model.base.MyShipMethodBase;

public class MyShipMethod
    extends MyShipMethodBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyShipMethod()
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
