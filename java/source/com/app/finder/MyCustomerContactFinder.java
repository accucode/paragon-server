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

public class MyCustomerContactFinder
    implements KmKeyFinderIF<MyCustomerContact,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyCustomerContact staticFind(String key)
    {
        return new MyCustomerContactFinder().find(key);
    }

    public static MyCustomerContact staticFindDao(String key)
    {
        return new MyCustomerContactFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyCustomerContact find(String key)
    {
        return new MyCustomerContactDao().findUid(key);
    }

    public MyCustomerContact findDao(String key)
    {
        MyDaoKeyFinder<MyCustomerContact,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
