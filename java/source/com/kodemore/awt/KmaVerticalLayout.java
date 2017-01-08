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

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;

public class KmaVerticalLayout
    extends KmaLayout
    implements KmaAwtConstants
{
    //##################################################
    //# variables
    //##################################################

    private int _gap;
    private int _horizontalAlignment;
    private int _verticalAlignment;

    //##################################################
    //# constructors
    //##################################################

    public KmaVerticalLayout()
    {
        _gap = 0;
        _horizontalAlignment = FILL;
        _verticalAlignment = TOP;
    }

    //##################################################
    //# accessing
    //##################################################

    public int getGap()
    {
        return _gap;
    }

    public void setGap(int i)
    {
        _gap = i;
    }

    public int getHorizontalAlignment()
    {
        return _horizontalAlignment;
    }

    public void setHorizontalAlignment(int i)
    {
        _horizontalAlignment = i;
    }

    public int getVerticalAlignment()
    {
        return _verticalAlignment;
    }

    public void setVerticalAlignment(int i)
    {
        _verticalAlignment = i;
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
            h += d.height;

            if ( w < d.width )
                w = d.width;
        }

        int ww = insets.left + insets.right + w;
        int hh = insets.top + insets.bottom + h + (n - 1) * _gap;
        return new Dimension(ww, hh);
    }

    @Override
    public void layoutContainer(Container parent)
    {
        Insets insets = parent.getInsets();
        int left = insets.left;
        int top = insets.top;
        int right = parent.getSize().width - insets.right;
        int bottom = parent.getSize().height - insets.bottom;
        int height = bottom - top;
        int prefHeight = _getSize(parent).height;
        int yOffset = 0;

        if ( _verticalAlignment == BOTTOM )
            yOffset = height - prefHeight;

        if ( _verticalAlignment == CENTER )
            yOffset = (height - prefHeight) / 2;

        if ( yOffset < 0 )
            yOffset = 0;

        int w = right - left;
        int y = top + yOffset;
        int n = parent.getComponentCount();

        for ( int i = 0; i < n; i++ )
        {
            Component c = parent.getComponent(i);
            if ( !c.isVisible() )
                continue;

            Dimension d = c.getPreferredSize();
            if ( _horizontalAlignment == FILL )
                c.setBounds(left, y, w, d.height);
            else
            {
                int ww = w - d.width;
                if ( _horizontalAlignment == LEFT )
                    c.setBounds(left, y, d.width, d.height);

                if ( _horizontalAlignment == CENTER )
                    c.setBounds(left + ww / 2, y, d.width, d.height);

                if ( _horizontalAlignment == RIGHT )
                    c.setBounds(left + ww - 1, y, d.width, d.height);
            }

            y += d.height + _gap;
        }
    }
}
