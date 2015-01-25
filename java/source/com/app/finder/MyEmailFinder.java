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

public class MyEmailFinder
    implements KmKeyFinderIF<MyEmail,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyEmail staticFind(String key)
    {
        return new MyEmailFinder().find(key);
    }

    public static MyEmail staticFindDao(String key)
    {
        return new MyEmailFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyEmail find(String key)
    {
        return new MyEmailDao().findUid(key);
    }

    public MyEmail findDao(String key)
    {
        MyDaoKeyFinder<MyEmail,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
