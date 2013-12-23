package com.app.model;

import com.app.model.base.MyAccountToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyAccountTools
    extends MyAccountToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyAccountTools instance = new MyAccountTools();

    //##################################################
    //# constructor
    //##################################################

    private MyAccountTools()
    {
        // singleton
    }

}
