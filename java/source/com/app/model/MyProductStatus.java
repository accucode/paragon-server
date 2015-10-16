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

public enum MyProductStatus
    implements KmCodedEnumIF
{
    //##################################################
    //# values
    //##################################################

    Draft("D", "Draft"),
    Published("P", "Published"),
    Cancelled("X", "Cancelled"),
    Archived("A", "Archived"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyProductStatus> _values;
    private static final KmMap<String,MyProductStatus> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyProductStatus e : EnumSet.allOf(MyProductStatus.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyProductStatus> getValues()
    {
        return _values;
    }

    public static MyProductStatus findCode(String code)
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

    private MyProductStatus(String code, String name)
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

    public boolean isPublished()
    {
        return this == Published;
    }

    public boolean isCancelled()
    {
        return this == Cancelled;
    }

    public boolean isArchived()
    {
        return this == Archived;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyProductStatus getAt(int index)
    {
        return values()[index];
    }

    public static MyProductStatus getFirst()
    {
        return values()[0];
    }

    public static MyProductStatus getLast()
    {
        return values()[values().length - 1];
    }

    public MyProductStatus getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyProductStatus getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
