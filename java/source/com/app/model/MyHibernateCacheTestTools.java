package com.app.model;

import com.app.model.base.MyHibernateCacheTestToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyHibernateCacheTestTools
    extends MyHibernateCacheTestToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyHibernateCacheTestTools instance = new MyHibernateCacheTestTools();

    //##################################################
    //# constructor
    //##################################################

    private MyHibernateCacheTestTools()
    {
        // singleton
    }

}
