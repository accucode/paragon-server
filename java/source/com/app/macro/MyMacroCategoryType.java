package com.app.macro;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.utility.KmEnumIF;
import com.kodemore.utility.Kmu;

/**
 * The category types supported by macros.
 */
public enum MyMacroCategoryType
    implements KmEnumIF
{
    //##################################################
    //# values
    //##################################################

    Current,
    Global;

    //##################################################
    //# static :: find
    //##################################################

    private static final KmMap<String,MyMacroCategoryType> _codes;

    static
    {
        _codes = new KmMap<>();
        for ( MyMacroCategoryType e : values() )
            _codes.put(e.getCode(), e);
    }

    public static MyMacroCategoryType findCode(String code)
    {
        return _codes.get(code);
    }

    public static KmList<MyMacroCategoryType> getValues()
    {
        return KmList.createWith(values());
    }

    //##################################################
    //# constructor
    //##################################################

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getCode()
    {
        return name();
    }

    @Override
    public String getLabel()
    {
        return Kmu.formatCamelCaseAsCapitalizedWords(name());
    }
}
