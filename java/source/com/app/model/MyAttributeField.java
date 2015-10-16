package com.app.model;

import com.app.model.base.MyAttributeFieldBase;

public class MyAttributeField
    extends MyAttributeFieldBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyAttributeField()
    {
        super();
    }

    //##################################################
    //# convenience
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getName();
    }

}
