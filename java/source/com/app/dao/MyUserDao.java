package com.app.dao;

import com.app.criteria.MyUserCriteria;
import com.app.dao.base.MyUserDaoBase;
import com.app.model.MyUser;

public class MyUserDao
    extends MyUserDaoBase
{
    //##################################################
    //# find
    //##################################################

    public MyUser findEmail(String email)
    {
        MyUserCriteria c;
        c = createCriteria();
        c.whereEmail().is(email);
        return c.findFirst();
    }

    public MyUser findUserWithName(String s)
    {
        MyUserCriteria c;
        c = createCriteria();
        c.whereName().is(s);
        return c.findFirst();
    }
}
