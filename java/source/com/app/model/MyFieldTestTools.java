package com.app.model;

import com.app.model.base.MyFieldTestToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyFieldTestTools
    extends MyFieldTestToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyFieldTestTools instance = new MyFieldTestTools();

    //##################################################
    //# constructor
    //##################################################

    private MyFieldTestTools()
    {
        // singleton
    }

}
