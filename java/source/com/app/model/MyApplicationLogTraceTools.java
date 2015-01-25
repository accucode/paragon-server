package com.app.model;

import com.app.model.base.MyApplicationLogTraceToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyApplicationLogTraceTools
    extends MyApplicationLogTraceToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyApplicationLogTraceTools instance = new MyApplicationLogTraceTools();

    //##################################################
    //# constructor
    //##################################################

    private MyApplicationLogTraceTools()
    {
        // singleton
    }

}
