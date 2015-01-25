package com.app.model;

import com.app.model.base.MyPowerTypeToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyPowerTypeTools
    extends MyPowerTypeToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyPowerTypeTools instance = new MyPowerTypeTools();

    //##################################################
    //# constructor
    //##################################################

    private MyPowerTypeTools()
    {
        // singleton
    }

}
