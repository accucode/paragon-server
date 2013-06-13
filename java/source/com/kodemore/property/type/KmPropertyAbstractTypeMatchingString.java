package com.kodemore.property.type;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

public abstract class KmPropertyAbstractTypeMatchingString
    extends KmPropertyAbstractType
{
    @Override
    public Object validateValue(String key, String value)
    {
        for ( String e : getOptions() )
            if ( Kmu.isEqual(e, value) )
                return value;
        error("Property %s: Value (%s) is not valid: %s.", key, value, getPossibleMatchString());
        return null;
    }

    @Override
    public Object convertValue(String key, String value)
    {
        return validateValue(key, value);
    }

    private String getPossibleMatchString()
    {
        StringBuilder sb = new StringBuilder();
        for ( String e : getOptions() )
        {
            if ( sb.length() > 0 )
                sb.append(", ");
            sb.append(e);
        }
        return sb.toString();
    }

    public abstract KmList<String> getOptions();

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
