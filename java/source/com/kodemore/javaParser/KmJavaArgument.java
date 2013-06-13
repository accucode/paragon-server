package com.kodemore.javaParser;

public class KmJavaArgument
{
    //##################################################
    //# variables
    //##################################################

    private String _name;
    private String _type;

    //##################################################
    //# accessing
    //##################################################

    public String getName()
    {
        return _name;
    }

    public void setName(String e)
    {
        _name = e;
    }

    public String getType()
    {
        return _type;
    }

    public void setType(String e)
    {
        _type = e;
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return _type + " " + _name;
    }

}
