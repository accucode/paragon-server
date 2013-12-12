package com.app.ui.activity.tools;

import com.app.ui.activity.MySubPage;

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
