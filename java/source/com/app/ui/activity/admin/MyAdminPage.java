package com.app.ui.activity.admin;

import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScGroupArray;

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
    protected ScControl installRoot()
    {
        ScBox root;
        root = new ScBox();
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

        return root;
    }

}
