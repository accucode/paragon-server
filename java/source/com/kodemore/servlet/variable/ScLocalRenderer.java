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

package com.kodemore.servlet.variable;

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScRenderer;

public class ScLocalRenderer
    extends ScSimpleLocal<ScRenderer>
{
    //##################################################
    //# constructor
    //##################################################

    public ScLocalRenderer()
    {
        super();
    }

    //##################################################
    //# convenience
    //##################################################

    public ScRenderer setValue(String e)
    {
        return setFormattable(e);
    }

    @Override
    public void setNull()
    {
        setFormattable(null);
    }

    public ScRenderer setFormattable(Object e)
    {
        ScRenderer r;
        r = setNewRenderer();
        r.setFormattable(e);
        return r;
    }

    public ScRenderer setControl(ScControl e)
    {
        ScRenderer r;
        r = setNewRenderer();
        r.setControl(e);
        return r;
    }

    @SuppressWarnings("rawtypes")
    public ScRenderer setAdaptor(KmAdaptorIF e)
    {
        ScRenderer r;
        r = setNewRenderer();
        r.setAdaptor(e);
        return r;
    }

    @SuppressWarnings("rawtypes")
    public ScRenderer setAttribute(KmMetaAttribute e)
    {
        ScRenderer r;
        r = setNewRenderer();
        r.setAttribute(e);
        return r;
    }

    //##################################################
    //# render
    //##################################################

    public void renderOn(KmHtmlBuilder out, ScControl parent)
    {
        if ( hasValue() )
            getValue().renderOn(out, parent);
    }

    //##################################################
    //# support
    //##################################################

    private ScRenderer setNewRenderer()
    {
        ScRenderer r;
        r = new ScRenderer();
        setValue(r);
        return r;
    }

}
