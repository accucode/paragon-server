package com.app.filter.core;

import com.kodemore.filter.KmFilter;

import com.app.dao.base.MyDaoAccess;
import com.app.utility.MyGlobals;

public abstract class MyFilter<T>
    extends KmFilter<T>
{
    //##################################################
    //# dao
    //##################################################

    protected MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

}
