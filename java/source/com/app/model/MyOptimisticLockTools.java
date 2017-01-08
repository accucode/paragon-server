package com.app.model;

import com.app.model.base.MyOptimisticLockToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyOptimisticLockTools
    extends MyOptimisticLockToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyOptimisticLockTools instance = new MyOptimisticLockTools();

    //##################################################
    //# constructor
    //##################################################

    private MyOptimisticLockTools()
    {
        // singleton
    }

}
