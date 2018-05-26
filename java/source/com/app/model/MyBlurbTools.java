package com.app.model;

import com.app.model.base.MyBlurbToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyBlurbTools
    extends MyBlurbToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyBlurbTools instance = new MyBlurbTools();

    //##################################################
    //# constructor
    //##################################################

    private MyBlurbTools()
    {
        // singleton
    }

}
