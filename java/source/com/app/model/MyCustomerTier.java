package com.app.model;

import com.app.model.base.MyCustomerTierBase;

public class MyCustomerTier
    extends MyCustomerTierBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyCustomerTier()
    {
        super();
    }

    //##################################################
    //# convenience
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getName();
    }

}
