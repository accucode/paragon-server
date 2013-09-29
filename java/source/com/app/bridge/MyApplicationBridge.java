package com.app.bridge;

import com.app.utility.MyConstantsIF;

import com.kodemore.utility.KmApplicationBridge;

public class MyApplicationBridge
    extends KmApplicationBridge
{
    //##################################################
    //# install
    //##################################################

    public static void install()
    {
        install(new MyApplicationBridge());
    }

    //##################################################
    //# constructor
    //##################################################

    private MyApplicationBridge()
    {
        // private
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return MyConstantsIF.APPLICATION_NAME;
    }

    @Override
    public String getVersion()
    {
        return MyConstantsIF.APPLICATION_VERSION;
    }
}
