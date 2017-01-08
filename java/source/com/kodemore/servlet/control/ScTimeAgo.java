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

package com.kodemore.servlet.control;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalTimestamp;
import com.kodemore.time.KmTimestamp;

/**
 * Add a <time> element to the page, but then use client
 * side javascript to display a timestamp using formats like
 *      10 minutes ago
 *      5 hours from now.
 *
 * See KmTimeAgo.js
 */
public class ScTimeAgo
    extends ScElement
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalTimestamp _utcTs;
    private ScLocalBoolean   _showsSuffix;

    //##################################################
    //# constructor
    //##################################################

    public ScTimeAgo()
    {
        _utcTs = new ScLocalTimestamp();
        _showsSuffix = new ScLocalBoolean(true);

        css().add("timeago");
    }

    //##################################################
    //# utc ts
    //##################################################

    public KmTimestamp getUtcTs()
    {
        return _utcTs.getValue();
    }

    public void setUtcTs(KmTimestamp e)
    {
        _utcTs.setValue(e);
    }

    public boolean hasUtcTs()
    {
        return _utcTs.hasValue();
    }

    //##################################################
    //# suffix
    //##################################################

    public boolean getShowsSuffix()
    {
        return _showsSuffix.getValue();
    }

    public void setShowsSuffix(boolean e)
    {
        _showsSuffix.setValue(e);
    }

    public void hideSuffix()
    {
        setShowsSuffix(false);
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

        if ( hasUtcTs() )
        {
            out.printDataAttribute("timeago-datetime", getUtcTs().formatIsoUtc());
            out.printDataAttribute("timeago-suffix", getShowsSuffix());
            out.getPostDom().run("KmTimeAgo.update(%s);", json(getJquerySelector()));
        }
    }
}
