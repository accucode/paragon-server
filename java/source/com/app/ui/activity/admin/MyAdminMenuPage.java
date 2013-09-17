package com.app.ui.activity.admin;

import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScGroupArray;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.activity.admin.accounts.MyAccounts2Page;
import com.app.ui.activity.admin.accounts.MyAccountsPage;

public class MyAdminMenuPage
    extends MyAdminPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyAdminMenuPage instance = new MyAdminMenuPage();

    private MyAdminMenuPage()
    {
        // singleton
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().gap();

        ScGroupArray groups;
        groups = root.addGroupArray();
        groups.style().width(150).height(200);

        ScGroup group;
        group = groups.addGroup("Admin");

        ScBox links;
        links = group.addLinkBox();
        links.addLink(MyAccountsPage.instance);
        links.addLink(MyAccounts2Page.instance);
        links.addLink(MyProfilePage.instance);
    }
}
