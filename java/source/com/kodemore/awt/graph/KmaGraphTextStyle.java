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

package com.kodemore.awt.graph;

import java.awt.Color;

public class KmaGraphTextStyle
{
    //##################################################
    //# variables
    //##################################################

    private boolean      _visible;
    private Color        _color;
    private KmaGraphFont _font;

    //##################################################
    //# constructor
    //##################################################

    public KmaGraphTextStyle()
    {
        _visible = true;
        _color = Color.black;
        _font = new KmaGraphFont();
    }

    //##################################################
    //# accessing
    //##################################################

    public boolean isVisible()
    {
        return _visible;
    }

    public void beVisible()
    {
        setVisible(true);
    }

    public void setVisible(boolean e)
    {
        _visible = e;
    }

    public Color getColor()
    {
        return _color;
    }

    public void setColor(Color e)
    {
        _color = e;
    }

    public KmaGraphFont getFont()
    {
        return _font;
    }

    public void setFont(KmaGraphFont e)
    {
        _font = e;
    }

    //##################################################
    //# graphics
    //##################################################

    public void applyTo(KmaGraphics g)
    {
        if ( !isVisible() )
            return;

        g.setFont(getFont().getFont());
        g.setColor(getColor());
    }

}
