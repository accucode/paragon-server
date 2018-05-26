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

/**
 * I am a div with a flex row layout.
 * I automatically contain three children: left, center, right.
 *
 * My css includes flexRow, flexAlignSpaced.
 * Clients may safely add additional css to further adjust the layout or style.
 */
public class ScSpacedRow
    extends ScDivWrapper
{
    //##################################################
    //# variables
    //##################################################

    private ScDiv _left;
    private ScDiv _center;
    private ScDiv _right;

    //##################################################
    //# constructor
    //##################################################

    public ScSpacedRow()
    {
        _left = getInner().addDiv();
        _center = getInner().addDiv();
        _right = getInner().addDiv();

        resetCss();
    }

    //##################################################
    //# css
    //##################################################

    public void resetCss()
    {
        css().clear().flexRow().flexAlignSpaced();
    }

    //##################################################
    //# accessing
    //##################################################

    public ScDiv getLeft()
    {
        return _left;
    }

    public ScDiv getCenter()
    {
        return _center;
    }

    public ScDiv getRight()
    {
        return _right;
    }

}
