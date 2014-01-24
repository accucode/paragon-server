package com.app.ui.page.admin;

import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
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

        ScGroup group = addGroup("Admin");
        ScDiv body = group.getBody();

        ScBox links;
        links = body.addLinkBox();
        links.addLink(MySelectAccountPage.instance);
        links.addLink(MyAccountSettingsPage.instance);
        links.addLink(MyAccountUsersPage.instance);

        group.addBodyDivider();

        links = body.addLinkBox();
        links.addLink(MyUserProfilePage.instance);
    }

    private ScGroup addGroup(String title)
    {
        ScGroup e;
        e = getRoot().addGroup();
        e.setTitle(title);
        e.layoutFixed();
        e.style().width(150).height(200);
        return e;
    }
}
