package com.app.ui.page.admin;

import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScOldGroup;
import com.kodemore.servlet.control.ScOldGroupArray;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.admin.accountSettings.MyAccountSettingsPage;
import com.app.ui.page.admin.accountUsers.MyAccountUsersPage;
import com.app.ui.page.admin.userProfile.MyUserProfilePage;

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
    protected void installRoot(ScPageRoot root)
    {
        root.css().gap();

        ScOldGroupArray groups;
        groups = root.addOldGroupArray();
        groups.style().width(150).height(200);

        ScOldGroup group;
        group = groups.addOldGroup("Admin");

        ScBox links;
        links = group.addLinkBox();
        links.addLink(MySelectAccountPage.instance);
        links.addLink(MyAccountSettingsPage.instance);
        links.addLink(MyAccountUsersPage.instance);

        group.addDivider();

        links = group.addLinkBox();
        links.addLink(MyUserProfilePage.instance);
    }
}
