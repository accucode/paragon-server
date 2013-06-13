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
import com.kodemore.jasper.xml.KmJasperXmlElement;

public class KmJasperText
    extends KmJasperAbstractText
    implements KmJasperBandElementIF
{
    //##################################################
    //# variables
    //##################################################

    private Boolean            _stretchOverflow;
    private Boolean            _blankWhenNull;
    private KmJasperExpression _expression;

    //##################################################
    //# constructor
    //##################################################

    public KmJasperText(KmJasperReportBuilder e)
    {
        super(e);
        setStretchOverflow();
        setBlankWhenNull();
    }

    //##################################################
    //# overflow
    //##################################################

    public Boolean getStretchOverflow()
    {
        return _stretchOverflow;
    }

    public void setStretchOverflow(Boolean e)
    {
        _stretchOverflow = e;
    }

    public void setStretchOverflow()
    {
        setStretchOverflow(true);
    }

    //##################################################
    //# blank 
    //##################################################

    public Boolean getBlankWhenNull()
    {
        return _blankWhenNull;
    }

    public void setBlankWhenNull(Boolean e)
    {
        _blankWhenNull = e;
    }

    public void setBlankWhenNull()
    {
        setBlankWhenNull(true);
    }

    //##################################################
    //# expression
    //##################################################

    public KmJasperExpression getExpression()
    {
        return _expression;
    }

    public void setExpression(KmJasperExpression e)
    {
        _expression = e;
    }

    //##################################################
    //# expression (convenience) 
    //##################################################

    public void setValue(String s)
    {
        KmJasperExpression e;
        e = new KmJasperExpression();
        e.setType(KmJasperType.String);
        e.setValue(s);
        setExpression(e);
    }

    public void setField(KmJasperField f)
    {
        setExpression(f.getExpression());
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void addTo(KmJasperXmlElement root)
    {
        KmJasperXmlElement field;
        field = root.addElement("textField");
        field.addAttribute("isStretchWithOverflow", _stretchOverflow);
        field.addAttribute("isBlankWhenNull", _blankWhenNull);

        addReportElementTo(field);
        addTextElementTo(field);

        _expression.addTo(field, "textFieldExpression");
    }

}
