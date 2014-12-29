package com.app.ui.page.general;

import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScText;

import com.app.ui.page.MyAbstractEntryPage;
import com.app.ui.page.MySecurityLevel;

public class MyTasksPage
    extends MyAbstractEntryPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyTasksPage instance = new MyTasksPage();

    private MyTasksPage()
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
        _message = root.addText("This page shows tasks for the current project.");
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        if ( !hasCurrentProject() )
            _message.setValue("Please select a project.");
    }

}
