package com.app.dao;

import com.app.criteria.MyAccountUserCriteria;
import com.app.dao.base.MyAccountUserDaoBase;
import com.app.model.MyAccount;
import com.app.model.MyAccountUser;
import com.app.model.MyUser;

import com.kodemore.collection.KmList;

public class MyAccountUserDao
    extends MyAccountUserDaoBase
{
    public MyAccountUser findWithUid(String uid)
    {
        MyAccountUserCriteria c;
        c = createCriteria();
        c.whereUid().is(uid);
        return c.findFirst();
    }

    public KmList<MyAccountUser> findAccountUsersFor(MyUser u)
    {
        MyAccountUserCriteria c;
        c = createCriteria();
        c.whereUserIs(u);
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
}
