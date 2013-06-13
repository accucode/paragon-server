package com.kodemore.policy.date;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.log.KmLog;
import com.kodemore.utility.Kmu;

/**
 * I am used to adapt the usage of date formatting and parsing.
 */
public class KmDatePolicyRegistry
{
    //##################################################
    //# variables
    //##################################################

    public static final KmMap<String,KmDatePolicyIF> _map = new KmMap<String,KmDatePolicyIF>();

    //##################################################
    //# constructor
    //##################################################

    public static KmDatePolicyIF getDatePolicy(String key)
    {
        KmDatePolicyIF p = _map.get(key);
        if ( p == null )
        {
            p = initializeDatePolicy(key);
            _map.put(key, p);
        }
        return p;
    }

    public static KmDatePolicyIF initializeDatePolicy(String key)
    {
        if ( Kmu.isEqual(key, KmDatePolicyEu.KEY) )
            return new KmDatePolicyEu();

        if ( Kmu.isEqual(key, KmDatePolicyIso.KEY) )
            return new KmDatePolicyIso();

        if ( Kmu.isEqual(key, KmDatePolicyUs.KEY) )
            return new KmDatePolicyUs();

        KmLog.error("Unknown date policy: %s.", key);
        return null;
    }

    public static KmList<String> getDatePolicyKeys()
    {
        return KmList.createStrings(KmDatePolicyEu.KEY, KmDatePolicyIso.KEY, KmDatePolicyUs.KEY);
    }
}
