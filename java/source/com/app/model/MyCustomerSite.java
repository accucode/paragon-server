package com.app.model;

import com.app.model.base.MyCustomerSiteBase;
import com.app.model.support.MyAddressDelegate;
import com.app.model.support.MyAddressIF;

public class MyCustomerSite
    extends MyCustomerSiteBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyCustomerSite()
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
