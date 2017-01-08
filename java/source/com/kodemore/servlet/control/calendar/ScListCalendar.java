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

import com.kodemore.collection.KmList;
import com.kodemore.json.KmJsonMap;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.variable.ScLocalList;

/**
 * Display a day/week/month calendar view that supports dynamic events.
 *
 * I rely on static list that is configured as part of the initial calendar
 * setup. Although the events may be dynamically updated, the client-side
 * tool does NOT request updated information when the user navigates to
 * subsequent months or years. This tool may be suitable for use when there
 * are a relatively small number of events to display.
 *
 * @see ScAjaxCalendar
 *
 * This widget relies on the 3rd party Full Calendar.
 * See http://fullcalendar.io/
 */
public class ScListCalendar
    extends ScCalendar
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The events to be displayed on the calendar.
     */
    private ScLocalList<ScCalendarEvent> _events;

    //##################################################
    //# constructor
    //##################################################

    public ScListCalendar()
    {
        _events = new ScLocalList<>();
    }

    //##################################################
    //# accessing
    //##################################################

    public ScLocalList<ScCalendarEvent> getEvents()
    {
        return _events;
    }

    public void setEvents(ScLocalList<ScCalendarEvent> e)
    {
        _events = e;
    }

    public void setEvents(KmList<ScCalendarEvent> e)
    {
        _events.clear();
        _events.addAll(e);
    }

    public void removeAllEvents()
    {
        getEvents().clear();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderOptionEventsOn(KmJsonMap options)
    {
        KmList<ScCalendarEvent> list = getEvents().getValue();
        options.setArray("events", createEventsArray(list));
    }

    //##################################################
    //# ajax
    //##################################################

    /**
     * Refresh the client-side events based on the events currently
     * set in the server-side events list.
     */
    @Override
    public void ajaxRefreshEvents()
    {
        String ref = getJqueryReference();
        KmList<ScCalendarEvent> events = getEvents().getValue();

        KmJsonMap map;
        map = new KmJsonMap();
        map.setArray("events", createEventsArray(events));

        ScBlockScript ajax;
        ajax = getRootScript();
        ajax.run("%s.fullCalendar('removeEvents');", ref);
        ajax.run("%s.fullCalendar('addEventSource',%s);", ref, map);
    }

}
