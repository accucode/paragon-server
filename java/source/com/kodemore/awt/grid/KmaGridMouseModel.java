/*
  Copyright (c) 2005-2013 www.kodemore.com

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

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class KmaGridMouseModel
    extends KmaGridModel
    implements MouseListener, MouseMotionListener
{
    //##################################################
    //# instance creation
    //##################################################

    public static KmaGridMouseModel create(KmaGrid g)
    {
        KmaGridMouseModel m;
        m = new KmaGridMouseModel();
        m.setGrid(g);
        return m;
    }

    //##################################################
    //# mouse listener
    //##################################################

    @Override
    public void mousePressed(MouseEvent ev)
    {
        KmaGrid grid;
        grid = getGrid();
        grid.requestFocus();

        Point p = grid.getCellForXY(ev.getPoint());
        if ( p == null )
            return;

        boolean control = ev.isControlDown();
        boolean shift = ev.isShiftDown();
        KmaGridActionModel m = getActionModel();

        if ( control )
        {
            m.setDot(p);
            m.resetAnchor();
            m.toggleAnchorSelection();
            m.fireSelectActions();
        }
        else
            if ( shift )
            {
                m.setDot(p);
                m.clearSelection();
                m.selectAnchor();
                m.extendSelection();
                m.fireSelectActions();
            }
            else
            {
                m.setDot(p);
                m.resetAnchor();
                m.clearSelection();
                m.selectDot();
                m.fireSelectActions();
            }
        repaintGrid();
    }

    @Override
    public void mouseDragged(MouseEvent ev)
    {
        Point p = getGrid().getCellForXY(ev.getPoint());
        if ( p == null )
            return;

        KmaGridActionModel m = getActionModel();
        if ( m.isDot(p) )
            return;

        m.setDot(p);
        m.extendSelection();
        m.fireSelectActions();
        repaintGrid();
    }

    @Override
    public void mouseClicked(MouseEvent ev)
    {
        int n = ev.getClickCount();
        if ( n > 1 )
            getActionModel().fireAcceptActions();
    }

    @Override
    public void mouseReleased(MouseEvent ev)
    {
        // ignored }
    }

    @Override
    public void mouseEntered(MouseEvent ev)
    {
        // ignored
    }

    @Override
    public void mouseExited(MouseEvent ev)
    {
        // ignored
    }

    @Override
    public void mouseMoved(MouseEvent ev)
    {
        // ignored
    }

}
