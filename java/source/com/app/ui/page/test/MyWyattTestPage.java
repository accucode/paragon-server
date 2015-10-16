package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyWyattTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyWyattTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyWyattTestPage();
    }

    public static MyWyattTestPage getInstance()
    {
        return _instance;
    }

    private MyWyattTestPage()
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
        root.addButton("test", this::handleTest);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }

    //##################################################
    //# handle
    //##################################################

    private void handleTest()
    {
        ajax().toast("hello");
    }
}
