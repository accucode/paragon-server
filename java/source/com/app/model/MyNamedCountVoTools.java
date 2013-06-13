package com.app.model;

import com.app.model.base.MyNamedCountVoToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyNamedCountVoTools
    extends MyNamedCountVoToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyNamedCountVoTools instance = new MyNamedCountVoTools();

    //##################################################
    //# constructor
    //##################################################

    private MyNamedCountVoTools()
    {
        // singleton
    }

}
