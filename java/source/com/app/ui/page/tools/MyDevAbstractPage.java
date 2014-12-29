package com.app.ui.page.tools;

import com.kodemore.servlet.ScEntryPageIF;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public abstract class MyDevAbstractPage
    extends MyPage
    implements ScEntryPageIF
{
    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }

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

}
