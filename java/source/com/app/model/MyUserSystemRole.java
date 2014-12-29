//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model;

import java.util.EnumSet;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.utility.KmCodedEnumIF;

public enum MyUserSystemRole
    implements KmCodedEnumIF
{
    //##################################################
    //# values
    //##################################################

    Admin("A", "Admin"),
    Developer("D", "Developer"), ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyUserSystemRole>       _values;
    private static final KmMap<String,MyUserSystemRole> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyUserSystemRole e : EnumSet.allOf(MyUserSystemRole.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyUserSystemRole> getValues()
    {
        return _values;
    }

    public static MyUserSystemRole findCode(String code)
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

    private MyUserSystemRole(String code, String name)
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

    public boolean isAdmin()
    {
        return this == Admin;
    }

    public boolean isDeveloper()
    {
        return this == Developer;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyUserSystemRole getAt(int index)
    {
        return values()[index];
    }

    public static MyUserSystemRole getFirst()
    {
        return values()[0];
    }

    public static MyUserSystemRole getLast()
    {
        return values()[values().length - 1];
    }

    public MyUserSystemRole getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyUserSystemRole getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
