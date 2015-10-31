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

public class MyNextOrderNumberFinder
    implements KmKeyFinderIF<MyNextOrderNumber,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyNextOrderNumber staticFind(String key)
    {
        return new MyNextOrderNumberFinder().find(key);
    }

    public static MyNextOrderNumber staticFindDao(String key)
    {
        return new MyNextOrderNumberFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyNextOrderNumber find(String key)
    {
        return new MyNextOrderNumberDao().findUid(key);
    }

    public MyNextOrderNumber findDao(String key)
    {
        MyDaoKeyFinder<MyNextOrderNumber,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
