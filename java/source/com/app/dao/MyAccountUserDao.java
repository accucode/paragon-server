package com.app.dao;

import com.app.criteria.MyAccountUserCriteria;
import com.app.dao.base.MyAccountUserDaoBase;
import com.app.model.MyAccountUser;

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
}
