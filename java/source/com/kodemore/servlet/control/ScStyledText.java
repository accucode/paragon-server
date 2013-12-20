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

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.servlet.variable.ScLocalRenderer;

/**
 * I am used to manage styled text.  I am in inline element
 * and apply styling via a span element.
 */
public class ScStyledText
    extends ScElement
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalRenderer _value;

    //##################################################
    //# constructor
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _value = new ScLocalRenderer();
    }

    //##################################################
    //# value
    //##################################################

    public ScRenderer getValue()
    {
        return _value.getValue();
    }

    public void setValue(CharSequence e)
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

    //##################################################
    //# print
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.open("span");
        renderAttributesOn(out);
        out.close();

        _value.renderOn(out, this);

        out.end("span");
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxSetText(String value)
    {
        getRootScript().setText(this, value);
    }
}
