package com.kodemore.property.type;

import com.kodemore.utility.Kmu;

public class KmPropertyTypeRequiredString
    extends KmPropertyAbstractType
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "required string";
    }

    @Override
    public Object validateValue(String key, String value)
    {
        if ( Kmu.isEmpty(value) )
            throw Kmu.newFatal("Property %s: Value cannot not be blank.", key);

        return value;
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
        return "getStringFor";
    }

    @Override
    public String formatJavaType()
    {
        return "String";
    }

}
