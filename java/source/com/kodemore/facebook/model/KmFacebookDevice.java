package com.kodemore.facebook.model;

import com.kodemore.json.KmJsonMap;

public class KmFacebookDevice
    extends Object
{
    //##################################################
    //# constants
    //##################################################

    public static final String OS_KEY       = "os";
    public static final String HARDWARE_KEY = "username";

    //##################################################
    //# variables 
    //##################################################

    private String             _os;
    private String             _hardware;

    //##################################################
    //# accessing
    //##################################################

    public String getOs()
    {
        return _os;
    }

    public void setOs(String e)
    {
        _os = e;
    }

    public String getHardware()
    {
        return _hardware;
    }

    public void setHardware(String e)
    {
        _hardware = e;
    }

    //##################################################
    //# convenience
    //##################################################

    public static KmFacebookDevice createWith(KmJsonMap map)
    {
        KmFacebookDevice e;
        e = new KmFacebookDevice();
        e.setOs(map.getString(KmFacebookDevice.OS_KEY));
        e.setHardware(map.getString(KmFacebookDevice.HARDWARE_KEY));
        return e;
    }
}
