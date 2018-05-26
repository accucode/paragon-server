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

public enum MyPriorityCategory
    implements MyPriorityCategoryIF
{
    //##################################################
    //# values
    //##################################################

    Low("Low", "Low"),
    Normal("Normal", "Normal"),
    High("High", "High"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyPriorityCategory> _values;
    private static final KmMap<String,MyPriorityCategory> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyPriorityCategory e : EnumSet.allOf(MyPriorityCategory.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyPriorityCategory> getValues()
    {
        return _values;
    }

    public static MyPriorityCategory findCode(String code)
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

    private MyPriorityCategory(String code, String label)
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

    public boolean isLow()
    {
        return this == Low;
    }

    public boolean isNormal()
    {
        return this == Normal;
    }

    public boolean isHigh()
    {
        return this == High;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyPriorityCategory getAt(int index)
    {
        return values()[index];
    }

    public static MyPriorityCategory getFirst()
    {
        return values()[0];
    }

    public static MyPriorityCategory getLast()
    {
        return values()[values().length - 1];
    }

    public MyPriorityCategory getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyPriorityCategory getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
