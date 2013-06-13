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
    protected KmDaoSession newSession()
    {
        return new MyDaoSession();
    }
}
