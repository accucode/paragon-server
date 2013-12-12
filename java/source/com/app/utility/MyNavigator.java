package com.app.utility;

import com.app.ui.page.MyPage;
import com.app.ui.page.login.MySignInPage;

public class MyNavigator
{
    public static void startDefaultPage()
    {
        getDefaultPage().start();
    }

    // todo_wyatt: default page
    public static MyPage getDefaultPage()
    {
        // return MyHomePage.instance;
        return MySignInPage.instance;
    }
}
