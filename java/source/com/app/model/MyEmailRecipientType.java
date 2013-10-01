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

public enum MyEmailRecipientType
    implements KmCodedEnumIF
{
    //##################################################
    //# values
    //##################################################

    To("T", "To"),
    Cc("C", "Cc"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyEmailRecipientType> _values;
    private static final KmMap<String,MyEmailRecipientType> _codes;

    static
    {
        _values = new KmList<MyEmailRecipientType>();
        _values.addAll(values());

        _codes = new KmMap<String,MyEmailRecipientType>();
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
    private String _name;

    //##################################################
    //# constructor
    //##################################################

    private MyEmailRecipientType(String code, String name)
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
