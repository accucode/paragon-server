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

    public KmJsonLiteral(CharSequence e)
    {
        _value = e == null
            ? null
            : e.toString();
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
