package com.app.model;

import com.app.model.base.MyHibernateCacheTestBase;

public class MyHibernateCacheTest
    extends MyHibernateCacheTestBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyHibernateCacheTest()
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
