package com.kodemore.iana;

public class KmIanaTimeZone
{
    //##################################################
    //# variables
    //##################################################

    private String _name;
    private String _country;
    private String _region;
    private String _offset;
    private String _rule;

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

    public String getCountry()
    {
        return _country;
    }

    public void setCountry(String e)
    {
        _country = e;
    }

    public String getRegion()
    {
        return _region;
    }

    public void setRegion(String e)
    {
        _region = e;
    }

    public String getOffset()
    {
        return _offset;
    }

    public void setOffset(String e)
    {
        _offset = e;
    }

    public String getRule()
    {
        return _rule;
    }

    public void setRule(String e)
    {
        _rule = e;
    }
}
