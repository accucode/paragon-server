package com.app.model;

import com.kodemore.servlet.field.ScEnumDropdownField;

import com.app.model.base.MyEmailStatus;
import com.app.model.base.MyEmailToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyEmailTools
    extends MyEmailToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyEmailTools instance = new MyEmailTools();

    //##################################################
    //# constructor
    //##################################################

    private MyEmailTools()
    {
        // singleton
    }

    //##################################################
    //# convenience
    //##################################################

    public ScEnumDropdownField newStatusDropdown()
    {
        ScEnumDropdownField e;
        e = new ScEnumDropdownField();
        e.setLabel("Status");
        e.addOption(MyEmailStatus.Draft);
        e.addOption(MyEmailStatus.Ready);
        e.addOption(MyEmailStatus.Sent);
        e.addOption(MyEmailStatus.Error);
        e.addOption(MyEmailStatus.Ignored);
        return e;
    }
}
