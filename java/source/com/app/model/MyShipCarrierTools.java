package com.app.model;

import com.app.model.base.MyShipCarrierToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyShipCarrierTools
    extends MyShipCarrierToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyShipCarrierTools instance = new MyShipCarrierTools();

    //##################################################
    //# constructor
    //##################################################

    private MyShipCarrierTools()
    {
        // singleton
    }

}
