package com.app.model;

import com.kodemore.servlet.field.ScDropdown;

import com.app.model.base.MyUserAccountToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyUserAccountTools
    extends MyUserAccountToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyUserAccountTools instance = new MyUserAccountTools();

    //##################################################
    //# constructor
    //##################################################

    private MyUserAccountTools()
    {
        // singleton
    }

    //##################################################
    //# convenience
    //##################################################

    public ScDropdown newRoleDropdown()
    {
        ScDropdown e;
        e = new ScDropdown();
        e.setLabel("Role");
        e.addOption(MyUserAccountRole.Owner);
        e.addOption(MyUserAccountRole.Manager);
        e.addOption(MyUserAccountRole.User);
        return e;
    }

}
