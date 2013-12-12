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
