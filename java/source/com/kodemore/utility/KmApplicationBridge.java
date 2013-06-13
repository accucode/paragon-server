package com.kodemore.utility;

/**
 * Used to define a few values that are useful for the framework
 * to know, but which are really the responsibility of the application.
 */
public abstract class KmApplicationBridge
{
    //##################################################
    //# install
    //##################################################

    private static KmApplicationBridge _instance;

    protected static void install(KmApplicationBridge e)
    {
        if ( _instance != null )
            throw new RuntimeException("Already installed.");

        _instance = e;
    }

    public static KmApplicationBridge getInstance()
    {
        return _instance;
    }

    //##################################################
    //# accessing
    //##################################################

    public abstract String getName();

    public abstract String getVersion();

}
