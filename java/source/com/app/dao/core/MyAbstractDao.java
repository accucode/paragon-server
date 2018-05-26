package com.app.dao.core;

import java.io.Serializable;

import com.kodemore.dao.KmAbstractDao;

import com.app.dao.base.MyDaoAccess;
import com.app.utility.MyGlobals;

public abstract class MyAbstractDao<T, K extends Serializable>
    extends KmAbstractDao<T,K>
{
    @Override
    protected MyDaoSession getDaoSession()
    {
        return (MyDaoSession)super.getDaoSession();
    }

    protected MyDaoSessionCache getCache()
    {
        return getDaoSession().getCache();
    }

    protected MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }
}
