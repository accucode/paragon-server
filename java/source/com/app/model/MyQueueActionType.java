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

public enum MyQueueActionType
    implements KmCodedEnumIF
{
    //##################################################
    //# values
    //##################################################

    ClearErrors("CE", "Clear Errors"), ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyQueueActionType>       _values;
    private static final KmMap<String,MyQueueActionType> _codes;

    static
    {
        _values = new KmList<MyQueueActionType>();
        _values.addAll(values());

        _codes = new KmMap<String,MyQueueActionType>();
        for ( MyQueueActionType e : EnumSet.allOf(MyQueueActionType.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyQueueActionType> getValues()
    {
        return _values;
    }

    public static MyQueueActionType findCode(String code)
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

    private MyQueueActionType(String code, String name)
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

    public boolean isClearErrors()
    {
        return this == ClearErrors;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyQueueActionType getAt(int index)
    {
        return values()[index];
    }

    public static MyQueueActionType getFirst()
    {
        return values()[0];
    }

    public static MyQueueActionType getLast()
    {
        return values()[values().length - 1];
    }

    public MyQueueActionType getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyQueueActionType getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
