package com.app.model;

import com.app.model.base.MyFieldTestBase;
import com.app.model.core.MySystemDomainIF;

public class MyFieldTest
    extends MyFieldTestBase
    implements MySystemDomainIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyFieldTest()
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
        return getNameValue();
    }
}
