/*
  Copyright (c) 2005-2011 www.kodemore.com

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
import java.util.Iterator;

import com.kodemore.collection.KmList;
import com.kodemore.log.KmLog;
import com.kodemore.utility.Kmu;
import com.kodemore.xml.utility.KmXmlUtility;

public class KmXmlElement
    extends KmXmlNode
{
    //##################################################
    //# variables
    //##################################################

    private String                 _uri;
    private String                 _localName;
    private String                 _qualifiedName;

    private KmList<KmXmlAttribute> _attributes;
    private KmList<KmXmlNode>      _children;

    //##################################################
    //# constructor
    //##################################################

    public KmXmlElement(KmXmlSourceLocation e)
    {
        super(e);
        _attributes = new KmList<KmXmlAttribute>();
        _children = new KmList<KmXmlNode>();
    }

    //##################################################
    //# name
    //##################################################

    public String getUri()
    {
        return _uri;
    }

    public void setUri(String e)
    {
        _uri = e;
    }

    public String getLocalName()
    {
        return _localName;
    }

    public void setLocalName(String e)
    {
        _localName = e;
    }

    public String getQualifiedName()
    {
        return _qualifiedName;
    }

    public void setQualifiedName(String e)
    {
        _qualifiedName = e;
    }

    //##################################################
    //# tag
    //##################################################

    public String getTag()
    {
        return _localName;
    }

    public boolean hasTag(String e)
    {
        return Kmu.isEqual(getTag(), e);
    }

    //##################################################
    //# path
    //##################################################

    public String getPath()
    {
        return formatPath(PATH_SEPARATOR);
    }

    public boolean hasPath(String s)
    {
        return Kmu.isEqual(getPath(), s);
    }

    private String formatPath(String split)
    {
        StringBuilder sb = new StringBuilder();
        Iterator<String> i = getPathNames().iterator();
        while ( i.hasNext() )
        {
            String s = i.next();
            sb.append(s);
            if ( i.hasNext() )
                sb.append(split);
        }
        return sb.toString();
    }

    public KmList<String> getPathNames()
    {
        KmList<String> v = new KmList<String>();
        collectPathNames(v);
        return v;
    }

    private void collectPathNames(KmList<String> v)
    {
        if ( hasParent() && getParent().isElement() )
            getParent().asElement().collectPathNames(v);
        v.add(getTag());
    }

    //##################################################
    //# attributes
    //##################################################

    public KmList<KmXmlAttribute> getAttributes()
    {
        return _attributes;
    }

    public void setAttributes(KmList<KmXmlAttribute> e)
    {
        _attributes = e;
    }

    public boolean hasAttribute(String key)
    {
        for ( KmXmlAttribute e : _attributes )
            if ( e.hasKey(key) )
                return true;
        return false;
    }

    public String getAttribute(String key)
    {
        for ( KmXmlAttribute e : _attributes )
            if ( e.hasKey(key) )
                return e.getValue();
        return null;
    }

    public void setAttribute(String key, String value)
    {
        Iterator<KmXmlAttribute> i = _attributes.iterator();
        while ( i.hasNext() )
        {
            KmXmlAttribute e = i.next();
            if ( e.hasKey(key) )
            {
                e.setValue(value);
                return;
            }
        }
        KmXmlAttribute a;
        a = new KmXmlAttribute();
        a.setKey(key);
        a.setValue(value);
        _attributes.add(a);
    }

    public boolean hasAttributes()
    {
        return _attributes.isNotEmpty();
    }

    //##################################################
    //# children
    //##################################################

    public KmList<KmXmlNode> getChildren()
    {
        return _children;
    }

    public void setChildren(KmList<KmXmlNode> e)
    {
        _children = e;
    }

    public void clearChildren()
    {
        _children.clear();
    }

    public void addChild(KmXmlNode e)
    {
        e.setParent(this);
        _children.add(e);
    }

    public void addChild(String s)
    {
        KmXmlText e = new KmXmlText(null);
        e.setValue(s);
        addChild(e);
    }

    public void removeChild(KmXmlNode e)
    {
        _children.remove(e);
    }

    public KmXmlNode getChildAt(int i)
    {
        return _children.get(i);
    }

    public int getChildCount()
    {
        return _children.size();
    }

    public KmXmlNode getFirstChild()
    {
        return _children.getFirstSafe();
    }

    public KmXmlNode getLastChild()
    {
        return _children.getLastSafe();
    }

    public boolean hasChildren()
    {
        return _children.isNotEmpty();
    }

    public boolean hasChildElements()
    {
        for ( KmXmlNode e : _children )
            if ( e.isElement() )
                return true;
        return false;
    }

    public boolean containsOnlyText()
    {
        return !containsNonText();
    }

    public boolean containsNonText()
    {
        Iterator<KmXmlNode> i = _children.iterator();
        while ( i.hasNext() )
        {
            KmXmlNode e = i.next();
            if ( !e.isText() )
                return true;
        }
        return false;
    }

    //##################################################
    //# child elements
    //##################################################

    public KmList<KmXmlElement> getChildElements()
    {
        KmList<KmXmlElement> v = new KmList<KmXmlElement>();
        for ( KmXmlNode e : _children )
            if ( e.isElement() )
                v.add(e.asElement());
        return v;
    }

    public KmList<KmXmlElement> getChildElements(String tag)
    {
        KmList<KmXmlElement> v = new KmList<KmXmlElement>();
        for ( KmXmlNode e : _children )
            if ( e.isElement() && e.asElement().hasTag(tag) )
                v.add(e.asElement());
        return v;
    }

    public KmXmlElement getChildElement(String tag)
    {
        return getChildElements(tag).getFirstSafe();
    }

    public boolean hasChildElement(String tag)
    {
        return getChildElement(tag) != null;
    }

    //##################################################
    //# elements at (path)
    //##################################################

    public KmList<KmXmlElement> getElementsAt(String path)
    {
        return getElementsAt(pathToTags(path));
    }

    public KmList<KmXmlElement> getElementsAt(KmList<String> path)
    {
        KmList<KmXmlElement> parents;
        parents = new KmList<KmXmlElement>();
        parents.add(this);

        KmList<KmXmlElement> children;
        children = new KmList<KmXmlElement>();

        for ( String tag : path )
        {
            for ( KmXmlElement parent : parents )
                children.addAll(parent.getChildElements(tag));

            parents.replaceAll(children);
            children.clear();
        }

        return parents;
    }

    public KmXmlElement getElementAt(String path)
    {
        return getElementsAt(path).getFirstSafe();
    }

    public KmXmlElement getElementAt(KmList<String> path)
    {
        return getElementsAt(path).getFirstSafe();
    }

    public boolean hasElementAt(String tag)
    {
        return getElementAt(tag) != null;
    }

    //##################################################
    //# text
    //##################################################

    public KmList<String> getChildElementTexts(String tag)
    {
        KmList<String> v = new KmList<String>();
        for ( KmXmlElement e : getChildElements(tag) )
            v.add(e.collectText());
        return v;
    }

    public String collectText()
    {
        StringBuilder sb = new StringBuilder();
        for ( KmXmlText e : getTextChildren() )
            sb.append(e.getValue());
        return sb.toString();
    }

    public String collectTextAt(String path)
    {
        KmXmlElement e = getElementAt(path);
        if ( e == null )
            return null;

        return e.collectText();
    }

    public KmList<String> collectTextsAt(String path)
    {
        KmList<String> v = new KmList<String>();
        for ( KmXmlElement e : getElementsAt(path) )
            v.add(e.collectText());
        return v;
    }

    public KmList<KmXmlText> getTextChildren()
    {
        KmList<KmXmlText> v = new KmList<KmXmlText>();
        for ( KmXmlNode e : _children )
            if ( e.isText() )
                v.add(e.asText());
        return v;
    }

    public KmList<String> getDistinctChildTags()
    {
        KmList<String> v = new KmList<String>();
        for ( KmXmlElement e : getChildElements() )
            v.addDistinct(e.getTag());
        return v;
    }

    //##################################################
    //# testing
    //##################################################

    @Override
    public boolean isElement()
    {
        return true;
    }

    @Override
    public boolean isElement(String tag)
    {
        return hasTag(tag);
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return Kmu.format("XmlElement[%s]", getTag());
    }

    @Override
    public void printOn(PrintWriter out)
    {
        if ( hasChildren() )
        {
            printBeginTag(out);
            printChildren(out);
            printEndTag(out);
            return;
        }

        printQuickTag(out);
    }

    private void printBeginTag(PrintWriter out)
    {
        out.print("<");
        out.print(getTag());
        printAttributes(out);
        out.print(">");
    }

    private void printQuickTag(PrintWriter out)
    {
        out.print("<");
        out.print(getTag());
        printAttributes(out);
        out.print("/>");
    }

    private void printAttributes(PrintWriter out)
    {
        Iterator<KmXmlAttribute> ia = _attributes.iterator();
        while ( ia.hasNext() )
        {
            KmXmlAttribute e = ia.next();
            out.print(" ");
            out.print(e.getKey());
            out.print("=");
            out.print("\"");
            out.print(KmXmlUtility.escape(e.getValue()));
            out.print("\"");
        }
    }

    private void printChildren(PrintWriter out)
    {
        Iterator<KmXmlNode> in = _children.iterator();
        while ( in.hasNext() )
        {
            KmXmlNode e = in.next();
            e.printOn(out);
        }
    }

    private void printEndTag(PrintWriter out)
    {
        out.print("</");
        out.print(getTag());
        out.print(">");
    }

    @Override
    public void printStructureOn(PrintWriter out)
    {
        indent(out);
        out.println("Element: " + getTag());

        Iterator<KmXmlAttribute> ia = _attributes.iterator();
        while ( ia.hasNext() )
        {
            KmXmlAttribute e = ia.next();
            indent(out, getDepth() + 1);
            out.println("Attribute: " + e.getKey() + " = " + formatForStructure(e.getValue()));
        }

        Iterator<KmXmlNode> in = _children.iterator();
        while ( in.hasNext() )
        {
            KmXmlNode e = in.next();
            e.printStructureOn(out);
        }
    }

    @Override
    public void prettyPrintOn(PrintWriter out)
    {
        if ( !hasChildren() )
        {
            indent(out);
            printQuickTag(out);
            out.println();
            return;
        }

        if ( containsOnlyText() )
        {
            String s = collectText().trim();
            indent(out);
            printBeginTag(out);
            out.print(KmXmlUtility.escape(s));
            printEndTag(out);
            out.println();
            return;
        }

        indent(out);
        printBeginTag(out);
        out.println();

        for ( KmXmlNode c : _children )
        {
            if ( c.isText() )
            {
                String s = c.asText().getValue().trim();
                if ( Kmu.isNotEmpty(s) )
                {
                    c.indent(out);
                    out.println(KmXmlUtility.escape(s));
                }
                continue;
            }
            c.prettyPrintOn(out);
        }

        indent(out);
        printEndTag(out);
        out.println();
    }

    //##################################################
    //# utility
    //##################################################

    public String getRequiredString(String key)
    {
        String s = getString(key, null);
        if ( Kmu.isEmpty(s) )
        {
            warn("Missing required value (%s).", key);
            return "";
        }
        return s;
    }

    public boolean getBoolean(String key, boolean def)
    {
        String s = getString(key, null);
        if ( s == null )
            return def;
        if ( s.equals("yes") )
            return true;
        if ( s.equals("no") )
            return false;
        warn("Cannot parse key (%s) as boolean (%s)... using default (%s).", key, s, def);
        return def;
    }

    public String getString(String key, String def)
    {
        KmList<String> v = getStrings(key);
        if ( v.isEmpty() )
            return def;
        if ( v.size() > 1 )
            warn("Expected single value for (%s).", key);
        return v.getFirst();
    }

    public KmList<String> getStrings(String key)
    {
        KmList<String> v = new KmList<String>();
        for ( KmXmlElement c : getChildElements(key) )
        {
            if ( c.containsNonText() )
                warn("Expected simple text for (%s).", key);
            v.add(c.collectText());
        }
        return v;
    }

    //##################################################
    //# utility
    //##################################################

    public void warn(String msg, Object... args)
    {
        KmLog.warnTrace(msg, args);
    }

    //##################################################
    //# static
    //##################################################

    public static KmList<String> pathToTags(String path)
    {
        KmList<String> v;
        v = new KmList<String>();
        v.addAll(path.split("/"));
        return v;
    }

}
