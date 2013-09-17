package com.app.ui.activity.test;

import com.app.ui.activity.MyPage;

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
