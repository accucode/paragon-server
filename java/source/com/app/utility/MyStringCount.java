package com.app.utility;

import com.kodemore.utility.Kmu;

public class MyStringCount
{
    //##################################################
    //# variables
    //##################################################

    private String  _string;
    private Integer _count;

    //##################################################
    //# string
    //##################################################

    public String getString()
    {
        return _string;
    }

    public void setString(String e)
    {
        _string = e;
    }

    public boolean hasString(String e)
    {
        return Kmu.isEqual(getString(), e);
    }

    //##################################################
    //# count
    //##################################################

    public Integer getCount()
    {
        return _count;
    }

    public void setCount(Integer e)
    {
        _count = e;
    }

    public boolean hasCount()
    {
        return _count != null;
    }

}
