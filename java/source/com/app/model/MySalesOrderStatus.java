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

public enum MySalesOrderStatus
    implements KmCodedEnumIF
{
    //##################################################
    //# values
    //##################################################

    New("N", "New"),
    InProgress("P", "In Progress"),
    Closed("C", "Closed"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MySalesOrderStatus> _values;
    private static final KmMap<String,MySalesOrderStatus> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MySalesOrderStatus e : EnumSet.allOf(MySalesOrderStatus.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MySalesOrderStatus> getValues()
    {
        return _values;
    }

    public static MySalesOrderStatus findCode(String code)
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

    private MySalesOrderStatus(String code, String name)
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

    public boolean isInProgress()
    {
        return this == InProgress;
    }

    public boolean isClosed()
    {
        return this == Closed;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MySalesOrderStatus getAt(int index)
    {
        return values()[index];
    }

    public static MySalesOrderStatus getFirst()
    {
        return values()[0];
    }

    public static MySalesOrderStatus getLast()
    {
        return values()[values().length - 1];
    }

    public MySalesOrderStatus getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MySalesOrderStatus getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
