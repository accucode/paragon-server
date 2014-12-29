package com.app.utility;

import com.kodemore.servlet.ScPage;

import com.app.dao.base.MyDaoRegistry;
import com.app.model.MyProject;
import com.app.model.MyServerSession;
import com.app.ui.layout.MyPageLayout;
import com.app.ui.page.general.MyDashboardPage;

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
    public static ScPage getEntryPage()
    {
        return _getDefaultPage();
    }

    public static void pushDefaultPage()
    {
        _getDefaultPage().ajaxPush();
    }

    public static String formatDefaultPageQueryString()
    {
        return _getDefaultPage().formatQueryString();
    }

    //==================================================
    //= default page :: private
    //==================================================

    private static MyDashboardPage _getDefaultPage()
    {
        return MyDashboardPage.instance;
    }

    //##################################################
    //# misc
    //##################################################

    public static void selectProject(String uid)
    {
        ScPage page = MyGlobals.getData().getCurrentPage();
        MyProject project = getAccess().findProjectUid(uid);
        MyServerSession ss = MyGlobals.getServerSession();
        MyPageLayout layout = MyPageLayout.getInstance();

        ss.setCurrentProject(project);
        layout.ajaxRefreshHeaderContent();
        layout.ajaxRefreshTitleContentFor(page);
        pushDefaultPage();
    }

    //##################################################
    //# support
    //##################################################

    private static MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
}
