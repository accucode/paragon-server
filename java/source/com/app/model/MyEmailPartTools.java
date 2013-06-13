package com.app.model;

import com.app.model.base.MyEmailPartToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyEmailPartTools
    extends MyEmailPartToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyEmailPartTools instance = new MyEmailPartTools();

    //##################################################
    //# constructor
    //##################################################

    private MyEmailPartTools()
    {
        // singleton
    }

}
