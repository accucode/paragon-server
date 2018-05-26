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

public enum MyEmailPartType
    implements MyEmailPartTypeIF
{
    //##################################################
    //# values
    //##################################################

    Text("Text", "Text"),
    Html("Html", "Html"),
    Attachment("Attachment", "Attachment"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyEmailPartType> _values;
    private static final KmMap<String,MyEmailPartType> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
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
    private String _label;

    //##################################################
    //# constructor
    //##################################################

    private MyEmailPartType(String code, String label)
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
