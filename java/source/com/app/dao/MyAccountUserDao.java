package com.app.dao;

import com.kodemore.collection.KmList;

import com.app.criteria.MyAccountUserCriteria;
import com.app.dao.base.MyAccountUserDaoBase;
import com.app.model.MyAccount;
import com.app.model.MyAccountUser;
import com.app.model.MyUser;

public class MyAccountUserDao
    extends MyAccountUserDaoBase
{
    public KmList<MyAccountUser> findAccountUsersFor(MyUser u)
    {
        MyAccountUserCriteria c;
        c = createCriteria();
        c.whereUserIs(u);
        return c.findAll();
    }

    public KmList<MyAccountUser> findAccountUsersFor(MyAccount a)
    {
        MyAccountUserCriteria c;
        c = createCriteria();
        c.whereAccountIs(a);
        return c.findAll();
    }

    public MyAccountUser findAccountUserFor(MyUser u, MyAccount a)
    {
        MyAccountUserCriteria c;
        c = createCriteria();
        c.whereUserIs(u);
        c.whereAccountIs(a);
        return c.findFirst();
    }

    public MyAccountUser findCurrentOwner(MyAccount a)
    {
        MyAccountUserCriteria c;
        c = createCriteria();
        c.whereAccountIs(a);
        c.whereRoleIsOwner();
        return c.findUnique();
    }
}
