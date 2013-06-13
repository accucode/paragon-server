package com.kodemore.json;

/**
 * Wraps the json-simple library.
 * http://code.google.com/p/json-simple/
 * Apache License 2.0
 */
public abstract class KmJsonUtility
{
    //##################################################
    //# format
    //##################################################

    public static String format(CharSequence e)
    {
        if ( e == null )
            return formatNull();

        KmJsonList v;
        v = new KmJsonList();
        v.addString(e.toString());

        return withoutBrackets(v);
    }

    public static String format(Integer e)
    {
        KmJsonList v;
        v = new KmJsonList();
        v.addInteger(e);

        return withoutBrackets(v);
    }

    public static String format(Long e)
    {
        KmJsonList v;
        v = new KmJsonList();
        v.addLong(e);

        return withoutBrackets(v);
    }

    public static String format(Double e)
    {
        KmJsonList v;
        v = new KmJsonList();
        v.addDouble(e);

        return withoutBrackets(v);
    }

    public static String formatNull()
    {
        return "null";
    }

    //##################################################
    //# support
    //##################################################

    private static String withoutBrackets(KmJsonList v)
    {
        return v.toString().substring(1, v.toString().length() - 1);
    }
}
