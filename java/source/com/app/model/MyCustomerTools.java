package com.app.model;

import com.app.model.base.MyCustomerToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyCustomerTools
    extends MyCustomerToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyCustomerTools instance = new MyCustomerTools();

    //##################################################
    //# constructor
    //##################################################

    private MyCustomerTools()
    {
        // singleton
    }

}
