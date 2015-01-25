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

public class MyDepotFinder
    implements KmKeyFinderIF<MyDepot,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyDepot staticFind(String key)
    {
        return new MyDepotFinder().find(key);
    }

    public static MyDepot staticFindDao(String key)
    {
        return new MyDepotFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyDepot find(String key)
    {
        return new MyDepotDao().findUid(key);
    }

    public MyDepot findDao(String key)
    {
        MyDaoKeyFinder<MyDepot,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
