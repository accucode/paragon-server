//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.finder;

import com.kodemore.collection.*;
import com.kodemore.utility.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.finder.core.*;
import com.app.model.*;

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
