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

package com.kodemore.telnet;

public class KmTelnetLabel
{
    //##################################################
    //# variables
    //##################################################

    private int    _x;
    private int    _y;
    private String _text;

    //##################################################
    //# constructor
    //##################################################

    public KmTelnetLabel()
    {
        _x = 0;
        _y = 0;
        _text = "";
    }

    //##################################################
    //# accessing
    //##################################################

    public int getX()
    {
        return _x;
    }

    public void setX(int e)
    {
        _x = e;
    }

    public int getY()
    {
        return _y;
    }

    public void setY(int e)
    {
        _y = e;
    }

    public String getText()
    {
        return _text;
    }

    public void setText(String e)
    {
        _text = e;
    }

    //##################################################
    //# utility
    //##################################################

    public void printOn(KmTelnetSession s)
    {
        s.normal();
        s.print(_x, _y, _text);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Label");
        sb.append("(");
        sb.append(_x);
        sb.append(",");
        sb.append(_y);
        sb.append(",");
        sb.append(_text);
        sb.append(")");
        return sb.toString();
    }

}
