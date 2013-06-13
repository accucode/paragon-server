package com.app.dao;

import com.app.criteria.MyPasswordResetCriteria;
import com.app.dao.base.MyPasswordResetDaoBase;
import com.app.model.MyPasswordReset;

public class MyPasswordResetDao
    extends MyPasswordResetDaoBase
{
    public MyPasswordReset findAccessKey(String key)
    {
        MyPasswordResetCriteria c;
        c = createCriteria();
        c.whereAccessKey().is(key);
        return c.findFirst();
    }
}
