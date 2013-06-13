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

package com.kodemore.awt.grid;

import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Rectangle;

public class KmaGridColumnHeader
    extends KmaGridAbstractHeader
{
    //##################################################
    //# instance creation
    //##################################################

    public static KmaGridColumnHeader create(KmaGrid g, int i)
    {
        KmaGridColumnHeader h;
        h = new KmaGridColumnHeader();
        h.setGrid(g);
        h.setSize(i);
        h.setCellRenderer(new KmaGridDefaultHeaderCellRenderer());
        return h;
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public Rectangle getBounds()
    {
        KmaGrid grid = getGrid();

        Rectangle r;
        r = grid.getDataBounds();
        r.height = isVisible()
            ? getSize()
            : 0;

        KmaGridHeaderIF gh = grid.getRowHeader();
        if ( gh.isVisible() )
        {
            int w = gh.getSize();
            r.x += w;
            r.width -= w;
        }
        return r;
    }

    //##################################################
    //# paint
    //##################################################

    @Override
    public void paint(Graphics g)
    {
        if ( !isVisible() )
            return;

        Rectangle oldClip = g.getClipBounds();
        Rectangle r = getBounds();
        g.clipRect(r.x, r.y, r.width, r.height);

        KmaGrid grid = getGrid();

        Component c = null;
        Container p = grid.getParent();
        Object value = null;
        boolean isSelected = false;
        boolean hasFocus = false;

        int x = r.x;
        int y = r.y;
        int h = r.height;
        int w = 0;
        int dx = getCellGap();

        int yy = -1;
        int x1 = grid.getFirstVisibleColumn();
        int x2 = grid.getLastVisibleColumn();
        for ( int xx = x1; xx <= x2; xx++ )
        {
            value = grid.getColumnHeaderValueAt(xx);
            w = grid.getColumnWidthAt(xx);
            c = getCellRenderer().getCellRendererFor(this, value, isSelected, hasFocus, xx, yy);
            grid.getCellRendererPane().paintComponent(g, c, p, x, y, w, h, false);
            x += w + dx;
        }
        g.setClip(oldClip);
    }

}
