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

public enum MyInvitationType
    implements KmCodedEnumIF
{
    //##################################################
    //# values
    //##################################################

    User("U", "User"),
    Transfer("T", "Transfer"),
    Join("J", "Join"),
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

    public boolean isUser()
    {
        return this == User;
    }

    public boolean isTransfer()
    {
        return this == Transfer;
    }

    public boolean isJoin()
    {
        return this == Join;
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
