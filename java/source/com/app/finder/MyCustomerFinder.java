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

public class MyCustomerFinder
    implements KmKeyFinderIF<MyCustomer,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyCustomer staticFind(String key)
    {
        return new MyCustomerFinder().find(key);
    }

    public static MyCustomer staticFindDao(String key)
    {
        return new MyCustomerFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyCustomer find(String key)
    {
        return new MyCustomerDao().findUid(key);
    }

    public MyCustomer findDao(String key)
    {
        MyDaoKeyFinder<MyCustomer,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
