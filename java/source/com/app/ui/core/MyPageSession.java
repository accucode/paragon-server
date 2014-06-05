package com.app.ui.core;

import com.kodemore.servlet.ScPageSession;

// todo_wyatt: obsolete page session?
public class MyPageSession
    extends ScPageSession
{
    public static void install()
    {
        install(new MyPageSession());
    }

    public static MyPageSession getInstance()
    {
        return (MyPageSession)ScPageSession.getInstance();
    }
}
