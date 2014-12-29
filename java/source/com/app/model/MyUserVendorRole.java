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

public enum MyUserVendorRole
    implements KmCodedEnumIF
{
    //##################################################
    //# values
    //##################################################

    Account("A", "Account"),
    Manager("M", "Manager"),
    User("U", "User"), ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyUserVendorRole>       _values;
    private static final KmMap<String,MyUserVendorRole> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyUserVendorRole e : EnumSet.allOf(MyUserVendorRole.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyUserVendorRole> getValues()
    {
        return _values;
    }

    public static MyUserVendorRole findCode(String code)
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

    private MyUserVendorRole(String code, String name)
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

    public static MyUserVendorRole getAt(int index)
    {
        return values()[index];
    }

    public static MyUserVendorRole getFirst()
    {
        return values()[0];
    }

    public static MyUserVendorRole getLast()
    {
        return values()[values().length - 1];
    }

    public MyUserVendorRole getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyUserVendorRole getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
