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

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KmaGridKeyModel
    extends KmaGridModel
    implements KeyListener
{
    //##################################################
    //# instance creation
    //##################################################

    public static KmaGridKeyModel create(KmaGrid g)
    {
        KmaGridKeyModel m;
        m = new KmaGridKeyModel();
        m.setGrid(g);
        return m;
    }

    //##################################################
    //# key listener
    //##################################################

    @Override
    public void keyPressed(KeyEvent ev)
    {
        int c = ev.getKeyCode();
        switch ( c )
        {
            case KeyEvent.VK_LEFT:
                moveLeft(ev);
                break;

            case KeyEvent.VK_RIGHT:
                moveRight(ev);
                break;

            case KeyEvent.VK_UP:
                moveUp(ev);
                break;

            case KeyEvent.VK_DOWN:
                moveDown(ev);
                break;

            case KeyEvent.VK_SPACE:
                space(ev);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ev)
    {
        // ignored
    }

    @Override
    public void keyTyped(KeyEvent ev)
    {
        // ignored
    }

    //##################################################
    //# actions
    //##################################################

    public void moveLeft(KeyEvent ev)
    {
        Point p;
        p = getDot();
        p.x--;
        moveTo(p, ev);
    }

    public void moveRight(KeyEvent ev)
    {
        Point p;
        p = getDot();
        p.x++;
        moveTo(p, ev);
    }

    public void moveUp(KeyEvent ev)
    {
        Point p;
        p = getDot();
        p.y--;
        moveTo(p, ev);
    }

    public void moveDown(KeyEvent ev)
    {
        Point p;
        p = getDot();
        p.y++;
        moveTo(p, ev);
    }

    //##################################################
    //# testing
    //##################################################

    public boolean contains(Point p)
    {
        if ( p.x < 0 )
            return false;

        if ( p.y < 0 )
            return false;

        KmaGrid grid = getGrid();

        if ( p.x >= grid.getColumnCount() )
            return false;

        if ( p.y >= grid.getRowCount() )
            return false;

        return true;
    }

    //##################################################
    //# move (types)
    //##################################################

    public void moveTo(Point p, KeyEvent ev)
    {
        if ( !contains(p) )
            return;

        boolean shift = ev.isShiftDown();
        boolean control = ev.isControlDown();
        KmaGridActionModel a = getActionModel();

        if ( shift && control )
        {
            a.extendToggleSelection();
            a.setDot(p);
            a.extendToggleSelection();
            a.fireSelectActions();

            getGrid().repaint();
            return;
        }

        if ( control )
        {
            a.setDot(p);
            a.resetAnchor();
            a.toggleDotSelection();
            a.fireSelectActions();

            getGrid().repaint();
            return;
        }

        if ( shift )
        {
            a.setDot(p);
            a.clearSelection();
            a.selectAnchor();
            a.extendSelection();
            a.fireSelectActions();

            getGrid().repaint();
            return;
        }

        a.setDot(p);
        a.resetAnchor();
        getGrid().repaint();
    }

    //##################################################
    //# space (types)
    //##################################################

    public void space(KeyEvent ev)
    {
        KmaGridActionModel a = getActionModel();

        boolean control = ev.isControlDown();
        if ( control )
        {
            a.resetAnchor();
            a.toggleDotSelection();
            a.setHasToggleSelection(false);
            a.fireSelectActions();
        }
        else
        {
            a.resetAnchor();
            a.clearSelection();
            a.selectDot();
            a.fireSelectActions();
        }

        getGrid().repaint();
    }

}
