package com.app.model;

import com.app.model.base.MyAttentionGroupBase;

public class MyAttentionGroup
    extends MyAttentionGroupBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyAttentionGroup()
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
