package com.app.ui.activity.test;

import com.kodemore.servlet.control.ScControl;

public class MyBlankTestPage
    extends MyAbstractTestPage
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
    protected ScControl installRoot()
    {
        return null;
    }
}
