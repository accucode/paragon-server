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

public enum MyEmailStatus
    implements KmCodedEnumIF
{
    //##################################################
    //# values
    //##################################################

    Draft("D", "Draft"),
    Ready("R", "Ready"),
    Pending("P", "Pending"),
    Sent("S", "Sent"),
    Error("E", "Error"),
    Ignored("I", "Ignored"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyEmailStatus> _values;
    private static final KmMap<String,MyEmailStatus> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyEmailStatus e : EnumSet.allOf(MyEmailStatus.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyEmailStatus> getValues()
    {
        return _values;
    }

    public static MyEmailStatus findCode(String code)
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

    private MyEmailStatus(String code, String name)
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

    public boolean isDraft()
    {
        return this == Draft;
    }

    public boolean isReady()
    {
        return this == Ready;
    }

    public boolean isPending()
    {
        return this == Pending;
    }

    public boolean isSent()
    {
        return this == Sent;
    }

    public boolean isError()
    {
        return this == Error;
    }

    public boolean isIgnored()
    {
        return this == Ignored;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyEmailStatus getAt(int index)
    {
        return values()[index];
    }

    public static MyEmailStatus getFirst()
    {
        return values()[0];
    }

    public static MyEmailStatus getLast()
    {
        return values()[values().length - 1];
    }

    public MyEmailStatus getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyEmailStatus getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
