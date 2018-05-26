package com.app.ui.page.menu;

import com.kodemore.servlet.control.ScContainer;

import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.test.MyBlankTestPage;
import com.app.ui.page.test.MyWyattTestPage;

/**
 * I act as a full page menu for development tests.
 */
public final class MyTestMenuPage
    extends MyMenuPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyTestMenuPage _instance;

    public static void installInstance()
    {
        _instance = new MyTestMenuPage();
    }

    public static MyTestMenuPage getInstance()
    {
        return _instance;
    }

    private MyTestMenuPage()
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
        return "Tests";
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
        installPersonal();
        installOther();
    }

    private void installPersonal()
    {
        ScContainer box;
        box = addMenu("Personal");
        box.addLink("Wyatt", MyWyattTestPage.getInstance());
    }

    private void installOther()
    {
        ScContainer box;
        box = addMenu("Other");
        box.addLink("Blank", MyBlankTestPage.getInstance());
    }
}
