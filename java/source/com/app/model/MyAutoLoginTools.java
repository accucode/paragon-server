package com.app.model;

import com.app.model.base.MyAutoLoginToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyAutoLoginTools
    extends MyAutoLoginToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyAutoLoginTools instance = new MyAutoLoginTools();

    //##################################################
    //# constructor
    //##################################################

    private MyAutoLoginTools()
    {
        // singleton
    }

}
