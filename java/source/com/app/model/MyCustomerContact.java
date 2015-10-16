package com.app.model;

import com.app.model.base.MyCustomerContactBase;

public class MyCustomerContact
    extends MyCustomerContactBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyCustomerContact()
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
