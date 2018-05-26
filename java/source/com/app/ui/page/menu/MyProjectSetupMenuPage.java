package com.app.ui.page.menu;

import com.kodemore.servlet.control.ScContainer;

import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.crud.customer.MyCustomerListPage;
import com.app.ui.page.crud.holiday.MyHolidayListPage;
import com.app.ui.page.crud.member.MyMemberListPage;
import com.app.ui.page.crud.priority.MyPriorityListPage;
import com.app.ui.page.crud.project.MyProjectListPage;
import com.app.ui.page.guide.MyProjectSetupHomePage;

/**
 * I act as a full page menu for tenant-level pages.
 */
public final class MyProjectSetupMenuPage
    extends MyMenuPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyProjectSetupMenuPage _instance;

    public static void installInstance()
    {
        _instance = new MyProjectSetupMenuPage();
    }

    public static MyProjectSetupMenuPage getInstance()
    {
        return _instance;
    }

    private MyProjectSetupMenuPage()
    {
        // singleton
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.projectManager;
    }

    @Override
    public String getTitle()
    {
        return "Project Setup";
    }

    @Override
    protected Integer getGroupWidth()
    {
        return 250;
    }

    @Override
    protected Integer getGroupHeight()
    {
        return 215;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installMenus()
    {
        installProject();
        installCustomers();
        installMembers();
        installMiscellaneous();
    }

    private void installProject()
    {
        ScContainer box;
        box = addMenu("Project");
        box.addLink("Setup Guide", MyProjectSetupHomePage.getInstance());
        box.addLink("Project List", MyProjectListPage.getInstance());
    }

    private void installMembers()
    {
        ScContainer box;
        box = addMenu("Members");
        box.addLink("Members", MyMemberListPage.getInstance());
    }

    private void installCustomers()
    {
        ScContainer box;
        box = addMenu("Customers");
        box.addLink("Customers", MyCustomerListPage.getInstance());
    }

    private void installMiscellaneous()
    {
        ScContainer box;
        box = addMenu("Miscellaneous");
        box.addLink("Holidays", MyHolidayListPage.getInstance());
        box.addLink("Priorities", MyPriorityListPage.getInstance());
    }
}
