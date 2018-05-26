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

package com.kodemore.servlet.variable;

import java.util.function.Function;

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.renderer.ScControlRenderer;
import com.kodemore.servlet.renderer.ScFunctionRenderer;
import com.kodemore.servlet.renderer.ScRenderer;
import com.kodemore.servlet.renderer.ScValueRenderer;
import com.kodemore.utility.Kmu;

public class ScLocalRenderer
    extends ScAbstractLocal<ScRenderer>
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

    public void setValue(CharSequence e)
    {
        if ( Kmu.isEmpty(e) )
        {
            clearValue();
            return;
        }

        ScValueRenderer r = new ScValueRenderer(e);
        setValue(r);
    }

    public void setFormattable(Object e)
    {
        if ( e == null )
        {
            clearValue();
            return;
        }

        ScValueRenderer r = new ScValueRenderer(e);
        setValue(r);
    }

    public void setControl(ScControl e)
    {
        if ( e == null )
        {
            clearValue();
            return;
        }

        ScControlRenderer r = new ScControlRenderer(e);
        setValue(r);
    }

    public void setFunction(Function<?,?> e)
    {
        if ( e == null )
        {
            clearValue();
            return;
        }

        ScFunctionRenderer r = new ScFunctionRenderer(e);
        setValue(r);
    }

    public void setAdaptor(KmAdaptorIF<?,?> e)
    {
        if ( e == null )
        {
            clearValue();
            return;
        }

        ScFunctionRenderer r = new ScFunctionRenderer(e);
        setValue(r);
    }

    public void setAttribute(KmMetaAttribute<?,?> e)
    {
        if ( e == null )
        {
            clearValue();
            return;
        }

        ScFunctionRenderer r = new ScFunctionRenderer(e);
        setValue(r);
    }

    //##################################################
    //# empty text
    //##################################################

    public void setEmptyText(String e)
    {
        if ( hasValue() )
            getValue().setEmptyText(e);
    }

    public void setEmptyTextNone()
    {
        if ( hasValue() )
            getValue().setEmptyTextNone();
    }

    public void setEmptyTextAny()
    {
        if ( hasValue() )
            getValue().setEmptyTextAny();
    }

    //##################################################
    //# render
    //##################################################

    public void renderOn(KmHtmlBuilder out, ScControl parent, Object model)
    {
        if ( hasValue() )
            getValue().renderOn(out, parent, model);
    }

}
