package com.kodemore.iana;

public class KmIanaRule
{
    //##################################################
    //# variables
    //##################################################

    private String _name;
    private String _fromYear;
    private String _toYear;
    private String _type;
    private String _inMonth;
    private String _onDay;
    private String _atTime;
    private String _save;

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

    public String getFromYear()
    {
        return _fromYear;
    }

    public void setFromYear(String e)
    {
        _fromYear = e;
    }

    public String getToYear()
    {
        return _toYear;
    }

    public void setToYear(String e)
    {
        _toYear = e;
    }

    public String getType()
    {
        return _type;
    }

    public void setType(String e)
    {
        _type = e;
    }

    public String getInMonth()
    {
        return _inMonth;
    }

    public void setInMonth(String e)
    {
        _inMonth = e;
    }

    public String getOnDay()
    {
        return _onDay;
    }

    public void setOnDay(String e)
    {
        _onDay = e;
    }

    public String getAtTime()
    {
        return _atTime;
    }

    public void setAtTime(String e)
    {
        _atTime = e;
    }

    public String getSave()
    {
        return _save;
    }

    public void setSave(String e)
    {
        _save = e;
    }

}
