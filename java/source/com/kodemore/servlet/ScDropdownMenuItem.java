package com.kodemore.servlet;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.script.ScScriptIF;

public class ScDropdownMenuItem
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The text to display.
     */
    private String     _text;

    /**
     * The action to run.
     * The action and href are mutually exclusive.
     */
    private ScScriptIF _script;

    //##################################################
    //# constructor
    //##################################################

    public ScDropdownMenuItem()
    {
        _text = "";
        _script = null;
    }

    //##################################################
    //# text
    //##################################################

    public String getText()
    {
        return _text;
    }

    public void setText(String e)
    {
        _text = e;
    }

    //##################################################
    //# action
    //##################################################

    public ScScriptIF getScript()
    {
        return _script;
    }

    public void setScript(ScScriptIF e)
    {
        _script = e;
    }

    public boolean hasScript()
    {
        return _script != null;
    }

    //##################################################
    //# script (action)
    //##################################################

    public void setAction(ScAction a)
    {
        setAction(a, null);
    }

    public void setAction(ScAction a, Object arg)
    {
        ScActionScript s;
        s = new ScActionScript();
        s.setAction(a);
        s.setArgument(arg);

        setScript(s);
    }

    public String formatScript()
    {
        return hasScript()
            ? getScript().formatScript()
            : "";
    }

}
