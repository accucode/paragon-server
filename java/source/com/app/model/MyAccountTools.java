package com.app.model;

import com.app.model.base.MyAccountToolsBase;

import com.kodemore.servlet.field.ScDropdown;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyAccountTools
    extends MyAccountToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyAccountTools instance = new MyAccountTools();

    //##################################################
    //# constructor
    //##################################################

    private MyAccountTools()
    {
        // singleton
    }

    public ScDropdown newTypeDropdown()
    {
        ScDropdown e;
        e = new ScDropdown();
        e.setLabel("Type");
        e.addOption(MyAccountType.Personal);
        e.addOption(MyAccountType.Business);
        return e;
    }
}
