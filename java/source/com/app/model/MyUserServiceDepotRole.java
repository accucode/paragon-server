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

public enum MyUserServiceDepotRole
    implements KmCodedEnumIF
{
    //##################################################
    //# values
    //##################################################

    Worker("W", "Worker"),
    Manager("M", "Manager"), ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyUserServiceDepotRole>       _values;
    private static final KmMap<String,MyUserServiceDepotRole> _codes;

    static
    {
        _values = new KmList<MyUserServiceDepotRole>();
        _values.addAll(values());

        _codes = new KmMap<String,MyUserServiceDepotRole>();
        for ( MyUserServiceDepotRole e : EnumSet.allOf(MyUserServiceDepotRole.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyUserServiceDepotRole> getValues()
    {
        return _values;
    }

    public static MyUserServiceDepotRole findCode(String code)
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

    private MyUserServiceDepotRole(String code, String name)
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

    public boolean isWorker()
    {
        return this == Worker;
    }

    public boolean isManager()
    {
        return this == Manager;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyUserServiceDepotRole getAt(int index)
    {
        return values()[index];
    }

    public static MyUserServiceDepotRole getFirst()
    {
        return values()[0];
    }

    public static MyUserServiceDepotRole getLast()
    {
        return values()[values().length - 1];
    }

    public MyUserServiceDepotRole getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyUserServiceDepotRole getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
