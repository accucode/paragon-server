package com.kodemore.property.type;

public class KmPropertyTypeString
    extends KmPropertyAbstractType
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "string";
    }

    @Override
    public Object validateValue(String key, String value)
    {
        // all properties can be strings
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
