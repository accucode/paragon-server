package com.app.utility;

import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyAccount;
import com.app.ui.core.MyPageSession;
import com.app.ui.layout.MyPageLayout;
import com.app.ui.page.MyPage;
import com.app.ui.page.general.MyHomePage;

public class MyNavigator
{
    //##################################################
    //# default page
    //##################################################

    /**
     * Return the page to which users should be directed when no specific page 
     * is requested.  The page must not have any required parameters.  If the 
     * page requires an authenticated user, navigation will automatically 
     * redirect to the Login page. 
     */
    public static MyPage getDefaultPage()
    {
        return _getDefaultPage();
    }

    public static void pushDefaultPage()
    {
        _getDefaultPage().push();
    }

    public static String formatDefaultPageQueryString()
    {
        return _getDefaultPage().formatQueryString();
    }

    //==================================================
    //= default page :: private
    //==================================================

    private static MyHomePage _getDefaultPage()
    {
        return MyHomePage.instance;
    }

    //##################################################
    //# misc
    //##################################################

    public static void selectAccount(String uid)
    {
        // todo_wyatt: security
        MyAccount acct = getAccess().findAccountUid(uid);

        getPageSession().setCurrentAccount(acct);
        getPageLayout().ajaxRefresh();
        pushDefaultPage();
    }

    //##################################################
    //# support
    //##################################################

    private static MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }

    private static MyPageSession getPageSession()
    {
        return MyGlobals.getPageSession();
    }

    private static MyPageLayout getPageLayout()
    {
        return MyPageLayout.getInstance();
    }
}
