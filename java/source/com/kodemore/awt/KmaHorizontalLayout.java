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

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;

public class KmaHorizontalLayout
    extends KmaLayout
    implements KmaAwtConstants
{
    //##################################################
    //# variables
    //##################################################

    private int _gap;
    private int _verticalAlignment;
    private int _horizontalAlignment;

    //##################################################
    //# constructors
    //##################################################

    public KmaHorizontalLayout()
    {
        _gap = 0;
        _verticalAlignment = FILL;
        _horizontalAlignment = CENTER;
    }

    //##################################################
    //# accessing
    //##################################################

    public void setGap(int i)
    {
        _gap = i;
    }

    public int getVerticalAlignment()
    {
        return _verticalAlignment;
    }

    public void setVerticalAlignment(int i)
    {
        _verticalAlignment = i;
    }

    public int getHorizontalAlignment()
    {
        return _horizontalAlignment;
    }

    public void setHorizontalAlignment(int i)
    {
        _horizontalAlignment = i;
    }

    //##################################################
    //# layout
    //##################################################

    @Override
    public Dimension _getSize(Container parent)
    {
        int w = 0;
        int h = 0;
        Insets insets = parent.getInsets();
        int n = parent.getComponentCount();
        for ( int i = 0; i < n; i++ )
        {
            Component c = parent.getComponent(i);
            if ( !c.isVisible() )
                continue;
            Dimension d = c.getPreferredSize();
            w += d.width;
            if ( h < d.height )
                h = d.height;
        }
        return new Dimension(insets.left + insets.right + w + (n - 1) * _gap, insets.top
            + insets.bottom
            + h);
    }

    @Override
    public void layoutContainer(Container parent)
    {
        Insets insets = parent.getInsets();
        int left = insets.left;
        int top = insets.top;
        int right = parent.getSize().width - insets.right;
        int bottom = parent.getSize().height - insets.bottom;
        int width = right - left;
        int prefWidth = _getSize(parent).width;
        int xOffset = 0;
        if ( _horizontalAlignment == RIGHT )
            xOffset = width - prefWidth;
        if ( _horizontalAlignment == CENTER )
            xOffset = (width - prefWidth) / 2;
        if ( xOffset < 0 )
            xOffset = 0;
        int x = left + xOffset;
        int h = bottom - top;
        int n = parent.getComponentCount();
        for ( int i = 0; i < n; i++ )
        {
            Component c = parent.getComponent(i);
            if ( !c.isVisible() )
                continue;
            Dimension d = c.getPreferredSize();
            if ( _verticalAlignment == FILL )
                c.setBounds(x, top, d.width, h);
            else
            {
                int hh = h - d.height;
                if ( _verticalAlignment == TOP )
                    c.setBounds(x, top, d.width, d.height);
                if ( _verticalAlignment == CENTER )
                    c.setBounds(x, top + hh / 2, d.width, d.height);
                if ( _verticalAlignment == BOTTOM )
                    c.setBounds(x, top + hh - 1, d.width, d.height);
            }
            x += d.width + _gap;
        }
    }
}
