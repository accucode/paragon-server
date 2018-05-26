package com.app.model;

import com.app.model.base.MyTenantToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyTenantTools
    extends MyTenantToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyTenantTools instance = new MyTenantTools();

    //##################################################
    //# constructor
    //##################################################

    private MyTenantTools()
    {
        // singleton
    }

}
