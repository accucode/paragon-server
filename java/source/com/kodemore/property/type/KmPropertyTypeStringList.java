package com.kodemore.property.type;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

public class KmPropertyTypeStringList
    extends KmPropertyAbstractType
{
    @Override
    public String getName()
    {
        return "string list";
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
        // tokenizing an empty string will result in a list with
        // one element which is an empty string. So check if value
        // is empty first and return an empty list.
        if ( Kmu.isEmpty(value) )
            return new KmList<String>();
        return Kmu.tokenize(value, ',');
    }

    //##################################################
    //# code generation
    //##################################################

    @Override
    public String formatGetValueFor()
    {
        return "getStringListFor";
    }

    @Override
    public String formatJavaType()
    {
        return "KmList<String>";
    }

}
