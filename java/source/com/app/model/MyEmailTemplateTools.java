package com.app.model;

import com.app.model.base.MyEmailTemplateToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyEmailTemplateTools
    extends MyEmailTemplateToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyEmailTemplateTools instance = new MyEmailTemplateTools();

    //##################################################
    //# constructor
    //##################################################

    private MyEmailTemplateTools()
    {
        // singleton
    }

}
