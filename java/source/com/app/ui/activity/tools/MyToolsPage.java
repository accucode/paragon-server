package com.app.ui.activity.tools;

import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScGroupArray;

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
    //# install
    //##################################################

    @Override
    protected ScControl installRoot()
    {
        ScBox root;
        root = new ScBox();
        root.css().padSpaced();

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
        links.addLink(MyPropertiesPage.instance);

        return root;
    }
}
