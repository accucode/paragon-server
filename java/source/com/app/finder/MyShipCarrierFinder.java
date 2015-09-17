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

public class MyShipCarrierFinder
    implements KmKeyFinderIF<MyShipCarrier,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyShipCarrier staticFind(String key)
    {
        return new MyShipCarrierFinder().find(key);
    }

    public static MyShipCarrier staticFindDao(String key)
    {
        return new MyShipCarrierFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyShipCarrier find(String key)
    {
        return new MyShipCarrierDao().findUid(key);
    }

    public MyShipCarrier findDao(String key)
    {
        MyDaoKeyFinder<MyShipCarrier,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
