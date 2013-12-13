package com.app.utility;

import com.app.ui.page.MyPage;
import com.app.ui.page.general.MyHomePage;

public class MyNavigator
{
    public static void startDefaultPage()
    {
        getDefaultPage().start();
    }

    public static MyPage getDefaultPage()
    {
        return MyHomePage.instance;
    }
}
