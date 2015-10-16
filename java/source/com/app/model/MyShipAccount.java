package com.app.model;

import com.app.model.base.MyShipAccountBase;

public class MyShipAccount
    extends MyShipAccountBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyShipAccount()
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
