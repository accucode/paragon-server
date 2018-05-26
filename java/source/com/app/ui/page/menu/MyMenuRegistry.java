package com.app.ui.page.menu;

import com.kodemore.utility.Kmu;

import com.app.ui.dashboard.core.MyDashboardPage;
import com.app.ui.layout.MyMenuItem;
import com.app.ui.page.crud.appFeedback.MyFeedbackListPage;
import com.app.ui.page.crud.blurb.MyBlurbListPage;
import com.app.ui.page.crud.emailTemplate.MyEmailTemplateListPage;
import com.app.ui.page.crud.project.MyProjectListPage;
import com.app.ui.page.crud.tenant.MyTenantListPage;
import com.app.ui.page.crud.user.MyUserListPage;
import com.app.ui.page.general.MyProjectCalendarPage;
import com.app.ui.page.general.MyProjectPage;
import com.app.ui.page.guide.MyProjectSetupHomePage;
import com.app.ui.page.guide.MySiteGuidePage;
import com.app.ui.page.report.MyNoteReportPage;
import com.app.ui.page.report.MySiteReportPage;
import com.app.ui.page.test.MyWyattTestPage;
import com.app.ui.page.tools.MyDevApplicationLogsPage;
import com.app.ui.page.tools.MyDevApplicationPropertiesPage;
import com.app.ui.page.tools.MyDevBeanShellPage;
import com.app.ui.page.tools.MyDevDataFixPage;
import com.app.ui.page.tools.MyDevEmailsPage;
import com.app.ui.page.tools.MyDevEnvironmentVariablesPage;
import com.app.ui.page.tools.MyDevPerformanceLogDetailPage;
import com.app.ui.page.tools.MyDevPerformanceLogSummaryPage;
import com.app.ui.page.tools.MyDevRenameMacroPage;
import com.app.ui.page.tools.MyDevSharedFileBrowserPage;
import com.app.ui.page.tools.MyDevSqlPage;
import com.app.ui.page.tools.MyDevSystemPropertiesPage;
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

        registerHomeOn(root);
        registerDataOn(root);
        registerReportsOn(root);
        registerSetupOn(root);
        registerGlobalOn(root);
        registerSystemAdminOn(root);
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

    private void registerHomeOn(MyMenuItem root)
    {
        MyDashboardPage def = MyDashboardPage.getInstance();

        MyMenuItem top;
        top = root.addMenu("Home");
        top.setPage(def);
        top.addMenu("Dashboard", def);
    }

    private void registerDataOn(MyMenuItem root)
    {
        MyProjectDataMenuPage def = MyProjectDataMenuPage.getInstance();

        MyMenuItem top;
        top = root.addMenu("Data");
        top.setPage(def);
        top.addMenu("Project", MyProjectPage.getInstance());
        top.addMenu("Calendar", MyProjectCalendarPage.getInstance()).setBottomDivider();
        top.addMenu("Sites", MySiteGuidePage.getInstance());
        top.addMenu("More...", def).setTopDivider();
    }

    private void registerReportsOn(MyMenuItem root)
    {
        MyProjectReportsMenuPage def = MyProjectReportsMenuPage.getInstance();

        MyMenuItem top;
        top = root.addMenu("Reports");
        top.setPage(def);
        top.addMenu("Sites", MySiteReportPage.getInstance());
        top.addMenu("Notes", MyNoteReportPage.getInstance());
        top.addMenu("More...", def).setTopDivider();
    }

    private void registerSetupOn(MyMenuItem root)
    {
        MyProjectSetupHomePage def = MyProjectSetupHomePage.getInstance();

        MyMenuItem top;
        top = root.addMenu("Setup");
        top.setPage(def);
        top.addMenu("Email Templates", MyEmailTemplateListPage.getInstance());
        top.addMenu("Blurbs", MyBlurbListPage.getInstance());
        top.addMenu("More...", def).setTopDivider();
    }

    private void registerGlobalOn(MyMenuItem root)
    {
        MyTenantSetupMenuPage def = MyTenantSetupMenuPage.getInstance();

        MyMenuItem top;
        top = root.addMenu("Global");
        top.setPage(def);
        top.addMenu("Users", MyUserListPage.getInstance());
        top.addMenu("Projects", MyProjectListPage.getInstance());
        top.addMenu("More...", def).setTopDivider();
    }

    private void registerSystemAdminOn(MyMenuItem root)
    {
        MySystemSetupMenuPage def = MySystemSetupMenuPage.getInstance();

        MyMenuItem top;
        top = root.addMenu("System");
        top.setPage(def);
        top.addMenu("Tenants", MyTenantListPage.getInstance());
        top.addMenu("More...", def).setTopDivider();
    }

    private void registerToolsOn(MyMenuItem root)
    {
        MyDevSqlPage def = MyDevSqlPage.getInstance();

        MyMenuItem top;
        top = root.addMenu("Tools");
        top.setPage(def);

        top.addMenu(def);
        top.addMenu(MyDevUtilityPage.getInstance());
        top.addMenu(MyDevEmailsPage.getInstance()).setBottomDivider();

        top.addMenu("Feedback", MyFeedbackListPage.getInstance());
        top.addMenu(MyDevDataFixPage.getInstance());
        top.addMenu(MyDevRenameMacroPage.getInstance());

        top.addMenu("App Logs", MyDevApplicationLogsPage.getInstance()).setTopDivider();
        top.addMenu("App Properties", MyDevApplicationPropertiesPage.getInstance());

        top.addMenu("Perf Detail", MyDevPerformanceLogDetailPage.getInstance());
        top.addMenu("Perf Summary", MyDevPerformanceLogSummaryPage.getInstance());
        top.addMenu("Sys Properties", MyDevSystemPropertiesPage.getInstance());
        top.addMenu("Env Variables", MyDevEnvironmentVariablesPage.getInstance())
            .setBottomDivider();

        top.addMenu(MyDevSharedFileBrowserPage.getInstance());
        top.addMenu(MyDevBeanShellPage.getInstance());
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
