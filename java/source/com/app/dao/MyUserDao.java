package com.app.dao;

import com.app.criteria.MyUserCriteria;
import com.app.dao.base.MyUserDaoBase;
import com.app.model.MyTenant;
import com.app.model.MyUser;

public class MyUserDao
    extends MyUserDaoBase
{
    //##################################################
    //# find email
    //##################################################

    public MyUser findEmail(MyTenant tenant, String email)
    {
        MyUserCriteria c;
        c = createCriteria();
        c.whereTenantIs(tenant);
        c.whereEmail().is(email);
        return c.findUnique();
    }

    //##################################################
    //# duplicate email
    //##################################################

    public boolean isDuplicateEmail(MyTenant tenant, String email)
    {
        MyUserCriteria c;
        c = createCriteria();
        c.whereTenantIs(tenant);
        c.whereEmail().is(email);
        return c.exists();
    }

    public boolean isDuplicateEmail(MyUser user, String email)
    {
        MyUserCriteria c;
        c = createCriteria();
        c.whereTenantIs(user.getTenant());
        c.whereEmail().is(email);
        c.whereUidIsNot(user);
        return c.exists();
    }
}
