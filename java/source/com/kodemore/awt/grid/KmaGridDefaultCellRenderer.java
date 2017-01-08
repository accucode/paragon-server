/*
  Copyright (c) 2005-2016 www.kodemore.com

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

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class KmaGridDefaultCellRenderer
    extends KmaGridLabelCellRenderer
{
    //##################################################
    //# variables
    //##################################################

    private Border _focusBorder;
    private Border _emptyBorder;

    //##################################################
    //# initialize
    //##################################################

    @Override
    public void initialize()
    {
        super.initialize();

        setBackground(getSelectionColor());
        int i = getFocusBorderWidth();
        Color c = getFocusBorderColor();

        _focusBorder = BorderFactory.createLineBorder(c, i);
        _emptyBorder = BorderFactory.createEmptyBorder(i, i, i, i);
    }

    //##################################################
    //# accessing
    //##################################################

    public Color getSelectionColor()
    {
        return Color.yellow;
    }

    public Color getFocusBorderColor()
    {
        return Color.red;
    }

    public int getFocusBorderWidth()
    {
        return 2;
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
        Border b = hasFocus
            ? _focusBorder
            : _emptyBorder;

        setBorder(b);
        setOpaque(isSelected);
        String s = getTextFor(x, y, value);
        setText(s);

        return this;
    }

    @Override
    public String getTextFor(int x, int y, Object value)
    {
        return value == null
            ? ""
            : value + "";
    }

}
