package com.app.ui.page.chartReport;

import com.kodemore.utility.Kmu;

public interface MyChartReportOption
{
    //##################################################
    //# code
    //##################################################

    default String getCode()
    {
        return getName();
    }

    default boolean hasCode(String e)
    {
        return Kmu.isEqual(e, getCode());
    }

    //##################################################
    //# name
    //##################################################

    String getName();
}
