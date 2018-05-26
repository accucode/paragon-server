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

package com.kodemore.servlet.control.layout;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;

public abstract class ScLayoutRenderer
{
    //##################################################
    //# tag
    //##################################################

    /**
     * Default returns 'div'.
     */
    public String getTag()
    {
        return "div";
    }

    //##################################################
    //# style
    //##################################################

    /**
     * Apply additional css. Default does nothing.
     * @param css
     */
    public void applyCss(KmCssDefaultBuilder css)
    {
        // none
    }

    /**
     * Apply additional style. Default does nothing.
     * @param style
     */
    public void applyStyle(KmStyleBuilder style)
    {
        // none
    }

    //##################################################
    //# render
    //##################################################

    public abstract void renderChildrenOn(KmHtmlBuilder out, ScLayout layout);

    /**
     * Render any scripts required by this layout.
     * Default does nothing.
     * @param out
     * @param layout
     */
    public void renderScriptsOn(KmHtmlBuilder out, ScLayout layout)
    {
        // none
    }

}
