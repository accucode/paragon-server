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

public class MyAccountFinder
    implements KmKeyFinderIF<MyAccount,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyAccount staticFind(String key)
    {
        return new MyAccountFinder().find(key);
    }

    public static MyAccount staticFindDao(String key)
    {
        return new MyAccountFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyAccount find(String key)
    {
        return new MyAccountDao().findUid(key);
    }

    public MyAccount findDao(String key)
    {
        MyDaoKeyFinder<MyAccount,String> e;
        e = new MyDaoKeyFinder<MyAccount,String>(this, key);
        e.run();
        return e.getValue();
    }
}
