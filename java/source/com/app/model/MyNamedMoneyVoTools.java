package com.app.model;

import com.app.model.base.MyNamedMoneyVoToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyNamedMoneyVoTools
    extends MyNamedMoneyVoToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyNamedMoneyVoTools instance = new MyNamedMoneyVoTools();

    //##################################################
    //# constructor
    //##################################################

    private MyNamedMoneyVoTools()
    {
        // singleton
    }

}
