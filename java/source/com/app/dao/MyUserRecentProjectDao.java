package com.app.dao;

import com.kodemore.collection.KmList;

import com.app.criteria.MyUserRecentProjectCriteria;
import com.app.dao.base.MyUserRecentProjectDaoBase;
import com.app.model.MyProject;
import com.app.model.MyUser;
import com.app.model.MyUserRecentProject;

public class MyUserRecentProjectDao
    extends MyUserRecentProjectDaoBase
{
    //##################################################
    //# find
    //##################################################

    public KmList<MyUserRecentProject> findAllFor(MyUser e)
    {
        MyUserRecentProjectCriteria c;
        c = createCriteria();
        c.whereUserIs(e);
        c.sortOnUpdatedUtcTsDescending();
        return c.findAll();
    }

    public KmList<MyProject> findProjectsFor(MyUser e)
    {
        return findAllFor(e).collect(x -> x.getProject());
    }
}
