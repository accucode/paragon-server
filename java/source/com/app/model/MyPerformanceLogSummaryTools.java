package com.app.model;

import com.app.model.base.MyPerformanceLogSummaryToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyPerformanceLogSummaryTools
    extends MyPerformanceLogSummaryToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyPerformanceLogSummaryTools instance = new MyPerformanceLogSummaryTools();

    //##################################################
    //# constructor
    //##################################################

    private MyPerformanceLogSummaryTools()
    {
        // singleton
    }

}
