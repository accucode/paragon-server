package com.app.ui.page.user;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.MyPage;

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
        ScGroup group;
        group = root.addGroup("User Settings");

        ScBox body;
        body = group.addLinkBox();
        body.addLink(MyUserPasswordPage.instance);
    }
}
