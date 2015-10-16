package com.app.model;

import com.app.model.base.MyProductCategoryBase;

public class MyProductCategory
    extends MyProductCategoryBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyProductCategory()
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
