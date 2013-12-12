package com.app.ui.page.admin.userProfile;

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
