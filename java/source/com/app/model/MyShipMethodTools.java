package com.app.model;

import com.app.model.base.MyShipMethodToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyShipMethodTools
    extends MyShipMethodToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyShipMethodTools instance = new MyShipMethodTools();

    //##################################################
    //# constructor
    //##################################################

    private MyShipMethodTools()
    {
        // singleton
    }

}
