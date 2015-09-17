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
        MyServerSession ss = MyGlobals.getServerSession();
        MyPageLayout layout = MyPageLayout.getInstance();

        ss.setCurrentProject(project);
        layout.ajaxRefreshHeaderContent();
        layout.ajaxRefreshTitleContentFor(page);
        ajaxEnter();
    }

    //##################################################
    //# support
    //##################################################

    private static MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
}
