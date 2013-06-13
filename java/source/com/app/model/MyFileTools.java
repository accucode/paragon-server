package com.app.model;

import com.app.model.base.MyFileToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyFileTools
    extends MyFileToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyFileTools instance = new MyFileTools();

    //##################################################
    //# constructor
    //##################################################

    private MyFileTools()
    {
        // singleton
    }

}
