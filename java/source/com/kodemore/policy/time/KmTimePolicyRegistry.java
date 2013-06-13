package com.kodemore.policy.time;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.log.KmLog;
import com.kodemore.utility.Kmu;

/**
 * I am used to adapt the usage of time formatting and parsing.
 */
public class KmTimePolicyRegistry
{
    //##################################################
    //# variables
    //##################################################

    public static final KmMap<String,KmTimePolicyIF> _map = new KmMap<String,KmTimePolicyIF>();

    //##################################################
    //# constructor
    //##################################################

    public static KmTimePolicyIF getTimePolicy(String key)
    {
        KmTimePolicyIF p = _map.get(key);
        if ( p == null )
        {
            p = initializeTimePolicy(key);
            _map.put(key, p);
        }
        return p;
    }

    public static KmTimePolicyIF initializeTimePolicy(String key)
    {
        if ( Kmu.isEqual(key, KmTimePolicyHour12.KEY) )
            return new KmTimePolicyHour12();

        if ( Kmu.isEqual(key, KmTimePolicyHour24.KEY) )
            return new KmTimePolicyHour24();

        KmLog.error("Unknown time policy: %s.", key);
        return null;
    }

    public static KmList<String> getTimePolicyKeys()
    {
        return KmList.createStrings(KmTimePolicyHour12.KEY, KmTimePolicyHour24.KEY);
    }
}
