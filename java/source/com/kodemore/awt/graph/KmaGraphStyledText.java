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

package com.kodemore.awt.graph;

public class KmaGraphStyledText
{
    //##################################################
    //# variables
    //##################################################

    private String            _text;
    private KmaGraphTextStyle _style;

    //##################################################
    //# constructor
    //##################################################

    public KmaGraphStyledText()
    {
        _text = "";
        _style = new KmaGraphTextStyle();
    }

    //##################################################
    //# accessing
    //##################################################

    public String getText()
    {
        return _text;
    }

    public void setText(String e)
    {
        _text = e;
    }

    public KmaGraphTextStyle getStyle()
    {
        return _style;
    }

    public void setStyle(KmaGraphTextStyle e)
    {
        _style = e;
    }
}
