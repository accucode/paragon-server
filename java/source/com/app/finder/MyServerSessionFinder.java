//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.finder;

import com.app.dao.MyServerSessionDao;
import com.app.finder.core.MyDaoKeyFinder;
import com.app.model.MyServerSession;

import com.kodemore.utility.KmKeyFinderIF;

public class MyServerSessionFinder
    implements KmKeyFinderIF<MyServerSession,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyServerSession staticFind(String key)
    {
        return new MyServerSessionFinder().find(key);
    }

    public static MyServerSession staticFindDao(String key)
    {
        return new MyServerSessionFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyServerSession find(String key)
    {
        return new MyServerSessionDao().findUid(key);
    }

    public MyServerSession findDao(String key)
    {
        MyDaoKeyFinder<MyServerSession,String> e;
        e = new MyDaoKeyFinder<MyServerSession,String>(this, key);
        e.run();
        return e.getValue();
    }
}
