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

public class MyShipMethodFinder
    implements KmKeyFinderIF<MyShipMethod,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyShipMethod staticFind(String key)
    {
        return new MyShipMethodFinder().find(key);
    }

    public static MyShipMethod staticFindDao(String key)
    {
        return new MyShipMethodFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyShipMethod find(String key)
    {
        return new MyShipMethodDao().findUid(key);
    }

    public MyShipMethod findDao(String key)
    {
        MyDaoKeyFinder<MyShipMethod,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
