package com.kodemore.property.type;

public class KmPropertyTypeInteger0to1000
    extends KmPropertyAbstractTypeIntegerRange
{
    @Override
    public Integer getMinimum()
    {
        return 0;
    }

    @Override
    public Integer getMaximum()
    {
        return 1000;
    }

}
