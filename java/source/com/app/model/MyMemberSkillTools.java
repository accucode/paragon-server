package com.app.model;

import com.app.model.base.MyMemberSkillToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyMemberSkillTools
    extends MyMemberSkillToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMemberSkillTools instance = new MyMemberSkillTools();

    //##################################################
    //# constructor
    //##################################################

    private MyMemberSkillTools()
    {
        // singleton
    }

}
