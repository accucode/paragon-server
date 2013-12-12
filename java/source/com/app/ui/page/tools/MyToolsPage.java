package com.app.ui.page.tools;

import com.app.ui.page.MySubPage;

public abstract class MyToolsPage
    extends MySubPage
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
