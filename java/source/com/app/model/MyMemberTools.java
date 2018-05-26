package com.app.model;

import com.kodemore.servlet.field.ScDropdownField;
import com.kodemore.servlet.field.ScStaticEnumDropdownField;

import com.app.model.base.MyMemberRole;
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

    public ScDropdownField<String> newRoleDropdown()
    {
        MyMetaMember x = MyMember.Meta;

        ScStaticEnumDropdownField e;
        e = new ScStaticEnumDropdownField();
        e.setLabel("Role");
        e.setHelp(x.RoleCode);
        e.addOption(MyMemberRole.Manager);
        e.addOption(MyMemberRole.Worker);
        return e;
    }

}
