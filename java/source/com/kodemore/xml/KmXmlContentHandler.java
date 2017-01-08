/*
  Copyright (c) 2005-2016 www.kodemore.com

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

import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.ext.DefaultHandler2;

import com.kodemore.collection.KmStack;
import com.kodemore.utility.Kmu;

/**
 * Parse xml into a simple model.  I do not attempt to parse everything,
 * but instead provide a simplified model that is easy to use for the
 * common cases.  Additional parsing can easily be added as it is deemed
 * useful.
 */
public class KmXmlContentHandler
    extends DefaultHandler2
{
    //##################################################
    //# variables
    //##################################################

    private Locator               _locator;
    private KmXmlDocument         _document;
    private KmStack<KmXmlElement> _elements;
    private String                _locationName;
    private String                _source;

    //##################################################
    //# accessing
    //##################################################

    public KmXmlDocument getDocument()
    {
        return _document;
    }

    public String getSource()
    {
        return _source;
    }

    public void setSource(String e)
    {
        _source = e;
    }

    public String getLocationName()
    {
        return _locationName;
    }

    public void setLocationName(String e)
    {
        _locationName = e;
    }

    //##################################################
    //# sax handler
    //##################################################

    @Override
    public void setDocumentLocator(Locator e)
    {
        _locator = e;
    }

    @Override
    public void startDocument()
    {
        _document = new KmXmlDocument(null);
        applyLocation(_document);
        _elements = new KmStack<>();
    }

    @Override
    public void startElement(String uri, String localName, String qualifiedName, Attributes attrs)
    {
        KmXmlElement e;
        e = new KmXmlElement(null);
        e.setUri(uri);
        e.setLocalName(localName);
        e.setQualifiedName(qualifiedName);
        applyLocation(e);

        int n = attrs.getLength();
        for ( int i = 0; i < n; i++ )
        {
            String key = attrs.getLocalName(i);
            String value = attrs.getValue(i);
            e.setAttribute(key, value);
        }

        if ( _elements.isEmpty() )
            _document.setRoot(e);
        else
            _elements.peek().addChild(e);

        _elements.push(e);
    }

    @Override
    public void endElement(String uri, String localName, String qualifiedName)
    {
        _elements.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length)
    {
        String s = new String(ch, start, length);
        if ( _elements.isNotEmpty() )
        {
            KmXmlElement e = _elements.peek();
            if ( e.hasChildren() && e.getLastChild().isText() )
            {
                e.getLastChild().asText().append(s);
                return;
            }
        }
        KmXmlText t = new KmXmlText(null);
        t.setValue(s);
        applyLocation(t);
        _elements.peek().addChild(t);
    }

    public void applyLocation(KmXmlNode n)
    {
        if ( _locator == null )
            throw Kmu.newFatal("Locator is required.");

        KmXmlSourceLocation e;
        e = new KmXmlSourceLocation();
        e.setName(_locationName);
        e.setSource(_source);
        e.setRow(_locator.getLineNumber());
        e.setColumn(_locator.getColumnNumber());
        n.setLocation(e);
    }
}
