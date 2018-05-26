package com.app.model.support;

import java.util.EnumSet;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.utility.KmEnumIF;

public enum MyPrioritySequence
    implements KmEnumIF
{
    //##################################################
    //# values
    //##################################################

    High1("a1", "High-1"),
    High2("a2", "High-2"),
    High3("a3", "High-3"),
    Normal1("b1", "Normal-1"),
    Normal2("b2", "Normal-2"),
    Normal3("b3", "Normal-3"),
    Low1("c1", "Low-1"),
    Low2("c2", "Low-2"),
    Low3("c3", "Low-3");

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyPrioritySequence>       _values;
    private static final KmMap<String,MyPrioritySequence> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyPrioritySequence e : EnumSet.allOf(MyPrioritySequence.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyPrioritySequence> getValues()
    {
        return _values;
    }

    public static MyPrioritySequence findCode(String code)
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

    private MyPrioritySequence(String code, String label)
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

    public static MyPrioritySequence getAt(int index)
    {
        return values()[index];
    }

    public static MyPrioritySequence getFirst()
    {
        return values()[0];
    }

    public static MyPrioritySequence getLast()
    {
        return values()[values().length - 1];
    }

    public MyPrioritySequence getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyPrioritySequence getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
