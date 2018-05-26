package com.app.dao.core;

import com.kodemore.dao.KmDaoSession;
import com.kodemore.dao.KmDaoSessionManager;

public class MyDaoSessionManager
    extends KmDaoSessionManager
{
    //##################################################
    //# install
    //##################################################

    public static void install()
    {
        KmDaoSessionManager.install(new MyDaoSessionManager());
    }

    public static MyDaoSessionManager getInstance()
    {
        return (MyDaoSessionManager)KmDaoSessionManager.getInstance();
    }

    //##################################################
    //# constructor
    //##################################################

    protected MyDaoSessionManager()
    {
        // protected
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public MyDaoSession getDaoSession()
    {
        return (MyDaoSession)super.getDaoSession();
    }

    @Override
    protected KmDaoSession newSession()
    {
        return new MyDaoSession();
    }

}
