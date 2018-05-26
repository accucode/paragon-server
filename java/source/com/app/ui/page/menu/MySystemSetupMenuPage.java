package com.app.ui.page.menu;

import com.kodemore.servlet.control.ScContainer;

import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.crud.tenant.MyTenantListPage;

/**
 * I act as a full page menu for system-level pages.
 */
public final class MySystemSetupMenuPage
    extends MyMenuPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MySystemSetupMenuPage _instance;

    public static void installInstance()
    {
        _instance = new MySystemSetupMenuPage();
    }

    public static MySystemSetupMenuPage getInstance()
    {
        return _instance;
    }

    private MySystemSetupMenuPage()
    {
        // singleton
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }

    @Override
    public String getTitle()
    {
        return "System Setup";
    }

    @Override
    protected Integer getGroupWidth()
    {
        return 180;
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
        installSystemObjects();
    }

    private void installSystemObjects()
    {
        ScContainer box;
        box = addMenu("System Objects");
        box.addLink("Tenants", MyTenantListPage.getInstance());
    }
}
