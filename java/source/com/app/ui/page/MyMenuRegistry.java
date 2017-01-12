package com.app.ui.page;

import com.kodemore.utility.Kmu;

import com.app.ui.dashboard.core.MyDashboardPage;
import com.app.ui.layout.MyMenuItem;
import com.app.ui.page.general.MyProjectDataMenuPage;
import com.app.ui.page.general.MyProjectPage;
import com.app.ui.page.manage.project.MyProjectManagePage;
import com.app.ui.page.manage.tenant.MyTenantManagePage;
import com.app.ui.page.manage.user.MyUserManagePage;
import com.app.ui.page.report.MyAuditLogReportPage;
import com.app.ui.page.test.MyTestMenuPage;
import com.app.ui.page.test.MyWyattTestPage;
import com.app.ui.page.tools.MyDevApplicationLogsPage;
import com.app.ui.page.tools.MyDevApplicationPropertiesPage;
import com.app.ui.page.tools.MyDevBeanShellPage;
import com.app.ui.page.tools.MyDevDataFixPage;
import com.app.ui.page.tools.MyDevEmailsPage;
import com.app.ui.page.tools.MyDevEnvironmentVariablesPage;
import com.app.ui.page.tools.MyDevPerformanceLogDetailPage;
import com.app.ui.page.tools.MyDevPerformanceLogSummaryPage;
import com.app.ui.page.tools.MyDevSharedFileBrowserPage;
import com.app.ui.page.tools.MyDevSqlPage;
import com.app.ui.page.tools.MyDevSystemPropertiesPage;
import com.app.ui.page.tools.MyDevUsersPage;
import com.app.ui.page.tools.MyDevUtilityPage;

public class MyMenuRegistry
{
    //##################################################
    //# static
    //##################################################

    private static MyMenuRegistry _instance;

    public static synchronized void install()
    {
        if ( _instance != null )
            throw Kmu.newFatal("Already installed.");

        _instance = new MyMenuRegistry();
    }

    public static MyMenuRegistry getInstance()
    {
        if ( _instance == null )
            throw Kmu.newFatal("Already installed.");

        return _instance;
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * The root of the recursive composite for the left-hand menu.
     * The root itself is generally ignored.
     */
    private MyMenuItem _left;

    /**
     * The root of the recursive composite for the right-hand menu.
     * The root itself is generally ignored.
     */
    private MyMenuItem _right;

    //##################################################
    //# constructor
    //##################################################

    private MyMenuRegistry()
    {
        registerLeft();
        registerRight();
    }

    //##################################################
    //# register
    //##################################################

    private void registerLeft()
    {
        MyMenuItem root;
        root = new MyMenuItem();
        _left = root;

        registerHomeMenuOn(root);
        registerDataMenuOn(root);
        registerReportsMenuOn(root);
        registerAdminOn(root);
    }

    private void registerRight()
    {
        MyMenuItem root;
        root = new MyMenuItem();
        _right = root;

        registerTestsOn(root);
        registerToolsOn(root);
    }

    //==================================================
    //= register :: menus
    //==================================================

    private void registerHomeMenuOn(MyMenuItem root)
    {
        MyMenuItem top;
        top = root.addMenu("Home");
        top.setPage(MyDashboardPage.getInstance());

        top.addMenu("Dashboard", MyDashboardPage.getInstance());
    }

    private void registerDataMenuOn(MyMenuItem root)
    {
        MyMenuItem top;
        top = root.addMenu("Data");
        top.setPage(MyProjectDataMenuPage.getInstance());

        top.addMenu("Project", MyProjectPage.getInstance()).setBottomDivider();
    }

    private void registerReportsMenuOn(MyMenuItem root)
    {
        MyMenuItem top;
        top = root.addMenu("Reports");
        top.addMenu("Audit Logs", MyAuditLogReportPage.getInstance());
    }

    private void registerAdminOn(MyMenuItem root)
    {
        MyMenuItem top;
        top = root.addMenu("Admin");
        top.setPage(MyAdminMenuPage.getInstance());

        top.addMenu("Tenants", MyTenantManagePage.getInstance());
        top.addMenu("Users", MyUserManagePage.getInstance());
        top.addMenu("Projects", MyProjectManagePage.getInstance());
        top.addMenu("More...", MyAdminMenuPage.getInstance()).setTopDivider();
    }

    private void registerToolsOn(MyMenuItem root)
    {
        MyMenuItem top;
        top = root.addMenu("Tools");
        top.setPage(MyDevSqlPage.getInstance());

        top.addMenu(MyDevSqlPage.getInstance());
        top.addMenu(MyDevUtilityPage.getInstance());
        top.addMenu(MyDevUsersPage.getInstance());
        top.addMenu(MyDevEmailsPage.getInstance());

        top.addMenu("Perf Detail", MyDevPerformanceLogDetailPage.getInstance());
        top.addMenu("Perf Summary", MyDevPerformanceLogSummaryPage.getInstance());
        top.addMenu("App Logs", MyDevApplicationLogsPage.getInstance());
        top.addMenu("App Properties", MyDevApplicationPropertiesPage.getInstance());
        top.addMenu("Sys Properties", MyDevSystemPropertiesPage.getInstance());
        top.addMenu("Env Variables", MyDevEnvironmentVariablesPage.getInstance())
            .setBottomDivider();

        top.addMenu(MyDevSharedFileBrowserPage.getInstance());
        top.addMenu(MyDevBeanShellPage.getInstance());
        top.addMenu(MyDevDataFixPage.getInstance()).setBottomDivider();
    }

    private void registerTestsOn(MyMenuItem root)
    {
        MyMenuItem top;
        top = root.addMenu("Tests");
        top.setPage(MyTestMenuPage.getInstance());

        top.addMenu(MyWyattTestPage.getInstance());
        top.addMenu("More...", MyTestMenuPage.getInstance()).setTopDivider();
    }

    //##################################################
    //# accessing
    //##################################################

    public MyMenuItem getLeftRoot()
    {
        return _left;
    }

    public MyMenuItem getRightRoot()
    {
        return _right;
    }
}
