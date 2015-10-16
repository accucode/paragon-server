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

public class MyCustomerTierFinder
    implements KmKeyFinderIF<MyCustomerTier,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyCustomerTier staticFind(String key)
    {
        return new MyCustomerTierFinder().find(key);
    }

    public static MyCustomerTier staticFindDao(String key)
    {
        return new MyCustomerTierFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyCustomerTier find(String key)
    {
        return new MyCustomerTierDao().findUid(key);
    }

    public MyCustomerTier findDao(String key)
    {
        MyDaoKeyFinder<MyCustomerTier,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
