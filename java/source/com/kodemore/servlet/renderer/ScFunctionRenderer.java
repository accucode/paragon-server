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

package com.kodemore.servlet.renderer;

import java.util.function.Function;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.control.ScControl;

public class ScFunctionRenderer
    extends ScRenderer
{
    //##################################################
    //# variables
    //##################################################

    @SuppressWarnings("rawtypes")
    private Function _function;

    //##################################################
    //# constructor
    //##################################################

    public ScFunctionRenderer(Function<?,?> e)
    {
        _function = e;
    }

    //##################################################
    //# render
    //##################################################

    @SuppressWarnings("unchecked")
    @Override
    public void renderOn(KmHtmlBuilder out, ScControl parent, Object model)
    {
        if ( _function == null )
            return;

        if ( model == null )
            return;

        Object e = _function.apply(model);
        out.print(format(e));
    }
}
