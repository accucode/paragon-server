package com.app.model;

import com.app.model.base.MyAttachmentToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyAttachmentTools
    extends MyAttachmentToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyAttachmentTools instance = new MyAttachmentTools();

    //##################################################
    //# constructor
    //##################################################

    private MyAttachmentTools()
    {
        // singleton
    }

}
