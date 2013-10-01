//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.finder;

import com.app.dao.MyAutoSignInDao;
import com.app.finder.core.MyDaoKeyFinder;
import com.app.model.MyAutoSignIn;

import com.kodemore.utility.KmKeyFinderIF;

public class MyAutoSignInFinder
    implements KmKeyFinderIF<MyAutoSignIn,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyAutoSignIn staticFind(String key)
    {
        return new MyAutoSignInFinder().find(key);
    }

    public static MyAutoSignIn staticFindDao(String key)
    {
        return new MyAutoSignInFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyAutoSignIn find(String key)
    {
        return new MyAutoSignInDao().findUid(key);
    }

    public MyAutoSignIn findDao(String key)
    {
        MyDaoKeyFinder<MyAutoSignIn,String> e;
        e = new MyDaoKeyFinder<MyAutoSignIn,String>(this, key);
        e.run();
        return e.getValue();
    }
}
