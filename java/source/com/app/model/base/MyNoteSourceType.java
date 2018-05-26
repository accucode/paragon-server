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

import com.app.model.*;

public enum MyNoteSourceType
    implements MyNoteSourceTypeIF
{
    //##################################################
    //# values
    //##################################################

    User("User", "User"),
    System("System", "System"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyNoteSourceType> _values;
    private static final KmMap<String,MyNoteSourceType> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyNoteSourceType e : EnumSet.allOf(MyNoteSourceType.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyNoteSourceType> getValues()
    {
        return _values;
    }

    public static MyNoteSourceType findCode(String code)
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

    private MyNoteSourceType(String code, String label)
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

    public boolean isUser()
    {
        return this == User;
    }

    public boolean isSystem()
    {
        return this == System;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyNoteSourceType getAt(int index)
    {
        return values()[index];
    }

    public static MyNoteSourceType getFirst()
    {
        return values()[0];
    }

    public static MyNoteSourceType getLast()
    {
        return values()[values().length - 1];
    }

    public MyNoteSourceType getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyNoteSourceType getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
