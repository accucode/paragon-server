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

public class MyVendorFinder
    implements KmKeyFinderIF<MyVendor,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyVendor staticFind(String key)
    {
        return new MyVendorFinder().find(key);
    }

    public static MyVendor staticFindDao(String key)
    {
        return new MyVendorFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyVendor find(String key)
    {
        return new MyVendorDao().findUid(key);
    }

    public MyVendor findDao(String key)
    {
        MyDaoKeyFinder<MyVendor,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
