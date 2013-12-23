package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
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
    //# start
    //##################################################

    @Override
    public void applyParametersToUrl(ScParameterList v)
    {
        // none
    }

    @Override
    public void applyParametersFromUrl(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        // none
    }
}
