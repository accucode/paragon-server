package com.app.dao;

import com.kodemore.collection.KmList;

import com.app.criteria.MyProjectCriteria;
import com.app.dao.base.MyProjectDaoBase;
import com.app.model.MyProject;

public class MyProjectDao
    extends MyProjectDaoBase
{
    //##################################################
    //# find
    //##################################################

    public KmList<MyProject> findAllByName()
    {
        MyProjectCriteria c;
        c = createCriteria();
        c.sortOnName();
        return c.findAll();
    }

    public KmList<MyProject> findName(String name)
    {
        MyProjectCriteria c;
        c = createCriteria();
        c.whereName().is(name);
        return c.findAll();
    }

    public MyProject findFirst()
    {
        MyProjectCriteria c;
        c = createCriteria();
        c.sortOnName();
        return c.findFirst();
    }

}
