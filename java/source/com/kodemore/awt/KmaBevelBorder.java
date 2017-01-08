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

package com.kodemore.awt;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;

public class KmaBevelBorder
    extends AbstractBorder
{
    //##################################################
    //# constants
    //##################################################

    public static final int    RAISED         = 0;
    public static final int    LOWERED        = 1;

    public static final Border _raisedBorder  = new KmaBevelBorder(RAISED);
    public static final Border _loweredBorder = new KmaBevelBorder(LOWERED);

    //##################################################
    //# static
    //##################################################

    public static Border getRaisedBorder()
    {
        return _raisedBorder;
    }

    public static Border getLoweredBorder()
    {
        return _loweredBorder;
    }

    //##################################################
    //# variables
    //##################################################

    public int   _bevelType;
    public Color _highlight;
    public Color _shadow;

    //##################################################
    //# constructor
    //##################################################

    public KmaBevelBorder(int bevelType)
    {
        _bevelType = bevelType;
    }

    public KmaBevelBorder(int bevelType, Color highlight, Color shadow)
    {
        _bevelType = bevelType;
        _highlight = highlight;
        _shadow = shadow;
    }

    //##################################################
    //# accessing
    //##################################################

    public int getBevelType()
    {
        return _bevelType;
    }

    public Color getHighlightColor(Component c)
    {
        if ( _highlight != null )
            return _highlight;

        return c.getBackground().brighter();
    }

    public Color getShadowColor(Component c)
    {
        if ( _shadow != null )
            return _shadow;

        return c.getBackground().darker();
    }

    @Override
    public boolean isBorderOpaque()
    {
        return true;
    }

    //##################################################
    //# insets
    //##################################################

    @Override
    public Insets getBorderInsets(Component c)
    {
        return new Insets(1, 1, 1, 1);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets)
    {
        insets.left = 1;
        insets.top = 1;
        insets.right = 1;
        insets.bottom = 1;
        return insets;
    }

    //##################################################
    //# paint
    //##################################################

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int w, int h)
    {
        if ( _bevelType == RAISED )
            paintRaisedBevel(c, g, x, y, w, h);
        else
            if ( _bevelType == LOWERED )
                paintLoweredBevel(c, g, x, y, w, h);
    }

    protected void paintRaisedBevel(Component c, Graphics g, int x, int y, int w, int h)
    {
        Color oldColor = g.getColor();
        g.translate(x, y);

        g.setColor(getHighlightColor(c));
        g.drawLine(0, 0, 0, h - 1);
        g.drawLine(1, 0, w - 1, 0);

        g.setColor(getShadowColor(c));
        g.drawLine(1, h - 1, w - 1, h - 1);
        g.drawLine(w - 1, 1, w - 1, h - 2);

        g.translate(-x, -y);
        g.setColor(oldColor);
    }

    protected void paintLoweredBevel(Component c, Graphics g, int x, int y, int w, int h)
    {
        Color oldColor = g.getColor();
        g.translate(x, y);

        g.setColor(getShadowColor(c));
        g.drawLine(0, 0, 0, h - 1);
        g.drawLine(1, 0, w - 1, 0);

        g.setColor(getHighlightColor(c));
        g.drawLine(1, h - 1, w - 1, h - 1);
        g.drawLine(w - 1, 1, w - 1, h - 2);

        g.translate(-x, -y);
        g.setColor(oldColor);
    }

}
