package com.app.model;

import org.apache.log4j.Level;

import com.kodemore.servlet.field.ScDropdown;

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
