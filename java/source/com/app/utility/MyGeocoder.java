package com.app.utility;

import com.kodemore.geocode.KmGeocoder;

public class MyGeocoder
    extends KmGeocoder
{
    //##################################################
    //# static
    //##################################################

    private static String getApiKey()
    {
        return MyGlobals.getProperties().getGoogleMapsApiKey();
    }

    //##################################################
    //# constructor
    //##################################################

    public MyGeocoder()
    {
        super(getApiKey());
    }

}
