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

public class MyOrderNumberFinder
    implements KmKeyFinderIF<MyOrderNumber,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyOrderNumber staticFind(String key)
    {
        return new MyOrderNumberFinder().find(key);
    }

    public static MyOrderNumber staticFindDao(String key)
    {
        return new MyOrderNumberFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyOrderNumber find(String key)
    {
        return new MyOrderNumberDao().findUid(key);
    }

    public MyOrderNumber findDao(String key)
    {
        MyDaoKeyFinder<MyOrderNumber,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
