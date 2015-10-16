/*
  Copyright (c) 2005-2014 www.kodemore.com

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
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.variable.ScLocalAction;
import com.kodemore.servlet.variable.ScLocalHtmlId;
import com.kodemore.servlet.variable.ScLocalRawFunction;
import com.kodemore.servlet.variable.ScLocalString;

/**
 * The typical button that we use to run an action.
 */
public class ScActionButton
    extends ScButton
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalAction      _action;
    private ScLocalRawFunction _argument;
    private ScLocalString      _extra;
    private ScLocalHtmlId      _blockTarget;
    private ScLocalString      _confirmationMessage;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _action = new ScLocalAction();
        _argument = new ScLocalRawFunction();
        _extra = new ScLocalString();
        _blockTarget = new ScLocalHtmlId();
        _confirmationMessage = new ScLocalString();
    }

    //##################################################
    //# type
    //##################################################

    @Override
    protected String formatHtmlType()
    {
        return "button";
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

    public ScAction setAction(Runnable r)
    {
        ScAction a = newAction(r);
        _action.setValue(a);
        return a;
    }

    public void setAction(ScAction e, Object arg)
    {
        setAction(e);
        setArgument(arg);
    }

    public boolean hasAction()
    {
        return _action.hasValue();
    }

    @SuppressWarnings("rawtypes")
    public Function getArgument()
    {
        return _argument.getValue();
    }

    @SuppressWarnings("rawtypes")
    public void setArgument(Object e)
    {
        Function fn = ScUtility.toFunction(e);
        _argument.setValue(fn);
    }

    public String getExtra()
    {
        return _extra.getValue();
    }

    public void setExtra(String e)
    {
        _extra.setValue(e);
    }

    public String getConfirmationMessage()
    {
        return _confirmationMessage.getValue();
    }

    public void setConfirmationMessage(String e)
    {
        _confirmationMessage.setValue(e);
    }

    public void disableChangeTracking()
    {
        if ( hasAction() )
            getAction().disableChangeTracking();
    }

    //##################################################
    //# block
    //##################################################

    public ScHtmlIdIF getBlockTarget()
    {
        return _blockTarget.getHtmlId();
    }

    public void setBlockTarget(ScHtmlIdIF e)
    {
        _blockTarget.setHtmlId(e);
    }

    public boolean hasBlockTarget()
    {
        return _blockTarget.hasValue();
    }

    //##################################################
    //# on click
    //##################################################

    @Override
    protected String formatOnClick()
    {
        if ( !hasAction() )
            return null;

        ScForm form;
        form = findFormWrapper();

        ScHtmlIdIF block = hasBlockTarget()
            ? getBlockTarget()
            : findBlockWrapper();

        ScActionScript s;
        s = new ScActionScript();
        s.setAction(getAction());
        s.setArgument(getArgument());
        s.setExtra(getExtra());
        s.setForm(form);
        s.setModel(getModel());
        s.setBlockTarget(block);
        s.setConfirmationMessage(getConfirmationMessage());

        return s.formatScript();
    }
}
