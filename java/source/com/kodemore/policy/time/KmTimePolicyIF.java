package com.kodemore.policy.time;

import com.kodemore.time.KmTime;

/**
 * I am used to adapt the usage of time formatting and parsing.
 */
public interface KmTimePolicyIF
{
    String getKey();

    String getTitle();

    String getExample();

    String format(KmTime t);

    KmTime parse(String s);
}
