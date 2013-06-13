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

import com.kodemore.jasper.field.KmJasperField;
import com.kodemore.jasper.field.KmJasperVariable;
import com.kodemore.jasper.xml.KmJasperXmlElement;

public class KmJasperExpression
{
    //##################################################
    //# variables
    //##################################################

    private KmJasperType _type;
    private String       _rawValue;

    //##################################################
    //# type
    //##################################################

    public KmJasperType getType()
    {
        return _type;
    }

    public void setType(KmJasperType e)
    {
        _type = e;
    }

    //##################################################
    //# raw value
    //##################################################

    public String getRawValue()
    {
        return _rawValue;
    }

    public void setRawValue(String e)
    {
        _rawValue = e;
    }

    //##################################################
    //# convenience
    //##################################################

    public void setValue(KmJasperField e)
    {
        setType(e.getType());
        setRawValue(e.formatToken());
    }

    public void setValue(KmJasperVariable e)
    {
        setType(e.getType());
        setRawValue(e.formatToken());
    }

    public void setValue(String s)
    {
        setType(KmJasperType.String);
        setRawValue('"' + escape(s) + '"');
    }

    //##################################################
    //# compose
    //##################################################

    public void addTo(KmJasperXmlElement field, String element)
    {
        KmJasperXmlElement expr;
        expr = field.addElement(element);
        expr.addAttribute("class", getType().getName());
        expr.setIndentChildren(false);
        expr.addCdata(getRawValue());
    }

    public void addToWithoutClass(KmJasperXmlElement field, String element)
    {
        KmJasperXmlElement expr;
        expr = field.addElement(element);
        expr.setIndentChildren(false);
        expr.addCdata(getRawValue());
    }

    //##################################################
    //# support
    //##################################################

    private String escape(String s)
    {
        StringBuilder out = new StringBuilder();
        for ( char c : s.toCharArray() )
        {
            switch ( c )
            {
                case '"':
                    out.append("\\\"");
                    break;

                case '\n':
                    out.append("\\n");
                    break;

                case '\r':
                    out.append("\\r");
                    break;

                case '\t':
                    out.append("\\t");
                    break;

                case '$':
                    out.append("$$");
                    break;

                default:
                    out.append(c);
            }

            if ( c == '"' )
            {
                out.append('\\');
                out.append(c);
            }
        }

        return out.toString();
    }

}
