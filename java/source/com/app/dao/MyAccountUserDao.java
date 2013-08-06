package com.app.dao;

import com.kodemore.collection.KmList;

import com.app.criteria.MyAccountUserCriteria;
import com.app.dao.base.MyAccountUserDaoBase;
import com.app.model.MyAccountUser;
import com.app.model.MyUser;

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
}
