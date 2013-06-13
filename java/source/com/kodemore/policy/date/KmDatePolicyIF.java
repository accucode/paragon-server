package com.kodemore.policy.date;

import com.kodemore.time.KmDate;

/**
 * I am used to adapt the usage of date formatting and parsing.
 */
public interface KmDatePolicyIF
{
    String getKey();

    String getTitle();

    String getExample();

    String format(KmDate d);

    KmDate parse(String s);
}
