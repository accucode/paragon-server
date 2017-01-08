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

        KmJsonArray v;
        v = new KmJsonArray();
        v.addString(e.toString());

        return withoutBrackets(v);
    }

    public static String format(Integer e)
    {
        KmJsonArray v;
        v = new KmJsonArray();
        v.addInteger(e);

        return withoutBrackets(v);
    }

    public static String format(Long e)
    {
        KmJsonArray v;
        v = new KmJsonArray();
        v.addLong(e);

        return withoutBrackets(v);
    }

    public static String format(Double e)
    {
        KmJsonArray v;
        v = new KmJsonArray();
        v.addDouble(e);

        return withoutBrackets(v);
    }

    public static String format(Boolean e)
    {
        KmJsonArray v;
        v = new KmJsonArray();
        v.addBoolean(e);

        return withoutBrackets(v);
    }

    public static String formatNull()
    {
        return "null";
    }

    //##################################################
    //# support
    //##################################################

    private static String withoutBrackets(KmJsonArray v)
    {
        return v.toString().substring(1, v.toString().length() - 1);
    }
}
