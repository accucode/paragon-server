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

package com.kodemore.awt;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.AbstractBorder;

public class KmaEtchedBorder
    extends AbstractBorder
{
    //##################################################
    //# constants
    //##################################################

    public static final int RAISED  = 0;
    public static final int LOWERED = 1;

    //##################################################
    //# variables
    //##################################################

    private int             _etchType;
    private Color           _highlight;
    private Color           _shadow;

    //##################################################
    //# constructor
    //##################################################

    public KmaEtchedBorder()
    {
        this(LOWERED);
    }

    public KmaEtchedBorder(int etchType)
    {
        this(etchType, null, null);
    }

    public KmaEtchedBorder(Color highlight, Color shadow)
    {
        this(LOWERED, highlight, shadow);
    }

    public KmaEtchedBorder(int etchType, Color highlight, Color shadow)
    {
        _etchType = etchType;
        _highlight = highlight;
        _shadow = shadow;
    }

    //##################################################
    //# paint
    //##################################################

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
    {
        int w = width;
        int h = height;

        g.translate(x, y);

        g.setColor(_etchType == LOWERED
            ? getShadowColor(c)
            : getHighlightColor(c));
        g.drawRect(0, 0, w - 2, h - 2);

        g.setColor(_etchType == LOWERED
            ? getHighlightColor(c)
            : getShadowColor(c));
        g.drawLine(1, h - 3, 1, 1);
        g.drawLine(1, 1, w - 3, 1);

        g.drawLine(0, h - 1, w - 1, h - 1);
        g.drawLine(w - 1, h - 1, w - 1, 0);

        g.translate(-x, -y);
    }

    @Override
    public Insets getBorderInsets(Component c)
    {
        return new Insets(2, 2, 2, 2);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets)
    {
        insets.left = insets.top = insets.right = insets.bottom = 2;
        return insets;
    }

    @Override
    public boolean isBorderOpaque()
    {
        return true;
    }

    public int getEtchType()
    {
        return _etchType;
    }

    public Color getHighlightColor(Component c)
    {
        return _highlight != null
            ? _highlight
            : c.getBackground().brighter();
    }

    public Color getShadowColor(Component c)
    {
        return _shadow != null
            ? _shadow
            : c.getBackground().darker();
    }

}
