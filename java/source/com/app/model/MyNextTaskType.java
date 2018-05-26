package com.app.model;

import java.util.EnumSet;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.utility.KmEnumIF;

public enum MyNextTaskType
    implements KmEnumIF
{
    //##################################################
    //# values
    //##################################################

    Task("Task", "Task"),
    Issue("Issue", "Issue"),;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyNextTaskType>       _values;
    private static final KmMap<String,MyNextTaskType> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyNextTaskType e : EnumSet.allOf(MyNextTaskType.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyNextTaskType> getValues()
    {
        return _values;
    }

    public static MyNextTaskType findCode(String code)
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

    private MyNextTaskType(String code, String label)
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

    public boolean isTask()
    {
        return this == Task;
    }

    public boolean isIssue()
    {
        return this == Issue;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyNextTaskType getAt(int index)
    {
        return values()[index];
    }

    public static MyNextTaskType getFirst()
    {
        return values()[0];
    }

    public static MyNextTaskType getLast()
    {
        return values()[values().length - 1];
    }

    public MyNextTaskType getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyNextTaskType getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
