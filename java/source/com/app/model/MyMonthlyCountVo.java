package com.app.model;

import com.kodemore.time.KmMonth;
import com.kodemore.utility.Kmu;

public class MyMonthlyCountVo
{
    //##################################################
    //# variables
    //##################################################

    private KmMonth _month;
    private Integer _count;

    //##################################################
    //# constructor
    //##################################################

    public MyMonthlyCountVo()
    {
        super();
    }

    public MyMonthlyCountVo(KmMonth month, Integer count)
    {
        setMonth(month);
        setCount(count);
    }

    //##################################################
    //# month
    //##################################################

    public KmMonth getMonth()
    {
        return _month;
    }

    public void setMonth(KmMonth e)
    {
        _month = e;
    }

    public boolean hasMonth()
    {
        return _month != null;
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
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return Kmu.format("%s => %s", getMonth(), getCount());
    }
}
