package com.app.model;

import com.app.model.base.MyPriorityToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyPriorityTools
    extends MyPriorityToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyPriorityTools instance = new MyPriorityTools();

    //##################################################
    //# constructor
    //##################################################

    private MyPriorityTools()
    {
        // singleton
    }

}
