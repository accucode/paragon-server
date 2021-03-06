package com.app.model;

import com.kodemore.time.KmDate;

import com.app.model.base.MyDatedCountVoBase;

public class MyDatedCountVo
    extends MyDatedCountVoBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyDatedCountVo()
    {
        super();
    }

    public MyDatedCountVo(KmDate date, Integer count)
    {
        setDate(date);
        setCount(count);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getAuditLogTitle()
    {
        return getDate() + " " + getCount();
    }

    @Override
    public String getDomainTitle()
    {
        return getDate() + " " + getCount();
    }

    @Override
    public String getDomainSubtitle()
    {
        return null;
    }
}
