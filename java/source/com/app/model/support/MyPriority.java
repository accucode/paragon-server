package com.app.model.support;

import java.util.EnumSet;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.utility.KmEnumIF;

public enum MyPriority
                implements KmEnumIF
{
    //##################################################
    //# values
    //##################################################

    // NOTE 1: changing the codes requires a database migration.
    // NOTE 2: the codes should be in alphabetical order, from highest to lowest.
    High("1-High", "High"),
    Normal("2-Normal", "Normal"),
    Low("3-Low", "Low");

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyPriority>       _values;
    private static final KmMap<String,MyPriority> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyPriority e : EnumSet.allOf(MyPriority.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyPriority> getValues()
    {
        return _values;
    }

    public static MyPriority findCode(String code)
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

    private MyPriority(String code, String label)
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
    //# sequence
    //##################################################

    public static MyPriority getAt(int index)
    {
        return values()[index];
    }

    public static MyPriority getFirst()
    {
        return values()[0];
    }

    public static MyPriority getLast()
    {
        return values()[values().length - 1];
    }

    public MyPriority getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyPriority getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
