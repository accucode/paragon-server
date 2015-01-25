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

public class MyProductFinder
    implements KmKeyFinderIF<MyProduct,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyProduct staticFind(String key)
    {
        return new MyProductFinder().find(key);
    }

    public static MyProduct staticFindDao(String key)
    {
        return new MyProductFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyProduct find(String key)
    {
        return new MyProductDao().findUid(key);
    }

    public MyProduct findDao(String key)
    {
        MyDaoKeyFinder<MyProduct,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
