package com.app.ui.page.tools;

import com.app.ui.page.MyPage;

public abstract class MyToolsPage
    extends MyPage
{
    //##################################################
    //# security
    //##################################################

    @Override
    protected boolean requiresDeveloper()
    {
        return true;
    }
}
