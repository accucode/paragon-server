package com.kodemore.types;

/**
 * I define a key-value pair of strings.
 */
public class KmStringTuple
    extends KmTuple<String,String>
{
    //##################################################
    //# static
    //##################################################

    public static KmStringTuple createStrings(String key, String value)
    {
        KmStringTuple e;
        e = new KmStringTuple();
        e.setKey(key);
        e.setValue(value);
        return e;
    }

    //##################################################
    //# constructor
    //##################################################

    public KmStringTuple()
    {
        // none
    }
}
