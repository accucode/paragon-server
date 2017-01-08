package com.app.model;

import org.apache.log4j.Level;

import com.kodemore.servlet.field.ScDropdownField;

import com.app.model.base.MyApplicationLogToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyApplicationLogTools
    extends MyApplicationLogToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyApplicationLogTools instance = new MyApplicationLogTools();

    //##################################################
    //# constructor
    //##################################################

    private MyApplicationLogTools()
    {
        // singleton
    }

    //##################################################
    //# convenience
    //##################################################

    public ScDropdownField<Integer> newLevelDropdown()
    {
        ScDropdownField<Integer> e;
        e = new ScDropdownField<>();
        e.setLabel("Level");

        addOptionTo(e, Level.DEBUG);
        addOptionTo(e, Level.INFO);
        addOptionTo(e, Level.WARN);
        addOptionTo(e, Level.ERROR);
        addOptionTo(e, Level.FATAL);

        return e;
    }

    private void addOptionTo(ScDropdownField<Integer> dd, Level level)
    {
        dd.addOption(level.getSyslogEquivalent(), level.toString());
    }

}
