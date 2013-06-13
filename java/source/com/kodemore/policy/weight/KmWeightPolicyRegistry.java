package com.kodemore.policy.weight;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.log.KmLog;
import com.kodemore.utility.Kmu;

/**
 * I am used to adapt the usage of weight formatting and parsing.
 */
public class KmWeightPolicyRegistry
{
    //##################################################
    //# variables
    //##################################################

    public static final KmMap<String,KmWeightPolicyIF> _map = new KmMap<String,KmWeightPolicyIF>();

    //##################################################
    //# constructor
    //##################################################

    public static KmWeightPolicyIF getWeightPolicy(String key)
    {
        KmWeightPolicyIF p = _map.get(key);
        if ( p == null )
        {
            p = initializeWeightPolicy(key);
            _map.put(key, p);
        }
        return p;
    }

    public static KmWeightPolicyIF initializeWeightPolicy(String key)
    {
        if ( Kmu.isEqual(key, KmWeightPolicyKg.KEY) )
            return new KmWeightPolicyKg();

        if ( Kmu.isEqual(key, KmWeightPolicyLb.KEY) )
            return new KmWeightPolicyLb();

        KmLog.error("Unknown weight policy: %s.", key);
        return null;
    }

    public static KmList<String> getWeightPolicyKeys()
    {
        return KmList.createStrings(KmWeightPolicyKg.KEY, KmWeightPolicyLb.KEY);
    }
}
