package com.app.model;

import com.app.model.base.MyEndUserSiteBase;
import com.app.model.support.MyAddressDelegate;
import com.app.model.support.MyAddressIF;

public class MyEndUserSite
    extends MyEndUserSiteBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyEndUserSite()
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
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getName();
    }

}
