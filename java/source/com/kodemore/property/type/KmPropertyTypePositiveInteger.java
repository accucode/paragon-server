package com.kodemore.property.type;

public class KmPropertyTypePositiveInteger
    extends KmPropertyAbstractTypeIntegerRange
{
    @Override
    public String getName()
    {
        return "positive integer";
    }

    @Override
    public Integer getMinimum()
    {
        return 1;
    }

    @Override
    public Integer getMaximum()
    {
        return Integer.MAX_VALUE;
    }

}
