package com.app.model;

import com.app.model.base.MyDepotToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyDepotTools
    extends MyDepotToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyDepotTools instance = new MyDepotTools();

    //##################################################
    //# constructor
    //##################################################

    private MyDepotTools()
    {
        // singleton
    }

}
