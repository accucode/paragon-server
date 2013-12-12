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

public enum MyInvitationStatus
    implements KmCodedEnumIF
{
    //##################################################
    //# values
    //##################################################

    New("N", "New"),
    Accepted("A", "Accepted"),
    Rejected("R", "Rejected"),
    Cancelled("X", "Cancelled"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyInvitationStatus> _values;
    private static final KmMap<String,MyInvitationStatus> _codes;

    static
    {
        _values = new KmList<MyInvitationStatus>();
        _values.addAll(values());

        _codes = new KmMap<String,MyInvitationStatus>();
        for ( MyInvitationStatus e : EnumSet.allOf(MyInvitationStatus.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyInvitationStatus> getValues()
    {
        return _values;
    }

    public static MyInvitationStatus findCode(String code)
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

    private MyInvitationStatus(String code, String name)
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

    public static MyInvitationStatus getAt(int index)
    {
        return values()[index];
    }

    public static MyInvitationStatus getFirst()
    {
        return values()[0];
    }

    public static MyInvitationStatus getLast()
    {
        return values()[values().length - 1];
    }

    public MyInvitationStatus getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyInvitationStatus getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
