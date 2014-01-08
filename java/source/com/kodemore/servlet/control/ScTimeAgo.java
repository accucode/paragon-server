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

package com.kodemore.servlet.control;

import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.variable.ScLocalTimestamp;
import com.kodemore.time.KmTimestamp;

/**
 * Add a <time> element to the page, but then use client
 * side javascript to display a timestamp using formats like
 *      10 minutes ago
 *      5 hours from now.
 *
 * If you want to display dates in the future "... from now",
 * then you need to change the timeAgo default setting with:
 *      $.timeago.settings.allowFuture = true;            
 * 
 * This relies on the jquery timeago utility.
 * http://timeago.yarp.com/
 * MIT License
 */
public class ScTimeAgo
    extends ScElement
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalTimestamp _utcTs;

    //##################################################
    //# constructor
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _utcTs = new ScLocalTimestamp();
    }

    //##################################################
    //# source
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
    //# print
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.open("time");
        renderAttributesOn(out);
        out.close();

        // no end tag.
    }

    @Override
    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        super.renderAttributesOn(out);

        if ( hasUtcTs() )
        {
            out.printAttribute("datetime", getUtcTs().formatIsoUtc());
            out.getPostDom().run("%s.timeago();", getJqueryReference());
        }
    }
}
