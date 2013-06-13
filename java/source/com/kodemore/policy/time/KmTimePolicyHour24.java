package com.kodemore.policy.time;

import com.kodemore.time.KmTime;
import com.kodemore.time.KmTimeFormatter;
import com.kodemore.time.KmTimeFormatterIF;
import com.kodemore.time.KmTimeParser;

/**
 * I am used to adapt the usage of date formatting and parsing.
 */
public class KmTimePolicyHour24
    implements KmTimePolicyIF
{
    //##################################################
    //# constants
    //##################################################

    public static final String KEY    = "hour24";
    public static final String FORMAT = "{HH24}:{MM}:{SS}";

    //##################################################
    //# variables
    //##################################################

    private KmTimeFormatterIF  _formatter;
    private KmTimeParser       _parser;

    //##################################################
    //# constructor
    //##################################################

    public KmTimePolicyHour24()
    {
        _formatter = new KmTimeFormatter(FORMAT);
        _parser = new KmTimeParser(false);
    }

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
        return "Time";
    }

    @Override
    public String getExample()
    {
        return "hh24:mm:ss";
    }

    @Override
    public String format(KmTime t)
    {
        return _formatter.format(t);
    }

    @Override
    public KmTime parse(String s)
    {
        return _parser.parse(s);
    }

    //##################################################
    //# test
    //##################################################

    public static void main(String args[])
    {
        KmTimePolicyHour24 p = new KmTimePolicyHour24();

        System.out.println("parse: ");
        System.out.println("  12:12:   " + p.parse("12:12"));
        System.out.println("  12:12am: " + p.parse("12:12am"));
        System.out.println("  12:12pm: " + p.parse("12:12pm"));
        System.out.println("  7:33:    " + p.parse("7:33"));
        System.out.println("  7:33am:  " + p.parse("7:33am"));
        System.out.println("  7:33pm:  " + p.parse("7:33pm"));
        System.out.println("  0:12:    " + p.parse("0:12"));
        System.out.println("  0:12am:  " + p.parse("0:12am"));
        System.out.println("  0:12pm:  " + p.parse("0:12pm"));
        System.out.println("  22:12:   " + p.parse("22:12"));
        System.out.println("  22:12am: " + p.parse("22:12am"));
        System.out.println("  22:12pm: " + p.parse("22:12pm"));
    }

}
