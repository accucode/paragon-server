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

package com.kodemore.servlet.field;

import com.kodemore.utility.Kmu;

public class ScOption
{
    //##################################################
    //# instance creation
    //##################################################

    public static ScOption create(String text, Object value)
    {
        ScOption e;
        e = new ScOption();
        e.setText(text);
        e.setValue(value);
        return e;
    }

    //##################################################
    //# variables
    //##################################################

    private Object _value;
    private String _text;

    //##################################################
    //# constructor
    //##################################################

    public ScOption()
    {
        _value = null;
        _text = "";
    }

    //##################################################
    //# value
    //##################################################

    public Object getValue()
    {
        return _value;
    }

    public void setValue(Object e)
    {
        _value = e;
    }

    public boolean hasValue()
    {
        return _value != null;
    }

    public boolean hasValue(Object e)
    {
        return Kmu.isEqual(_value, e);
    }

    //##################################################
    //# text
    //##################################################

    public String getText()
    {
        return _text;
    }

    public void setText(String e)
    {
        _text = e;
    }

    public boolean hasText(String e)
    {
        return Kmu.isEqual(getText(), e);
    }

}
