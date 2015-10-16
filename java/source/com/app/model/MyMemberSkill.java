package com.app.model;

import com.kodemore.utility.Kmu;

import com.app.model.base.MyMemberSkillBase;

public class MyMemberSkill
    extends MyMemberSkillBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyMemberSkill()
    {
        super();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return Kmu.format("%s => %s", getMember().getUserName(), getSkill().getName());
    }

}
