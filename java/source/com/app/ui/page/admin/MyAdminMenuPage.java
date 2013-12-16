package com.app.ui.page.admin;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScGroupArray;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.admin.accounts.MyAccountsPage;
import com.app.ui.page.admin.userProfile.MyUserProfilePage;

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
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeUrlParameters()
    {
        return null;
    }

    @Override
    public void applyUrlParameters(ScParameterList v)
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
        groups = root.addGroupArray();
        groups.style().width(150).height(200);

        ScGroup group;
        group = groups.addGroup("Admin");

        ScBox links;
        links = group.addLinkBox();
        links.addLink(MyAccountsPage.instance);
        links.addLink(MyUserProfilePage.instance);
    }
}
