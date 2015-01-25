package com.app.model;

import com.app.model.base.MyProductToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyProductTools
    extends MyProductToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyProductTools instance = new MyProductTools();

    //##################################################
    //# constructor
    //##################################################

    private MyProductTools()
    {
        // singleton
    }

}
