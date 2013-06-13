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

import java.awt.Font;

import javax.swing.JLabel;

public class KmaLabel
    extends JLabel
{
    //##################################################
    //# constructors
    //##################################################

    public KmaLabel()
    {
        this("");
    }

    public KmaLabel(String s)
    {
        super(s);
    }

    //##################################################
    //# utility
    //##################################################

    public void clear()
    {
        setText("");
    }

    public void setSize(int i)
    {
        Font f = getFont();
        f = new Font(f.getName(), f.getStyle(), i);
        setFont(f);
    }

    public void setNormal()
    {
        _clearStyle();
    }

    public void setBold()
    {
        setBold(true);
    }

    public void setBold(boolean b)
    {
        _setStyle(Font.BOLD, b);
    }

    public void setItalic()
    {
        setItalic(true);
    }

    public void setItalic(boolean b)
    {
        _setStyle(Font.ITALIC, b);
    }

    //##################################################
    //# alignment
    //##################################################

    public void alignLeft()
    {
        setHorizontalAlignment(LEFT);
    }

    public void alignRight()
    {
        setHorizontalAlignment(RIGHT);
    }

    public void alignCenterX()
    {
        setHorizontalAlignment(CENTER);
    }

    public void alignTop()
    {
        setVerticalAlignment(TOP);
    }

    public void alignBottom()
    {
        setVerticalAlignment(BOTTOM);
    }

    public void alignCenterY()
    {
        setVerticalAlignment(CENTER);
    }

    public void alignCenter()
    {
        alignCenterX();
        alignCenterY();
    }

    //##################################################
    //# utility
    //##################################################

    /**
     * Turn a style flag on or off.
     */
    public void _setStyle(int s, boolean b)
    {
        Font f = getFont();
        int i;
        if ( b )
            i = f.getStyle() | s;
        else
            i = f.getStyle() & ~s;
        f = new Font(f.getName(), i, f.getSize());
        setFont(f);
    }

    public void _clearStyle()
    {
        Font f = getFont();
        f = new Font(f.getName(), 0, f.getSize());
        setFont(f);
    }

    //##################################################
    //# paint
    //##################################################

    public void repaintNow()
    {
        paintImmediately(getBounds());
    }

}
