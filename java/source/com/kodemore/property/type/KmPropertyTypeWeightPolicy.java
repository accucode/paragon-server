package com.kodemore.property.type;

import com.kodemore.collection.KmList;
import com.kodemore.policy.weight.KmWeightPolicyRegistry;

public class KmPropertyTypeWeightPolicy
    extends KmPropertyAbstractTypeMatchingString
{
    @Override
    public String getName()
    {
        return "weight policy";
    }

    @Override
    public KmList<String> getOptions()
    {
        return KmWeightPolicyRegistry.getWeightPolicyKeys();
    }
}
