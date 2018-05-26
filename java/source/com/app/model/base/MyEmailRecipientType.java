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

public enum MyEmailRecipientType
    implements MyEmailRecipientTypeIF
{
    //##################################################
    //# values
    //##################################################

    To("To", "To"),
    Cc("Cc", "Cc"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyEmailRecipientType> _values;
    private static final KmMap<String,MyEmailRecipientType> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyEmailRecipientType e : EnumSet.allOf(MyEmailRecipientType.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyEmailRecipientType> getValues()
    {
        return _values;
    }

    public static MyEmailRecipientType findCode(String code)
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

    private MyEmailRecipientType(String code, String label)
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

    public boolean isTo()
    {
        return this == To;
    }

    public boolean isCc()
    {
        return this == Cc;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyEmailRecipientType getAt(int index)
    {
        return values()[index];
    }

    public static MyEmailRecipientType getFirst()
    {
        return values()[0];
    }

    public static MyEmailRecipientType getLast()
    {
        return values()[values().length - 1];
    }

    public MyEmailRecipientType getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyEmailRecipientType getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
