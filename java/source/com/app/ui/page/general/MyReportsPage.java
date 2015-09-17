package com.app.ui.page.general;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScText;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyReportsPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyReportsPage _instance;

    public static void installInstance()
    {
        _instance = new MyReportsPage();
    }

    public static MyReportsPage getInstance()
    {
        return _instance;
    }

    private MyReportsPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScText _message;

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.member;
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
        _message = root.addText("This page displays reports for the current project.");
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        if ( !hasCurrentProject() )
            _message.setValue("Please select a project.");
    }

}
