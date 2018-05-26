package com.app.ui.page.crud.tenant;

import com.app.model.MyTenant;
import com.app.model.core.MyNullDomain;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.crud.abstractBase.MyCrudListPage;

public final class MyTenantListPage
    extends MyCrudListPage<MyNullDomain,MyTenant>
{
    //##################################################
    //# singleton
    //##################################################

    private static MyTenantListPage _instance;

    public static void installInstance()
    {
        _instance = new MyTenantListPage();
    }

    public static MyTenantListPage getInstance()
    {
        return _instance;
    }

    private MyTenantListPage()
    {
        super(new MyTenantBuilder());
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }

    //##################################################
    //# domain
    //##################################################

    @Override
    protected MyNullDomain getDomainParent()
    {
        return null;
    }

}
