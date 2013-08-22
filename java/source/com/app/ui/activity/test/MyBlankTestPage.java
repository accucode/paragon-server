package com.app.ui.activity.test;

import com.kodemore.servlet.control.ScPageRoot;

public class MyBlankTestPage
    extends MyTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyBlankTestPage instance = new MyBlankTestPage();

    private MyBlankTestPage()
    {
        // singleton
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScPageRoot installRoot()
    {
        return null;
    }
}
