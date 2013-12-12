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

public enum MyEmailPartType
    implements KmCodedEnumIF
{
    //##################################################
    //# values
    //##################################################

    Text("T", "Text"),
    Html("H", "Html"),
    Attachment("A", "Attachment"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyEmailPartType> _values;
    private static final KmMap<String,MyEmailPartType> _codes;

    static
    {
        _values = new KmList<MyEmailPartType>();
        _values.addAll(values());

        _codes = new KmMap<String,MyEmailPartType>();
        for ( MyEmailPartType e : EnumSet.allOf(MyEmailPartType.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyEmailPartType> getValues()
    {
        return _values;
    }

    public static MyEmailPartType findCode(String code)
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

    private MyEmailPartType(String code, String name)
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

    public boolean isText()
    {
        return this == Text;
    }

    public boolean isHtml()
    {
        return this == Html;
    }

    public boolean isAttachment()
    {
        return this == Attachment;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyEmailPartType getAt(int index)
    {
        return values()[index];
    }

    public static MyEmailPartType getFirst()
    {
        return values()[0];
    }

    public static MyEmailPartType getLast()
    {
        return values()[values().length - 1];
    }

    public MyEmailPartType getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyEmailPartType getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
