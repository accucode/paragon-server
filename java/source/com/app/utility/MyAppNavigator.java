package com.app.utility;

import com.kodemore.command.KmDao;
import com.kodemore.exception.KmSecurityException;
import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.script.ScEnterPageScript;

import com.app.model.MyMember;
import com.app.model.MyProject;
import com.app.model.MyUser;
import com.app.ui.MyGlobalSession;
import com.app.ui.core.MyServletData;
import com.app.ui.dashboard.core.MyDashboardPage;
import com.app.ui.layout.MyPageLayout;
import com.app.ui.page.MyPage;

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
        getDefaultPage().ajaxEnterFresh();
    }

    /**
     * Return the page to which users should be directed when no specific page
     * is requested.  If the page requires an authenticated user, navigation will
     * automatically redirect to the Login page.
     */
    public static MyPage getEntryPage()
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

    private static MyPage getDefaultPage()
    {
        return KmDao.fetch(MyAppNavigator::getDefaultPageDao);
    }

    private static MyPage getDefaultPageDao()
    {
        MyDashboardPage def = MyDashboardPage.getInstance();

        MyMember member = MyGlobals.getCurrentMember();
        if ( member == null )
            return def;

        return def;
    }

    //##################################################
    //# ajax
    //##################################################

    public static void ajaxSelectProject(MyProject project)
    {
        ScPage preferredPage = MyGlobals.getData().getCurrentPage();
        ajaxSelectProject(project, preferredPage);
    }

    public static void ajaxSelectProject(MyProject project, ScPage preferredPage)
    {
        // Update the user's last project (in database).
        MyUser user;
        user = MyGlobals.getCurrentUser();
        user.selectProject(project);

        // Try to show the preferred page...
        ScPage page;
        page = preferredPage;

        // ...but switch to default page if user lacks permission on new project.
        if ( !allowsPage(page, user, project) )
            page = getDefaultPage();

        // disable automatic page session updates
        ScServletData data;
        data = MyServletData.getLocal();
        data.getAjaxResult().disablePageSessionUpdate();

        // update page session manually NOW, rather than automatically at the end.
        ScBlockScript ajax;
        ajax = data.ajax();
        ajax.updatePageSession();

        // reset the page session, start with a blank session for the new project.
        MyGlobalSession.getInstance().setCurrentProject(project);
        data.getPageSession().reset();

        // Update page header, etc...
        MyPageLayout layout;
        layout = MyPageLayout.getInstance();
        layout.ajaxRefreshHeader();
        layout.ajaxRefreshMenu();
        layout.ajaxRefreshTitleFor(page);

        // enter page
        ScEnterPageScript enter;
        enter = ajax.enterPage(page);
        enter.setPageSessionOverride();
        enter.disableChangeTracking();
    }

    private static boolean allowsPage(ScPage page, MyUser user, MyProject project)
    {
        if ( page == null )
            return false;

        if ( !(page instanceof MyPage) )
            return false;

        try
        {
            ((MyPage)page).checkSecurityFor(user, project);
            return true;
        }
        catch ( KmSecurityException ex )
        {
            return false;
        }
    }
}
