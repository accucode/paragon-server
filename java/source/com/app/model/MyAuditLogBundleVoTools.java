package com.app.model;

import com.app.model.base.MyAuditLogBundleVoToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyAuditLogBundleVoTools
    extends MyAuditLogBundleVoToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyAuditLogBundleVoTools instance = new MyAuditLogBundleVoTools();

    //##################################################
    //# constructor
    //##################################################

    private MyAuditLogBundleVoTools()
    {
        // singleton
    }

}
