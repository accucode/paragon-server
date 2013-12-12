//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.finder;

import com.kodemore.utility.KmKeyFinderIF;

import com.app.dao.MySystemLogTraceDao;
import com.app.finder.core.MyDaoKeyFinder;
import com.app.model.MySystemLogTrace;

public class MySystemLogTraceFinder
    implements KmKeyFinderIF<MySystemLogTrace,Integer>
{
    //##################################################
    //# static
    //##################################################

    public static MySystemLogTrace staticFind(Integer key)
    {
        return new MySystemLogTraceFinder().find(key);
    }

    public static MySystemLogTrace staticFindDao(Integer key)
    {
        return new MySystemLogTraceFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MySystemLogTrace find(Integer key)
    {
        return new MySystemLogTraceDao().findId(key);
    }

    public MySystemLogTrace findDao(Integer key)
    {
        MyDaoKeyFinder<MySystemLogTrace,Integer> e;
        e = new MyDaoKeyFinder<MySystemLogTrace,Integer>(this, key);
        e.run();
        return e.getValue();
    }
}
