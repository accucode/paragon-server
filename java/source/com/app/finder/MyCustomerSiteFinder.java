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

public class MyCustomerSiteFinder
    implements KmKeyFinderIF<MyCustomerSite,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyCustomerSite staticFind(String key)
    {
        return new MyCustomerSiteFinder().find(key);
    }

    public static MyCustomerSite staticFindDao(String key)
    {
        return new MyCustomerSiteFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyCustomerSite find(String key)
    {
        return new MyCustomerSiteDao().findUid(key);
    }

    public MyCustomerSite findDao(String key)
    {
        MyDaoKeyFinder<MyCustomerSite,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
