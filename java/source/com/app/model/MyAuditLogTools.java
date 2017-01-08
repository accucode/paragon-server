package com.app.model;

import com.app.model.base.MyAuditLogToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyAuditLogTools
    extends MyAuditLogToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyAuditLogTools instance = new MyAuditLogTools();

    //##################################################
    //# constructor
    //##################################################

    private MyAuditLogTools()
    {
        // singleton
    }

}
