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

import java.awt.Font;

public class KmaGraphFont
{
    //##################################################
    //# variables
    //##################################################

    private String  _name;
    private boolean _bold;
    private boolean _italic;
    private int     _size;
    private Font    _font;

    //##################################################
    //# constructor
    //##################################################

    public KmaGraphFont()
    {
        beSansSerif();
        bePlain();
        setSize(10);
    }

    //##################################################
    //# name
    //##################################################

    public String getName()
    {
        return _name;
    }

    public void setName(String e)
    {
        _name = e;
        _font = null;
    }

    public void beSansSerif()
    {
        setName("SansSerif");
    }

    //##################################################
    //# style
    //##################################################

    public boolean isBold()
    {
        return _bold;
    }

    public void beBold()
    {
        beBold(true);
    }

    public void beBold(boolean e)
    {
        _bold = e;
        _font = null;
    }

    public boolean isItalic()
    {
        return _italic;
    }

    public void beItalic()
    {
        beItalic(true);
    }

    public void beItalic(boolean e)
    {
        _italic = e;
        _font = null;
    }

    public void bePlain()
    {
        beBold(false);
        beItalic(false);
    }

    public boolean isPlain()
    {
        if ( isBold() )
            return false;

        if ( isItalic() )
            return false;

        return true;
    }

    public int getStyle()
    {
        int i = 0;

        if ( isBold() )
            i |= Font.BOLD;

        if ( isItalic() )
            i |= Font.ITALIC;

        return i;
    }

    //##################################################
    //# size
    //##################################################

    public int getSize()
    {
        return _size;
    }

    public void setSize(int e)
    {
        _size = e;
        _font = null;
    }

    //##################################################
    //# font
    //##################################################

    public Font getFont()
    {
        if ( _font == null )
            _font = new Font(getName(), getStyle(), getSize());

        return _font;
    }
}
