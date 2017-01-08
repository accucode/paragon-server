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

public class MyAutoLoginFinder
    implements KmKeyFinderIF<MyAutoLogin,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyAutoLogin staticFind(String key)
    {
        return new MyAutoLoginFinder().find(key);
    }

    public static MyAutoLogin staticFindDao(String key)
    {
        return new MyAutoLoginFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyAutoLogin find(String key)
    {
        return new MyAutoLoginDao().findUid(key);
    }

    public MyAutoLogin findDao(String key)
    {
        MyDaoKeyFinder<MyAutoLogin,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
