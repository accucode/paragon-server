package com.app.ui.page.admin.userProfile;

import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.admin.MyAbstractAdminPage;

public class MyUserProfilePage
    extends MyAbstractAdminPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyUserProfilePage instance = new MyUserProfilePage();

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
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.add(new MyUserProfileFrame());
    }

}
