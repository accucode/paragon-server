package com.app.model;

import com.app.model.base.MyAttributeValueBase;

public class MyAttributeValue
    extends MyAttributeValueBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyAttributeValue()
    {
        super();
    }

    //##################################################
    //# convenience
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getTextValue();
    }

}
