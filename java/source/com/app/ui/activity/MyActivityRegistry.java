package com.app.ui.activity;

import com.kodemore.servlet.ScActivityRegistry;

import com.app.ui.servlet.base.MyActivityRegistryBase;

public class MyActivityRegistry
    extends MyActivityRegistryBase
{
    //##################################################
    //# install
    //##################################################

    public static void install()
    {
        ScActivityRegistry.install(new MyActivityRegistry());
    }

    public static MyActivityRegistry getInstance()
    {
        return (MyActivityRegistry)ScActivityRegistry.getInstance();
    }

    //##################################################
    //# constructor
    //##################################################

    protected MyActivityRegistry()
    {
        // protected
    }

}
