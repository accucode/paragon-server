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

public class MyApplicationLogFinder
    implements KmKeyFinderIF<MyApplicationLog,Integer>
{
    //##################################################
    //# static
    //##################################################

    public static MyApplicationLog staticFind(Integer key)
    {
        return new MyApplicationLogFinder().find(key);
    }

    public static MyApplicationLog staticFindDao(Integer key)
    {
        return new MyApplicationLogFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyApplicationLog find(Integer key)
    {
        return new MyApplicationLogDao().findId(key);
    }

    public MyApplicationLog findDao(Integer key)
    {
        MyDaoKeyFinder<MyApplicationLog,Integer> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
