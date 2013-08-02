package com.app.model;

import com.app.model.base.MyAccountUserToolsBase;

import com.kodemore.servlet.field.ScDropdown;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyAccountUserTools
    extends MyAccountUserToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyAccountUserTools instance = new MyAccountUserTools();

    //##################################################
    //# constructor
    //##################################################

    private MyAccountUserTools()
    {
        // singleton
    }

    public ScDropdown newRoleDropdown()
    {
        ScDropdown e;
        e = new ScDropdown();
        e.setLabel("Role");
        e.addOption(MyAccountUserRole.Owner);
        e.addOption(MyAccountUserRole.Manager);
        e.addOption(MyAccountUserRole.User);
        return e;
    }

}
