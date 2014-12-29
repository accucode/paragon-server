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

package com.kodemore.awt;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Polygon;

import javax.swing.Icon;

public class KmaArrowIcon
    implements Icon
{
    //##################################################
    //# constants
    //##################################################

    public static final int ARROW_NONE    = 0;
    public static final int ARROW_UP      = 1;
    public static final int ARROW_DOWN    = 2;
    public static final int ARROW_LEFT    = 3;
    public static final int ARROW_RIGHT   = 4;

    public static final int ARROW_FILL    = 0;
    public static final int ARROW_OUTLINE = 1;

    //##################################################
    //# variables
    //##################################################

    private int             _arrow;
    private int             _width;
    private int             _height;
    private Insets          _insets;
    private Color           _color;
    private int             _drawMode;

    //##################################################
    //# constructor
    //##################################################

    public KmaArrowIcon()
    {
        _arrow = ARROW_DOWN;
        _width = 16;
        _height = 16;
        _insets = new Insets(4, 4, 4, 4);
        _color = Color.black;
        _drawMode = ARROW_FILL;
    }

    //##################################################
    //# accessing
    //##################################################

    public int getArrow()
    {
        return _arrow;
    }

    public void setArrow(int e)
    {
        _arrow = e;
    }

    public void setArrowNone()
    {
        setArrow(ARROW_NONE);
    }

    public void setArrowUp()
    {
        setArrow(ARROW_UP);
    }

    public void setArrowDown()
    {
        setArrow(ARROW_DOWN);
    }

    public void setArrowLeft()
    {
        setArrow(ARROW_LEFT);
    }

    public void setArrowRight()
    {
        setArrow(ARROW_RIGHT);
    }

    public boolean isArrowNone()
    {
        return getArrow() == ARROW_NONE;
    }

    public boolean isArrowUp()
    {
        return getArrow() == ARROW_UP;
    }

    public boolean isArrowDown()
    {
        return getArrow() == ARROW_DOWN;
    }

    public boolean isArrowLeft()
    {
        return getArrow() == ARROW_LEFT;
    }

    public boolean isArrowRight()
    {
        return getArrow() == ARROW_RIGHT;
    }

    //##################################################
    //# draw style
    //##################################################

    public int getDrawMode()
    {
        return _drawMode;
    }

    public void setDrawMode(int e)
    {
        _drawMode = e;
    }

    public void setFill()
    {
        setDrawMode(ARROW_FILL);
    }

    public void setOutline()
    {
        setDrawMode(ARROW_OUTLINE);
    }

    public boolean isFill()
    {
        return getDrawMode() == ARROW_FILL;
    }

    public boolean isOutline()
    {
        return getDrawMode() == ARROW_OUTLINE;
    }

    //##################################################
    //# size
    //##################################################

    public int getWidth()
    {
        return _width;
    }

    public void setWidth(int e)
    {
        _width = e;
    }

    public int getHeight()
    {
        return _height;
    }

    public void setHeight(int e)
    {
        _height = e;
    }

    //##################################################
    //# insets
    //##################################################

    public Insets getInsets()
    {
        return _insets;
    }

    public void setInsets(Insets e)
    {
        _insets = e;
    }

    public void setInsets(int i)
    {
        setInsets(i, i);
    }

    public void setInsets(int x, int y)
    {
        setInsets(y, x, y, x);
    }

    public void setInsets(int top, int left, int bottom, int right)
    {
        _insets.top = top;
        _insets.left = left;
        _insets.bottom = bottom;
        _insets.right = right;
    }

    //##################################################
    //# color
    //##################################################

    public Color getColor()
    {
        return _color;
    }

    public void setColor(Color e)
    {
        _color = e;
    }

    //##################################################
    //# paint
    //##################################################

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y)
    {
        Color oldColor = g.getColor();
        Insets i = getInsets();

        x += i.left;
        y += i.top;
        int w = getIconWidth() - i.left - i.right;
        int h = getIconHeight() - i.top - i.bottom;

        g.setColor(getColor());
        Polygon p = new Polygon();

        if ( isArrowUp() )
        {
            p.addPoint(x, y + h);
            p.addPoint(x + w / 2, y);
            p.addPoint(x + w, y + h);
        }

        if ( isArrowDown() )
        {
            p.addPoint(x, y);
            p.addPoint(x + w, y);
            p.addPoint(x + w / 2, y + h);
        }

        if ( isArrowLeft() )
        {
            p.addPoint(x, y + h / 2);
            p.addPoint(x + w, y);
            p.addPoint(x + w, y + h);
        }

        if ( isArrowRight() )
        {
            p.addPoint(x, y);
            p.addPoint(x, y + h);
            p.addPoint(x + w, y + h / 2);
        }

        g.drawPolygon(p);

        if ( isFill() )
            g.fillPolygon(p);

        g.setColor(oldColor);
    }

    @Override
    public int getIconWidth()
    {
        return getWidth();
    }

    @Override
    public int getIconHeight()
    {
        return getHeight();
    }
}
