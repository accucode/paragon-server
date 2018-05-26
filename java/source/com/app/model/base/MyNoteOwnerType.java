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

public enum MyNoteOwnerType
    implements MyNoteOwnerTypeIF
{
    //##################################################
    //# values
    //##################################################

    Project("Project", "Project"),
    Customer("Customer", "Customer"),
    Site("Site", "Site"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyNoteOwnerType> _values;
    private static final KmMap<String,MyNoteOwnerType> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyNoteOwnerType e : EnumSet.allOf(MyNoteOwnerType.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyNoteOwnerType> getValues()
    {
        return _values;
    }

    public static MyNoteOwnerType findCode(String code)
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

    private MyNoteOwnerType(String code, String label)
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

    public boolean isProject()
    {
        return this == Project;
    }

    public boolean isCustomer()
    {
        return this == Customer;
    }

    public boolean isSite()
    {
        return this == Site;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyNoteOwnerType getAt(int index)
    {
        return values()[index];
    }

    public static MyNoteOwnerType getFirst()
    {
        return values()[0];
    }

    public static MyNoteOwnerType getLast()
    {
        return values()[values().length - 1];
    }

    public MyNoteOwnerType getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyNoteOwnerType getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
