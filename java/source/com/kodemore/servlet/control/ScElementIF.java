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

import com.kodemore.servlet.field.ScHtmlIdIF;

public interface ScElementIF
    extends ScHtmlIdIF
{
    //##################################################
    //# html id
    //##################################################

    // see super

    //##################################################
    //# show / hide
    //##################################################

    /**
     * These should be implemented by updating the html STYLE, not the CSS.
     * E.g.: this.style().show().  If the subclass instead attempts to control
     * visibility by applying it to the css it can interfere with other css rules.
     *
     * The issue is that visibility is controlled via the 'display' attribute;
     * and to hide something we set display:none.  But display is also used for other
     * things such as block, inline, and flex.  Overriding visibility on the style
     * allows jquery to reinspect the css classes and correctly figure out the correct
     * display value.
     */
    void show();

    void hide();

}
