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

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultConstantsIF;

/**
 * I am used in conjunction with the equalize javascript tool.  When 
 * elements are equalized, they will attempt to distribute the extra
 * space into any filler elements inside the target.  If no filler elements
 * are found, then the original target is resized directly.
 * 
 * This is a simple div designed to fill the remaining available
 * space when equalize is called on the parent container.  This is
 * useful if there is content that should always remain at the bottom
 * after the height of the container is changed.
 */
public class ScEqualizeFiller
    extends ScControl
{
    //##################################################
    //# render 
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.beginDivCss(KmCssDefaultConstantsIF.equalizeFiller);
        out.endDiv();
    }
}
