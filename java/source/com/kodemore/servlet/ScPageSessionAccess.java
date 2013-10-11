package com.kodemore.servlet;

import com.kodemore.json.KmJsonMap;
import com.kodemore.servlet.encoder.ScDecoder;
import com.kodemore.servlet.encoder.ScEncoder;

public class ScPageSessionAccess
{
    //##################################################
    //# variables
    //##################################################

    private ScServletData _data;

    //##################################################
    //# constructor
    //##################################################

    ScPageSessionAccess(ScServletData data)
    {
        _data = data;
    }

    //##################################################
    //# accessing
    //##################################################

    public Object get(String key)
    {
        String s = _getJson().getString(key);
        return ScDecoder.staticDecode(s);
    }

    public void put(String key, Object e)
    {
        String s = ScEncoder.staticEncode(e);
        _getJson().setString(key, s);
    }

    public void remove(String key)
    {
        _getJson().removeKey(key);
    }

    public boolean containsKey(String key)
    {
        return _getJson().hasKey(key);
    }

    //##################################################
    //# support
    //##################################################

    private KmJsonMap _getJson()
    {
        return _data.getPageSessionEncodedValues();
    }

}
