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

public class MyApplicationLogTraceFinder
    implements KmKeyFinderIF<MyApplicationLogTrace,Integer>
{
    //##################################################
    //# static
    //##################################################

    public static MyApplicationLogTrace staticFind(Integer key)
    {
        return new MyApplicationLogTraceFinder().find(key);
    }

    public static MyApplicationLogTrace staticFindDao(Integer key)
    {
        return new MyApplicationLogTraceFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyApplicationLogTrace find(Integer key)
    {
        return new MyApplicationLogTraceDao().findId(key);
    }

    public MyApplicationLogTrace findDao(Integer key)
    {
        MyDaoKeyFinder<MyApplicationLogTrace,Integer> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
