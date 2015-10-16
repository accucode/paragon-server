package com.app.model;

import com.kodemore.utility.Kmu;

import com.app.model.base.MyPerformanceLogSummaryBase;

public class MyPerformanceLogSummary
    extends MyPerformanceLogSummaryBase
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
