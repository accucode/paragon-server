package com.kodemore.policy.weight;

import com.kodemore.types.KmDecimal;
import com.kodemore.types.KmKilogram;
import com.kodemore.utility.Kmu;

/**
 * I am used to adapt the usage of weight formatting and parsing.
 */
public class KmWeightPolicyLb
    implements KmWeightPolicyIF
{
    //##################################################
    //# constants
    //##################################################

    public static final String KEY = "lb";

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
        return "Pounds";
    }

    @Override
    public String getUnit()
    {
        return "lb";
    }

    @Override
    public String format(KmKilogram kg, int displayScale)
    {
        double d = kg.getDoubleValue();
        d = Kmu.kilogramsToPounds(d);
        KmDecimal dec = new KmDecimal(d, displayScale);
        return Kmu.format("%s %s", dec.format(displayScale, true), getUnit());
    }

    @Override
    public KmKilogram parse(String s)
    {
        s = Kmu.removeSuffix(s, getUnit());
        s = s.trim();
        double d = Kmu.parse_double(s);
        if ( Double.isNaN(d) )
            return null;
        d = Kmu.poundsToKilograms(d);
        return new KmKilogram(d);
    }

    //##################################################
    //# test
    //##################################################

    public static void main(String args[])
    {
        KmWeightPolicyLb p = new KmWeightPolicyLb();

        System.out.println("parse: ");
        System.out.println("  10:   " + p.format(p.parse("10"), 3));
        System.out.println("  2832.33: " + p.format(p.parse("2832.33"), 3));
        System.out.println("  123.546789:      " + p.format(p.parse("123.546789"), 3));
    }

}
