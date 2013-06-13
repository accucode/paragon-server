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

public enum MyImportDataStatus
    implements KmCodedEnumIF
{
    //##################################################
    //# values
    //##################################################

    New("N", "New"),
    Error("E", "Error"),
    Complete("C", "Complete"), ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyImportDataStatus>       _values;
    private static final KmMap<String,MyImportDataStatus> _codes;

    static
    {
        _values = new KmList<MyImportDataStatus>();
        _values.addAll(values());

        _codes = new KmMap<String,MyImportDataStatus>();
        for ( MyImportDataStatus e : EnumSet.allOf(MyImportDataStatus.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyImportDataStatus> getValues()
    {
        return _values;
    }

    public static MyImportDataStatus findCode(String code)
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

    private MyImportDataStatus(String code, String name)
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

    public boolean isNew()
    {
        return this == New;
    }

    public boolean isError()
    {
        return this == Error;
    }

    public boolean isComplete()
    {
        return this == Complete;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyImportDataStatus getAt(int index)
    {
        return values()[index];
    }

    public static MyImportDataStatus getFirst()
    {
        return values()[0];
    }

    public static MyImportDataStatus getLast()
    {
        return values()[values().length - 1];
    }

    public MyImportDataStatus getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyImportDataStatus getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
