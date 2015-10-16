//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model;

import java.util.*;

import com.kodemore.collection.*;
import com.kodemore.utility.*;

public enum MyShipAccountBillToType
    implements KmCodedEnumIF
{
    //##################################################
    //# values
    //##################################################

    Sender("S", "Sender"),
    Receiving("R", "Receiving"),
    Third("T", "Third"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyShipAccountBillToType> _values;
    private static final KmMap<String,MyShipAccountBillToType> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyShipAccountBillToType e : EnumSet.allOf(MyShipAccountBillToType.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyShipAccountBillToType> getValues()
    {
        return _values;
    }

    public static MyShipAccountBillToType findCode(String code)
    {
        return _codes.get(code);
    }

    //##################################################
    //# variables
    //##################################################

    private String _code;
    private String _name;

    //##################################################
    //# constructor
    //##################################################

    private MyShipAccountBillToType(String code, String name)
    {
        _code = code;
        _name = name;
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getCode()
    {
        return _code;
    }

    @Override
    public String getName()
    {
        return _name;
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isSender()
    {
        return this == Sender;
    }

    public boolean isReceiving()
    {
        return this == Receiving;
    }

    public boolean isThird()
    {
        return this == Third;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyShipAccountBillToType getAt(int index)
    {
        return values()[index];
    }

    public static MyShipAccountBillToType getFirst()
    {
        return values()[0];
    }

    public static MyShipAccountBillToType getLast()
    {
        return values()[values().length - 1];
    }

    public MyShipAccountBillToType getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyShipAccountBillToType getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
