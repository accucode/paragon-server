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

package com.kodemore.servlet.renderer;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.utility.ScFormatter;
import com.kodemore.utility.KmCompressMemoryIF;
import com.kodemore.utility.KmVirtualOptions;

public abstract class ScRenderer
    implements KmCompressMemoryIF
{
    //##################################################
    //# constants
    //##################################################

    private static final String NONE = KmVirtualOptions.NONE;
    private static final String ANY  = KmVirtualOptions.ANY;

    //##################################################
    //# accessing
    //##################################################

    public abstract void setEmptyText(String e);

    public final void setEmptyTextNone()
    {
        setEmptyText(NONE);
    }

    public final void setEmptyTextAny()
    {
        setEmptyText(ANY);
    }

    //##################################################
    //# render
    //##################################################

    public String render(ScControl parent, Object model)
    {
        KmHtmlBuilder out = new KmHtmlBuilder();
        renderOn(out, parent, model);
        return out.toString();
    }

    public abstract void renderOn(KmHtmlBuilder out, ScControl parent, Object model);

    //##################################################
    //# compress
    //##################################################

    /**
     * @see KmCompressMemoryIF#compressMemory
     */
    @Override
    public void compressMemory()
    {
        // subclass
    }

    //##################################################
    //# support
    //##################################################

    protected String format(Object e)
    {
        return ScFormatter.getInstance().formatAny(e);
    }
}
