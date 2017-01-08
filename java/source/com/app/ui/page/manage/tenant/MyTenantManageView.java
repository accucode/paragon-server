package com.app.ui.page.manage.tenant;

import com.app.model.MyTenant;
import com.app.model.core.MyNullDomain;
import com.app.ui.page.manage.crud.MyCrudManageView;

public final class MyTenantManageView
    extends MyCrudManageView<MyNullDomain,MyTenant>
{
    //##################################################
    //# constructor
    //##################################################

    public MyTenantManageView()
    {
        this(new MyTenantBuilder());
    }

    public MyTenantManageView(MyTenantBuilder e)
    {
        super(e);
    }
}
