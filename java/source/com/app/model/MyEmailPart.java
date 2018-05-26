package com.app.model;

import com.kodemore.collection.KmBlob;

import com.app.model.base.MyEmailPartBase;
import com.app.model.core.MySystemDomainIF;

public class MyEmailPart
    extends MyEmailPartBase
    implements MySystemDomainIF
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
        e.setUtfValue(s);
        setData(e);
    }

    public void setData(byte[] bytes)
    {
        KmBlob e;
        e = new KmBlob();
        e.setValue(bytes);
        setData(e);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getAuditLogTitle()
    {
        return getTypeName();
    }

    @Override
    public String getDomainTitle()
    {
        return getTypeName();
    }

    @Override
    public String getDomainSubtitle()
    {
        return null;
    }
}
