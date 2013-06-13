package com.kodemore.property.type;

public class KmPropertyTypeTimeZoneOffsetMinutes
    extends KmPropertyAbstractTypeIntegerRange
{
    @Override
    public String getName()
    {
        return "time zone offset minutes";
    }

    @Override
    public Integer getMinimum()
    {
        return -1440;
    }

    @Override
    public Integer getMaximum()
    {
        return 1440;
    }

}
