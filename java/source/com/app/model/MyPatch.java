package com.app.model;

import com.app.model.base.MyPatchBase;

public class MyPatch
    extends MyPatchBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyPatch()
    {
        super();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getName();
    }

}
