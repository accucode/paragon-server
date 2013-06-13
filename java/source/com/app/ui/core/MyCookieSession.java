package com.app.ui.core;

import com.kodemore.servlet.encoder.ScDecoder;
import com.kodemore.servlet.encoder.ScEncoder;
import com.kodemore.utility.Kmu;

import com.app.utility.MyGlobals;

@SuppressWarnings("unused")
public class MyCookieSession
{
    //##################################################
    //# static
    //##################################################

    private static MyCookieSession _instance;

    public static void install()
    {
        if ( _instance != null )
            throw new RuntimeException("Already installed.");

        _instance = new MyCookieSession();
    }

    public static MyCookieSession getInstance()
    {
        if ( _instance == null )
            throw new RuntimeException("Not installed.");

        return _instance;
    }

    //##################################################
    //# private
    //##################################################

    private MyServletData getData()
    {
        return MyGlobals.getData();
    }

    private Integer getInteger(String key)
    {
        try
        {
            return (Integer)getValue(key);
        }
        catch ( Exception ex )
        {
            return null;
        }
    }

    private Object getValue(String key)
    {
        try
        {
            String s = getData().getCookie(key);
            if ( Kmu.isEmpty(s) )
                return null;

            return ScDecoder.staticDecode(s);
        }
        catch ( Exception ex )
        {
            return null;
        }
    }

    private void setValue(String key, Object e)
    {
        String s = ScEncoder.staticEncode(e);
        getData().setCookie(key, s);
    }

}
