package com.app.model;

import org.apache.log4j.Level;

import com.kodemore.servlet.field.ScDropdown;

import com.app.model.base.MySystemLogToolsBase;

/**
 * Miscellaneous tools for use with the model.
 */
public class MySystemLogTools
    extends MySystemLogToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MySystemLogTools instance = new MySystemLogTools();

    //##################################################
    //# constructor
    //##################################################

    private MySystemLogTools()
    {
        // singleton
    }

    //##################################################
    //# convenience
    //##################################################

    public ScDropdown newLevelDropdown()
    {
        ScDropdown e;
        e = new ScDropdown();
        e.setLabel("Level");

        addOption(e, Level.DEBUG);
        addOption(e, Level.INFO);
        addOption(e, Level.WARN);
        addOption(e, Level.ERROR);
        addOption(e, Level.FATAL);

        return e;
    }

    private void addOption(ScDropdown dd, Level level)
    {
        dd.addOption(level.getSyslogEquivalent(), level.toString());
    }

}
