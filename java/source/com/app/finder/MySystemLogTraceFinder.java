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
