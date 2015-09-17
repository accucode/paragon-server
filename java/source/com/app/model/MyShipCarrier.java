package com.app.model;

import com.kodemore.collection.KmList;

import com.app.model.base.MyShipCarrierBase;

public class MyShipCarrier
    extends MyShipCarrierBase
{
    //##################################################
    //# constants
    //##################################################

    public static final int MAX_PER_PROJECT = 5;

    //##################################################
    //# constructor
    //##################################################

    public MyShipCarrier()
    {
        super();
    }

    //##################################################
    //# convenience
    //##################################################

    public KmList<MyShipMethod> getShipMethodsByName()
    {
        KmList<MyShipMethod> v;
        v = getShipMethods().toList();
        v.sortOn(MyShipMethod::getName);
        return v;
    }

    public MyShipMethod addShipMethod(String name)
    {
        MyShipMethod e;
        e = addShipMethod();
        e.setName(name);
        return e;
    }

    @Override
    public String getMethodNames()
    {
        return getShipMethodsByName().join(e -> e.getName());
    }
}
