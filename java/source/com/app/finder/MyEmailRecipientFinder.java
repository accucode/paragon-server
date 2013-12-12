//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.finder;

import com.kodemore.utility.KmKeyFinderIF;

import com.app.dao.MyEmailRecipientDao;
import com.app.finder.core.MyDaoKeyFinder;
import com.app.model.MyEmailRecipient;

public class MyEmailRecipientFinder
    implements KmKeyFinderIF<MyEmailRecipient,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyEmailRecipient staticFind(String key)
    {
        return new MyEmailRecipientFinder().find(key);
    }

    public static MyEmailRecipient staticFindDao(String key)
    {
        return new MyEmailRecipientFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyEmailRecipient find(String key)
    {
        return new MyEmailRecipientDao().findUid(key);
    }

    public MyEmailRecipient findDao(String key)
    {
        MyDaoKeyFinder<MyEmailRecipient,String> e;
        e = new MyDaoKeyFinder<MyEmailRecipient,String>(this, key);
        e.run();
        return e.getValue();
    }
}
