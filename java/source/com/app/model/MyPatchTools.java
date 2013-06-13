package com.app.model;

import com.app.model.base.MyPatchToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyPatchTools
    extends MyPatchToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyPatchTools instance = new MyPatchTools();

    //##################################################
    //# constructor
    //##################################################

    private MyPatchTools()
    {
        // singleton
    }

}
