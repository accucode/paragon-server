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

public enum MyFeedbackType
    implements MyFeedbackTypeIF
{
    //##################################################
    //# values
    //##################################################

    Bug("Bug", "Bug"),
    Cosmetic("Cosmetic", "Cosmetic"),
    Enhancement("Enhancement", "Enhancement"),
    Duplicate("Duplicate", "Duplicate"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyFeedbackType> _values;
    private static final KmMap<String,MyFeedbackType> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyFeedbackType e : EnumSet.allOf(MyFeedbackType.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyFeedbackType> getValues()
    {
        return _values;
    }

    public static MyFeedbackType findCode(String code)
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

    private MyFeedbackType(String code, String label)
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

    public boolean isBug()
    {
        return this == Bug;
    }

    public boolean isCosmetic()
    {
        return this == Cosmetic;
    }

    public boolean isEnhancement()
    {
        return this == Enhancement;
    }

    public boolean isDuplicate()
    {
        return this == Duplicate;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyFeedbackType getAt(int index)
    {
        return values()[index];
    }

    public static MyFeedbackType getFirst()
    {
        return values()[0];
    }

    public static MyFeedbackType getLast()
    {
        return values()[values().length - 1];
    }

    public MyFeedbackType getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyFeedbackType getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
