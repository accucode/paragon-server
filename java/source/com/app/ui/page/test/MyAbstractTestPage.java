package com.app.ui.page.test;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public abstract class MyAbstractTestPage
    extends MyPage
{
    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }

}
