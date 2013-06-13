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
