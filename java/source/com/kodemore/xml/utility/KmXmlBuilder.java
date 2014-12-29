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

package com.kodemore.xml.utility;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

/**
 * A very simple xml buffer for printing an xml tree.
 * Attributes are not supported.
 */
public class KmXmlBuilder
{
    //##################################################
    //# constants
    //##################################################

    private static final String NEW_LINE         = "\r\n";
    private static final String XML_DEF          =
                                                     "<?xml version=\"VERSION\" encoding=\"ENCODING\"?>";

    private static final String DEFAULT_VERSION  = "1.0";
    private static final String DEFAULT_ENCODING = "utf-8";

    //##################################################
    //# variables
    //##################################################

    private StringBuilder       _buffer;
    private KmList<String>      _tags;

    private boolean             _autoFormat;
    private String              _indent;

    private String              _version;
    private String              _encoding;
    private boolean             _hasXmlDefinition;

    //##################################################
    //# constructor
    //##################################################

    public KmXmlBuilder()
    {
        _buffer = new StringBuilder();
        _tags = new KmList<>();
        _autoFormat = true;
        _indent = "    ";
        _version = DEFAULT_VERSION;
        _encoding = DEFAULT_ENCODING;
    }

    //##################################################
    //# xml definition
    //##################################################

    public void addXmlDefinition(String version, String encoding)
    {
        setVersion(version);
        setEncoding(encoding);
        addXmlDefinition();
    }

    public void addXmlDefinition()
    {
        if ( !_hasXmlDefinition )
        {
            String def;
            def = XML_DEF.replaceAll("VERSION", getVersion());
            def = def.replaceAll("ENCODING", getEncoding()) + NEW_LINE;
            _buffer.insert(0, def);
            _hasXmlDefinition = true;
        }
    }

    public String getVersion()
    {
        return _version;
    }

    public void setVersion(String version)
    {
        _version = version;
    }

    public String getEncoding()
    {
        return _encoding;
    }

    public void setEncoding(String encoding)
    {
        _encoding = encoding;
    }

    //##################################################
    //# accessing
    //##################################################

    public boolean getAutoFormat()
    {
        return _autoFormat;
    }

    public void setAutoFormat(boolean e)
    {
        _autoFormat = e;
    }

    public String getIndent()
    {
        return _indent;
    }

    public void setIndent(String e)
    {
        _indent = e;
    }

    //##################################################
    //# simple tags
    //##################################################

    public void begin(String tag)
    {
        _begin(tag);
        if ( _autoFormat )
            printLine();
    }

    public void end()
    {
        _end(true);
    }

    //##################################################
    //# tags with attributes
    //##################################################

    public void open(String tag)
    {
        if ( _autoFormat )
            indent();
        _tags.add(tag);
        _buffer.append("<");
        _buffer.append(tag);
    }

    public void printAttribute(String key, Object value)
    {
        if ( value == null )
            return;

        _buffer.append(" ");
        _buffer.append(escape(key));
        _buffer.append("=");
        _buffer.append("\"");
        _buffer.append(escape(value));
        _buffer.append("\"");
    }

    public void close()
    {
        _close();
        if ( _autoFormat )
            printLine();
    }

    private void _close()
    {
        _buffer.append(">");
    }

    //##################################################
    //# value (text content)
    //##################################################

    public void value(String tag, Object e)
    {
        _begin(tag);
        if ( e != null )
            _buffer.append(escape(e));
        _end(false);
    }

    public void value(String tag, int e)
    {
        String s = e + "";
        value(tag, s);
    }

    public void value(String tag, double e)
    {
        String s = e + "";
        value(tag, s);
    }

    public void value(String tag, double e, int places)
    {
        String s = Kmu.formatDouble(e, places);
        value(tag, s);
    }

    public void value(String tag, boolean e)
    {
        String s = e + "";
        value(tag, s);
    }

    public void emptyValue(String tag)
    {
        value(tag, "");
    }

    //##################################################
    //# misc
    //##################################################

    public void printLiteral(String s)
    {
        _buffer.append(s);
    }

    public void printLine()
    {
        _buffer.append(NEW_LINE);
    }

    public void indent()
    {
        int n = _tags.size();
        for ( int i = 0; i < n; i++ )
            _buffer.append(_indent);
    }

    public void clear()
    {
        _buffer.setLength(0);
        _tags.clear();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return _buffer.toString();
    }

    //##################################################
    //# private
    //##################################################

    private void _begin(String tag)
    {
        open(tag);
        _close();
    }

    private void _end(boolean indent)
    {
        String tag = _tags.remove(_tags.size() - 1);

        if ( _autoFormat && indent )
            indent();

        _buffer.append("</");
        _buffer.append(tag);
        _close();

        if ( _autoFormat )
            printLine();
    }

    private String escape(Object e)
    {
        if ( e == null )
            return "null";

        return KmXmlUtility.escape(e.toString());
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String args[])
    {
        KmXmlBuilder out;
        out = new KmXmlBuilder();

        out.begin("root");
        out.begin("house");
        out.value("owner", "John Smith");
        out.begin("address");
        out.value("street", "500 Main Street");
        out.value("city", "Somewhere");
        out.end(); // address
        out.begin("room");
        out.value("bedroom", 3);
        out.value("bathroom", 2);

        out.open("kitchen");
        out.printAttribute("sinks", 2);
        out.close();
        out.end();

        out.end(); // room
        out.end(); // house
        out.end(); // root

        System.out.println(out);
    }

}
