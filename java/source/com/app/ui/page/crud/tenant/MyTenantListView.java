package com.app.ui.page.crud.tenant;

import com.app.model.MyTenant;
import com.app.model.core.MyNullDomain;
import com.app.ui.page.crud.abstractBase.MyCrudListView;

public final class MyTenantListView
    extends MyCrudListView<MyNullDomain,MyTenant>
{
    //##################################################
    //# constructor
    //##################################################

    public MyTenantListView()
    {
        this(new MyTenantBuilder());
    }

    public MyTenantListView(MyTenantBuilder e)
    {
        super(e);
    }
}
