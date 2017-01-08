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
    public String getDisplayString()
    {
        return getUid();
    }
}
