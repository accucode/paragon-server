//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.finder;

import com.app.dao.MyEmailDao;
import com.app.finder.core.MyDaoKeyFinder;
import com.app.model.MyEmail;

import com.kodemore.utility.KmKeyFinderIF;

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
        e = new MyDaoKeyFinder<MyEmail,String>(this, key);
        e.run();
        return e.getValue();
    }
}
