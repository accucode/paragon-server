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
import com.kodemore.servlet.variable.ScLocalObject;

public class ScLiteral
    extends ScControl
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalObject _value;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _value = new ScLocalObject();
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        String html = formatHtml();
        if ( html == null )
            return;

        out.printLiteral(html);
    }

    @SuppressWarnings(
    {
        "unchecked",
        "rawtypes"
    })
    private String formatHtml()
    {
        Object value = getValue();

        if ( value instanceof KmAdaptorIF<?,?> )
        {
            Object model = getModel();
            if ( model == null )
                return null;

            KmAdaptorIF adaptor = (KmAdaptorIF)value;
            value = adaptor.getValue(model);
        }

        if ( value == null )
            return null;

        return value.toString();
    }

    //##################################################
    //# accessing
    //##################################################

    public void setValue(String e)
    {
        _value.setValue(e);
    }

    public void setValue(KmHtmlBuilder out)
    {
        setValue(out.toString());
    }

    @SuppressWarnings("rawtypes")
    public void setValue(KmAdaptorIF e)
    {
        _value.setValue(e);
    }

    public Object getValue()
    {
        return _value.getValue();
    }

    public void clearValue()
    {
        _value.resetValue();
    }

}
