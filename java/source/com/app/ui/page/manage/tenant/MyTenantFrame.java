package com.app.ui.page.manage.tenant;

import com.app.model.MyTenant;
import com.app.model.core.MyNullDomain;
import com.app.ui.page.manage.crud.MyCrudFrame;

public class MyTenantFrame
    extends MyCrudFrame<MyNullDomain,MyTenant>
{
    //##################################################
    //# constructor
    //##################################################

    public MyTenantFrame()
    {
        this(new MyTenantBuilder());
    }

    public MyTenantFrame(MyTenantBuilder e)
    {
        super(e);
    }
}
