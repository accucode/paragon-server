package com.app.model;

import com.app.model.base.MyUserActivationToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyUserActivationTools
    extends MyUserActivationToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyUserActivationTools instance = new MyUserActivationTools();

    //##################################################
    //# constructor
    //##################################################

    private MyUserActivationTools()
    {
        // singleton
    }

}
