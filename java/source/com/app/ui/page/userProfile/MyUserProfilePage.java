package com.app.ui.page.userProfile;

import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.MyAbstractEntryPage;
import com.app.ui.page.MySecurityLevel;

public class MyUserProfilePage
    extends MyAbstractEntryPage
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
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.member;
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
