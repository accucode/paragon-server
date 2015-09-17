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
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
