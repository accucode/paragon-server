package com.app.model;

import com.kodemore.collection.KmList;

import com.app.model.base.MyProjectContactBase;
import com.app.model.core.MyProjectDomainIF;
import com.app.model.support.MyPersonNameUtility;

public class MyProjectContact
    extends MyProjectContactBase
    implements MyProjectDomainIF, MyContactIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyProjectContact()
    {
        super();
    }

    //##################################################
    //# context
    //##################################################

    @Override
    public MyTenant getTenant()
    {
        return getProject().getTenant();
    }

    //##################################################
    //# name
    //##################################################

    @Override
    public void updateFullName()
    {
        String s = MyPersonNameUtility.getFullName(this);
        setFullName(s);
        truncateFullName();
    }

    @Override
    public String getFormalName()
    {
        return MyPersonNameUtility.getFormalName(this);
    }

    @Override
    public String getShortName()
    {
        return MyPersonNameUtility.getShortName(this);
    }

    @Override
    public String getLongName()
    {
        return MyPersonNameUtility.getLongName(this);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getAuditLogTitle()
    {
        return getFullName();
    }

    @Override
    public String getDomainTitle()
    {
        return getFullName();
    }

    @Override
    public String getDomainSubtitle()
    {
        KmList<String> v;
        v = new KmList<>();
        v.addNonNull(getEmail());
        v.addNonNull(getTitle());
        return v.join();
    }
}
