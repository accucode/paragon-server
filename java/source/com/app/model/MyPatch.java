package com.app.model;

import com.app.model.base.MyPatchBase;
import com.app.model.core.MySystemDomainIF;

public class MyPatch
    extends MyPatchBase
    implements MySystemDomainIF
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
