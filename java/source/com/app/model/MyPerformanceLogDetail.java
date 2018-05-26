package com.app.model;

import com.kodemore.utility.Kmu;

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
    public String getAuditLogTitle()
    {
        return getName();
    }

    @Override
    public String getDomainTitle()
    {
        return getName();
    }

    @Override
    public String getDomainSubtitle()
    {
        return getFormatter().formatInteger(getDurationMs()) + " ms";
    }

    //##################################################
    //# format
    //##################################################

    public String formatLine()
    {
        return Kmu.format("%s: %sms", getName(), getDurationMs());
    }

}
