package com.app.model;

import com.app.model.base.MyUserToolsBase;

import com.kodemore.servlet.field.ScDropdown;

public class MyUserTools
    extends MyUserToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyUserTools instance = new MyUserTools();

    //##################################################
    //# constructor
    //##################################################

    private MyUserTools()
    {
        // singleton
    }

    //##################################################
    //# convenience
    //##################################################

    public ScDropdown newUidNameDropdown()
    {
        ScDropdown e;
        e = new ScDropdown();
        e.setLabel("User");
        e.setOptionValueAdaptor(Meta.Uid);
        e.setOptionLabelAdaptor(Meta.Name);
        return e;
    }

    public ScDropdown newUserRoleDropdown()
    {
        ScDropdown e;
        e = new ScDropdown();
        e.setLabel("Role");
        e.setValueAdaptor(Meta.RoleCode);
        e.addOptions(MyUserRole.values());
        return e;
    }

}
