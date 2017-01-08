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

package com.kodemore.servlet.control.calendar;

import java.util.Iterator;
import java.util.function.BiFunction;

import com.kodemore.collection.KmList;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;
import com.kodemore.servlet.ScEncodedValueIF;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.encoder.ScDecoder;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.utility.ScServletCallback;
import com.kodemore.servlet.utility.ScServletCallbackRegistry;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmDateParser;
import com.kodemore.utility.Kmu;

/**
 * Display a day/week/month calendar view that supports dynamic events.
 *
 * I rely on a server-side function that dynamically generates the events
 * on-demand as the user navigates to different periods.
 *
 * @see ScListCalendar
 *
 * This widget relies on the 3rd party Full Calendar.
 * See http://fullcalendar.io/
 */
public class ScAjaxCalendar
    extends ScCalendar
{
    //##################################################
    //# constants
    //##################################################

    private static final String                               PARAMETER_TRACKED_VALUES = "myTrackedValues";

    //##################################################
    //# variables
    //##################################################

    private BiFunction<KmDate,KmDate,KmList<ScCalendarEvent>> _eventsFunction;

    /**
     * Used to bind extra data for filtering and sorting.
     * The values in this list will be encoded into the grid's
     * callback request url.  The values will be rebound to
     * their respective ScValue's prior to execute the filter.
     */
    private KmList<ScEncodedValueIF>                          _trackedValues;

    //##################################################
    //# constructor
    //##################################################

    public ScAjaxCalendar()
    {
        // none
    }

    //##################################################
    //# options
    //##################################################

    /**
     * events:
     * {
     *      url: /the/url,
     *      cache: false,
     *      data: function() { return... }
     * }
     *
     */
    @Override
    protected void renderOptionEventsOn(KmJsonMap options)
    {
        KmJsonMap map;
        map = options.setMap("events");
        map.setString("url", formatEventsUrl());
        map.setBoolean("cache", false);
        map.setLiteral("data", formatEventsFunction());
    }

    /**
     * The url used to fetch events via ajax.
     */
    private String formatEventsUrl()
    {
        ScServletCallbackRegistry r = ScServletCallbackRegistry.getInstance();
        ScServletCallback c = r.getCalendarCallback();
        return c.getPath(getKey());
    }

    /**
     * Compose a function that dynamically returns the current
     * contents of the page session and form.
     */
    private String formatEventsFunction()
    {
        String calRef = getJqueryReference();

        ScForm form = findFormWrapper();
        String formRef = form == null
            ? "null"
            : form.getJqueryReference();

        String val = Kmu.format("Kmu.calendarGetAjaxData(%s,%s)", calRef, formRef);
        String fun = Kmu.format("function(){return %s}", val);
        return fun;
    }

    //##################################################
    //# events
    //##################################################

    public BiFunction<KmDate,KmDate,KmList<ScCalendarEvent>> getEventsFunction()
    {
        return _eventsFunction;
    }

    public void setEventsFunction(BiFunction<KmDate,KmDate,KmList<ScCalendarEvent>> e)
    {
        _eventsFunction = e;
    }

    public boolean hasEventsFunction()
    {
        return _eventsFunction != null;
    }

    //##################################################
    //# ajax
    //##################################################

    /**
     * Refresh the client-side events by trigging an ajax refetch.
     */
    @Override
    public void ajaxRefreshEvents()
    {
        ScBlockScript ajax;
        ajax = getRootScript();
        ajax.run("%s.fullCalendar('refetchEvents');", getJqueryReference());
    }

    //##################################################
    //# calback :: static
    //##################################################

    /**
     * Handle servlet callback requests to fill the dropdown dynamically.
     * Callback handlers are registered in the ScServletCallbackRegistry.
     */
    public static void handleServletCallback(String pathSuffix)
    {
        ScAjaxCalendar e = getCalendarForPath(pathSuffix);
        if ( e != null )
            e.composeAjaxEvents();
    }

    private static ScAjaxCalendar getCalendarForPath(String suffix)
    {
        /*
         * We assume the pathSuffix is the control's key since that is
         * what we provided when composing the url.  See formatRequestUrl().
         */
        String key = suffix;
        if ( Kmu.isEmpty(key) )
            return null;

        ScControl e = getRegistry().getControl(key);
        return e instanceof ScAjaxCalendar
            ? (ScAjaxCalendar)e
            : null;
    }

    //==================================================
    //= callback :: instance
    //==================================================

    private void composeAjaxEvents()
    {
        ScServletData data = getData();

        KmDateParser p;
        p = new KmDateParser();
        p.setThreeNumberMode(KmDateParser.THREE_NUMBER_MODE_YEAR_MONTH_DAY);
        p.setSeparatorDash();

        String sStart = data.getParameter("start");
        String sEnd = data.getParameter("end");

        KmDate start = p.parse(sStart);
        KmDate end = p.parse(sEnd);

        if ( start == null )
            return;

        if ( end == null )
            return;

        applyTrackedValuesFor(data);

        KmList<ScCalendarEvent> events = _eventsFunction.apply(start, end);
        KmJsonArray json = createEventsArray(events);
        data.setJsonResult(json);
    }

    /**
     * Decode the values that are passed in on the request url and apply
     * them to the appropriate ScValue's.  This must be done prior to calling
     * the filter, so that the client code will be able to conveniently
     * access the values.
     */
    private void applyTrackedValuesFor(ScServletData data)
    {
        String encodedValues = data.getParameter(PARAMETER_TRACKED_VALUES);

        if ( Kmu.isEmpty(encodedValues) )
            return;

        KmList<?> decodedValues = (KmList<?>)ScDecoder.staticDecode(encodedValues);
        Iterator<?> decodedIterator = decodedValues.iterator();
        Iterator<ScEncodedValueIF> trackedIterator = _trackedValues.iterator();

        while ( decodedIterator.hasNext() )
        {
            Object nextDecode = decodedIterator.next();

            ScEncodedValueIF nextValue;
            nextValue = trackedIterator.next();
            nextValue.setEncodableValue(nextDecode);
        }
    }
}
