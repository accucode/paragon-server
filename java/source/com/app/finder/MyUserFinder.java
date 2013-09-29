//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.finder;

import com.app.dao.MyUserDao;
import com.app.finder.core.MyDaoKeyFinder;
import com.app.model.MyUser;

import com.kodemore.utility.KmKeyFinderIF;

public class MyUserFinder
    implements KmKeyFinderIF<MyUser,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyUser staticFind(String key)
    {
        return new MyUserFinder().find(key);
    }

    public static MyUser staticFindDao(String key)
    {
        return new MyUserFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyUser find(String key)
    {
        return new MyUserDao().findUid(key);
    }

    public MyUser findDao(String key)
    {
        MyDaoKeyFinder<MyUser,String> e;
        e = new MyDaoKeyFinder<MyUser,String>(this, key);
        e.run();
        return e.getValue();
    }
}
