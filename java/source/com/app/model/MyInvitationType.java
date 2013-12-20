//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model;

import java.util.*;

import com.kodemore.collection.*;
import com.kodemore.utility.*;

public enum MyInvitationType
    implements KmCodedEnumIF
{
    //##################################################
    //# values
    //##################################################

    TransferAccount("T", "Transfer Account"),
    JoinAccount("J", "Join Account"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyInvitationType> _values;
    private static final KmMap<String,MyInvitationType> _codes;

    static
    {
        _values = new KmList<MyInvitationType>();
        _values.addAll(values());

        _codes = new KmMap<String,MyInvitationType>();
        for ( MyInvitationType e : EnumSet.allOf(MyInvitationType.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyInvitationType> getValues()
    {
        return _values;
    }

    public static MyInvitationType findCode(String code)
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

    private MyInvitationType(String code, String name)
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

    public boolean isTransferAccount()
    {
        return this == TransferAccount;
    }

    public boolean isJoinAccount()
    {
        return this == JoinAccount;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyInvitationType getAt(int index)
    {
        return values()[index];
    }

    public static MyInvitationType getFirst()
    {
        return values()[0];
    }

    public static MyInvitationType getLast()
    {
        return values()[values().length - 1];
    }

    public MyInvitationType getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyInvitationType getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
