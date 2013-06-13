/*
  Copyright (c) 2005-2011 www.kodemore.com

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

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.json.KmJsonObject;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.encoder.ScEncoder;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.utility.Kmu;

public class ScActionScript
    extends ScAbstractScript
{
    //##################################################
    //# instance creation
    //##################################################

    public static ScActionScript create(ScActionIF action)
    {
        ScActionScript e;
        e = new ScActionScript();
        e.setAction(action);
        return e;
    }

    public static ScActionScript create(ScActionIF action, ScForm form)
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
    private ScActionIF _action;

    /**
     * The optional form.  This needs to be set in order for
     * field values to be submitted.
     */
    private ScForm     _form;

    /**
     * The optional argument; this value is encoded to a string
     * using the ScEncoder.
     */
    private Object     _argument;

    /**
     * The optional model.  This is used for arguments that dynamically
     * evaluate their value based on a model.
     */
    private Object     _model;

    /**
     * If set, the client will block the target element prior
     * to submitting the ajax request.
     */
    private ScHtmlIdIF _blockTarget;

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

    public ScActionIF getAction()
    {
        return _action;
    }

    public void setAction(ScActionIF e)
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

    public Object getArgument()
    {
        return _argument;
    }

    public void setArgument(Object e)
    {
        _argument = e;
    }

    @SuppressWarnings(
    {
        "unchecked",
        "rawtypes"
    })
    private Object evalArgument()
    {
        Object e = getArgument();

        if ( e instanceof KmMetaAttribute )
            e = ((KmMetaAttribute)e).getAdaptor();

        if ( e instanceof KmAdaptorIF )
        {
            KmAdaptorIF a = (KmAdaptorIF)e;
            e = a.getValue(getModel());
        }

        return e;
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
    //# format
    //##################################################

    @Override
    public String formatScript()
    {
        if ( !hasAction() )
            return null;

        KmJsonObject args;
        args = new KmJsonObject();

        args.setString("action", getAction().getKey());

        Object arg = evalArgument();
        if ( arg != null )
            args.setString("argument", ScEncoder.staticEncode(arg));

        if ( hasForm() )
            args.setString("form", getForm().formatJquerySelector());

        if ( hasBlockTarget() )
            args.setString("block", getBlockTarget().formatJquerySelector());

        return Kmu.format("Kmu.ajax(%s);", args);
    }

}
