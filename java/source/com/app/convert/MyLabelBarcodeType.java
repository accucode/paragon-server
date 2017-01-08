package com.app.convert;

import java.util.EnumSet;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;

public enum MyLabelBarcodeType
{
    //##################################################
    //# constants
    //##################################################

    UPC_A("upc a"),
    Standard_2_of_5("standard 2 of 5"),
    Code_39("code 39");

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyLabelBarcodeType>       _values;
    private static final KmMap<String,MyLabelBarcodeType> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyLabelBarcodeType e : EnumSet.allOf(MyLabelBarcodeType.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyLabelBarcodeType> getValues()
    {
        return _values;
    }

    public static MyLabelBarcodeType findCode(String code)
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

    private MyLabelBarcodeType(String code)
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
