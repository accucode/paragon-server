package com.app.ui.activity.user;

import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScGroup;

import com.app.ui.activity.MyPage;

public class MyUserSettingsPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyUserSettingsPage instance = new MyUserSettingsPage();

    private MyUserSettingsPage()
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

        ScGroup group;
        group = root.addGroup("User Settings");

        ScBox body;
        body = group.addLinkBox();
        body.addLink(MyUserPasswordPage.instance);

        return root;
    }
}
