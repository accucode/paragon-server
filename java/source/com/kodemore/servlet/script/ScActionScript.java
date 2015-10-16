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

package com.kodemore.servlet.script;

import java.util.function.Function;

import com.kodemore.json.KmJsonMap;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScUtility;
import com.kodemore.servlet.encoder.ScEncoder;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

public class ScActionScript
    extends ScAbstractScript
{
    //##################################################
    //# instance creation
    //##################################################

    public static ScActionScript create(ScAction action)
    {
        ScActionScript e;
        e = new ScActionScript();
        e.setAction(action);
        return e;
    }

    public static ScActionScript create(ScAction action, ScForm form)
    {
        ScActionScript e;
        e = create(action);
        e.setForm(form);
        e.setBlockTarget(form);
        return e;
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * The primary attribute; the action to run.  If null
     * the resulting script will be null as well.
     */
    private ScAction _action;

    /**
     * The optional form.  This needs to be set in order for
     * field values to be submitted.
     */
    private ScForm _form;

    /**
     * The optional argument; this value is encoded to a string
     * using the ScEncoder.  This is primarily used for situations
     * such as grids or other repeating content, where the same
     * action may be applied to one of many different items.
     */
    @SuppressWarnings("rawtypes")
    private Function _argument;

    /**
     * The optional model.  This is used for arguments that dynamically
     * evaluate their value based on a model.
     */
    private Object _model;

    /**
     * If set, the client will block the target element prior
     * to submitting the ajax request.
     */
    private ScHtmlIdIF _blockTarget;

    /**
     * The optional 'extra' parameter.  This value will be resubmitted
     * along with the action and the argument; but this extra value
     * is NOT encoded or evaluated using the model.
     */
    private String _extra;

    /**
     * The optional confirmation message.  If set, the browser will prompt
     * the user with an ok/cancel dialog before submitting the request.
     */
    private String _confirmationMessage;

    //##################################################
    //# constructor
    //##################################################

    public ScActionScript()
    {
        // none
    }

    //##################################################
    //# action
    //##################################################

    public ScAction getAction()
    {
        return _action;
    }

    public void setAction(ScAction e)
    {
        _action = e;
    }

    public boolean hasAction()
    {
        return _action != null;
    }

    //##################################################
    //# argument
    //##################################################

    public void setArgument(Object e)
    {
        _argument = ScUtility.toFunction(e);
    }

    @SuppressWarnings("unchecked")
    private Object evalArgument()
    {
        if ( _argument == null )
            return null;

        return _argument.apply(getModel());
    }

    //##################################################
    //# extra
    //##################################################

    public String getExtra()
    {
        return _extra;
    }

    public void setExtra(String e)
    {
        _extra = e;
    }

    public boolean hasExtra()
    {
        return Kmu.hasValue(getExtra());
    }

    //##################################################
    //# model
    //##################################################

    public Object getModel()
    {
        return _model;
    }

    public void setModel(Object e)
    {
        _model = e;
    }

    //##################################################
    //# form
    //##################################################

    public ScForm getForm()
    {
        return _form;
    }

    public void setForm(ScForm e)
    {
        _form = e;
    }

    public boolean hasForm()
    {
        return _form != null;
    }

    //##################################################
    //# block
    //##################################################

    public ScHtmlIdIF getBlockTarget()
    {
        return _blockTarget;
    }

    public void setBlockTarget(ScHtmlIdIF e)
    {
        _blockTarget = e;
    }

    public boolean hasBlockTarget()
    {
        return _blockTarget != null;
    }

    //##################################################
    //# confirmation
    //##################################################

    public String getConfirmationMessage()
    {
        return _confirmationMessage;
    }

    public void setConfirmationMessage(String e)
    {
        _confirmationMessage = e;
    }

    public boolean hasConfirmationMessage()
    {
        return Kmu.hasValue(getConfirmationMessage());
    }

    //##################################################
    //# format
    //##################################################

    @Override
    public void formatScriptOn(KmStringBuilder out)
    {
        if ( !hasAction() )
            return;

        KmJsonMap args;
        args = new KmJsonMap();

        args.setString("action", getAction().getKey());

        Object arg = evalArgument();
        if ( arg != null )
            args.setString("argument", ScEncoder.staticEncode(arg));

        if ( hasExtra() )
            args.setString("extra", getExtra());

        if ( hasForm() )
            args.setString("form", getForm().getKey());

        if ( hasBlockTarget() )
            args.setString("block", getBlockTarget().getJquerySelector());

        if ( hasConfirmationMessage() )
            args.setString("confirmation", getConfirmationMessage());

        if ( !getAction().getChangeTracking() )
            args.setBoolean("changeTracking", false);

        out.printf("Kmu.ajax(%s);", args);
    }

}
