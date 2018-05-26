package com.app.model;

import com.app.model.base.MyDatedCountVoToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyDatedCountVoTools
    extends MyDatedCountVoToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyDatedCountVoTools instance = new MyDatedCountVoTools();

    //##################################################
    //# constructor
    //##################################################

    private MyDatedCountVoTools()
    {
        // singleton
    }

}
