package com.kodemore.json;

import org.json.simple.JSONAware;

/**
 * Wraps the json-simple library.
 * http://code.google.com/p/json-simple/
 * Apache License 2.0
 */
public class KmJsonLiteral
    implements JSONAware
{
    //##################################################
    //# variables
    //##################################################

    private String _value;

    //##################################################
    //# constructor
    //##################################################

    public KmJsonLiteral(String e)
    {
        _value = e;
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toJSONString()
    {
        return _value;
    }
}
