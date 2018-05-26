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

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.collection.KmList;
import com.kodemore.exception.error.KmErrorIF;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.servlet.variable.ScLocalStringList;
import com.kodemore.utility.Kmu;

/**
 * I represent read only text for views that display 'field' oriented
 * information.  Similar to a text SPAN, I am always rendered with
 * an enclosing element which allows me to be dynamically updated,
 * or hidden.  I render an an inline (vs block) element, and automatically
 * display the standard help icon for any attached help message.
 */
public class ScFieldText
    extends ScDivWrapper
{
    //##################################################
    //# variables
    //##################################################

    private ScImage    _helpImage;
    private ScTextSpan _text;

    /**
     * The list of errors currently associated with this field.
     */
    private ScLocalStringList _errors;

    //##################################################
    //# constructor
    //##################################################

    public ScFieldText()
    {
        css().fieldText();

        ScDiv root;
        root = getInner();
        root.add(createHelpImage());
        root.add(createText());

        _errors = new ScLocalStringList();
    }

    //==================================================
    //= constructor :: support
    //==================================================

    private ScControl createHelpImage()
    {
        ScImage e;
        e = new ScImage();
        e.css().helpTriangle().helpTooltip();
        e.setSource(getUrls().getHelpTriangleUrl());
        e.hide();
        _helpImage = e;
        return e;
    }

    private ScControl createText()
    {
        ScTextSpan e;
        e = new ScTextSpan();
        _text = e;
        return e;
    }

    //##################################################
    //# empty text
    //##################################################

    public void setEmptyText(String e)
    {
        _text.setEmptyText(e);
    }

    public void setEmptyTextNone()
    {
        _text.setEmptyTextNone();
    }

    public void setEmptyTextAny()
    {
        _text.setEmptyTextAny();
    }

    //##################################################
    //# value
    //##################################################

    public void setValue(String e)
    {
        _text.setValue(e);
    }

    public void setFormattedValue(Object e)
    {
        _text.setFormattedValue(e);
    }

    public void setValue(KmAdaptorIF<?,?> e)
    {
        _text.setValue(e);
    }

    public void setValue(KmMetaAttribute<?,?> e)
    {
        _text.setValue(e);
    }

    public void clearValue()
    {
        _text.clearValue();
    }

    //##################################################
    //# errors
    //##################################################

    public final KmList<String> getErrors()
    {
        return _errors.getValue();
    }

    @Override
    public final boolean hasErrors()
    {
        return _errors.isNotEmpty() || super.hasErrors();
    }

    /**
     * Add an error message to this field, but do NOT throw an exception.
     * The client can later check for, and display the error messages with checkErrors.
     *
     * @see #checkErrors
     */
    public final void addError(String format, Object... args)
    {
        String s = Kmu.format(format, args);
        _errors.add(s);
    }

    public final void clearErrors()
    {
        _errors.resetValue();
    }

    public final void setError(String msg, Object... args)
    {
        clearErrors();
        addError(msg, args);
    }

    public final void addError(KmErrorIF e)
    {
        addError(e.formatProblem());
    }

    @Override
    public final void collectErrorsOn(KmList<String> v)
    {
        super.collectErrorsOn(v);

        v.addAll(_errors.getValue());
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxClearValue()
    {
        _text.ajaxClearText();
    }

    public void ajaxSetValue(String e)
    {
        _text.ajaxSetText(e);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        preRenderHelp();
    }

    private void preRenderHelp()
    {
        if ( !hasHelp() )
            return;

        _helpImage.setHoverText(getHelp());
        _helpImage.show();
    }

}
