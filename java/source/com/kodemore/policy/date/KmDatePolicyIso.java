package com.kodemore.policy.date;

import com.kodemore.time.KmDate;
import com.kodemore.time.KmDateFormatter;
import com.kodemore.time.KmDateFormatterIF;
import com.kodemore.time.KmDateParser;
import com.kodemore.time.KmDateUtility;

/**
 * I am used to adapt the usage of date formatting and parsing.
 */
public class KmDatePolicyIso
    implements KmDatePolicyIF
{
    //##################################################
    //# constants
    //##################################################

    public static final String KEY    = "iso";
    public static final String FORMAT = "{yyyy}-{mm}-{dd}";

    //##################################################
    //# variables
    //##################################################

    private KmDateFormatterIF  _formatter;
    private KmDateParser       _parser;

    //##################################################
    //# constructor
    //##################################################

    public KmDatePolicyIso()
    {
        _formatter = new KmDateFormatter(FORMAT);
        _parser = new KmDateParser();
        _parser.setSeparator('-');
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
        return "Date";
    }

    @Override
    public String getExample()
    {
        return "yyyy-mm-dd";
    }

    @Override
    public String format(KmDate d)
    {
        return _formatter.format(d);
    }

    @Override
    public KmDate parse(String s)
    {
        int[] arr = _parser.getFields(s);
        if ( arr.length != 3 )
            return null;

        Integer yy = _parser.coerceYear(arr[0]);
        Integer mm = arr[1];
        Integer dd = arr[2];
        if ( !KmDateUtility.isValid(yy, mm, dd) )
            return null;
        return KmDate.create(yy, mm, dd);
    }

    //##################################################
    //# test
    //##################################################

    public static void main(String args[])
    {
        KmDatePolicyIso p = new KmDatePolicyIso();

        System.out.println("parse: ");
        System.out.println("  01-02-03:   " + p.parse("01-02-03").format("{mmmm} {d}, {yyyy}"));
        System.out.println("  2003-04-05: " + p.parse("2003-04-05").format("{mmmm} {d}, {yyyy}"));
        System.out.println("  2-3-4:      " + p.parse("2-3-4").format("{mmmm} {d}, {yyyy}"));
    }
}
