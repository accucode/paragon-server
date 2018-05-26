package com.app.model;

import com.app.model.base.MyProjectContactToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyProjectContactTools
    extends MyProjectContactToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyProjectContactTools instance = new MyProjectContactTools();

    //##################################################
    //# constructor
    //##################################################

    private MyProjectContactTools()
    {
        // singleton
    }

}
