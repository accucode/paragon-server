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

public enum MyFileStatus
    implements KmEnumIF
{
    //##################################################
    //# values
    //##################################################

    New("New", "New"),
    Ready("Ready", "Ready"),
    Deleted("Deleted", "Deleted"),
    Error("Error", "Error"),
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
    private String _label;

    //##################################################
    //# constructor
    //##################################################

    private MyFileStatus(String code, String label)
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
