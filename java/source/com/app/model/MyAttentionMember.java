package com.app.model;

import com.app.model.base.MyAttentionMemberBase;

public class MyAttentionMember
    extends MyAttentionMemberBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyAttentionMember()
    {
        super();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getGroupName() + " " + getUserName();
    }
}
