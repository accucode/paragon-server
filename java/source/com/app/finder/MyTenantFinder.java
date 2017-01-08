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

public class MyTenantFinder
    implements KmKeyFinderIF<MyTenant,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyTenant staticFind(String key)
    {
        return new MyTenantFinder().find(key);
    }

    public static MyTenant staticFindDao(String key)
    {
        return new MyTenantFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyTenant find(String key)
    {
        return new MyTenantDao().findUid(key);
    }

    public MyTenant findDao(String key)
    {
        MyDaoKeyFinder<MyTenant,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
