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

import com.kodemore.html.KmCssBuilder;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.servlet.variable.ScLocalCss;

/**
 * I am a horizontal divider used to conveniently display
 * a groove with padding.  I use two nested DIV elements
 * rather than a traditional rule (HR) because horizontal
 * 'rules' do not render consistently across multiple
 * browsers.
 */
public class ScDivider
    extends ScElement
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalCss _innerCss;

    //##################################################
    //# constructor
    //##################################################

    public ScDivider()
    {
        _innerCss = new ScLocalCss();
        setFlavorGroove();
    }

    //##################################################
    //# flavor
    //##################################################

    public void setFlavorBevel()
    {
        _innerCss.toBuilder().divider_inner_bevel();
    }

    public void setFlavorGroove()
    {
        _innerCss.toBuilder().divider_inner_groove();
    }

    //##################################################
    //# inner
    //##################################################

    public KmCssDefaultBuilder innerCss()
    {
        return _innerCss.toBuilder();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.openDiv();
        renderAttributesOn(out);
        out.close();

        out.openDiv();
        out.printAttribute(formatInnerCss());
        out.close();
        out.endDiv();

        out.endDiv();
    }

    private KmCssBuilder formatInnerCss()
    {
        return _innerCss.toBuilder();
    }

}
