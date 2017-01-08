package com.app.model.support;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.utility.KmEnumIF;

/**
 * I define the supported IP Address types; e.g.: None, Dhcp, Static.
 * These types are shared across multiple domain models; e.g.: Product, Device, Order Line.
 */
public enum MyIpAddressType
                implements KmEnumIF
{
    //##################################################
    //# values
    //##################################################

    // !!! NOTE !!!
    // !!! The codes used in the database.
    // !!! Changing them requires a database migration.
    // !!! see types.stf, longEnumCode, max length = 30.
    None("None"),
    Dhcp("Dhcp"),
    Static("Static");

    //##################################################
    //# static
    //##################################################

    private static final KmMap<String,MyIpAddressType> _codes;

    static
    {
        _codes = new KmMap<>();
        for ( MyIpAddressType e : values() )
            _codes.put(e.getCode(), e);
    }

    public static MyIpAddressType findCode(String code)
    {
        return _codes.get(code);
    }

    public static KmList<MyIpAddressType> getValues()
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

    private MyIpAddressType(String code)
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

    //##################################################
    //# testing
    //##################################################

    public boolean usesIpAddress()
    {
        switch ( this )
        {
            case None:
            case Dhcp:
                return false;

            case Static:
                return true;
        }

        return false;
    }

    public boolean usesMacAddress()
    {
        switch ( this )
        {
            case None:
                return false;

            case Dhcp:
            case Static:
                return true;
        }

        return false;
    }
}
