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

package com.kodemore.awt.grid;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JScrollBar;

import com.kodemore.awt.KmaLayout;

public class KmaGridLayout
    extends KmaLayout
{
    @Override
    public void layoutContainer(Container parent)
    {
        KmaGrid g = (KmaGrid)parent;
        Rectangle r = g.getInsetBounds();
        JScrollBar vsb = g.getVerticalScrollBar();
        JScrollBar hsb = g.getHorizontalScrollBar();

        int vw = vsb.getPreferredSize().width;
        int vh = r.height;
        int vx = r.x + r.width - vw;
        int vy = r.y;

        int hw = r.width;
        int hh = hsb.getPreferredSize().height;
        int hx = r.x;
        int hy = r.y + r.height - hh;

        if ( vsb.isVisible() && hsb.isVisible() )
        {
            vh -= hh - 2;
            hw -= vw - 2;
        }

        if ( g.getRowHeader().isVisible() )
        {
            int n = g.getRowHeader().getSize();
            hx += n;
            hw -= n;
        }

        if ( g.getColumnHeader().isVisible() )
        {
            int n = g.getColumnHeader().getSize();
            vy += n;
            vh -= n;
        }

        vsb.setBounds(vx, vy, vw, vh);
        hsb.setBounds(hx, hy, hw, hh);
    }

    @Override
    public Dimension _getSize(Container parent)
    {
        return new Dimension(200, 200);
    }

}
