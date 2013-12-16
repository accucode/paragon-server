package com.app.ui.page.admin.userProfile;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.MyPage;
import com.app.ui.page.admin.MyAdminPage;

public class MyUserProfilePage
    extends MyAdminPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyPage instance = new MyUserProfilePage();

    private MyUserProfilePage()
    {
        // singleton 
    }

    //##################################################
    //# setup
    //##################################################

    @Override
    protected boolean requiresAccountMember()
    {
        return true;
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
        root.add(new MyUserProfileFrame());
    }

}
