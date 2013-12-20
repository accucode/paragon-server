package com.app.dao;

import com.app.criteria.MyUserActivationCriteria;
import com.app.dao.base.MyUserActivationDaoBase;
import com.app.model.MyUserActivation;

public class MyUserActivationDao
    extends MyUserActivationDaoBase
{
    public MyUserActivation findToken(String token)
    {
        MyUserActivationCriteria c;
        c = createCriteria();
        c.whereToken().is(token);
        return c.findFirst();
    }
}
