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

public class MyHibernateCacheTestFinder
    implements KmKeyFinderIF<MyHibernateCacheTest,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyHibernateCacheTest staticFind(String key)
    {
        return new MyHibernateCacheTestFinder().find(key);
    }

    public static MyHibernateCacheTest staticFindDao(String key)
    {
        return new MyHibernateCacheTestFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyHibernateCacheTest find(String key)
    {
        return new MyHibernateCacheTestDao().findUid(key);
    }

    public MyHibernateCacheTest findDao(String key)
    {
        MyDaoKeyFinder<MyHibernateCacheTest,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
