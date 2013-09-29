//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.finder;

import com.app.dao.MySystemLogDao;
import com.app.finder.core.MyDaoKeyFinder;
import com.app.model.MySystemLog;

import com.kodemore.utility.KmKeyFinderIF;

public class MySystemLogFinder
    implements KmKeyFinderIF<MySystemLog,Integer>
{
    //##################################################
    //# static
    //##################################################

    public static MySystemLog staticFind(Integer key)
    {
        return new MySystemLogFinder().find(key);
    }

    public static MySystemLog staticFindDao(Integer key)
    {
        return new MySystemLogFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MySystemLog find(Integer key)
    {
        return new MySystemLogDao().findId(key);
    }

    public MySystemLog findDao(Integer key)
    {
        MyDaoKeyFinder<MySystemLog,Integer> e;
        e = new MyDaoKeyFinder<MySystemLog,Integer>(this, key);
        e.run();
        return e.getValue();
    }
}
