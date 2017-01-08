package com.app.ui.dashboard.core;

import java.util.EnumSet;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.exception.KmEnumException;
import com.kodemore.utility.KmEnumIF;
import com.kodemore.utility.Kmu;

import com.app.ui.dashboard.MyEmptyPanel;
import com.app.ui.dashboard.MyWelcomePanel;

public enum MyDashboardPanelType
                implements KmEnumIF
{
    //##################################################
    //# values
    //##################################################

    Welcome("Welcome", "Welcome"),
    Empty("Empty", "Empty");

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyDashboardPanelType>       _values;
    private static final KmMap<String,MyDashboardPanelType> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyDashboardPanelType e : EnumSet.allOf(MyDashboardPanelType.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyDashboardPanelType> getValues()
    {
        return _values;
    }

    public static MyDashboardPanelType findCode(String code)
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

    private MyDashboardPanelType(String code, String label)
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
    //# panels
    //##################################################

    public MyDashboardPanel createPanel()
    {
        switch ( this )
        {
            case Welcome:
                return new MyWelcomePanel();

            case Empty:
                return new MyEmptyPanel();
        }

        throw new KmEnumException(this);
    }

    public boolean isPublic()
    {
        switch ( this )
        {
            case Empty:
                return false;

            case Welcome:
                return true;
        }
        throw Kmu.newEnumError(this);
    }
}
