package com.app.model;

import com.app.model.base.MyFieldTestBase;

public class MyFieldTest
    extends MyFieldTestBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyFieldTest()
    {
        super();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getUid();
    }
}
