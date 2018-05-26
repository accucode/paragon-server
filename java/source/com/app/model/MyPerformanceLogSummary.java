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
    public String getAuditLogTitle()
    {
        return formatNameAndDate();
    }

    @Override
    public String getDomainTitle()
    {
        return formatNameAndDate();
    }

    @Override
    public String getDomainSubtitle()
    {
        String s = getFormatter().formatInteger(getTotalMs());
        return s + " total ms";
    }

    //==================================================
    //= display :: private
    //==================================================

    private String formatNameAndDate()
    {
        return Kmu.format("%s-%s", formatName(), formatUtcDate());
    }

    private String formatName()
    {
        return hasName()
            ? getName()
            : "NoName";
    }

    private String formatUtcDate()
    {
        return hasUtcDate()
            ? getUtcDate().format_mm_dd_yy()
            : "NoDate";
    }

}
