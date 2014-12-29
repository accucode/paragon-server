package com.app.ui.page.general;

import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.MyAbstractEntryPage;
import com.app.ui.page.MySecurityLevel;

public class MyDashboardPage
    extends MyAbstractEntryPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyDashboardPage instance = new MyDashboardPage();

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
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().pad();
        root.addText("Welcome to the KodeMore demo.");
    }

}
