//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model;

import java.util.*;

import com.kodemore.collection.*;
import com.kodemore.utility.*;

public enum MyAttributeFieldCategory
    implements KmCodedEnumIF
{
    //##################################################
    //# values
    //##################################################

    CustomerSite("CS", "Customer Site"),
    Product("P", "Product"),
    SalesOrderLine("SOL", "Sales Order Line"),
    ;

    //##################################################
    //# find
    //##################################################

    private static final KmList<MyAttributeFieldCategory> _values;
    private static final KmMap<String,MyAttributeFieldCategory> _codes;

    static
    {
        _values = new KmList<>();
        _values.addAll(values());

        _codes = new KmMap<>();
        for ( MyAttributeFieldCategory e : EnumSet.allOf(MyAttributeFieldCategory.class) )
            _codes.put(e.getCode(), e);
    }

    public static KmList<MyAttributeFieldCategory> getValues()
    {
        return _values;
    }

    public static MyAttributeFieldCategory findCode(String code)
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

    private MyAttributeFieldCategory(String code, String name)
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

    public boolean isCustomerSite()
    {
        return this == CustomerSite;
    }

    public boolean isProduct()
    {
        return this == Product;
    }

    public boolean isSalesOrderLine()
    {
        return this == SalesOrderLine;
    }

    //##################################################
    //# sequence
    //##################################################

    public static MyAttributeFieldCategory getAt(int index)
    {
        return values()[index];
    }

    public static MyAttributeFieldCategory getFirst()
    {
        return values()[0];
    }

    public static MyAttributeFieldCategory getLast()
    {
        return values()[values().length - 1];
    }

    public MyAttributeFieldCategory getPrevious()
    {
        int i = ordinal() - 1;
        if ( i >= 0 )
            return values()[i];
        return null;
    }

    public MyAttributeFieldCategory getNext()
    {
        int i = ordinal() + 1;
        if ( i < values().length )
            return values()[i];
        return null;
    }
}
