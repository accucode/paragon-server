package com.app.model;

import com.app.model.base.MyRegionToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyRegionTools
    extends MyRegionToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyRegionTools instance = new MyRegionTools();

    //##################################################
    //# constructor
    //##################################################

    private MyRegionTools()
    {
        // singleton
    }

}
