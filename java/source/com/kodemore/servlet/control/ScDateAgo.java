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

package com.kodemore.servlet.control;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.variable.ScLocalDate;
import com.kodemore.time.KmDate;

/**
 * Add a <time> element to the page, but then use client
 * side javascript to display a date/timestamp using formats like
 *      today
 *      tomorrow
 *      5 days ago
 *      2 weeks from now
 *
 * See KmDateAgo.js
 */
public class ScDateAgo
    extends ScElement
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalDate _date;

    //##################################################
    //# constructor
    //##################################################

    public ScDateAgo()
    {
        css().add("dateago");
        _date = new ScLocalDate();
    }

    //##################################################
    //# utc ts
    //##################################################

    public KmDate getDate()
    {
        return _date.getValue();
    }

    public void setDate(KmDate e)
    {
        _date.setValue(e);
    }

    public boolean hasDate()
    {
        return _date.hasValue();
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.open("time");
        renderAttributesOn(out);
        out.close();

        out.end("time");
    }

    @Override
    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        super.renderAttributesOn(out);

        if ( hasDate() )
        {
            out.printAttribute("datetime", getDate().formatIso());
            out.getPostDom().run("KmDateAgo.update('%s');", getJquerySelector());
        }
    }
}
