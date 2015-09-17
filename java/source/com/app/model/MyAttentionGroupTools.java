package com.app.model;

import com.app.model.base.MyAttentionGroupToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyAttentionGroupTools
    extends MyAttentionGroupToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyAttentionGroupTools instance = new MyAttentionGroupTools();

    //##################################################
    //# constructor
    //##################################################

    private MyAttentionGroupTools()
    {
        // singleton
    }

}
