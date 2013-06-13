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

package com.kodemore.jasper.field;

import net.sf.jasperreports.engine.JRField;

import com.kodemore.jasper.KmJasperElementIF;
import com.kodemore.jasper.KmJasperExpression;
import com.kodemore.jasper.KmJasperType;
import com.kodemore.jasper.xml.KmJasperXmlElement;

public abstract class KmJasperField
    implements KmJasperElementIF
{
    //##################################################
    //# variables
    //##################################################

    private String       _name;
    private KmJasperType _type;

    //##################################################
    //# constructor
    //##################################################

    public KmJasperField(String name)
    {
        _name = name;
    }

    //##################################################
    //# name
    //##################################################

    public String getName()
    {
        return _name;
    }

    public boolean hasName(String e)
    {
        return _name.equals(e);
    }

    //##################################################
    //# format
    //##################################################

    public String formatToken()
    {
        return "$F{" + getName() + "}";
    }

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

    public String getTypeName()
    {
        return getType().getName();
    }

    public boolean matches(JRField f)
    {
        return hasName(f.getName()) && getType().getName().equals(f.getValueClassName());
    }

    //##################################################
    //# compose 
    //##################################################

    @Override
    public void addTo(KmJasperXmlElement root)
    {
        KmJasperXmlElement field;
        field = root.addElement("field");
        field.addAttribute("name", getName());
        field.addAttribute("class", getType().getName());
    }

    //##################################################
    //# expressions
    //##################################################

    public KmJasperExpression getExpression()
    {
        return expr(getType(), formatToken());
    }

    //##################################################
    //# support
    //##################################################

    protected String format(String template, Object... args)
    {
        return String.format(template, args);
    }

    protected KmJasperExpression exprWrapBoolean(String template, Object... args)
    {
        String raw = format(template, args);
        String wrap = wrap("Boolean.valueOf", raw);
        return expr(KmJasperType.Boolean, wrap);
    }

    protected String wrap(String wrapper, String value)
    {
        return format("(%s(%s))", wrapper, value);
    }

    protected KmJasperExpression exprf(KmJasperType type, String template, Object... args)
    {
        return expr(type, format(template, args));
    }

    protected KmJasperExpression expr(KmJasperType type, String value)
    {
        KmJasperExpression e;
        e = new KmJasperExpression();
        e.setType(type);
        e.setRawValue(value);
        return e;

    }

}
