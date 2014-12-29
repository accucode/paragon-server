package com.app.ui.page;

import com.kodemore.servlet.ScEntryPageIF;
import com.kodemore.servlet.ScParameterList;

public abstract class MyAbstractEntryPage
    extends MyPage
    implements ScEntryPageIF
{
    //##################################################
    //# navigation
    //##################################################

    @Override
    public final void ajaxPush()
    {
        _ajaxPush();
    }

    @Override
    public final String formatQueryString()
    {
        return _formatQueryString();
    }

    @Override
    public ScParameterList composeQueryParameters()
    {
        return null;
    }

    @Override
    public void applyQueryParameters(ScParameterList v)
    {
        // none
    }

}
