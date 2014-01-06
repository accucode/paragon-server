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

import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.variable.ScLocalAction;
import com.kodemore.servlet.variable.ScLocalObject;
import com.kodemore.servlet.variable.ScLocalString;

/**
 * The typical link that we use to run an action.
 */
public class ScLink
    extends ScAbstractLink
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalAction _action;
    private ScLocalObject _argument;
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
        _confirmationMessage = new ScLocalString();
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

    public void setArgument(Object e)
    {
        _argument.setValue(e);
    }

    public Object getArgument()
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
    //# override
    //##################################################

    @Override
    protected String formatTarget()
    {
        return null;
    }

    @Override
    protected String formatHref()
    {
        return "#";
    }

    @Override
    protected String formatOnClick()
    {
        String suffix = "return false;";

        ScForm form;
        form = findFormWrapper();

        ScActionScript s;
        s = new ScActionScript();
        s.setForm(form);
        s.setAction(getAction());
        s.setArgument(getArgument());
        s.setModel(getModel());
        s.setConfirmationMessage(getConfirmationMessage());

        String prefix;
        prefix = s.formatScript();

        return prefix == null
            ? suffix
            : prefix + suffix;
    }

}
