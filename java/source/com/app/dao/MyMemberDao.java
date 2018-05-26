package com.app.dao;

import com.kodemore.collection.KmList;

import com.app.criteria.MyMemberCriteria;
import com.app.dao.base.MyMemberDaoBase;
import com.app.dao.core.MyDaoSessionCache;
import com.app.model.MyMember;
import com.app.model.MyProject;
import com.app.model.MyUser;

public class MyMemberDao
    extends MyMemberDaoBase
{
    public MyMember findMember(MyProject p, MyUser u)
    {
        if ( p == null || u == null )
            return null;

        MyDaoSessionCache cache = getCache();

        MyMember m = cache.getMember(p, u);
        if ( m != null )
            return m;

        MyMemberCriteria c;
        c = createCriteria();
        c.whereProjectIs(p);
        c.whereUserIs(u);

        m = c.findFirst();
        if ( m == null )
            return null;

        cache.putMember(m);
        return m;
    }

    public KmList<MyMember> findUser(MyUser e)
    {
        MyMemberCriteria c;
        c = createCriteria();
        c.whereUserIs(e);
        c.joinToProject().sortOnName();
        return c.findAll();
    }

    public MyMember findFirstFor(MyUser e)
    {
        MyMemberCriteria c;
        c = createCriteria();
        c.whereUserIs(e);
        c.joinToProject().sortOnName();
        return c.findFirst();
    }

    public KmList<MyMember> findWorkersFor(MyProject e)
    {
        MyMemberCriteria c;
        c = createCriteria();
        c.whereProjectIs(e);
        c.whereRoleIsWorker();
        return c.findAll();
    }
}
