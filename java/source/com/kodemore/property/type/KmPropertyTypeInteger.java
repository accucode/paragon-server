package com.kodemore.property.type;

public class KmPropertyTypeInteger
    extends KmPropertyAbstractTypeIntegerRange
{
    @Override
    public String getName()
    {
        return "integer";
    }

    @Override
    public Integer getMinimum()
    {
        return Integer.MIN_VALUE;
    }

    @Override
    public Integer getMaximum()
    {
        return Integer.MAX_VALUE;
    }

}
