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

public enum MyFeedbackStatus
    implements MyFeedbackStatusIF
{
    //##################################################
    //# values
    //##################################################

    Pending("Pending", "Pending"),
    Resolved("Resolved", "Resolved"),
    Dropped("Dropped", "Dropped"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyFeedbackStatus> _values;
    private static final KmMap<String,MyFeedbackStatus> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyFeedbackStatus e : EnumSet.allOf(MyFeedbackStatus.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyFeedbackStatus> getValues()
    {
        return _values;
    }

    public static MyFeedbackStatus findCode(String code)
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

    private MyFeedbackStatus(String code, String label)
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

    public boolean isPending()
    {
        return this == Pending;
    }

    public boolean isResolved()
    {
        return this == Resolved;
    }

    public boolean isDropped()
    {
        return this == Dropped;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyFeedbackStatus getAt(int index)
    {
        return values()[index];
    }

    public static MyFeedbackStatus getFirst()
    {
        return values()[0];
    }

    public static MyFeedbackStatus getLast()
    {
        return values()[values().length - 1];
    }

    public MyFeedbackStatus getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyFeedbackStatus getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
