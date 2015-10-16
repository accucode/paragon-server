package com.app.model;

import com.app.model.base.MyVisitTypeBase;

public class MyVisitType
    extends MyVisitTypeBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyVisitType()
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
