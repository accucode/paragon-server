package com.kodemore.servlet.utility;

import com.kodemore.utility.Kmu;

/**
 * See MyCallbackServlet
 */
public abstract class ScServletCallback
{
    //##################################################
    //# variables
    //##################################################

    private String _key;

    //##################################################
    //# constructor
    //##################################################

    public ScServletCallback(String key)
    {
        _key = key;
    }

    //##################################################
    //# key
    //##################################################

    public String getKey()
    {
        return _key;
    }

    public boolean hasKey(String e)
    {
        return Kmu.isEqual(_key, e);
    }

    //##################################################
    //# path
    //##################################################

    public String getPath(String suffix)
    {
        ScServletCallbackRegistry r = ScServletCallbackRegistry.getInstance();
        String prefix = r.getPrefix();

        return Kmu.joinUrlPath(prefix, getKey(), suffix);
    }

    //##################################################
    //# handle
    //##################################################

    public abstract void handle(String suffix);
}
