package com.app.ui.page.tools;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScGroupArray;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.admin.MyEmailListPage;
import com.app.ui.page.admin.MyUsersPage;

public class MyToolsPage
    extends MyAbstractToolsPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyToolsPage instance = new MyToolsPage();

    private MyToolsPage()
    {
        // singleton
    }

    //##################################################
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeQueryParameters()
    {
        return null;
    }

    @Override
    public void applyQueryParameters(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().gap();

        ScGroupArray groups;
        groups = root.addGroupArray(150, 300);

        ScGroup group;
        group = groups.addGroup("Tools");

        ScBox links;
        links = group.addLinkBox();
        links.addLink(MyUtilityPage.instance);
        links.addLink(MySqlPage.instance);

        group.addDivider();

        links = group.addLinkBox();
        links.addLink(MyBeanShellPage.instance);
        links.addLink(MyPerformanceLogPage.instance);
        links.addLink(MySharedFileBrowserPage.instance);
        links.addLink(MySystemLogListPage.instance);
        links.addLink(MyApplicationPropertiesPage.instance);
        links.addLink(MySystemPropertiesPage.instance);
        links.addLink(MyUsersPage.instance);
        links.addLink(MyEmailListPage.instance);
    }
}
