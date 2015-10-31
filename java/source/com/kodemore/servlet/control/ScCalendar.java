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

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;
import com.kodemore.json.KmJsonReader;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.utility.ScJquery;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalList;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTime;
import com.kodemore.time.KmTimestamp;
import com.kodemore.time.KmWeekDay;
import com.kodemore.types.KmHtmlColor;
import com.kodemore.utility.Kmu;

/**
 * This is a calendar tool that uses a 3rd party javascript library.  The
 * current library used is Full Calendar.  See http://fullcalendar.io/ for
 * more info.
 */
public class ScCalendar
    extends ScControl
    implements ScHtmlIdIF
{
    //##################################################
    //# constants
    //##################################################

    public static final String EVENT_UID_KEY     = "eventUid";
    public static final String EVENT_TITLE_KEY   = "eventTitle";
    public static final String EVENT_START_KEY   = "eventStart";
    public static final String EVENT_END_KEY     = "eventEnd";
    public static final String EVENT_ALL_DAY_KEY = "eventAllDay";
    public static final String EVENT_COLOR_KEY   = "eventColor";

    //##################################################
    //# variables
    //##################################################

    /**
     * The events to be displayed on the calendar.
     */
    private ScLocalList<ScCalendarEvent> _events;

    /**
     * If the user is allowed to drag or resize events on the calendar.
     */
    private ScLocalBoolean _editable;

    /**
     * If true, days with many events will only display the first few with
     * a "+n more" link at the bottom to view the rest.
     */
    private ScLocalBoolean _collapseEvents;

    /**
     * If true the user may select a day/time or day/time span on the calendar.
     * A callback action can be set for this using setOnSelectAction().
     */
    private ScLocalBoolean _selectable;

    /**
     * If true, the calendar will highlight business hours and days. Business hours
     * must be set up for this to work, either by manually specifying business days
     * and hours, or by calling setStandardBusinessHours();
     */
    private ScLocalBoolean _showBusinessHours;

    /**
     * If set, the calendar will display this date when loaded.  If not set, the
     * calendar will always display the current date.
     */
    private ScLocalString _defaultDate;

    private ScLocalList<KmWeekDay> _businessDays;

    private ScLocalString _businessHoursStart;
    private ScLocalString _businessHoursEnd;

    private ScLocalString _onSelectScript;
    private ScLocalString _onClickScript;
    private ScLocalString _onEditScript;

    //##################################################
    //# html id
    //##################################################

    @Override
    public String getHtmlId()
    {
        return getKey();
    }

    @Override
    public String getJquerySelector()
    {
        return ScJquery.formatSelector(this);
    }

    @Override
    public ScHtmlIdAjax ajax()
    {
        return new ScHtmlIdAjax(this, getRootScript());
    }

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _events = new ScLocalList<>();

        _editable = new ScLocalBoolean(false);
        _collapseEvents = new ScLocalBoolean(false);
        _selectable = new ScLocalBoolean(false);
        _showBusinessHours = new ScLocalBoolean(false);

        _defaultDate = new ScLocalString();

        _businessDays = new ScLocalList<>();
        _businessHoursStart = new ScLocalString();
        _businessHoursEnd = new ScLocalString();

        _onSelectScript = new ScLocalString();
        _onClickScript = new ScLocalString();
        _onEditScript = new ScLocalString();
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.openDiv();
        out.printAttribute("id", getHtmlId());
        out.close();
        out.endDiv();

        out.getPostRender().run(getRenderScript());
    }

    private String getRenderScript()
    {
        KmStringBuilder out = new KmStringBuilder();

        out.printf("$('%s').fullCalendar(%s);", getJquerySelector(), getOptionsMap());

        return out.toString();
    }

    //##################################################
    //# options
    //##################################################

    private KmJsonMap getOptionsMap()
    {
        KmJsonMap map;
        map = new KmJsonMap();

        map.setBoolean("eventLimit", getCollapseEvents());
        map.setBoolean("selectable", getSelectable());
        map.setBoolean("editable", getEditable());

        map.setMap("header", getHeaderMap());

        if ( getShowBusinessHours() )
            map.setMap("businessHours", getBusinessHoursMap());

        if ( hasDefaultDate() )
            map.setString("defaultDate", getDefaultDate());

        if ( hasOnSelectScript() )
            map.setLiteral("select", Kmu.format("function(start,end){%s}", getOnSelectScript()));

        if ( hasOnEditScript() )
        {
            map.setLiteral("eventDrop", Kmu.format("function(event){%s}", getOnEditScript()));
            map.setLiteral("eventResize", Kmu.format("function(event){%s}", getOnEditScript()));
        }

        if ( hasOnClickScript() )
            map.setLiteral("eventClick", Kmu.format("function(event){%s}", getOnClickScript()));

        map.setArray("events", formatEventsJsonArray());

        return map;
    }

    private KmJsonMap getHeaderMap()
    {
        KmJsonMap map;
        map = new KmJsonMap();
        map.setString("left", "prev,next,today");
        map.setString("center", "title");
        map.setString("right", "month,agendaWeek,agendaDay");
        return map;
    }

    private KmJsonMap getBusinessHoursMap()
    {
        KmJsonArray dow = new KmJsonArray();

        for ( KmWeekDay day : getBusinessDays() )
            dow.addInteger(day.getIndex());

        KmJsonMap map;
        map = new KmJsonMap();
        map.setString("start", getBusinessHoursStart());
        map.setString("end", getBusinessHoursEnd());
        map.setArray("dow", dow);

        return map;
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

    public boolean getEditable()
    {
        return _editable.getValue();
    }

    public void setEditable(boolean e)
    {
        _editable.setValue(e);
    }

    public void setEditable()
    {
        setEditable(true);
    }

    public boolean getSelectable()
    {
        return _selectable.getValue();
    }

    public void setSelectable(boolean e)
    {
        _selectable.setValue(e);
    }

    public void setSelectable()
    {
        setSelectable(true);
    }

    public boolean getShowBusinessHours()
    {
        return _showBusinessHours.getValue();
    }

    public void setShowBusinessHours(boolean e)
    {
        _showBusinessHours.setValue(e);
    }

    public void showBusinessHours()
    {
        setShowBusinessHours(true);
    }

    public boolean getCollapseEvents()
    {
        return _collapseEvents.getValue();
    }

    public void setCollapseEvents(boolean e)
    {
        _collapseEvents.setValue(e);
    }

    public void collapseEvents()
    {
        setCollapseEvents(true);
    }

    public String getDefaultDate()
    {
        return _defaultDate.getValue();
    }

    public void setDefaultDate(KmDate e)
    {
        _defaultDate.setValue(e.formatIso());
    }

    public boolean hasDefaultDate()
    {
        return getDefaultDate() != null;
    }

    public KmList<KmWeekDay> getBusinessDays()
    {
        return _businessDays.getValue();
    }

    public void addBusinessDay(KmWeekDay e)
    {
        _businessDays.add(e);
    }

    public String getBusinessHoursStart()
    {
        return _businessHoursStart.getValue();
    }

    public void setBusinessHoursStart(KmTime e)
    {
        _businessHoursStart.setValue(e.format_hh24_mm_ss());
    }

    public String getBusinessHoursEnd()
    {
        return _businessHoursEnd.getValue();
    }

    public void setBusinessHoursEnd(KmTime e)
    {
        _businessHoursEnd.setValue(e.format_hh24_mm_ss());
    }

    public void setOnSelectScript(String e)
    {
        _onSelectScript.setValue(e);
    }

    public String getOnSelectScript()
    {
        return _onSelectScript.getValue();
    }

    public boolean hasOnSelectScript()
    {
        return _onSelectScript.hasValue();
    }

    public String getOnClickScript()
    {
        return _onClickScript.getValue();
    }

    public void setOnClickScript(String e)
    {
        _onClickScript.setValue(e);
    }

    public boolean hasOnClickScript()
    {
        return _onClickScript.hasValue();
    }

    public String getOnEditScript()
    {
        return _onEditScript.getValue();
    }

    public void setOnMoveScript(String e)
    {
        _onEditScript.setValue(e);
    }

    public boolean hasOnEditScript()
    {
        return _onEditScript.hasValue();
    }

    //##################################################
    //# action
    //##################################################

    /**
     * This uses Kmu.calendarSelectAjax in Kmu.js
     */
    public void setOnSelectAction(ScAction action)
    {
        KmStringBuilder out;
        out = new KmStringBuilder();

        KmJsonMap actionMap;
        actionMap = new KmJsonMap();
        actionMap.setString("key", action.getKey());

        out.printf("Kmu.calendarSelectAjax(%s, start, end);", actionMap);

        setOnSelectScript(out.toString());
    }

    /**
     * This uses Kmu.calendarAjax in Kmu.js
     */
    public void setOnClickAction(ScAction action)
    {
        KmStringBuilder out;
        out = new KmStringBuilder();

        KmJsonMap actionMap;
        actionMap = new KmJsonMap();
        actionMap.setString("key", action.getKey());

        out.printf("Kmu.calendarAjax(%s, event);", actionMap);

        setOnClickScript(out.toString());
    }

    /**
     * This uses Kmu.calendarAjax in Kmu.js
     */
    public void setOnEditAction(ScAction action)
    {
        KmStringBuilder out;
        out = new KmStringBuilder();

        KmJsonMap actionMap;
        actionMap = new KmJsonMap();
        actionMap.setString("key", action.getKey());

        out.printf("Kmu.calendarAjax(%s, event);", actionMap);

        setOnMoveScript(out.toString());
    }

    //##################################################
    //# convenience
    //##################################################

    public void removeAllEvents()
    {
        getEvents().clear();
    }

    public void ajaxUpdateEvents()
    {
        ajax().run("$('%s').fullCalendar('removeEvents');", getJquerySelector());
        ajax().run(
            "$('%s').fullCalendar('addEventSource',%s);",
            getJquerySelector(),
            formatEventsJson());
    }

    public void ajaxAddEvent(ScCalendarEvent e)
    {
        ajax().run(
            "$('%s').fullCalendar('renderEvent', %s, true);",
            getJquerySelector(),
            e.toJsonMap());
    }

    public void ajaxRemoveEvent(String uid)
    {
        ajax().run("$('%s').fullCalendar('removeEvents', '%s');", getJquerySelector(), uid);
    }

    public void ajaxReplaceEvent(ScCalendarEvent e)
    {
        ajaxRemoveEvent(e.getUid());
        ajaxAddEvent(e);
    }

    public void ajaxUpdateEvent(ScCalendarEvent e)
    {
        ajax().run("Kmu.calendarUpdateEventAjax($('%s'), %s);", getJquerySelector(), e.toJsonMap());
    }

    /**
     * This returns a new event based on the user's selection.  This should only be
     * used inside the onSelection callback.
     */
    public ScCalendarEvent getSelectionAsEvent()
    {
        KmJsonMap extra = parseExtraJson();

        if ( extra == null )
            return null;

        Long start = extra.getLong(ScCalendar.EVENT_START_KEY);
        Long end = extra.getLong(ScCalendar.EVENT_END_KEY);

        KmTimestamp startUtcTs = KmTimestamp.fromEpochMs(start);
        KmTimestamp endUtcTs = KmTimestamp.fromEpochMs(end);

        ScCalendarEvent e;
        e = new ScCalendarEvent();
        e.setStartUtcTs(startUtcTs);
        e.setEndUtcTs(endUtcTs);
        return e;
    }

    /**
     * Convenience method to retrieve the event from the calendar submitted through
     * one of its callbacks.
     */
    public ScCalendarEvent getEventFromData()
    {
        KmJsonMap extra = parseExtraJson();

        if ( extra == null )
            return null;

        String uid = extra.getString(ScCalendar.EVENT_UID_KEY);
        String title = extra.getString(ScCalendar.EVENT_TITLE_KEY);
        Long start = extra.getLong(ScCalendar.EVENT_START_KEY);
        Long end = extra.getLong(ScCalendar.EVENT_END_KEY);
        Boolean allDay = extra.getBoolean(ScCalendar.EVENT_ALL_DAY_KEY);
        String color = extra.getString(ScCalendar.EVENT_COLOR_KEY);

        KmTimestamp startUtcTs = KmTimestamp.fromEpochMs(start);

        KmTimestamp endUtcTs = null;
        if ( end != null )
            endUtcTs = KmTimestamp.fromEpochMs(end);

        ScCalendarEvent e;
        e = new ScCalendarEvent();
        e.setUid(uid);
        e.setTitle(title);
        e.setStartUtcTs(startUtcTs);
        e.setEndUtcTs(endUtcTs);
        e.setAllDay(Kmu.isTrue(allDay));

        if ( Kmu.hasValue(color) )
            e.setColor(KmHtmlColor.create(color));

        return e;
    }

    /**
     * Set up standar business hours. Monday - Friday, 9am - 5pm.
     */
    public void setStandardBusinessHours()
    {
        addBusinessDay(KmWeekDay.Monday);
        addBusinessDay(KmWeekDay.Tuesday);
        addBusinessDay(KmWeekDay.Wednesday);
        addBusinessDay(KmWeekDay.Thursday);
        addBusinessDay(KmWeekDay.Friday);

        setBusinessHoursStart(KmTime.fromHour(9));
        setBusinessHoursEnd(KmTime.fromHour(17));
    }

    //##################################################
    //# utility
    //##################################################

    private KmJsonMap parseExtraJson()
    {
        String extraString = getData().getExtraParameter();

        if ( Kmu.isEmpty(extraString) )
            return null;

        KmJsonMap extra = KmJsonReader.parseJsonMap(extraString);
        return extra;
    }

    //##################################################
    //# events
    //##################################################

    private KmJsonMap formatEventsJson()
    {
        KmJsonMap map;
        map = new KmJsonMap();

        KmJsonArray arr = map.setArray("events");

        for ( ScCalendarEvent e : getEvents() )
            arr.addMap(e.toJsonMap());

        return map;
    }

    private KmJsonArray formatEventsJsonArray()
    {
        KmJsonArray arr = new KmJsonArray();

        for ( ScCalendarEvent e : getEvents() )
            arr.addMap(e.toJsonMap());

        return arr;
    }
}
