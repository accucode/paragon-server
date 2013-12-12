package com.app.ui.activity.admin.userProfile;

import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.activity.MyPage;
import com.app.ui.activity.admin.MyAdminPage;

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
