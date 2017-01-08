//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.base;

import java.util.*;

import com.kodemore.collection.*;
import com.kodemore.utility.*;

public enum MyUserRole
    implements KmEnumIF
{
    //##################################################
    //# values
    //##################################################

    Developer("Developer", "Developer"),
    Admin("Admin", "Admin"),
    Other("Other", "Other"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyUserRole> _values;
    private static final KmMap<String,MyUserRole> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyUserRole e : EnumSet.allOf(MyUserRole.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyUserRole> getValues()
    {
        return _values;
    }

    public static MyUserRole findCode(String code)
    {
        return _codes.get(code);
    }

    //##################################################
    //# variables
    //##################################################

    private String _code;
    private String _label;

    //##################################################
    //# constructor
    //##################################################

    private MyUserRole(String code, String label)
    {
        _code = code;
        _label = label;
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
    public String getLabel()
    {
        return _label;
    }

    //##################################################
    //# testing
    //##################################################

    public boolean isDeveloper()
    {
        return this == Developer;
    }

    public boolean isAdmin()
    {
        return this == Admin;
    }

    public boolean isOther()
    {
        return this == Other;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyUserRole getAt(int index)
    {
        return values()[index];
    }

    public static MyUserRole getFirst()
    {
        return values()[0];
    }

    public static MyUserRole getLast()
    {
        return values()[values().length - 1];
    }

    public MyUserRole getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyUserRole getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
