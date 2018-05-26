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

public enum MyFilterTemplateType
    implements MyFilterTemplateTypeIF
{
    //##################################################
    //# values
    //##################################################

    Predefined("Predefined", "Predefined"),
    Shared("Shared", "Shared"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyFilterTemplateType> _values;
    private static final KmMap<String,MyFilterTemplateType> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyFilterTemplateType e : EnumSet.allOf(MyFilterTemplateType.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyFilterTemplateType> getValues()
    {
        return _values;
    }

    public static MyFilterTemplateType findCode(String code)
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

    private MyFilterTemplateType(String code, String label)
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

    public boolean isPredefined()
    {
        return this == Predefined;
    }

    public boolean isShared()
    {
        return this == Shared;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyFilterTemplateType getAt(int index)
    {
        return values()[index];
    }

    public static MyFilterTemplateType getFirst()
    {
        return values()[0];
    }

    public static MyFilterTemplateType getLast()
    {
        return values()[values().length - 1];
    }

    public MyFilterTemplateType getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyFilterTemplateType getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
