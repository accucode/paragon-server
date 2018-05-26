package com.app.model;

import com.app.model.base.MyDefaultRecipientToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyDefaultRecipientTools
    extends MyDefaultRecipientToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyDefaultRecipientTools instance = new MyDefaultRecipientTools();

    //##################################################
    //# constructor
    //##################################################

    private MyDefaultRecipientTools()
    {
        // singleton
    }

}
