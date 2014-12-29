package com.app.model;

import com.kodemore.servlet.field.ScDropdown;

import com.app.model.base.MyMemberToolsBase;
import com.app.model.meta.MyMetaMember;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyMemberTools
    extends MyMemberToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMemberTools instance = new MyMemberTools();

    //##################################################
    //# constructor
    //##################################################

    private MyMemberTools()
    {
        // singleton
    }

    //##################################################
    //# convenience
    //##################################################

    public ScDropdown newRoleDropdown()
    {
        MyMetaMember x = MyMember.Meta;

        ScDropdown e;
        e = new ScDropdown();
        e.setLabel("Role");
        e.setHelp(x.RoleCode);
        e.addOption(MyMemberRole.Manager);
        e.addOption(MyMemberRole.Worker);
        e.addOption(MyMemberRole.Customer);
        return e;
    }

}
