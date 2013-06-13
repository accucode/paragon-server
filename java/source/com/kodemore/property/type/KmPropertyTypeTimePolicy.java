package com.kodemore.property.type;

import com.kodemore.collection.KmList;
import com.kodemore.policy.time.KmTimePolicyRegistry;

public class KmPropertyTypeTimePolicy
    extends KmPropertyAbstractTypeMatchingString
{
    @Override
    public String getName()
    {
        return "time policy";
    }

    @Override
    public KmList<String> getOptions()
    {
        return KmTimePolicyRegistry.getTimePolicyKeys();
    }
}
