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

public enum MyEmailTemplateContextType
    implements MyEmailTemplateContextTypeIF
{
    //##################################################
    //# values
    //##################################################

    Project("Project", "Project"),
    Site("Site", "Site"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyEmailTemplateContextType> _values;
    private static final KmMap<String,MyEmailTemplateContextType> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyEmailTemplateContextType e : EnumSet.allOf(MyEmailTemplateContextType.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyEmailTemplateContextType> getValues()
    {
        return _values;
    }

    public static MyEmailTemplateContextType findCode(String code)
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

    private MyEmailTemplateContextType(String code, String label)
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

    public boolean isSite()
    {
        return this == Site;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyEmailTemplateContextType getAt(int index)
    {
        return values()[index];
    }

    public static MyEmailTemplateContextType getFirst()
    {
        return values()[0];
    }

    public static MyEmailTemplateContextType getLast()
    {
        return values()[values().length - 1];
    }

    public MyEmailTemplateContextType getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyEmailTemplateContextType getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
