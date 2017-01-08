package com.app.model;

import com.app.model.base.MyFileBase;
import com.app.model.core.MySystemDomainIF;

public class MyFile
    extends MyFileBase
    implements MySystemDomainIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyFile()
    {
        super();

        setStatusNew();
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
