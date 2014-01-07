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

package com.kodemore.xml;

import java.io.PrintWriter;

import com.kodemore.utility.Kmu;
import com.kodemore.xml.utility.KmXmlUtility;

public class KmXmlText
    extends KmXmlNode
{
    //##################################################
    //# variables
    //##################################################

    private String _value;

    //##################################################
    //# constructor
    //##################################################

    public KmXmlText(KmXmlSourceLocation e)
    {
        super(e);
        _value = "";
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

    public boolean hasValue()
    {
        return Kmu.hasValue(_value);
    }

    public void append(String s)
    {
        _value += s;
    }

    public boolean isEmpty()
    {
        return Kmu.isEmpty(_value);
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public void trimValue()
    {
        _value = _value.trim();
    }

    //##################################################
    //# testing
    //##################################################

    @Override
    public boolean isText()
    {
        return true;
    }

    public boolean isWhitespace()
    {
        return KmXmlUtility.isWhitespace(getValue());
    }

    public boolean hasWhitespace()
    {
        return KmXmlUtility.hasWhitespace(getValue());
    }

    public boolean hasNonWhitespace()
    {
        return KmXmlUtility.hasNonWhitespace(getValue());
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return Kmu.format("XmlText[%s]", Kmu.truncate(getValue(), 30, true));
    }

    @Override
    public void printOn(PrintWriter out)
    {
        out.print(KmXmlUtility.escape(_value));
    }

    @Override
    public void printStructureOn(PrintWriter out)
    {
        indent(out);
        out.println("Text: " + formatForStructure(_value));
    }

    @Override
    public void prettyPrintOn(PrintWriter out)
    {
        out.print(_value.trim());
    }

}
