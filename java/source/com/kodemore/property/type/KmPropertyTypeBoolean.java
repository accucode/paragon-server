package com.kodemore.property.type;

import com.kodemore.utility.Kmu;

public class KmPropertyTypeBoolean
    extends KmPropertyAbstractType
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "boolean";
    }

    @Override
    public Object validateValue(String key, String value)
    {
        if ( Kmu.isEmpty(value) )
            return false;

        Boolean e = Kmu.parseBoolean(value);
        if ( e == null )
            throw Kmu.newFatal("Property %s: Value (%s) is not a boolean.", key, value);

        return e;
    }

    @Override
    public Object convertValue(String key, String value)
    {
        return validateValue(key, value);
    }

    //##################################################
    //# code generation
    //##################################################

    @Override
    public String formatGetValueFor()
    {
        return "getBooleanFor";
    }

    @Override
    public String formatJavaType()
    {
        return "Boolean";
    }

}
