package com.kodemore.policy.weight;

import com.kodemore.types.KmKilogram;
import com.kodemore.utility.Kmu;

/**
 * I am used to adapt the usage of weight formatting and parsing.
 */
public class KmWeightPolicyKg
    implements KmWeightPolicyIF
{
    //##################################################
    //# constants
    //##################################################

    public static final String KEY = "kg";

    //##################################################
    //# public
    //##################################################

    @Override
    public String getKey()
    {
        return KEY;
    }

    @Override
    public String getTitle()
    {
        return "Kilogram";
    }

    @Override
    public String getUnit()
    {
        return "kg";
    }

    @Override
    public String format(KmKilogram kg, int displayScale)
    {
        return Kmu.format("%s %s", kg.getDisplayString(displayScale, true), getUnit());
    }

    @Override
    public KmKilogram parse(String s)
    {
        s = Kmu.removeSuffix(s, getUnit());
        s = s.trim();
        return Kmu.parseKilogram(s);
    }

    //##################################################
    //# test
    //##################################################

    public static void main(String args[])
    {
        KmWeightPolicyKg p = new KmWeightPolicyKg();

        System.out.println("parse: ");
        System.out.println("  10:   " + p.parse("10").getDisplayString(3));

        System.out.println("  2832.33: " + p.parse("2832.33").getDisplayString(3));

        System.out.println("  123.546789:      " + p.parse("123.546789").getDisplayString(3));
    }

}
