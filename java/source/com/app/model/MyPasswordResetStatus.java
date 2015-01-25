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

public enum MyPasswordResetStatus
    implements KmCodedEnumIF
{
    //##################################################
    //# values
    //##################################################

    New("N", "New"),
    Accepted("A", "Accepted"),
    Rejected("R", "Rejected"),
    Cancelled("X", "Cancelled"), ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyPasswordResetStatus>       _values;
    private static final KmMap<String,MyPasswordResetStatus> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyPasswordResetStatus e : EnumSet.allOf(MyPasswordResetStatus.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyPasswordResetStatus> getValues()
    {
        return _values;
    }

    public static MyPasswordResetStatus findCode(String code)
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

    private MyPasswordResetStatus(String code, String name)
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

    public boolean isNew()
    {
        return this == New;
    }

    public boolean isAccepted()
    {
        return this == Accepted;
    }

    public boolean isRejected()
    {
        return this == Rejected;
    }

    public boolean isCancelled()
    {
        return this == Cancelled;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyPasswordResetStatus getAt(int index)
    {
        return values()[index];
    }

    public static MyPasswordResetStatus getFirst()
    {
        return values()[0];
    }

    public static MyPasswordResetStatus getLast()
    {
        return values()[values().length - 1];
    }

    public MyPasswordResetStatus getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyPasswordResetStatus getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
