package com.kodemore.utility;

public abstract class KmContextFormatter
{
    //##################################################
    //# constants
    //##################################################

    public static boolean enabled = false;
    public static int     lines   = 20;

    //##################################################
    //# accessing
    //##################################################

    public static String format()
    {
        if ( !enabled )
            return null;

        return Kmu.formatLocalStackTrace(1, lines);
    }
}
