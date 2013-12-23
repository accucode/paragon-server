package com.app.ui.page.tools;

import com.app.ui.layout.MyLeftMenuItem;
import com.app.ui.page.MyPage;

public abstract class MyToolsPage
    extends MyPage
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

}
