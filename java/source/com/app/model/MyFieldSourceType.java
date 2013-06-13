//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model;

import java.util.EnumSet;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.utility.KmCodedEnumIF;

public enum MyFieldSourceType
    implements KmCodedEnumIF
{
    //##################################################
    //# values
    //##################################################

    Output("O", "Output"),
    Performance("P", "Performance"), ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyFieldSourceType>       _values;
    private static final KmMap<String,MyFieldSourceType> _codes;

    static
    {
        _values = new KmList<MyFieldSourceType>();
        _values.addAll(values());

        _codes = new KmMap<String,MyFieldSourceType>();
        for ( MyFieldSourceType e : EnumSet.allOf(MyFieldSourceType.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyFieldSourceType> getValues()
    {
        return _values;
    }

    public static MyFieldSourceType findCode(String code)
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

    private MyFieldSourceType(String code, String name)
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

    public boolean isOutput()
    {
        return this == Output;
    }

    public boolean isPerformance()
    {
        return this == Performance;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyFieldSourceType getAt(int index)
    {
        return values()[index];
    }

    public static MyFieldSourceType getFirst()
    {
        return values()[0];
    }

    public static MyFieldSourceType getLast()
    {
        return values()[values().length - 1];
    }

    public MyFieldSourceType getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyFieldSourceType getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
