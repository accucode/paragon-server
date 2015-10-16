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
    implements KmKeyFinderIF<MyApplicationLog,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyApplicationLog staticFind(String key)
    {
        return new MyApplicationLogFinder().find(key);
    }

    public static MyApplicationLog staticFindDao(String key)
    {
        return new MyApplicationLogFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyApplicationLog find(String key)
    {
        return new MyApplicationLogDao().findUid(key);
    }

    public MyApplicationLog findDao(String key)
    {
        MyDaoKeyFinder<MyApplicationLog,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
