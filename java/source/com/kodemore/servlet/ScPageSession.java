package com.kodemore.servlet;

import com.kodemore.utility.Kmu;

public class ScPageSession
{
    //##################################################
    //# singleton
    //##################################################

    private static ScPageSession _instance;

    public static ScPageSession getInstance()
    {
        if ( _instance == null )
            Kmu.fatal("Not installed.");

        return _instance;
    }

    protected static synchronized void install(ScPageSession e)
    {
        if ( _instance != null )
            Kmu.fatal("Already installed.");

        _instance = e;
    }
}
