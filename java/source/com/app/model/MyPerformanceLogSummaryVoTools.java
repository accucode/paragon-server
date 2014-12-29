package com.app.model;

import com.app.model.base.MyPerformanceLogSummaryVoToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyPerformanceLogSummaryVoTools
    extends MyPerformanceLogSummaryVoToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyPerformanceLogSummaryVoTools instance =
                                                                    new MyPerformanceLogSummaryVoTools();

    //##################################################
    //# constructor
    //##################################################

    private MyPerformanceLogSummaryVoTools()
    {
        // singleton
    }

}
