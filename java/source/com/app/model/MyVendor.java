package com.app.model;

import com.app.model.base.MyVendorBase;

public class MyVendor
    extends MyVendorBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyVendor()
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
