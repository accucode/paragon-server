package com.app.model;

import com.kodemore.utility.Kmu;

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

    public void addMember(MyUser e)
    {
        MyProject p = getProject();
        MyMember m = p.findMember(e);

        if ( m == null )
            throw Kmu.newError(
                "Cannot add user (%s) to attention group. User is not a member of project (%s).",
                e.getName(),
                p.getName());

        MyAttentionMember attn = getAttentionMembers().selectFirst(x -> x.hasMember(m));
        if ( attn == null )
        {
            attn = addAttentionMember();
            attn.setMember(m);
        }
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
