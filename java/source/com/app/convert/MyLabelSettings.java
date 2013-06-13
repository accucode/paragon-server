package com.app.convert;

public class MyLabelSettings
{
    //##################################################
    //# variables
    //##################################################

    private Integer _dotsPerInch;

    //##################################################
    //# constructor
    //##################################################

    public MyLabelSettings()
    {
        _dotsPerInch = 203;
    }

    //##################################################
    //# accessing
    //##################################################

    public Integer getDotsPerInch()
    {
        return _dotsPerInch;
    }

    public void setDotsPerInch(Integer e)
    {
        _dotsPerInch = e;
    }

}
