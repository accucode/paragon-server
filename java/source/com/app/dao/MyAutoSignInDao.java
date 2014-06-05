package com.app.dao;

import com.app.criteria.MyAutoSignInCriteria;
import com.app.dao.base.MyAutoSignInDaoBase;
import com.app.model.MyUser;

public class MyAutoSignInDao
    extends MyAutoSignInDaoBase
{
    public void deleteAllFor(MyUser e)
    {
        MyAutoSignInCriteria c;
        c = createCriteria();
        c.whereUserIs(e);

        deleteAll(c.findAll());
    }
}
