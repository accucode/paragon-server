package com.app.model;

import com.app.model.base.MyShipmentBase;

public class MyShipment
    extends MyShipmentBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyShipment()
    {
        super();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getTrackingNumber();
    }

}
