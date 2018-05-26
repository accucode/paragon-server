package com.app.ui.dashboard;

import com.kodemore.types.KmHtmlColor;
import com.kodemore.utility.Kmu;

public class MyBarChartValue
{
    //##################################################
    //# variables
    //##################################################

    private String      _name;
    private Integer     _count;
    private KmHtmlColor _color;

    //##################################################
    //# constructor
    //##################################################

    public MyBarChartValue()
    {
        _color = KmHtmlColor.createBlack();
    }

    //##################################################
    //# label
    //##################################################

    public String getName()
    {
        return _name;
    }

    public void setName(String e)
    {
        _name = e;
    }

    public boolean hasName(String e)
    {
        return Kmu.isEqual(getName(), e);
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

    //##################################################
    //# color
    //##################################################

    public KmHtmlColor getColor()
    {
        return _color;
    }

    public void setColor(KmHtmlColor e)
    {
        _color = e;
    }

    public boolean hasColor()
    {
        return _color != null;
    }
}
