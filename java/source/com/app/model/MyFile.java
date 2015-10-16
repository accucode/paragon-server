package com.app.model;

import com.app.model.base.MyFileBase;

public class MyFile
    extends MyFileBase
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
