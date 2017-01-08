package com.app.ui.page;

import com.kodemore.servlet.control.ScContainer;

import com.app.ui.page.manage.project.MyProjectManagePage;
import com.app.ui.page.manage.tenant.MyTenantManagePage;
import com.app.ui.page.manage.user.MyUserManagePage;
import com.app.ui.page.test.MyMenuPage;

/**
 * I act as a full page menu for various admin pages.
 */
public final class MyAdminMenuPage
    extends MyMenuPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyAdminMenuPage _instance;

    public static void installInstance()
    {
        _instance = new MyAdminMenuPage();
    }

    public static MyAdminMenuPage getInstance()
    {
        return _instance;
    }

    private MyAdminMenuPage()
    {
        // singleton
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.user;
    }

    @Override
    public String getTitle()
    {
        return "Admin";
    }

    @Override
    protected Integer getGroupWidth()
    {
        return 150;
    }

    @Override
    protected Integer getGroupHeight()
    {
        return 200;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installMenus()
    {
        installTenant();
    }

    private void installTenant()
    {
        ScContainer box;
        box = addMenu("Tenant");
        box.addLink("Tenants", MyTenantManagePage.getInstance());
        box.addLink("Users", MyUserManagePage.getInstance());
        box.addLink("Projects", MyProjectManagePage.getInstance());
    }
}
