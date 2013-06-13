package com.kodemore.policy.weight;

import com.kodemore.types.KmKilogram;

/**
 * I am used to adapt the usage of weight formatting and parsing.
 */
public interface KmWeightPolicyIF
{
    String getKey();

    String getTitle();

    String getUnit();

    String format(KmKilogram kg, int displayScale);

    KmKilogram parse(String s);
}
