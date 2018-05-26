package com.app.model;

import com.app.model.base.MyHibernateCacheTestBase;
import com.app.model.core.MySystemDomainIF;

public class MyHibernateCacheTest
    extends MyHibernateCacheTestBase
    implements MySystemDomainIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyHibernateCacheTest()
    {
        super();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getAuditLogTitle()
    {
        return getUid();
    }

    @Override
    public String getDomainTitle()
    {
        return getUid();
    }

    @Override
    public String getDomainSubtitle()
    {
        return null;
    }
}
