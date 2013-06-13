/*
  Copyright (c) 2010-2010 www.kodemore.com

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

package com.kodemore.jasper;

public class KmJasperColor
{
    //##################################################
    //# variables
    //##################################################

    private String _value;

    //##################################################
    //# constructor
    //##################################################

    public KmJasperColor()
    {
        setBlack();
    }

    //##################################################
    //# accessing
    //##################################################

    public String getValue()
    {
        return _value;
    }

    public void setValue(String e)
    {
        _value = e;
    }

    //##################################################
    //# named
    //##################################################

    public void setBlack()
    {
        _value = "#000000";
    }

    public void setWhite()
    {
        _value = "#FFFFFF";
    }

    public void setRed()
    {
        _value = "#FF0000";
    }

    public void setBlue()
    {
        _value = "#0000FF";
    }

    public void setGray()
    {
        _value = "#808080";
    }

    public void setLightGray()
    {
        _value = "#B0B0B0";
    }

    public void setVeryLightGray()
    {
        _value = "#E0E0E0";
    }

    public void setDarkGray()
    {
        _value = "#404040";
    }

    public void setVeryDarkGray()
    {
        _value = "#202020";
    }

    public void setGreen()
    {
        _value = "#00FF00";
    }

    public void setYellow()
    {
        _value = "#FFFF00";
    }

}
