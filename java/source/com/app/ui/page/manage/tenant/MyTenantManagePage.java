package com.app.ui.page.manage.tenant;

import com.app.model.MyTenant;
import com.app.model.core.MyNullDomain;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.manage.crud.MyCrudManagePage;

public final class MyTenantManagePage
    extends MyCrudManagePage<MyNullDomain,MyTenant>
{
    //##################################################
    //# singleton
    //##################################################

    private static MyTenantManagePage _instance;

    public static void installInstance()
    {
        _instance = new MyTenantManagePage();
    }

    public static MyTenantManagePage getInstance()
    {
        return _instance;
    }

    private MyTenantManagePage()
    {
        super(new MyTenantBuilder());
    }

    //##################################################
    //# domain
    //##################################################

    @Override
    protected MyNullDomain getDomainParent()
    {
        return null;
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }
}
