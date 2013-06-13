package com.kodemore.property.type;

public class KmPropertyTypeInteger1to100
    extends KmPropertyAbstractTypeIntegerRange
{
    @Override
    public Integer getMinimum()
    {
        return 1;
    }

    @Override
    public Integer getMaximum()
    {
        return 100;
    }

}
