package com.app.model;

import com.app.model.base.MySiteContactToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MySiteContactTools
    extends MySiteContactToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MySiteContactTools instance = new MySiteContactTools();

    //##################################################
    //# constructor
    //##################################################

    private MySiteContactTools()
    {
        // singleton
    }

}
