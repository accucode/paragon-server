package com.app.model;

import com.app.model.base.MyEndUserBase;

public class MyEndUser
    extends MyEndUserBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyEndUser()
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
