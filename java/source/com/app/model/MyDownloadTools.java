package com.app.model;

import com.app.model.base.MyDownloadToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyDownloadTools
    extends MyDownloadToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyDownloadTools instance = new MyDownloadTools();

    //##################################################
    //# constructor
    //##################################################

    private MyDownloadTools()
    {
        // singleton
    }

}
