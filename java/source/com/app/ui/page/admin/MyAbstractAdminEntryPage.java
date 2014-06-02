package com.app.ui.page.admin;

import com.kodemore.servlet.ScEntryPageIF;
import com.kodemore.servlet.ScParameterList;

import com.app.ui.layout.MyLeftMenuItem;

public abstract class MyAbstractAdminEntryPage
    extends MyAbstractAdminPage
    implements ScEntryPageIF
{
    //##################################################
    //# setup
    //##################################################

    @Override
    public MyLeftMenuItem getMenuItem()
    {
        return MyLeftMenuItem.admin;
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

    @Override
    public final ScParameterList composeQueryParameters()
    {
        return null;
    }

    @Override
    public final void applyQueryParameters(ScParameterList v)
    {
        // none
    }

}
