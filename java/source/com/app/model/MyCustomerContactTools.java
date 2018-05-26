package com.app.model;

import com.app.model.base.MyCustomerContactToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyCustomerContactTools
    extends MyCustomerContactToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyCustomerContactTools instance = new MyCustomerContactTools();

    //##################################################
    //# constructor
    //##################################################

    private MyCustomerContactTools()
    {
        // singleton
    }

}
