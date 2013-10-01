package com.app.model;

import com.app.model.base.MyEmailPartBase;

import com.kodemore.collection.KmBlob;

public class MyEmailPart
    extends MyEmailPartBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyEmailPart()
    {
        super();
    }

    //##################################################
    //# data
    //##################################################

    public void setData(String s)
    {
        KmBlob e;
        e = new KmBlob();
        e.setValue(s);
        setData(e);
    }

    public void setData(byte[] bytes)
    {
        KmBlob e;
        e = new KmBlob();
        e.setValue(bytes);
        setData(e);
    }
}
