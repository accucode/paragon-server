package com.app.ui.page.general;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;
import com.app.utility.MyConstantsIF;

public final class MyDashboardPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyDashboardPage _instance;

    public static void installInstance()
    {
        _instance = new MyDashboardPage();
    }

    public static MyDashboardPage getInstance()
    {
        return _instance;
    }

    private MyDashboardPage()
    {
        // singleton
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.user;
    }

    //##################################################
    //# bookmark
    //##################################################

    @Override
    public void composeBookmarkOn(ScParameterList v)
    {
        // none
    }

    @Override
    public void applyBookmark(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().pad();
        root.addText("Welcome to the %s.", MyConstantsIF.APPLICATION_NAME);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }

}
