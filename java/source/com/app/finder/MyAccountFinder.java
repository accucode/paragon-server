//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.finder;

import com.kodemore.utility.KmKeyFinderIF;

import com.app.dao.MyAccountDao;
import com.app.finder.core.MyDaoKeyFinder;
import com.app.model.MyAccount;

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
