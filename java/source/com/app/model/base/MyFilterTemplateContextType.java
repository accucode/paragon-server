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

public enum MyFilterTemplateContextType
    implements MyFilterTemplateContextTypeIF
{
    //##################################################
    //# values
    //##################################################

    Site("Site", "Site"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyFilterTemplateContextType> _values;
    private static final KmMap<String,MyFilterTemplateContextType> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyFilterTemplateContextType e : EnumSet.allOf(MyFilterTemplateContextType.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyFilterTemplateContextType> getValues()
    {
        return _values;
    }

    public static MyFilterTemplateContextType findCode(String code)
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

    private MyFilterTemplateContextType(String code, String label)
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

    public boolean isSite()
    {
        return this == Site;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyFilterTemplateContextType getAt(int index)
    {
        return values()[index];
    }

    public static MyFilterTemplateContextType getFirst()
    {
        return values()[0];
    }

    public static MyFilterTemplateContextType getLast()
    {
        return values()[values().length - 1];
    }

    public MyFilterTemplateContextType getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyFilterTemplateContextType getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
