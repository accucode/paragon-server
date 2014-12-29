package com.app.dao.core;

import org.hibernate.Session;

import com.kodemore.dao.KmDaoSession;

import com.app.hibernate.MyHibernateConfiguration;

public class MyDaoSession
    extends KmDaoSession
{
    //##################################################
    //# variables
    //##################################################

    private MyDaoSessionCache _cache;

    //##################################################
    //# creation
    //##################################################

    @Override
    protected Session newSession()
    {
        return MyHibernateConfiguration.getInstance().newSession();
    }

    //##################################################
    //# cache
    //##################################################

    public MyDaoSessionCache getCache()
    {
        if ( _cache == null )
            _cache = new MyDaoSessionCache();

        return _cache;
    }

    @Override
    protected void clearCache()
    {
        _cache = null;
    }

}
