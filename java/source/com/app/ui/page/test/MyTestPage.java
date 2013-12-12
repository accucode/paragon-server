package com.app.ui.page.test;

import com.app.ui.page.MyPage;

public abstract class MyTestPage
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
