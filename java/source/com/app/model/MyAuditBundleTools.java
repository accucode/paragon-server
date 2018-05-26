package com.app.model;

import com.app.model.base.MyAuditBundleToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyAuditBundleTools
    extends MyAuditBundleToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyAuditBundleTools instance = new MyAuditBundleTools();

    //##################################################
    //# constructor
    //##################################################

    private MyAuditBundleTools()
    {
        // singleton
    }

}
