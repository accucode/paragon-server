package com.app.model;

import com.app.model.base.MyNamedDoubleVoToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyNamedDoubleVoTools
    extends MyNamedDoubleVoToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyNamedDoubleVoTools instance = new MyNamedDoubleVoTools();

    //##################################################
    //# constructor
    //##################################################

    private MyNamedDoubleVoTools()
    {
        // singleton
    }

}
