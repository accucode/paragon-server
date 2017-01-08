package com.app.model;

import com.app.model.base.MyNamedIntegerVoToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyNamedIntegerVoTools
    extends MyNamedIntegerVoToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyNamedIntegerVoTools instance = new MyNamedIntegerVoTools();

    //##################################################
    //# constructor
    //##################################################

    private MyNamedIntegerVoTools()
    {
        // singleton
    }

}
