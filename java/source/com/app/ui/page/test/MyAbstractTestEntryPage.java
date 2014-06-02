package com.app.ui.page.test;

import com.kodemore.servlet.ScEntryPageIF;

import com.app.ui.layout.MyLeftMenuItem;
import com.app.ui.page.MyPage;

public abstract class MyAbstractTestEntryPage
    extends MyPage
    implements ScEntryPageIF
{
    //##################################################
    //# setup
    //##################################################

    @Override
    protected boolean requiresDeveloper()
    {
        return true;
    }

    @Override
    public MyLeftMenuItem getMenuItem()
    {
        return MyLeftMenuItem.tests;
    }

    //##################################################
    //# navigation
    //##################################################

    @Override
    public final void push()
    {
        _push();
    }

    @Override
    public final String formatQueryString()
    {
        return _formatQueryString();
    }

}
