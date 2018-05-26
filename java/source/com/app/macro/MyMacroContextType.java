package com.app.macro;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.utility.KmEnumIF;
import com.kodemore.utility.Kmu;

import com.app.model.support.MyDomainCodes;

/**
 * The list of domain types supported by macros.
 */
public enum MyMacroContextType
    implements KmEnumIF
{
    //##################################################
    //# values
    //##################################################

    Attachment(MyDomainCodes.ATTACHMENT),
    Project(MyDomainCodes.PROJECT),
    Site(MyDomainCodes.SITE),
    Tenant(MyDomainCodes.TENANT);

    //##################################################
    //# static :: find
    //##################################################

    private static final KmMap<String,MyMacroContextType> _codes;

    static
    {
        _codes = new KmMap<>();
        for ( MyMacroContextType e : values() )
            _codes.put(e.getCode(), e);
    }

    public static MyMacroContextType findCode(String code)
    {
        return _codes.get(code);
    }

    public static KmList<MyMacroContextType> getValues()
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

    private MyMacroContextType(String code)
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
        return Kmu.formatCamelCaseAsCapitalizedWords(name());
    }

    //##################################################
    //# convenience
    //##################################################

    public MyMacroDomainType getDefaultDomainType()
    {
        switch ( this )
        {
            case Attachment:
                return MyMacroDomainType.Attachment;

            case Project:
                return MyMacroDomainType.Project;

            case Site:
                return MyMacroDomainType.Site;

            case Tenant:
                return MyMacroDomainType.Tenant;
        }
        throw Kmu.newEnumError(this);
    }

}
