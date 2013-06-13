package com.app.model;

import com.app.model.base.MySystemLogTraceToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MySystemLogTraceTools
    extends MySystemLogTraceToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MySystemLogTraceTools instance = new MySystemLogTraceTools();

    //##################################################
    //# constructor
    //##################################################

    private MySystemLogTraceTools()
    {
        // singleton
    }

}
