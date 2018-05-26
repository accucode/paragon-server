package com.app.ui.selector.core;

import com.kodemore.domain.KmUidDomainIF;

import com.app.model.MyTenant;

/**
 * I define common methods for selectors whose parent is a tenant.
 */
public abstract class MyAbstractTenantSelector<T extends KmUidDomainIF>
    extends MyAbstractSelector<MyTenant,T>
{
    //##################################################
    //# constructor
    //##################################################

    public MyAbstractTenantSelector()
    {
        // none
    }

    //##################################################
    //# tenant
    //##################################################

    @Override
    protected String getDomainParentName()
    {
        return "Tenant";
    }

    @Override
    protected MyTenant findDomainParent(String uid)
    {
        return getAccess().findTenantUid(uid);
    }

    public void setTenant(MyTenant e)
    {
        setDomainParent(e);
    }

}
