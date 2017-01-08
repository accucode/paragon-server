package com.app.model;

import com.app.model.base.MyPerformanceLogDetailBase;
import com.app.model.core.MySystemDomainIF;

public class MyPerformanceLogDetail
    extends MyPerformanceLogDetailBase
    implements MySystemDomainIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyPerformanceLogDetail()
    {
        super();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getName();
    }
}
