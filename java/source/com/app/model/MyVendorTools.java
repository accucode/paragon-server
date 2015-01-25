package com.app.model;

import com.app.model.base.MyVendorToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyVendorTools
    extends MyVendorToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyVendorTools instance = new MyVendorTools();

    //##################################################
    //# constructor
    //##################################################

    private MyVendorTools()
    {
        // singleton
    }

}
