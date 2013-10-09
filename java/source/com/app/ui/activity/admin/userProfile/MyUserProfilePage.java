package com.app.ui.activity.admin.userProfile;

import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.activity.MyActivity;
import com.app.ui.activity.admin.MyAdminPage;

public class MyUserProfilePage
    extends MyAdminPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyActivity instance = new MyUserProfilePage();

    private MyUserProfilePage()
    {
        // singleton 
    }

    //##################################################
    //# security
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
