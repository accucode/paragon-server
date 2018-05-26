package com.app.ui.page.crud.project;

import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.servlet.ScParameterList;

import com.app.ui.page.MyBookmark;
import com.app.ui.page.MyPage;

public class MyPrintDomainBookmark
    extends MyBookmark
{
    //##################################################
    //# constants
    //##################################################

    private static final String PARAM_DOMAIN_UID = "domainUid";

    //##################################################
    //# variables
    //##################################################

    private String _domainUid;

    //##################################################
    //# constructor
    //##################################################

    public MyPrintDomainBookmark(MyPage e)
    {
        super(e);
    }

    //##################################################
    //# domain uid
    //##################################################

    public String getDomainUid()
    {
        return _domainUid;
    }

    public void setDomainUid(String e)
    {
        _domainUid = e;
    }

    public void setDomain(KmUidDomainIF e)
    {
        setDomainUid(KmUidDomainIF.getUidFor(e));
    }

    //##################################################
    //# params
    //##################################################

    @Override
    public void readFrom(ScParameterList params)
    {
        super.readFrom(params);

        setDomainUid(params.getString(PARAM_DOMAIN_UID));
    }

    @Override
    public void writeTo(ScParameterList params)
    {
        super.writeTo(params);

        params.setString(PARAM_DOMAIN_UID, getDomainUid());
    }

}
