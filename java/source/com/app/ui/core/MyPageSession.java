package com.app.ui.core;

import com.kodemore.servlet.ScPageSession;

import com.app.ui.servlet.base.MyPageSessionBase;

public class MyPageSession
    extends MyPageSessionBase
{
    //##################################################
    //# static
    //##################################################

    public static MyPageSession getInstance()
    {
        return (MyPageSession)ScPageSession.getInstance();
    }

    public static void install()
    {
        install(new MyPageSession());
    }

    //##################################################
    //# constructor
    //##################################################

    private MyPageSession()
    {
        // private
    }
}
