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

import java.awt.Font;

public class KmaFontWrapper
{
    //##################################################
    //# variables
    //##################################################

    private Font _font;

    //##################################################
    //# variables
    //##################################################

    public KmaFontWrapper()
    {
        _font = new Font("Sans Serif", 0, 12);
    }

    public KmaFontWrapper(Font f)
    {
        _font = f;
    }

    //##################################################
    //# accessing
    //##################################################

    public Font getFont()
    {
        return _font;
    }

    public void setFont(Font e)
    {
        _font = e;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public String getName()
    {
        return getFont().getName();
    }

    public void setName(String s)
    {
        _font = new Font(s, getStyle(), getSize());
    }

    public int getStyle()
    {
        return getFont().getStyle();
    }

    public void setStyle(int i)
    {
        _font = new Font(getName(), i, getSize());
    }

    public int getSize()
    {
        return getFont().getSize();
    }

    public void setSize(int i)
    {
        _font = new Font(getName(), getStyle(), i);
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

}
