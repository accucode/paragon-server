package com.app.model;

import com.kodemore.utility.Kmu;

import com.app.model.base.MyPerformanceLogSummaryBase;
import com.app.model.core.MySystemDomainIF;

public class MyPerformanceLogSummary
    extends MyPerformanceLogSummaryBase
    implements MySystemDomainIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyPerformanceLogSummary()
    {
        super();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        String name = hasName()
            ? getName()
            : "NoName";

        String date = hasUtcDate()
            ? getUtcDate().format_mm_dd_yy()
            : "NoDate";

        return Kmu.format("%s-%s", name, date);
    }
}
