package com.app.ui.activity.test;

import com.app.ui.activity.MySubPage;

public abstract class MyTestPage
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
