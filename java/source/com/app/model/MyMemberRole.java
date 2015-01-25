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

public enum MyMemberRole
    implements KmCodedEnumIF
{
    //##################################################
    //# values
    //##################################################

    Manager("M", "Manager"),
    Worker("W", "Worker"),
    Customer("C", "Customer"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyMemberRole> _values;
    private static final KmMap<String,MyMemberRole> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyMemberRole e : EnumSet.allOf(MyMemberRole.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyMemberRole> getValues()
    {
        return _values;
    }

    public static MyMemberRole findCode(String code)
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

    private MyMemberRole(String code, String name)
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

    public boolean isManager()
    {
        return this == Manager;
    }

    public boolean isWorker()
    {
        return this == Worker;
    }

    public boolean isCustomer()
    {
        return this == Customer;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyMemberRole getAt(int index)
    {
        return values()[index];
    }

    public static MyMemberRole getFirst()
    {
        return values()[0];
    }

    public static MyMemberRole getLast()
    {
        return values()[values().length - 1];
    }

    public MyMemberRole getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyMemberRole getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
