package com.kodemore.property.type;

import com.kodemore.collection.KmList;
import com.kodemore.policy.date.KmDatePolicyRegistry;

public class KmPropertyTypeDatePolicy
    extends KmPropertyAbstractTypeMatchingString
{
    @Override
    public String getName()
    {
        return "date policy";
    }

    @Override
    public KmList<String> getOptions()
    {
        return KmDatePolicyRegistry.getDatePolicyKeys();
    }
}
