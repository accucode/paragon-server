package com.app.model;

import com.app.model.base.MyThreadTopicToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyThreadTopicTools
    extends MyThreadTopicToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyThreadTopicTools instance = new MyThreadTopicTools();

    //##################################################
    //# constructor
    //##################################################

    private MyThreadTopicTools()
    {
        // singleton
    }

}
