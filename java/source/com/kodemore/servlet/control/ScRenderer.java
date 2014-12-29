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

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.servlet.utility.ScFormatter;
import com.kodemore.servlet.variable.ScLocalObject;
import com.kodemore.utility.Kmu;

public class ScRenderer
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalObject _value;

    //##################################################
    //# accessing
    //##################################################

    public ScRenderer()
    {
        _value = new ScLocalObject();
    }

    //##################################################
    //# value
    //##################################################

    /**
     * Set the simple string value.  This will be formatted
     * with any escaping required by html.
     */
    public void setValue(String e)
    {
        setFormattable(e);
    }

    /**
     * Set the value to null.
     */
    public void setNull()
    {
        _setValue(null);
    }

    /**
     * Any value handled by ScFormatter.
     */
    public void setFormattable(Object e)
    {
        _setValue(e);

    }

    /**
     * Any control.  The control's model will be set immediately
     * prior to rendering.
     */
    public void setControl(ScControl e)
    {
        _setValue(e);
    }

    /**
     * The adaptor will use the parent control's model to determine
     * the effective value.  The effective value must resolve to
     * either null, or something handled by ScFormatter.
     */
    public void setAdaptor(KmAdaptorIF<?,?> e)
    {
        _setValue(e);
    }

    /**
     * Just a convenience for getting to the adaptor.
     */
    public void setAttribute(KmMetaAttribute<?,?> e)
    {
        setAdaptor(e.getAdaptor());
    }

    public Object getValue()
    {
        return _value.getValue();
    }

    //##################################################
    //# render
    //##################################################

    public String render(ScControl parent, Object model)
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();

        renderOn(out, parent, model);

        return out.toString();
    }

    public void renderOn(KmHtmlBuilder out, ScControl parent)
    {
        renderOn(out, parent, parent.getModel());
    }

    public void renderOn(KmHtmlBuilder out, ScControl parent, Object model)
    {
        Object e = getValue();

        if ( e == null )
        {
            renderNullOn(out);
            return;
        }

        if ( e instanceof ScControl )
        {
            renderControlOn(out, e, parent, model);
            return;
        }

        if ( e instanceof KmAdaptorIF<?,?> )
        {
            renderAdaptorOn(out, e, parent, model);
            return;
        }

        if ( e instanceof KmMetaAttribute<?,?> )
        {
            renderAttributeOn(out, e, parent, model);
            return;
        }

        renderFormattableOn(out, e);
    }

    //##################################################
    //# render (private)
    //##################################################

    /**
     * @param out unused, but defined for subclasses.
     */
    private void renderNullOn(KmHtmlBuilder out)
    {
        // none
    }

    private void renderControlOn(KmHtmlBuilder out, Object oControl, ScControl parent, Object model)
    {
        ScControl c;
        c = (ScControl)oControl;
        c.setParent(parent);
        c.applyFromModel(model);
        c.renderOn(out);
    }

    /**
     * @param parent
     */
    @SuppressWarnings(
    {
        "unchecked", "rawtypes"
    })
    private void renderAdaptorOn(KmHtmlBuilder out, Object oAdaptor, ScControl parent, Object model)
    {
        KmAdaptorIF adaptor = (KmAdaptorIF)oAdaptor;
        if ( model == null )
        {
            renderNullOn(out);
            return;
        }

        Object value = adaptor.getValue(model);
        renderFormattableOn(out, value);
    }

    private void renderAttributeOn(KmHtmlBuilder out, Object oAttr, ScControl parent, Object model)
    {
        KmMetaAttribute<?,?> attr = (KmMetaAttribute<?,?>)oAttr;
        renderAdaptorOn(out, attr.getAdaptor(), parent, model);
    }

    private void renderFormattableOn(KmHtmlBuilder out, Object value)
    {
        String s = getFormatter().formatAny(value);

        if ( Kmu.isEmpty(s) )
        {
            renderNullOn(out);
            return;
        }

        out.print(s);
    }

    //##################################################
    //# support
    //##################################################

    private void _setValue(Object e)
    {
        _value.setValue(e);
    }

    private ScFormatter getFormatter()
    {
        return ScFormatter.getInstance();
    }
}
