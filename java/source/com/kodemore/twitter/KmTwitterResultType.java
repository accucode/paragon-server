package com.kodemore.twitter;

/**
 * I am used connect to Twitter make various requests.
 */
public enum KmTwitterResultType
{
    //##################################################
    //# values
    //##################################################

    Mixed("mixed"),
    Recent("recent"),
    Popular("popular");

    //##################################################
    //# variables
    //##################################################

    private String _type;

    //##################################################
    //# constructor
    //##################################################

    private KmTwitterResultType(String type)
    {
        _type = type;
    }

    //##################################################
    //# accessing
    //##################################################

    public String getType()
    {
        return _type;
    }
}
