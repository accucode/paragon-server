package com.app.model;

import com.app.model.base.MyInvitationToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyInvitationTools
    extends MyInvitationToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyInvitationTools instance = new MyInvitationTools();

    //##################################################
    //# constructor
    //##################################################

    private MyInvitationTools()
    {
        // singleton
    }

}
