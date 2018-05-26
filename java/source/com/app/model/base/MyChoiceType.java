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

public enum MyChoiceType
    implements MyChoiceTypeIF
{
    //##################################################
    //# values
    //##################################################

    SiteType("siteType", "Site Type"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyChoiceType> _values;
    private static final KmMap<String,MyChoiceType> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyChoiceType e : EnumSet.allOf(MyChoiceType.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyChoiceType> getValues()
    {
        return _values;
    }

    public static MyChoiceType findCode(String code)
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

    private MyChoiceType(String code, String label)
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

    public boolean isSiteType()
    {
        return this == SiteType;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyChoiceType getAt(int index)
    {
        return values()[index];
    }

    public static MyChoiceType getFirst()
    {
        return values()[0];
    }

    public static MyChoiceType getLast()
    {
        return values()[values().length - 1];
    }

    public MyChoiceType getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyChoiceType getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
