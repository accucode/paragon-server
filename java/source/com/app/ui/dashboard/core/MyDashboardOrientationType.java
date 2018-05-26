package com.app.ui.dashboard.core;

import java.util.EnumSet;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.utility.KmEnumIF;

public enum MyDashboardOrientationType
    implements KmEnumIF
{
    //##################################################
    //# values
    //##################################################

    Landsapce("Landscape", "Landscape"),
    Portrait("Portrait", "Portrait"),
    Auto("Auto", "Auto");

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyDashboardOrientationType>       _values;
    private static final KmMap<String,MyDashboardOrientationType> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyDashboardOrientationType e : EnumSet.allOf(MyDashboardOrientationType.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyDashboardOrientationType> getValues()
    {
        return _values;
    }

    public static MyDashboardOrientationType findCode(String code)
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

    private MyDashboardOrientationType(String code, String label)
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

}
