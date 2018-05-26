/*
  Copyright (c) 2005-2018 www.kodemore.com

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

package com.kodemore.servlet.script;

import com.kodemore.json.KmJsonMap;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

/**
 * I am used to show a simple message in modal dialog.
 */
public class ScShowNoticeScript
    extends ScAbstractScript
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The plaintext title/banner.
     * If not set, defaults to something like "Notice".
     */
    private String _title;

    /**
     * The message, as plain text.
     */
    private String _textMessage;

    /**
     * The message, as preformatted html.
     */
    private String _htmlMessage;

    //##################################################
    //# constructor
    //##################################################

    public ScShowNoticeScript()
    {
        // none
    }

    //##################################################
    //# title
    //##################################################

    public String getTitle()
    {
        return _title;
    }

    public void setTitle(String e)
    {
        _title = e;
    }

    public boolean hasTitle()
    {
        return Kmu.hasValue(_title);
    }

    //##################################################
    //# text message
    //##################################################

    public String getTextMessage()
    {
        return _textMessage;
    }

    public void setTextMessage(String e)
    {
        _textMessage = e;
    }

    public boolean hasTextMessage()
    {
        return Kmu.hasValue(_textMessage);
    }

    //##################################################
    //# html message
    //##################################################

    public String getHtmlMessage()
    {
        return _htmlMessage;
    }

    public void setHtmlMessage(String e)
    {
        _htmlMessage = e;
    }

    public boolean hasHtmlMessage()
    {
        return Kmu.hasValue(_htmlMessage);
    }

    //##################################################
    //# scriptIF
    //##################################################

    @Override
    public void formatScriptOn(KmStringBuilder out)
    {
        KmJsonMap args;
        args = new KmJsonMap();

        if ( hasTitle() )
            args.setString("title", getTitle());

        if ( hasTextMessage() )
            args.setString("textMessage", getTextMessage());

        if ( hasHtmlMessage() )
            args.setString("htmlMessage", getHtmlMessage());

        out.printf("Kmu.showNotice(%s);", args);
    }

}
