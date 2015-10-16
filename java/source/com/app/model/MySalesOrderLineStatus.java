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

public enum MySalesOrderLineStatus
    implements KmCodedEnumIF
{
    //##################################################
    //# values
    //##################################################

    New("N", "New"),
    In("P", "In"),
    Closed("C", "Closed"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MySalesOrderLineStatus> _values;
    private static final KmMap<String,MySalesOrderLineStatus> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MySalesOrderLineStatus e : EnumSet.allOf(MySalesOrderLineStatus.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MySalesOrderLineStatus> getValues()
    {
        return _values;
    }

    public static MySalesOrderLineStatus findCode(String code)
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

    private MySalesOrderLineStatus(String code, String name)
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

    public boolean isNew()
    {
        return this == New;
    }

    public boolean isIn()
    {
        return this == In;
    }

    public boolean isClosed()
    {
        return this == Closed;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MySalesOrderLineStatus getAt(int index)
    {
        return values()[index];
    }

    public static MySalesOrderLineStatus getFirst()
    {
        return values()[0];
    }

    public static MySalesOrderLineStatus getLast()
    {
        return values()[values().length - 1];
    }

    public MySalesOrderLineStatus getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MySalesOrderLineStatus getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
