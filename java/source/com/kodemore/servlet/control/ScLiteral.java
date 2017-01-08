/*
  Copyright (c) 2005-2016 www.kodemore.com

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

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.variable.ScLocalRawFunction;

public class ScLiteral
    extends ScControl
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalRawFunction _function;

    //##################################################
    //# constructor
    //##################################################

    public ScLiteral()
    {
        _function = new ScLocalRawFunction();
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.printLiteral(formatHtml());
    }

    private String formatHtml()
    {
        if ( !_function.hasValue() )
            return "";

        Object e = _function.apply(getModel());
        return getFormatter().formatAny(e);
    }

    //##################################################
    //# accessing
    //##################################################

    public void setValue(Object e)
    {
        _function.setValue(ScUtility.toFunction(e));
    }

    public void setValue(KmHtmlBuilder e)
    {
        setValue(e.formatHtml());
    }

    public void clearValue()
    {
        _function.clearValue();
    }

}
