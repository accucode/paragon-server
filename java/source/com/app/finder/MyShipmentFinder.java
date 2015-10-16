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

public class MyShipmentFinder
    implements KmKeyFinderIF<MyShipment,String>
{
    //##################################################
    //# static
    //##################################################

    public static MyShipment staticFind(String key)
    {
        return new MyShipmentFinder().find(key);
    }

    public static MyShipment staticFindDao(String key)
    {
        return new MyShipmentFinder().findDao(key);
    }

    //##################################################
    //# find
    //##################################################

    @Override
    public MyShipment find(String key)
    {
        return new MyShipmentDao().findUid(key);
    }

    public MyShipment findDao(String key)
    {
        MyDaoKeyFinder<MyShipment,String> e;
        e = new MyDaoKeyFinder<>(this, key);
        e.run();
        return e.getValue();
    }
}
