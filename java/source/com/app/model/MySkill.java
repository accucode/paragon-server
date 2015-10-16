package com.app.model;

import com.app.model.base.MySkillBase;

public class MySkill
    extends MySkillBase
{
    //##################################################
    //# constructor
    //##################################################

    public MySkill()
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
