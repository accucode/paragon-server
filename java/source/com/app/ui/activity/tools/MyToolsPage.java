package com.app.ui.activity.tools;

import com.app.ui.activity.MyPage;

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
