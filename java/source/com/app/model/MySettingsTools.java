package com.app.model;

import com.app.model.base.MySettingsToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MySettingsTools
    extends MySettingsToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MySettingsTools instance = new MySettingsTools();

    //##################################################
    //# constructor
    //##################################################

    private MySettingsTools()
    {
        // singleton
    }

}
