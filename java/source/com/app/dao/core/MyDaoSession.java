package com.app.dao.core;

import org.hibernate.Session;

import com.kodemore.collection.KmSet;
import com.kodemore.collection.KmSetImpl;
import com.kodemore.dao.KmDaoSession;

import com.app.hibernate.MyHibernateConfiguration;
import com.app.utility.MyBasicTimestampsIF;

public class MyDaoSession
    extends KmDaoSession
{
    //##################################################
    //# variables
    //##################################################

    private MyDaoSessionCache _cache;

    private KmSet<MyBasicTimestampsIF> _disabledTimestamps;

    //##################################################
    //# constructor
    //##################################################

    public MyDaoSession()
    {
        _disabledTimestamps = new KmSetImpl<>();
    }

    //##################################################
    //# inner
    //##################################################

    @Override
    protected Session newInnerSession()
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

    //##################################################
    //# basic timestamps
    //##################################################

    public void disableBasicTimestampsFor(MyBasicTimestampsIF e)
    {
        _disabledTimestamps.add(e);
    }

    public boolean areBasicTimestampsEnabledFor(MyBasicTimestampsIF e)
    {
        return !_disabledTimestamps.contains(e);
    }

}
