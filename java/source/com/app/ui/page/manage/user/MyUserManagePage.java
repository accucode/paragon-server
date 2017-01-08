package com.app.ui.page.manage.user;

import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.manage.crud.MyCrudManagePage;

public final class MyUserManagePage
    extends MyCrudManagePage<MyTenant,MyUser>
{
    //##################################################
    //# singleton
    //##################################################

    private static MyUserManagePage _instance;

    public static void installInstance()
    {
        _instance = new MyUserManagePage();
    }

    public static MyUserManagePage getInstance()
    {
        return _instance;
    }

    private MyUserManagePage()
    {
        super(new MyUserBuilder());
    }

    //##################################################
    //# domain
    //##################################################

    @Override
    protected MyTenant getDomainParent()
    {
        return getCurrentTenant();
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.user;
    }
}
