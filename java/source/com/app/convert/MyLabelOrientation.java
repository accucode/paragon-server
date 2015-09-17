package com.app.convert;

import java.util.EnumSet;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;

public enum MyLabelOrientation
{
    //##################################################
    //# constants
    //##################################################

    Normal("normal"),
    Rotate90("rotate90"),
    Rotate180("rotate180"),
    Rotate270("rotate270");

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyLabelOrientation> _values;
    private static final KmMap<String,MyLabelOrientation> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyLabelOrientation e : EnumSet.allOf(MyLabelOrientation.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyLabelOrientation> getValues()
    {
        return _values;
    }

    public static MyLabelOrientation findCode(String code)
    {
        return _codes.get(code);
    }

    //##################################################
    //# variables
    //##################################################

    private String _code;

    //##################################################
    //# constructor
    //##################################################

    private MyLabelOrientation(String code)
    {
        _code = code;
    }

    //##################################################
    //# accessing
    //##################################################

    public String getCode()
    {
        return _code;
    }
}
