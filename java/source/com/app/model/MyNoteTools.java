package com.app.model;

import com.app.model.base.MyNoteToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyNoteTools
    extends MyNoteToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyNoteTools instance = new MyNoteTools();

    //##################################################
    //# constructor
    //##################################################

    private MyNoteTools()
    {
        // singleton
    }

}
