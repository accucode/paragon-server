package com.app.model.support;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.utility.KmEnumIF;

/**
 * The list of standard radio types.
 */
public enum MyRadioType
    implements KmEnumIF
{
    //##################################################
    //# values
    //##################################################

    Type_2_4GHz("2.4GHz"),
    Type_5GHz("5GHz"),
    Type_Both("Both"),
    Type_None("None");

    //##################################################
    //# static :: find
    //##################################################

    private static final KmMap<String,MyRadioType> _codes;

    static
    {
        _codes = new KmMap<>();
        for ( MyRadioType e : values() )
            _codes.put(e.getCode(), e);
    }

    public static MyRadioType findCode(String code)
    {
        return _codes.get(code);
    }

    public static KmList<MyRadioType> getValues()
    {
        return KmList.createWith(values());
    }

    //##################################################
    //# variables
    //##################################################

    private String _code;

    //##################################################
    //# constructor
    //##################################################

    private MyRadioType(String code)
    {
        _code = code;
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
        switch ( this )
        {
            case Type_None:
                return "None";

            case Type_2_4GHz:
                return "2.4GHz";

            case Type_5GHz:
                return "5GHz";

            case Type_Both:
                return "5GHz/2.4GHz";
        }

        return name();
    }
}
