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

public class KmJasperXmlBuilder
{
    //##################################################
    //# constants
    //##################################################

    private static final String CR  = "\r";
    private static final String LF  = "\n";
    private static final String EOL = CR + LF;

    //##################################################
    //# variables
    //##################################################

    private StringBuilder       _out;

    private int                 _indentLevel;
    private String              _indentText;

    //##################################################
    //# constructor
    //##################################################

    public KmJasperXmlBuilder()
    {
        _out = new StringBuilder();

        _indentLevel = 0;
        _indentText = "    ";
    }

    //##################################################
    //# header
    //##################################################

    public void printHeader()
    {
        _println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    }

    //##################################################
    //# open / close
    //##################################################

    public void open(String tag)
    {
        _print("<");
        _print(tag);
    }

    public void printAttribute(String key, String value)
    {
        _print(key);
        _print("=");
        _print("\"");
        _print(value);
        _print("\"");
    }

    public void close()
    {
        _print(">");
    }

    public void closeAndEnd()
    {
        _print("/>");
    }

    //##################################################
    //# begin / end
    //##################################################

    public void begin(String tag)
    {
        open(tag);
        close();
    }

    public void end(String tag)
    {
        _print("</");
        _print(tag);
        close();
    }

    //##################################################
    //# formatting
    //##################################################

    public void printNewLineIndent()
    {
        printNewLine();
        printIndent();
    }

    public void printNewLine()
    {
        _println();
    }

    public void printIndent()
    {
        for ( int i = 0; i < _indentLevel; i++ )
            _print(_indentText);
    }

    public void indent()
    {
        _indentLevel++;
    }

    public void undent()
    {
        _indentLevel--;
    }

    //##################################################
    //# print
    //##################################################

    public void printText(String value)
    {
        _print(_escape(value));
    }

    public void printCdata(String value)
    {
        _print("<![CDATA[");
        _print(value);
        _print("]]>");
    }

    //##################################################
    //# support
    //##################################################

    private void _print(String e)
    {
        _out.append(e);
    }

    private void _println()
    {
        _print(EOL);
    }

    private void _println(String e)
    {
        _print(e);
        printNewLine();
    }

    private String _escape(String value)
    {
        StringBuilder out = new StringBuilder();
        for ( char c : value.toCharArray() )
            switch ( c )
            {
                case '>':
                    out.append("&gt;");
                    break;
                case '<':
                    out.append("&lt;");
                    break;
                case '"':
                    out.append("&quot;");
                    break;
                case '\'':
                    out.append("&apos;");
                    break;
                case '&':
                    out.append("&amp;");
                    break;
                default:
                    out.append(c);
            }
        return out.toString();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return _out.toString();
    }

}
