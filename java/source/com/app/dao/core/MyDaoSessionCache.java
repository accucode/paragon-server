package com.app.dao.core;

import com.kodemore.collection.KmMap;
import com.kodemore.collection.KmTwoKeyMap;

import com.app.model.MyMember;
import com.app.model.MyProject;
import com.app.model.MyServerSession;
import com.app.model.MyUser;

public class MyDaoSessionCache
{
    //##################################################
    //# variables
    //##################################################

    private KmMap<String,MyServerSession>          _serverSessions;
    private KmTwoKeyMap<MyProject,MyUser,MyMember> _members;

    //##################################################
    //# constructor
    //##################################################

    public MyDaoSessionCache()
    {
        _serverSessions = new KmMap<>();
        _members = new KmTwoKeyMap<>();
    }

    //##################################################
    //# server session
    //##################################################

    public MyServerSession getServerSession(String uid)
    {
        return _serverSessions.get(uid);
    }

    public void putServerSession(MyServerSession e)
    {
        _serverSessions.put(e.getUid(), e);
    }

    public void clearServerSessions()
    {
        _serverSessions = new KmMap<>();
    }

    //##################################################
    //# members
    //##################################################

    public MyMember getMember(MyProject p, MyUser u)
    {
        return _members.get(p, u);
    }

    public void putMember(MyMember m)
    {
        _members.put(m.getProject(), m.getUser(), m);
    }

}
