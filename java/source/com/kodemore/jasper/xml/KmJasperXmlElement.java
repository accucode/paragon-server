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

package com.kodemore.jasper.xml;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.kodemore.jasper.KmJasperColor;
import com.kodemore.jasper.KmJasperElementIF;
import com.kodemore.jasper.KmJasperFont;
import com.kodemore.jasper.KmJasperStyle;

public class KmJasperXmlElement
    extends KmJasperXmlNode
{
    //##################################################
    //# variables
    //##################################################

    private String                     _name;
    private List<KmJasperXmlAttribute> _attributes;
    private List<KmJasperXmlNode>      _children;

    private boolean                    _indentChildren;

    //##################################################
    //# constructor
    //##################################################

    public KmJasperXmlElement()
    {
        _attributes = new ArrayList<KmJasperXmlAttribute>();
        _children = new ArrayList<KmJasperXmlNode>();
        _indentChildren = true;
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
    }

    //##################################################
    //# attributes
    //##################################################

    public List<KmJasperXmlAttribute> getAttributes()
    {
        return _attributes;
    }

    public void addAttribute(String key, String value)
    {
        if ( value == null )
            return;

        KmJasperXmlAttribute e;
        e = addAttribute();
        e.setKey(key);
        e.setValue(value);
    }

    public void addAttribute(String key, Integer value)
    {
        if ( value == null )
            return;

        addAttribute(key, value + "");
    }

    public void addAttribute(String key, Double value)
    {
        if ( value == null )
            return;

        addAttribute(key, new DecimalFormat("0.#####").format(value));
    }

    public void addAttribute(String key, KmJasperFont value)
    {
        if ( value == null )
            return;

        addAttribute(key, value.getName());
    }

    public void addAttribute(String key, KmJasperColor value)
    {
        if ( value == null )
            return;

        addAttribute(key, value.getValue());
    }

    public void addAttribute(String key, KmJasperStyle value)
    {
        if ( value == null )
            return;
        addAttribute(key, value.getName());
    }

    public void addAttribute(String key, Boolean value)
    {
        if ( value == null )
            return;

        String s = value
            ? "true"
            : "false";
        addAttribute(key, s);
    }

    private KmJasperXmlAttribute addAttribute()
    {
        KmJasperXmlAttribute e = new KmJasperXmlAttribute();
        _attributes.add(e);
        return e;
    }

    //##################################################
    //# children
    //##################################################

    public List<KmJasperXmlNode> getChildren()
    {
        return _children;
    }

    public KmJasperXmlElement addElement(String name)
    {
        KmJasperXmlElement e;
        e = new KmJasperXmlElement();
        e.setName(name);
        addChild(e);
        return e;
    }

    public KmJasperXmlText addText()
    {
        KmJasperXmlText e;
        e = new KmJasperXmlText();
        addChild(e);
        return e;
    }

    public KmJasperXmlText addText(String value)
    {
        KmJasperXmlText e;
        e = addText();
        e.setValue(value);
        return e;
    }

    public KmJasperXmlCdata addCdata()
    {
        KmJasperXmlCdata e;
        e = new KmJasperXmlCdata();
        addChild(e);
        return e;
    }

    public KmJasperXmlCdata addCdata(String value)
    {
        KmJasperXmlCdata e;
        e = addCdata();
        e.setValue(value);
        return e;
    }

    private void addChild(KmJasperXmlNode e)
    {
        _children.add(e);
    }

    //##################################################
    //# indent
    //##################################################

    public boolean getIndentChildren()
    {
        return _indentChildren;
    }

    public void setIndentChildren(boolean e)
    {
        _indentChildren = e;
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void printOn(KmJasperXmlBuilder out)
    {
        String name = getName();
        out.open(name);

        if ( !getAttributes().isEmpty() )
        {
            out.indent();
            for ( KmJasperXmlAttribute e : getAttributes() )
            {
                out.printNewLineIndent();
                out.printAttribute(e.getKey(), e.getValue());
            }
            out.undent();
        }

        List<KmJasperXmlNode> children = getChildren();
        if ( children.isEmpty() )
        {
            out.closeAndEnd();
            return;
        }

        out.close();

        out.indent();
        for ( KmJasperXmlNode e : children )
        {
            indent(out);
            e.printOn(out);
        }
        out.undent();

        indent(out);
        out.end(name);
    }

    private void indent(KmJasperXmlBuilder out)
    {
        if ( _indentChildren )
            out.printNewLineIndent();
    }

    //##################################################
    //# compose
    //##################################################

    public void add(KmJasperElementIF e)
    {
        if ( e != null )
            e.addTo(this);
    }

    public void addAll(List<? extends KmJasperElementIF> v)
    {
        if ( v != null )
            for ( KmJasperElementIF e : v )
                add(e);
    }

}
