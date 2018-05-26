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
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.servlet.renderer.ScRenderer;
import com.kodemore.servlet.variable.ScLocalRenderer;

/**
 * I represent simple html text.
 *
 * I am NOT an element, do NOT have an htmlId
 * and CANNOT be styled or targeted for dynamic ajax.
 *
 * If you need formatting or ajax, use a different class such as
 * ScTextSpan, or ScFieldText.
 *
 * @see ScTextSpan
 * @see ScFieldText
 */
public class ScText
    extends ScControl
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalRenderer _value;

    //##################################################
    //# constructor
    //##################################################

    public ScText()
    {
        _value = new ScLocalRenderer();
    }

    //##################################################
    //# empty text
    //##################################################

    public void setEmptyText(String e)
    {
        _value.setEmptyText(e);
    }

    //##################################################
    //# value
    //##################################################

    public ScRenderer getValue()
    {
        return _value.getValue();
    }

    public void setValue(String e)
    {
        _value.setValue(e);
    }

    public void setFormattedValue(Object e)
    {
        _value.setFormattable(e);
    }

    public void setValue(KmAdaptorIF<?,?> e)
    {
        _value.setAdaptor(e);
    }

    public void setValue(KmMetaAttribute<?,?> e)
    {
        _value.setAttribute(e);
    }

    public void clearValue()
    {
        setValue((String)null);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        _value.renderOn(out, this, getModel());
    }
}
