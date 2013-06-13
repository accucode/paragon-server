package com.app.model;

import com.app.model.base.MyPasswordResetToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyPasswordResetTools
    extends MyPasswordResetToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyPasswordResetTools instance = new MyPasswordResetTools();

    //##################################################
    //# constructor
    //##################################################

    private MyPasswordResetTools()
    {
        // singleton
    }

}
