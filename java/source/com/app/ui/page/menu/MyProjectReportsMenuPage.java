package com.app.ui.page.menu;

import com.kodemore.servlet.control.ScContainer;

import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.report.MyNoteReportPage;
import com.app.ui.page.report.MySiteReportPage;

/**
 * I act as a full page menu for project-level reports.
 */
public final class MyProjectReportsMenuPage
    extends MyMenuPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyProjectReportsMenuPage _instance;

    public static void installInstance()
    {
        _instance = new MyProjectReportsMenuPage();
    }

    public static MyProjectReportsMenuPage getInstance()
    {
        return _instance;
    }

    private MyProjectReportsMenuPage()
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
        return "Project Reports";
    }

    @Override
    protected Integer getGroupWidth()
    {
        return 200;
    }

    @Override
    protected Integer getGroupHeight()
    {
        return 500;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installMenus()
    {
        installProject();
    }

    private void installProject()
    {
        ScContainer box;
        box = addMenu("Project");
        box.addLink("Sites", MySiteReportPage.getInstance());
        box.addLink("Notes", MyNoteReportPage.getInstance());
    }
}
