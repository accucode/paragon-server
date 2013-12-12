//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.finder;

import com.kodemore.utility.KmKeyFinderIF;

import com.app.dao.MyAccountUserDao;
import com.app.finder.core.MyDaoKeyFinder;
import com.app.model.MyAccountUser;

public class MyAccountUserFinder
    implements KmKeyFinderIF<MyAccountUser,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyAccountUser staticFind(String key)
    {
        return new MyAccountUserFinder().find(key);
    }

    public static MyAccountUser staticFindDao(String key)
    {
        return new MyAccountUserFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyAccountUser find(String key)
    {
        return new MyAccountUserDao().findUid(key);
    }

    public MyAccountUser findDao(String key)
    {
        MyDaoKeyFinder<MyAccountUser,String> e;
        e = new MyDaoKeyFinder<MyAccountUser,String>(this, key);
        e.run();
        return e.getValue();
    }
}
