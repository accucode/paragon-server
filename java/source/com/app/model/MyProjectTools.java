package com.app.model;

import com.app.model.base.MyProjectToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyProjectTools
    extends MyProjectToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyProjectTools instance = new MyProjectTools();

    //##################################################
    //# constructor
    //##################################################

    private MyProjectTools()
    {
        // singleton
    }

}
