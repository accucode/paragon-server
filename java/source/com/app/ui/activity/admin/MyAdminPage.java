package com.app.ui.activity.admin;

import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScGroupArray;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.activity.test.MyAccountTestPage;
import com.app.ui.activity.test.MyAccountUserTestPage;
import com.app.ui.activity.test.MyTabManagerTestPage;
import com.app.ui.activity.test.MyWelcomePage;

public class MyAdminPage
    extends MyAbstractAdminPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyAdminPage instance = new MyAdminPage();

    private MyAdminPage()
    {
        // singleton
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScPageRoot installRoot()
    {
        ScPageRoot root;
        root = newPageRoot();
        root.css().padSpaced();

        ScGroupArray groups;
        groups = root.addGroupArray();
        groups.style().width(150).height(200);

        ScGroup group;
        group = groups.addGroup("Admin");

        ScBox links;
        links = group.addLinkBox();
        links.addLink(MyUsersPage.instance);
        links.addLink(MyEmailListPage.instance);
        links.addLink(MyWelcomePage.instance);
        links.addLink(MyTabManagerTestPage.instance);
        links.addLink(MyAccountTestPage.instance);
        links.addLink(MyAccountUserTestPage.instance);

        return root;
    }

}
