package com.app.dao;

import com.app.criteria.MyAutoLoginCriteria;
import com.app.dao.base.MyAutoLoginDaoBase;
import com.app.model.MyUser;

public class MyAutoLoginDao
    extends MyAutoLoginDaoBase
{
    public void deleteAllFor(MyUser e)
    {
        MyAutoLoginCriteria c;
        c = createCriteria();
        c.whereUserIs(e);

        deleteAll(c.findAll());
    }
}
