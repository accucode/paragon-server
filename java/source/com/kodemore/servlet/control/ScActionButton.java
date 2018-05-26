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
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.variable.ScLocalAction;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalHtmlId;
import com.kodemore.servlet.variable.ScLocalRawFunction;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.KmHtmlLineEnding;
import com.kodemore.utility.Kmu;

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
    private ScLocalString      _confirmationMessageHtml;

    /**
     * By default, the button automatically determines the form
     * to use when composing the action script. If ignoresForm is true,
     * the script's form parameter will be left null. This is useful
     * when you have a button that is inside a form, but you do do NOT
     * want to submit the context of the form with the ajax request.
     */
    private ScLocalBoolean _ignoresForm;

    //##################################################
    //# constructor
    //##################################################

    public ScActionButton()
    {
        _action = new ScLocalAction();
        _argument = new ScLocalRawFunction();
        _extra = new ScLocalString();
        _blockTarget = new ScLocalHtmlId();
        _confirmationMessageHtml = new ScLocalString();
        _ignoresForm = new ScLocalBoolean(false);
    }

    //##################################################
    //# type
    //##################################################

    @Override
    protected String getButtonType()
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

    public String getConfirmationMessageHtml()
    {
        return _confirmationMessageHtml.getValue();
    }

    public void setConfirmationMessageHtml(String html)
    {
        _confirmationMessageHtml.setValue(html);
    }

    public void setConfirmationMessageText(String text)
    {
        String html = Kmu.escapeHtml(text, KmHtmlLineEnding.BreakElement);
        setConfirmationMessageHtml(html);
    }

    //##################################################
    //# ignores form
    //##################################################

    public boolean ignoresForm()
    {
        return _ignoresForm.isTrue();
    }

    public void ignoreForm()
    {
        _ignoresForm.setTrue();
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
    protected String formatEnabledOnClick()
    {
        if ( !hasAction() )
            return null;

        ScActionScript s;
        s = new ScActionScript();
        s.setAction(getAction());
        s.setArgument(getArgument());
        s.setExtra(getExtra());
        s.setForm(getActionForm());
        s.setModel(getModel());
        s.setBlockTarget(getActionBlockTarget());
        s.setConfirmationMessage(getConfirmationMessageHtml());
        return s.formatScript();
    }

    private ScForm getActionForm()
    {
        return ignoresForm()
            ? null
            : findFormWrapper();
    }

    private ScHtmlIdIF getActionBlockTarget()
    {
        return hasBlockTarget()
            ? getBlockTarget()
            : findBlockWrapper();
    }

}
