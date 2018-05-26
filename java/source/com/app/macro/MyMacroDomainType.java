package com.app.macro;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.utility.KmEnumIF;
import com.kodemore.utility.Kmu;

/**
 * The domain types supported by macros.
 */
public enum MyMacroDomainType
    implements KmEnumIF
{
    //##################################################
    //# values
    //##################################################

    Attachment,
    Customer,
    Project,
    Site,
    Tenant,
    Global,
    CurrentUser;

    //##################################################
    //# static :: find
    //##################################################

    private static final KmMap<String,MyMacroDomainType> _codes;

    static
    {
        _codes = new KmMap<>();
        for ( MyMacroDomainType e : values() )
            _codes.put(e.getCode(), e);
    }

    public static MyMacroDomainType findCode(String code)
    {
        return _codes.get(code);
    }

    /**
     * Find the types that match the select label.
     */
    public static KmList<MyMacroDomainType> findSharedCode(String s)
    {
        return getValues().select(e -> e.hasSharedCode(s));
    }

    public static KmList<MyMacroDomainType> getValues()
    {
        return KmList.createWith(values());
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * The shared code is usually unique, but multiple domain types
     * may use the same value if you want their lists to be consolidated.
     *
     * The shared code is used to compose the macro key, and the key
     * must still be unique across all domain types.
     */
    private String _sharedCode;

    //##################################################
    //# constructor
    //##################################################

    private MyMacroDomainType()
    {
        _sharedCode = name();
    }

    private MyMacroDomainType(String e)
    {
        _sharedCode = e;
    }

    //##################################################
    //# KmEnumIF
    //##################################################

    @Override
    public String getCode()
    {
        return name();
    }

    @Override
    public String getLabel()
    {
        return Kmu.formatCamelCaseAsCapitalizedWords(getCode());
    }

    //##################################################
    //# shared code
    //##################################################

    public String getSharedCode()
    {
        return _sharedCode;
    }

    public boolean hasSharedCode(String e)
    {
        return _sharedCode.equals(e);
    }
}
