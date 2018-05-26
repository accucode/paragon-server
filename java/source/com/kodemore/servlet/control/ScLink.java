/*
  Copyright (c) 2005-2018 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
*/

package com.kodemore.servlet.control;

import java.util.function.Function;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.variable.ScLocalAction;
import com.kodemore.servlet.variable.ScLocalRawFunction;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

/**
 * The typical link that we use to run an action.
 */
public class ScLink
    extends ScAbstractLink
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The action to run when the link is clicked.
     */
    private ScLocalAction _action;

    /**
     * The optional argument. This must be an encodeable values (ScEncoder).
     */
    private ScLocalRawFunction _argument;

    /**
     * If set, prompt the user to confirm the action before submitting it.
     * The confirmation is handled via client-side javascript before
     * the action is submitted via ajax.
     */
    private ScLocalString _confirmationMessage;

    /**
     * By default, the action form is automatically detected
     * based on the parent hierarchy. However, in some cases
     * it is useful to set the form manually.
     */
    private ScForm _actionFormOverride;

    //##################################################
    //# constructor
    //##################################################

    public ScLink()
    {
        _action = new ScLocalAction();
        _argument = new ScLocalRawFunction();
        _confirmationMessage = new ScLocalString();
    }

    //##################################################
    //# action
    //##################################################

    public ScAction getAction()
    {
        return _action.getValue();
    }

    public void setAction(ScAction e)
    {
        _action.setValue(e);
    }

    public void setAction(ScAction e, Object arg)
    {
        setAction(e);
        setArgument(arg);
    }

    @SuppressWarnings("rawtypes")
    public void setArgument(Object e)
    {
        Function fn = ScUtility.toFunction(e);
        _argument.setValue(fn);
    }

    @SuppressWarnings("rawtypes")
    public Function getArgument()
    {
        return _argument.getValue();
    }

    public String getConfirmationMessage()
    {
        return _confirmationMessage.getValue();
    }

    public void setConfirmationMessage(String e)
    {
        _confirmationMessage.setValue(e);
    }

    //##################################################
    //# action form override
    //##################################################

    public ScForm getActionFormOverride()
    {
        return _actionFormOverride;
    }

    public void setActionFormOverride(ScForm e)
    {
        _actionFormOverride = e;
    }

    public boolean hasActionFormOverride()
    {
        return _actionFormOverride != null;
    }

    //##################################################
    //# override
    //##################################################

    @Override
    protected String formatTarget()
    {
        return null;
    }

    @Override
    protected String formatEnabledHref()
    {
        return "#";
    }

    @Override
    protected String formatEnabledOnClick()
    {
        ScActionScript s;
        s = new ScActionScript();
        s.setForm(getActionForm());
        s.setAction(getAction());
        s.setArgument(getArgument());
        s.setModel(getModel());
        s.setConfirmationMessage(getConfirmationMessage());

        String prefix = s.formatScript();
        String suffix = "return false;";

        return Kmu.hasValue(prefix)
            ? prefix + suffix
            : suffix;
    }

    private ScForm getActionForm()
    {
        return hasActionFormOverride()
            ? getActionFormOverride()
            : findFormWrapper();
    }

}
