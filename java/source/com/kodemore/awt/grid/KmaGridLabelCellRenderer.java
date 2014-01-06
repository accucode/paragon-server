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

package com.kodemore.awt.grid;

import java.awt.Component;

import com.kodemore.awt.KmaLabel;

public class KmaGridLabelCellRenderer
    extends KmaLabel
    implements KmaGridCellRendererIF
{
    //##################################################
    //# constructors
    //##################################################

    public KmaGridLabelCellRenderer()
    {
        initialize();
    }

    //##################################################
    //# initialize
    //##################################################

    public void initialize()
    {
        setOpaque(false);
        setHorizontalAlignment(LEFT);
        setVerticalAlignment(CENTER);
    }

    //##################################################
    //# cell renderer
    //##################################################

    @Override
    public Component getCellRendererFor(
        Object source,
        Object value,
        boolean isSelected,
        boolean hasFocus,
        int x,
        int y)
    {
        String s = getTextFor(x, y, value);
        setText(s);
        return this;
    }

    public String getTextFor(int x, int y, Object value)
    {
        return value == null
            ? x + " " + y
            : value + "";
    }

}
