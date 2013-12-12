package com.app.ui.page.test;

import com.app.ui.page.MySubPage;

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
