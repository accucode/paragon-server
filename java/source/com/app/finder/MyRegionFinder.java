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

public class MyRegionFinder
    implements KmKeyFinderIF<MyRegion,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyRegion staticFind(String key)
    {
        return new MyRegionFinder().find(key);
    }

    public static MyRegion staticFindDao(String key)
    {
        return new MyRegionFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyRegion find(String key)
    {
        return new MyRegionDao().findUid(key);
    }

    public MyRegion findDao(String key)
    {
        MyDaoKeyFinder<MyRegion,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
