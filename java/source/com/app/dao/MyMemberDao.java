package com.app.dao;

import com.kodemore.collection.KmList;

import com.app.criteria.MyMemberCriteria;
import com.app.dao.base.MyMemberDaoBase;
import com.app.model.MyMember;
import com.app.model.MyProject;
import com.app.model.MyUser;

public class MyMemberDao
    extends MyMemberDaoBase
{
    public MyMember findMember(MyProject p, MyUser u)
    {
        MyMemberCriteria c;
        c = createCriteria();
        c.whereProjectIs(p);
        c.whereUserIs(u);
        return c.findFirst();
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

}
