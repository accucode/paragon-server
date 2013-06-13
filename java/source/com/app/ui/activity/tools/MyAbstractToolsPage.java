package com.app.ui.activity.tools;

import com.kodemore.exception.KmRoleViolationException;

import com.app.model.MyUser;
import com.app.ui.activity.MyPage;

public abstract class MyAbstractToolsPage
    extends MyPage
{
    @Override
    public void checkSecurity()
    {
        super.checkSecurity();

        MyUser u = getServerSession().getUser();
        if ( !u.allowsDeveloper() )
            throw new KmRoleViolationException("Must be developer");
    }
}
