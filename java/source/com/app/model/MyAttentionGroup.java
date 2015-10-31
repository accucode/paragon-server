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
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getName();
    }

}
