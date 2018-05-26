package com.app.ui.page.menu;

import com.kodemore.servlet.control.ScContainer;

import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.crud.project.MyProjectListPage;
import com.app.ui.page.crud.user.MyUserListPage;
import com.app.ui.page.report.MyAuditBundleReportPage;

/**
 * I act as a full page menu for tenant-level pages.
 */
public final class MyTenantSetupMenuPage
    extends MyMenuPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyTenantSetupMenuPage _instance;

    public static void installInstance()
    {
        _instance = new MyTenantSetupMenuPage();
    }

    public static MyTenantSetupMenuPage getInstance()
    {
        return _instance;
    }

    private MyTenantSetupMenuPage()
    {
        // singleton
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.tenantAdmin;
    }

    @Override
    public String getTitle()
    {
        return "Tenant Setup";
    }

    @Override
    protected Integer getGroupWidth()
    {
        return 200;
    }

    @Override
    protected Integer getGroupHeight()
    {
        return 350;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installMenus()
    {
        installObjects();
        installReports();
    }

    private void installObjects()
    {
        ScContainer box;
        box = addMenu("Objects");
        box.addLink("Users", MyUserListPage.getInstance());
        box.addLink("Projects", MyProjectListPage.getInstance());
    }

    private void installReports()
    {
        ScContainer box;
        box = addMenu("Reports");
        box.addLink("Audit Logs", MyAuditBundleReportPage.getInstance());
    }
}
