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

public enum MyInvitationStatus
    implements KmEnumIF
{
    //##################################################
    //# values
    //##################################################

    Pending("Pending", "Pending"),
    Accepted("Accepted", "Accepted"),
    Rejected("Rejected", "Rejected"),
    Expired("Expired", "Expired"),
    Cancelled("Cancelled", "Cancelled"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyInvitationStatus> _values;
    private static final KmMap<String,MyInvitationStatus> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
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
    private String _label;

    //##################################################
    //# constructor
    //##################################################

    private MyInvitationStatus(String code, String label)
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

    public boolean isAccepted()
    {
        return this == Accepted;
    }

    public boolean isRejected()
    {
        return this == Rejected;
    }

    public boolean isExpired()
    {
        return this == Expired;
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
