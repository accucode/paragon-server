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

public enum MyFileStatus
    implements KmCodedEnumIF
{
    //##################################################
    //# values
    //##################################################

    New("N", "New"),
    Ready("R", "Ready"),
    Deleted("D", "Deleted"),
    Error("E", "Error"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyFileStatus> _values;
    private static final KmMap<String,MyFileStatus> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyFileStatus e : EnumSet.allOf(MyFileStatus.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyFileStatus> getValues()
    {
        return _values;
    }

    public static MyFileStatus findCode(String code)
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

    private MyFileStatus(String code, String name)
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

    public boolean isReady()
    {
        return this == Ready;
    }

    public boolean isDeleted()
    {
        return this == Deleted;
    }

    public boolean isError()
    {
        return this == Error;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyFileStatus getAt(int index)
    {
        return values()[index];
    }

    public static MyFileStatus getFirst()
    {
        return values()[0];
    }

    public static MyFileStatus getLast()
    {
        return values()[values().length - 1];
    }

    public MyFileStatus getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyFileStatus getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
