package com.app.ui.page.general;

import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScText;

import com.app.ui.page.MyAbstractEntryPage;
import com.app.ui.page.MySecurityLevel;

public class MyReportsPage
    extends MyAbstractEntryPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyReportsPage instance = new MyReportsPage();

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
        super.preRender();

        if ( !hasCurrentProject() )
            _message.setValue("Please select a project.");
    }

}
