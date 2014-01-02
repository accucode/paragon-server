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

public enum MyUserAccountRole
    implements KmCodedEnumIF
{
    //##################################################
    //# values
    //##################################################

    Owner("O", "Owner"),
    Manager("M", "Manager"),
    User("U", "User"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyUserAccountRole> _values;
    private static final KmMap<String,MyUserAccountRole> _codes;

    static
    {
        _values = new KmList<MyUserAccountRole>();
        _values.addAll(values());

        _codes = new KmMap<String,MyUserAccountRole>();
        for ( MyUserAccountRole e : EnumSet.allOf(MyUserAccountRole.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyUserAccountRole> getValues()
    {
        return _values;
    }

    public static MyUserAccountRole findCode(String code)
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

    private MyUserAccountRole(String code, String name)
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

    public boolean isOwner()
    {
        return this == Owner;
    }

    public boolean isManager()
    {
        return this == Manager;
    }

    public boolean isUser()
    {
        return this == User;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyUserAccountRole getAt(int index)
    {
        return values()[index];
    }

    public static MyUserAccountRole getFirst()
    {
        return values()[0];
    }

    public static MyUserAccountRole getLast()
    {
        return values()[values().length - 1];
    }

    public MyUserAccountRole getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyUserAccountRole getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
