package com.app.ui.activity.admin;

import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScGroupArray;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.activity.test.MyAccountsPage;

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
        root.css().gap();

        ScGroupArray groups;
        groups = root.addGroupArray();
        groups.style().width(150).height(200);

        ScGroup group;
        group = groups.addGroup("Admin");

        ScBox links;
        links = group.addLinkBox();
        links.addLink(MyAccountsPage.instance);

        return root;
    }
}
