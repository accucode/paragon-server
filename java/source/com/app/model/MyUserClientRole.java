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

public enum MyUserClientRole
    implements KmCodedEnumIF
{
    //##################################################
    //# values
    //##################################################

    Account("A", "Account"),
    Manager("M", "Manager"),
    User("U", "User"),;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyUserClientRole> _values;
    private static final KmMap<String,MyUserClientRole> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyUserClientRole e : EnumSet.allOf(MyUserClientRole.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyUserClientRole> getValues()
    {
        return _values;
    }

    public static MyUserClientRole findCode(String code)
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

    private MyUserClientRole(String code, String name)
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

    public boolean isAccount()
    {
        return this == Account;
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

    public static MyUserClientRole getAt(int index)
    {
        return values()[index];
    }

    public static MyUserClientRole getFirst()
    {
        return values()[0];
    }

    public static MyUserClientRole getLast()
    {
        return values()[values().length - 1];
    }

    public MyUserClientRole getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyUserClientRole getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
