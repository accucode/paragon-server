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

public enum MyAccountUserRole
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

    private static final KmList<MyAccountUserRole> _values;
    private static final KmMap<String,MyAccountUserRole> _codes;

    static
    {
        _values = new KmList<MyAccountUserRole>();
        _values.addAll(values());

        _codes = new KmMap<String,MyAccountUserRole>();
        for ( MyAccountUserRole e : EnumSet.allOf(MyAccountUserRole.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyAccountUserRole> getValues()
    {
        return _values;
    }

    public static MyAccountUserRole findCode(String code)
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

    private MyAccountUserRole(String code, String name)
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

    public static MyAccountUserRole getAt(int index)
    {
        return values()[index];
    }

    public static MyAccountUserRole getFirst()
    {
        return values()[0];
    }

    public static MyAccountUserRole getLast()
    {
        return values()[values().length - 1];
    }

    public MyAccountUserRole getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyAccountUserRole getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
