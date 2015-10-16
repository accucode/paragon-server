package com.app.model;

import com.app.model.base.MyPerformanceLogDetailToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyPerformanceLogDetailTools
    extends MyPerformanceLogDetailToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyPerformanceLogDetailTools instance = new MyPerformanceLogDetailTools();

    //##################################################
    //# constructor
    //##################################################

    private MyPerformanceLogDetailTools()
    {
        // singleton
    }

}
