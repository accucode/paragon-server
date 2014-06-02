package com.app.ui.page.admin;

import com.app.ui.layout.MyLeftMenuItem;
import com.app.ui.page.MyPage;

public abstract class MyAbstractAdminPage
    extends MyPage
{
    //##################################################
    //# setup
    //##################################################

    @Override
    public MyLeftMenuItem getMenuItem()
    {
        return MyLeftMenuItem.admin;
    }

}
