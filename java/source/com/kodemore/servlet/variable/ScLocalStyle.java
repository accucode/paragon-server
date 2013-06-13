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

import com.kodemore.html.KmStyleBuilder;

/**
 * I am used to store the "style" attribute in html elements.
 * E.g.: <div style="...">
 * 
 * We commonly use multiple style values for a single elements.
 * E.g.: <div style="width:100px;height:100px;"
 */
public class ScLocalStyle
    extends ScLocalString
{
    //##################################################
    //# constructor
    //##################################################

    public ScLocalStyle()
    {
        super();
    }

    //##################################################
    //# convenience 
    //##################################################

    public KmStyleBuilder toBuilder()
    {
        return new KmStyleBuilder(this);
    }
}
