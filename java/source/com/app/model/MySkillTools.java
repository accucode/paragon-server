package com.app.model;

import com.app.model.base.MySkillToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MySkillTools
    extends MySkillToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MySkillTools instance = new MySkillTools();

    //##################################################
    //# constructor
    //##################################################

    private MySkillTools()
    {
        // singleton
    }

}
