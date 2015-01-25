package com.app.model;

import com.app.model.base.MyVisitTypeToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyVisitTypeTools
    extends MyVisitTypeToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyVisitTypeTools instance = new MyVisitTypeTools();

    //##################################################
    //# constructor
    //##################################################

    private MyVisitTypeTools()
    {
        // singleton
    }

}
