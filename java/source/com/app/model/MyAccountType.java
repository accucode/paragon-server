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

public enum MyAccountType
    implements KmCodedEnumIF
{
    //##################################################
    //# values
    //##################################################

    Personal("P", "Personal"),
    Business("B", "Business"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyAccountType> _values;
    private static final KmMap<String,MyAccountType> _codes;

    static
    {
        _values = new KmList<MyAccountType>();
        _values.addAll(values());

        _codes = new KmMap<String,MyAccountType>();
        for ( MyAccountType e : EnumSet.allOf(MyAccountType.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyAccountType> getValues()
    {
        return _values;
    }

    public static MyAccountType findCode(String code)
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

    private MyAccountType(String code, String name)
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

    public boolean isPersonal()
    {
        return this == Personal;
    }

    public boolean isBusiness()
    {
        return this == Business;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyAccountType getAt(int index)
    {
        return values()[index];
    }

    public static MyAccountType getFirst()
    {
        return values()[0];
    }

    public static MyAccountType getLast()
    {
        return values()[values().length - 1];
    }

    public MyAccountType getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyAccountType getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
