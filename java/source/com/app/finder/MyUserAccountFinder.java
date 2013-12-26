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

public class MyUserAccountFinder
    implements KmKeyFinderIF<MyUserAccount,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyUserAccount staticFind(String key)
    {
        return new MyUserAccountFinder().find(key);
    }

    public static MyUserAccount staticFindDao(String key)
    {
        return new MyUserAccountFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyUserAccount find(String key)
    {
        return new MyUserAccountDao().findUid(key);
    }

    public MyUserAccount findDao(String key)
    {
        MyDaoKeyFinder<MyUserAccount,String> e;
        e = new MyDaoKeyFinder<MyUserAccount,String>(this, key);
        e.run();
        return e.getValue();
    }
}
