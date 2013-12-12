package com.app.ui.activity;

import com.kodemore.servlet.ScPageRegistry;

import com.app.ui.activity.general.MyHomePage;
import com.app.ui.servlet.base.MyPageRegistryBase;

public class MyPageRegistry
    extends MyPageRegistryBase
{
    //##################################################
    //# install
    //##################################################

    public static void install()
    {
        ScPageRegistry.install(new MyPageRegistry());
    }

    public static MyPageRegistry getInstance()
    {
        return (MyPageRegistry)ScPageRegistry.getInstance();
    }

    //##################################################
    //# constructor
    //##################################################

    protected MyPageRegistry()
    {
        // protected
    }

    //##################################################
    //# accessing
    //##################################################

    public MyPage getHomeActivity()
    {
        return MyHomePage.instance;
    }

}
