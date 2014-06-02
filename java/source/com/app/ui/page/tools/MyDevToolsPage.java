package com.app.ui.page.tools;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;

public class MyDevToolsPage
    extends MyDevAbstractPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyDevToolsPage instance = new MyDevToolsPage();

    private MyDevToolsPage()
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

        ScGroup group;
        group = root.addGroup("Tools");

        ScBox links;
        links = group.addLinkBox();
        links.addLink(MyDevUtilityPage.instance);
        links.addLink(MyDevSqlPage.instance);

        group.addBodyDivider();

        links = group.addLinkBox();
        links.addLink(MyDevBeanShellPage.instance);
        links.addLink(MyDevPerformanceLogPage.instance);
        links.addLink(MyDevSharedFileBrowserPage.instance);
        links.addLink(MyDevSystemLogsPage.instance);
        links.addLink(MyDevApplicationPropertiesPage.instance);
        links.addLink(MyDevSystemPropertiesPage.instance);
        links.addLink(MyDevUsersPage.instance);
        links.addLink(MyDevEmailsPage.instance);
        links.addLink(MyDevHibernateCachePage.instance);
    }
}
