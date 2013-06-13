package com.app.model;

import com.app.model.base.MyTimeZoneToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyTimeZoneTools
    extends MyTimeZoneToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyTimeZoneTools instance = new MyTimeZoneTools();

    //##################################################
    //# constructor
    //##################################################

    private MyTimeZoneTools()
    {
        // singleton
    }

}
