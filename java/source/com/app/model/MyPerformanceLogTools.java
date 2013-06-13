package com.app.model;

import com.app.model.base.MyPerformanceLogToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyPerformanceLogTools
    extends MyPerformanceLogToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyPerformanceLogTools instance = new MyPerformanceLogTools();

    //##################################################
    //# constructor
    //##################################################

    private MyPerformanceLogTools()
    {
        // singleton
    }

}
