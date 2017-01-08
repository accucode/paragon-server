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
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmTimeZone;
import com.kodemore.time.KmTimestamp;

/**
 * Display the current time, in a specified time zone,
 * then use a client side script to update the display.
 *
 * See KmClock.js
 */
public class ScClockField
    extends ScElement
{
    //##################################################
    //# constants
    //##################################################

    /**
     * The client-side script relies on this tag to identify
     * the clocks to be updated.
     *
     * See kmClock.js
     */
    private static final String HTML_TAG   = "div";

    /**
     * The client-side script relies on this attribute to identify
     * the clocks to be updated.
     *
     * See kmClock.js
     */
    private static final String HTML_CLASS = "clock";

    /**
     * The html 'data' attribute used to indicate the timezone for
     * a specific field. This should be all lowercase for compatibility
     * with html attributes.
     */
    private static final String TIME_ZONE  = "timezone";

    //##################################################
    //# variables
    //##################################################

    /**
     * The time zone to use for the clock.
     */
    private ScLocalString       _timeZoneCode;

    //##################################################
    //# constructor
    //##################################################

    public ScClockField()
    {
        _timeZoneCode = new ScLocalString(KmTimeZone.UTC.getCode());

        css().add(HTML_CLASS);
    }

    //##################################################
    //# utc ts
    //##################################################

    public KmTimeZone getTimeZone()
    {
        String code = _timeZoneCode.getValue();
        return KmTimeZone.findCode(code);
    }

    public void setTimeZone(KmTimeZone e)
    {
        _timeZoneCode.setValue(e.getCode());
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.open(HTML_TAG);
        renderAttributesOn(out);
        out.close();

        out.print(formatTime());
        out.end(HTML_TAG);
    }

    @Override
    protected void renderAttributesOn(KmHtmlBuilder out)
    {
        super.renderAttributesOn(out);

        out.printDataAttribute(TIME_ZONE, _timeZoneCode.getValue());
    }

    //##################################################
    //# support
    //##################################################

    private String formatTime()
    {
        KmTimestamp ts = KmClock.getUtcTimestamp().toLocal(getTimeZone());
        return ts.getTime().format_h_mm_am();
    }

}
