package com.app.model;

import com.app.model.base.MyCustomerBase;
import com.app.model.support.MyAddressDelegate;
import com.app.model.support.MyAddressIF;

public class MyCustomer
    extends MyCustomerBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyCustomer()
    {
        super();
    }

    //##################################################
    //# address
    //##################################################

    public MyAddressIF getAddress()
    {
        return new MyAddressDelegate<>(
            this,
            Meta.AddressStreet1.getAdaptor(),
            Meta.AddressStreet2.getAdaptor(),
            Meta.AddressCity.getAdaptor(),
            Meta.AddressRegion.getAdaptor(),
            Meta.AddressPostalCode.getAdaptor(),
            Meta.AddressCountry.getAdaptor());
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
