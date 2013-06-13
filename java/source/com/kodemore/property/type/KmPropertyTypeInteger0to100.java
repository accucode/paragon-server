package com.kodemore.property.type;

public class KmPropertyTypeInteger0to100
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
        return 100;
    }

}
