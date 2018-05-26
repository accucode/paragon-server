package com.app.model;

import com.app.model.base.MySiteToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MySiteTools
    extends MySiteToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MySiteTools instance = new MySiteTools();

    //##################################################
    //# constructor
    //##################################################

    private MySiteTools()
    {
        // singleton
    }

}
