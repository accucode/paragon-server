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

package com.kodemore.servlet.control;

import com.kodemore.html.KmStyleBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;

/**
 * I define standard methods for styling a control.
 */
public interface ScStyledControlIF
    extends ScControlIF
{
    /**
     * Apply css "classes" to the exterior of the control.
     * This is applied to the HTML DOM via the CLASS attribute.
     *
     * By exterior, we mean the outermost visual boundary between the
     * control and the rest of the html content.  For complex controls
     * that are composed of multiple pieces, this styling should apply
     * to a single wrapper that contains all of the other internal
     * elements.
     *
     * Client code and/or parent controls can safely use this to apply
     * a margin around the entire child.
     */
    KmCssDefaultBuilder css();

    /**
     * Apply css "style" to the exterior of the control.
     * This is applied to the HTML DOM via the STYLE attribute.
     *
     * See css() for additional clarification.
     */
    KmStyleBuilder style();
}
