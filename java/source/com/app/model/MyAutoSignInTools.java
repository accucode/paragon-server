package com.app.model;

import com.app.model.base.MyAutoSignInToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyAutoSignInTools
    extends MyAutoSignInToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyAutoSignInTools instance = new MyAutoSignInTools();

    //##################################################
    //# constructor
    //##################################################

    private MyAutoSignInTools()
    {
        // singleton
    }

}
