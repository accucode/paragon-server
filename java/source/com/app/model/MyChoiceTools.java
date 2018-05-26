package com.app.model;

import com.app.model.base.MyChoiceToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyChoiceTools
    extends MyChoiceToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyChoiceTools instance = new MyChoiceTools();

    //##################################################
    //# constructor
    //##################################################

    private MyChoiceTools()
    {
        // singleton
    }

}
