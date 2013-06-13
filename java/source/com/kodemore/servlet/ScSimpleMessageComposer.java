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

package com.kodemore.servlet;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.utility.Kmu;

public class ScSimpleMessageComposer
{
    //##################################################
    //# variables
    //##################################################

    private String        _header;
    private String        _title;
    private String        _message;
    private Throwable     _exception;
    private boolean       _showException;

    private KmHtmlBuilder _out;

    //##################################################
    //# accessing
    //##################################################

    public String getHeader()
    {
        return _header;
    }

    public void setHeader(String e)
    {
        _header = e;
    }

    public String getTitle()
    {
        return _title;
    }

    public void setTitle(String e)
    {
        _title = e;
    }

    public String getMessage()
    {
        return _message;
    }

    public void setMessage(String e)
    {
        _message = e;
    }

    public Throwable getException()
    {
        return _exception;
    }

    public void setException(Throwable e)
    {
        _exception = e;
    }

    public boolean getShowException()
    {
        return _showException;
    }

    public void setShowException(boolean e)
    {
        _showException = e;
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        compose();
        return _out.toString();
    }

    //##################################################
    //# compose html
    //##################################################

    private void compose()
    {
        _out = new KmHtmlBuilder();
        _out.begin("html");
        writeHead();
        writeBody();
        _out.end("html");
    }

    private void writeHead()
    {
        _out.begin("head");
        _out.begin("title");
        _out.print(_header);
        _out.end("title");
        _out.end("head");
    }

    private void writeBody()
    {
        _out.begin("body");
        writeBannerLogo();
        writeBannerText();
        writeException();
        _out.end("body");
    }

    private void writeBannerLogo()
    {
        _out.beginCss("div", "headerBlock");
        _out.open("table");
        _out.printAttribute("width", "100%");
        _out.close();

        _out.begin("tr");
        _out.beginCss("td", "logo");
        _out.printHeader(1, _header);
        _out.end("td");

        _out.beginCss("td", "logo");
        _out.end("td");

        _out.end("tr");
        _out.end("table");

        _out.end("div");

        _out.beginCss("div", "separator");
        _out.begin("a");
        _out.end("a");
        _out.end("div");
    }

    private void writeBannerText()
    {
        _out.begin("center");
        writeTitle();
        writeMessage();
        _out.end("center");
    }

    private void writeTitle()
    {
        int headerSize = 3;
        if ( _title == null )
        {
            _out.printHeader(3, "We are sorry, an error has occurred in the "
                + "application.  This has been recorded and administrators "
                + "will be reviewing it.");
            return;
        }

        _out.printHeader(headerSize, _title);
    }

    private void writeMessage()
    {
        if ( _message == null )
            return;

        _out.printHeader(4, _message);
    }

    private void writeException()
    {
        if ( _exception == null )
            return;

        if ( getShowException() )
        {
            _out.println();
            _out.println();
            _out.print(Kmu.formatStackTrace(_exception));
        }
        else
        {
            String cr = "\n\n";
            _out.printLiteral(cr);
            _out.beginComment();
            _out.printLiteral(cr);
            _out.printLiteral(Kmu.formatStackTrace(_exception));
            _out.printLiteral(cr);
            _out.endComment();
            _out.printLiteral(cr);
        }
    }

}
