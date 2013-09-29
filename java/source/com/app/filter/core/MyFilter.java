package com.app.filter.core;

import java.io.Serializable;

import com.app.dao.base.MyDaoRegistry;
import com.app.utility.MyGlobals;

import com.kodemore.dao.KmAbstractDao;
import com.kodemore.filter.KmFilter;

public abstract class MyFilter<T>
    extends KmFilter<T>
{
    //##################################################
    //# dao
    //##################################################

    protected abstract KmAbstractDao<T,? extends Serializable> getDao();

    protected MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }

}
