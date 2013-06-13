package com.app.model;

import com.app.model.base.MyEmailRecipientToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyEmailRecipientTools
    extends MyEmailRecipientToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyEmailRecipientTools instance = new MyEmailRecipientTools();

    //##################################################
    //# constructor
    //##################################################

    private MyEmailRecipientTools()
    {
        // singleton
    }

}
