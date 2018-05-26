package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyBlankTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyBlankTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyBlankTestPage();
    }

    public static MyBlankTestPage getInstance()
    {
        return _instance;
    }

    private MyBlankTestPage()
    {
        // singleton
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public final MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        // none
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }

}
