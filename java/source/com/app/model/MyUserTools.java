package com.app.model;

import com.app.model.base.MyUserToolsBase;

public class MyUserTools
    extends MyUserToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyUserTools instance = new MyUserTools();

    //##################################################
    //# constructor
    //##################################################

    private MyUserTools()
    {
        // singleton
    }
}
