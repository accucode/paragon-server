package com.app.ui.activity.admin;

import com.kodemore.exception.KmRoleViolationException;

import com.app.model.MyUser;
import com.app.ui.activity.MyPage;

public abstract class MyAdminPage
    extends MyPage
{
    @Override
    public void checkSecurity()
    {
        super.checkSecurity();

        MyUser u = getServerSession().getUser();
        if ( !u.allowsAdmin() )
            throw new KmRoleViolationException("Must be admin");
    }
}
