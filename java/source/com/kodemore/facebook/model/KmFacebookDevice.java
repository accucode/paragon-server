package com.kodemore.facebook.model;

import com.kodemore.collection.KmList;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;

public class KmFacebookDevice
    extends Object
{
    //##################################################
    //# constants
    //##################################################

    private static final String OS_KEY       = "os";
    private static final String HARDWARE_KEY = "username";

    //##################################################
    //# variables
    //##################################################

    private String _os;
    private String _hardware;

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

    public static KmList<KmFacebookDevice> createListWith(KmJsonArray devices)
    {
        KmList<KmFacebookDevice> v;
        v = new KmList<>();

        int n = devices.size();
        for ( int i = 0; i < n; i++ )
        {
            KmJsonMap e = devices.getMapAt(i);
            v.add(KmFacebookDevice.createWith(e));
        }

        return v;
    }
}
