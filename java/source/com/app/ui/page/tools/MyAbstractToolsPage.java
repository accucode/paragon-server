package com.app.ui.page.tools;

import com.kodemore.servlet.ScEntryPageIF;

import com.app.ui.layout.MyLeftMenuItem;
import com.app.ui.page.MyPage;

public abstract class MyAbstractToolsPage
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

    //##################################################
    //# setup
    //##################################################

    @Override
    public MyLeftMenuItem getMenuItem()
    {
        return MyLeftMenuItem.tools;
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
