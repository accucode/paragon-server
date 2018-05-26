package com.app.ui.page.crud.user;

import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.crud.abstractBase.MyCrudListPage;

public final class MyUserListPage
    extends MyCrudListPage<MyTenant,MyUser>
{
    //##################################################
    //# singleton
    //##################################################

    private static MyUserListPage _instance;

    public static void installInstance()
    {
        _instance = new MyUserListPage();
    }

    public static MyUserListPage getInstance()
    {
        return _instance;
    }

    private MyUserListPage()
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
        return MySecurityLevel.tenantAdmin;
    }
}
