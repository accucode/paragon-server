/*
  Copyright (c) 2005-2013 www.kodemore.com

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

import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.variable.ScLocalAction;
import com.kodemore.servlet.variable.ScLocalHtmlId;
import com.kodemore.servlet.variable.ScLocalObject;
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

    private ScLocalAction _action;
    private ScLocalObject _argument;
    private ScLocalString _extra;
    private ScLocalHtmlId _blockTarget;
    private ScLocalString _confirmationMessage;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _action = new ScLocalAction();
        _argument = new ScLocalObject();
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

    public ScActionIF getAction()
    {
        return _action.getValue();
    }

    public void setAction(ScActionIF e)
    {
        _action.setValue(e);
    }

    public void setAction(ScActionIF e, Object arg)
    {
        setAction(e);
        setArgument(arg);
    }

    public boolean hasAction()
    {
        return _action.hasValue();
    }

    public Object getArgument()
    {
        return _argument.getValue();
    }

    public void setArgument(Object e)
    {
        _argument.setValue(e);
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
