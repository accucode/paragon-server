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

public class MyUserActivationFinder
    implements KmKeyFinderIF<MyUserActivation,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyUserActivation staticFind(String key)
    {
        return new MyUserActivationFinder().find(key);
    }

    public static MyUserActivation staticFindDao(String key)
    {
        return new MyUserActivationFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyUserActivation find(String key)
    {
        return new MyUserActivationDao().findUid(key);
    }

    public MyUserActivation findDao(String key)
    {
        MyDaoKeyFinder<MyUserActivation,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
