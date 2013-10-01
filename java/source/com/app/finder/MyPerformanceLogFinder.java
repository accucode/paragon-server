//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.finder;

import com.app.dao.MyPerformanceLogDao;
import com.app.finder.core.MyDaoKeyFinder;
import com.app.model.MyPerformanceLog;

import com.kodemore.utility.KmKeyFinderIF;

public class MyPerformanceLogFinder
    implements KmKeyFinderIF<MyPerformanceLog,Integer>
{
    //##################################################
    //# static
    //##################################################

    public static MyPerformanceLog staticFind(Integer key)
    {
        return new MyPerformanceLogFinder().find(key);
    }

    public static MyPerformanceLog staticFindDao(Integer key)
    {
        return new MyPerformanceLogFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyPerformanceLog find(Integer key)
    {
        return new MyPerformanceLogDao().findId(key);
    }

    public MyPerformanceLog findDao(Integer key)
    {
        MyDaoKeyFinder<MyPerformanceLog,Integer> e;
        e = new MyDaoKeyFinder<MyPerformanceLog,Integer>(this, key);
        e.run();
        return e.getValue();
    }
}
