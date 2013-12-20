package com.app.dao;

import com.app.criteria.MyPasswordResetCriteria;
import com.app.dao.base.MyPasswordResetDaoBase;
import com.app.model.MyPasswordReset;

public class MyPasswordResetDao
    extends MyPasswordResetDaoBase
{
    public MyPasswordReset findToken(String s)
    {
        MyPasswordResetCriteria c;
        c = createCriteria();
        c.whereToken().is(s);
        return c.findFirst();
    }
}
