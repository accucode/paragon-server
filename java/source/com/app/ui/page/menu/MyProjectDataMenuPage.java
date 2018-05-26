package com.app.ui.page.menu;

import com.kodemore.servlet.control.ScContainer;

import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.crud.site.MySiteListPage;
import com.app.ui.page.general.MyProjectPage;

/**
 * I act as a full page menu for various data pages under a project.
 */
public final class MyProjectDataMenuPage
    extends MyMenuPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyProjectDataMenuPage _instance;

    public static void installInstance()
    {
        _instance = new MyProjectDataMenuPage();
    }

    public static MyProjectDataMenuPage getInstance()
    {
        return _instance;
    }

    private MyProjectDataMenuPage()
    {
        // singleton
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.projectWorker;
    }

    @Override
    public String getTitle()
    {
        return "Data";
    }

    @Override
    protected Integer getGroupWidth()
    {
        return 150;
    }

    @Override
    protected Integer getGroupHeight()
    {
        return 250;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installMenus()
    {
        installProject();
        installSites();
    }

    private void installProject()
    {
        ScContainer box;
        box = addMenu("Project");
        box.addLink("Project", MyProjectPage.getInstance());
    }

    private void installSites()
    {
        ScContainer box;
        box = addMenu("Sites");
        box.addLink("Sites", MySiteListPage.getInstance());
    }
}
