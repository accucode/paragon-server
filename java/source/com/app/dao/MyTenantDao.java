package com.app.dao;

import com.app.criteria.MyTenantCriteria;
import com.app.dao.base.MyTenantDaoBase;
import com.app.model.MyTenant;

public class MyTenantDao
    extends MyTenantDaoBase
{
    //##################################################
    //# find
    //##################################################

    public MyTenant findSystemTenant()
    {
        return findUid(MyTenant.SYSTEM_UID);
    }

    public MyTenant findName(String e)
    {
        MyTenantCriteria c;
        c = createCriteria();
        c.whereName().is(e);
        return c.findFirst();
    }

    public MyTenant findHostname(String e)
    {
        MyTenantCriteria c;
        c = createCriteria();
        c.whereHostname().is(e);
        return c.findFirst();
    }

}
