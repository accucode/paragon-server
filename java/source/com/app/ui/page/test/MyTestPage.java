package com.app.ui.page.test;

import com.app.ui.layout.MyLeftMenuItem;
import com.app.ui.page.MyPage;

public abstract class MyTestPage
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

    @Override
    public MyLeftMenuItem getMenuItem()
    {
        return MyLeftMenuItem.tests;
    }

}
