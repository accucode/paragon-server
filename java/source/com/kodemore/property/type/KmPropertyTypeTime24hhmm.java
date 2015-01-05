package com.kodemore.property.type;

import com.kodemore.time.KmTimeUtility;
import com.kodemore.utility.Kmu;

public class KmPropertyTypeTime24hhmm
    extends KmPropertyAbstractType
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "time 24hhmm";
    }

    @Override
    public Object validateValue(String key, String value)
    {
        try
        {
            return KmTimeUtility.parse_24HHMM(value);
        }
        catch ( NumberFormatException ex )
        {
            throw Kmu.newFatal("Property %s: Value (%s) is not a Time (24HH:MM).", key, value);
        }
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
        return "getTimeFor";
    }

    @Override
    public String formatJavaType()
    {
        return "KmTime";
    }
}
