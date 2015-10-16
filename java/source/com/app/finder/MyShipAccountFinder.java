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

public class MyShipAccountFinder
    implements KmKeyFinderIF<MyShipAccount,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyShipAccount staticFind(String key)
    {
        return new MyShipAccountFinder().find(key);
    }

    public static MyShipAccount staticFindDao(String key)
    {
        return new MyShipAccountFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyShipAccount find(String key)
    {
        return new MyShipAccountDao().findUid(key);
    }

    public MyShipAccount findDao(String key)
    {
        MyDaoKeyFinder<MyShipAccount,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
