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

package com.kodemore.awt.graph;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class KmaGraphPanel
    extends JComponent
{
    //##################################################
    //# variables
    //##################################################

    private KmaGraphPainter _painter;

    //##################################################
    //# constructor
    //##################################################

    public KmaGraphPanel()
    {
        _painter = new KmaGraphPainter();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmaGraphPainter getPainter()
    {
        return _painter;
    }

    public void setPainter(KmaGraphPainter e)
    {
        _painter = e;
    }

    //##################################################
    //# paint
    //##################################################

    @Override
    public void paintComponent(Graphics g)
    {
        _painter.setBackgroundColor(getBackground());
        _painter.setBounds(getClientBounds());
        _painter.paintOn((Graphics2D)g);
    }

    public Rectangle getClientBounds()
    {
        Insets i = getInsets();
        int l = i.left;
        int r = i.right;
        int t = i.top;
        int b = i.bottom;
        int w = getWidth();
        int h = getHeight();

        return new Rectangle(l, t, w - l - r - 1, h - t - b - 1);
    }

}
