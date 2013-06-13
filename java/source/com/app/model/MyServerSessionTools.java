package com.app.model;

import com.app.model.base.MyServerSessionToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyServerSessionTools
    extends MyServerSessionToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyServerSessionTools instance = new MyServerSessionTools();

    //##################################################
    //# constructor
    //##################################################

    private MyServerSessionTools()
    {
        // singleton
    }

}
