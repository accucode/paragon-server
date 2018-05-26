//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.finder;

import com.kodemore.collection.*;
import com.kodemore.command.*;
import com.kodemore.utility.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.finder.core.*;
import com.app.model.*;

public final class MyHibernateCacheTestFinder
    implements KmKeyFinderIF<MyHibernateCacheTest,String>
{
    //##################################################
    //# instance
    //##################################################

    public static final MyHibernateCacheTestFinder instance = new MyHibernateCacheTestFinder();

    //##################################################
    //# constructor
    //##################################################

    private MyHibernateCacheTestFinder()
    {
        // private
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
        return KmDao.fetch(this::find, key);
    }
}
