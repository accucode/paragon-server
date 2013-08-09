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

public enum MyInvitationRole
    implements KmCodedEnumIF
{
    //##################################################
    //# values
    //##################################################

    Owner("O", "Owner"),
    Manager("M", "Manager"),
    User("U", "User"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyInvitationRole> _values;
    private static final KmMap<String,MyInvitationRole> _codes;

    static
    {
        _values = new KmList<MyInvitationRole>();
        _values.addAll(values());

        _codes = new KmMap<String,MyInvitationRole>();
        for ( MyInvitationRole e : EnumSet.allOf(MyInvitationRole.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyInvitationRole> getValues()
    {
        return _values;
    }

    public static MyInvitationRole findCode(String code)
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

    private MyInvitationRole(String code, String name)
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

    public boolean isOwner()
    {
        return this == Owner;
    }

    public boolean isManager()
    {
        return this == Manager;
    }

    public boolean isUser()
    {
        return this == User;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyInvitationRole getAt(int index)
    {
        return values()[index];
    }

    public static MyInvitationRole getFirst()
    {
        return values()[0];
    }

    public static MyInvitationRole getLast()
    {
        return values()[values().length - 1];
    }

    public MyInvitationRole getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyInvitationRole getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
