package com.app.utility;

import com.kodemore.servlet.MyGlobalSession;
import com.kodemore.servlet.ScPage;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyProject;
import com.app.ui.dashboard.core.MyDashboardPage;
import com.app.ui.layout.MyPageLayout;

/**
 * I coordinate top-level navigation in the application.
 */
public class MyAppNavigator
{
    //##################################################
    //# default page
    //##################################################

    /**
     * Enter the application via the default page.
     */
    public static void ajaxEnter()
    {
        getDefaultPage().ajaxEnter();
    }

    /**
     * Return the page to which users should be directed when no specific page
     * is requested.  If the page requires an authenticated user, navigation will
     * automatically redirect to the Login page.
     */
    public static ScPage getEntryPage()
    {
        return getDefaultPage();
    }

    public static String formatEntryPageQueryString()
    {
        return getDefaultPage().formatQueryString();
    }

    //==================================================
    //= default page :: private
    //==================================================

    private static MyDashboardPage getDefaultPage()
    {
        return MyDashboardPage.getInstance();
    }

    //##################################################
    //# misc
    //##################################################

    public static void selectProject(String uid)
    {
        ScPage page = MyGlobals.getData().getCurrentPage();
        MyProject project = getAccess().findProjectUid(uid);
        MyGlobalSession ps = MyGlobals.getGlobalSession();
        MyPageLayout layout = MyPageLayout.getInstance();

        ps.setCurrentProject(project);
        MyGlobals.getCurrentUser().setLastProject(project);

        layout.ajaxRefreshHeader();
        layout.ajaxRefreshMenu();
        layout.ajaxRefreshTitleFor(page);

        ajaxEnter();
    }

    //##################################################
    //# support
    //##################################################

    private static MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }
}
