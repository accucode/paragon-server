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

package com.kodemore.servlet.control.calendar;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.KmStyleBuilder;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;
import com.kodemore.json.KmJsonReader;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScActionScript;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.script.ScVisibilityScript;
import com.kodemore.servlet.variable.ScLocalAction;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalDate;
import com.kodemore.servlet.variable.ScLocalList;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.servlet.variable.ScLocalStyle;
import com.kodemore.servlet.variable.ScLocalTime;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTime;
import com.kodemore.time.KmTimeZone;
import com.kodemore.time.KmTimestamp;
import com.kodemore.time.KmWeekDay;
import com.kodemore.types.KmHtmlColor;
import com.kodemore.utility.Kmu;

/**
 * Display a day/week/month calendar view that supports dynamic events.
 *
 * This widget relies on the 3rd party Full Calendar.
 * See http://fullcalendar.io/
 *
 * Abstract, use subclasses...
 * @see ScAjaxCalendar
 * @see ScListCalendar
 */

public abstract class ScCalendar
    extends ScControl
    implements ScHtmlIdIF
{
    //##################################################
    //# constants
    //##################################################

    private static final String KEY_EVENT_UID     = "eventUid";
    private static final String KEY_EVENT_TITLE   = "eventTitle";
    private static final String KEY_EVENT_START   = "eventStart";
    private static final String KEY_EVENT_END     = "eventEnd";
    private static final String KEY_EVENT_ALL_DAY = "eventAllDay";

    private static final String KEY_EVENT_CSS_NAME         = "eventCssName";
    private static final String KEY_EVENT_TEXT_COLOR       = "eventTextColor";
    private static final String KEY_EVENT_BACKGROUND_COLOR = "eventBackgroundColor";
    private static final String KEY_EVENT_BORDER_COLOR     = "eventBorderColor";

    private static final String VIEW_MONTH       = "month";
    private static final String VIEW_BASIC_WEEK  = "basicWeek";
    private static final String VIEW_BASIC_DAY   = "basicDay";
    private static final String VIEW_AGENDA_WEEK = "agendaWeek";
    private static final String VIEW_AGENDA_DAY  = "agendaDay";

    //##################################################
    //# variables
    //##################################################

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
     * The timeZone associated with this calendar.
     * Event times are specified in UTC but are converted to
     * this time for display on the calendar. The timeZone
     * defaults to UTC.
     */
    private ScLocalString _timeZoneCode;

    /**
     * If set, the calendar will display this date when loaded.
     * If not set, the calendar will initially display the current date.
     */
    private ScLocalDate _defaultDate;

    /**
     * If set open this view by default.
     */
    private ScLocalString _defaultView;

    //==================================================
    //= variables :: business hours
    //==================================================

    /**
     * If true, the calendar will highlight business hours and days. Business hours
     * must be set up for this to work, either by manually specifying business days
     * and hours, or by calling setStandardBusinessHours();
     */
    private ScLocalBoolean _showBusinessHours;

    /**
     * The optional business days.
     * If set, these are displayed in a different color.
     *
     * TIMEZONE: the business hours should be set relative to the
     * calendar's timezone.
     */
    private ScLocalList<KmWeekDay> _businessDays;

    /**
     * The optional start of the business day.
     * If set, the business hours are displayed in a different color.
     *
     * TIMEZONE: the business hours should be set relative to the
     * calendar's timezone. That is, if the calendar's time zone
     * is US/Eastern, then a start time of 5am means 5am Eastern.
     */
    private ScLocalTime _businessHoursStart;

    /**
     * The optional end of the business day.
     * If set, the business hours are displayed in a different color.
     *
     * TIMEZONE: the business hours should be set relative to the
     * calendar's timezone. That is, if the calendar's time zone
     * is US/Eastern, then an end time of 5am means 5am Eastern.
     */
    private ScLocalTime _businessHoursEnd;

    //==================================================
    //= variables :: min/max time
    //==================================================

    /**
     * The minimum time to be displayed.
     * Defaults to midnight at the start of day, 00:00:00.
     */
    private ScLocalTime _minimumTime;

    /**
     * The maximum time to display.
     * Defaults to midnight at end of day, 24:00:00;
     */
    private ScLocalTime _maximumTime;

    /**
     * The time of day that the view is initially scrolled to.
     * The user can still scroll up to the minimum time (or midnight).
     */
    private ScLocalTime _scrollTime;

    //==================================================
    //= variables :: other
    //==================================================

    /**
     * If true, show the header for the All Day events.
     * Default is true.
     */
    private ScLocalBoolean _showsAllDay;

    /**
     * Used to manage visibility (show/hide) but not exposed to client code.
     */
    private ScLocalStyle _style;

    //==================================================
    //= actions
    //==================================================

    /**
     * Called when the user highlights a new region in the calendar.
     * This is typically used to create a new event.
     *
     * NOTE: the calendar uses the 'extra' attribute internally.
     */
    private ScLocalAction _selectAction;

    /**
     * Called when the user clicks on an existing event.
     *
     * NOTE: the calendar uses the 'extra' attribute internally.
     */
    private ScLocalAction _clickAction;

    /**
     * Called when the user moves or resizes an existing event.
     *
     * NOTE: the calendar uses the 'extra' attribute internally.
     */
    private ScLocalAction _editAction;

    //##################################################
    //# constructor
    //##################################################

    public ScCalendar()
    {
        _editable = new ScLocalBoolean(false);
        _collapseEvents = new ScLocalBoolean(false);
        _selectable = new ScLocalBoolean(false);
        _showBusinessHours = new ScLocalBoolean(false);

        _timeZoneCode = new ScLocalString(KmTimeZone.UTC.getCode());

        _defaultDate = new ScLocalDate();
        _defaultView = new ScLocalString();

        _businessDays = new ScLocalList<>();
        _businessHoursStart = new ScLocalTime();
        _businessHoursEnd = new ScLocalTime();

        _minimumTime = new ScLocalTime();
        _maximumTime = new ScLocalTime();

        _scrollTime = new ScLocalTime();
        _showsAllDay = new ScLocalBoolean(true);

        _selectAction = new ScLocalAction();
        _clickAction = new ScLocalAction();
        _editAction = new ScLocalAction();

        _style = new ScLocalStyle();
    }

    //##################################################
    //# html id
    //##################################################

    @Override
    public String getHtmlId()
    {
        return getKeyToken();
    }

    @Override
    public ScHtmlIdAjax _htmlIdAjax()
    {
        return ScHtmlIdAjax.createOnRoot(this);
    }

    //##################################################
    //# accessing
    //##################################################

    //==================================================
    //= editable
    //==================================================

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

    //==================================================
    //= selectable
    //==================================================

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

    //==================================================
    //= business hours
    //==================================================

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

    //==================================================
    //= collapse
    //==================================================

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

    //==================================================
    //= default date
    //==================================================

    public KmDate getDefaultDate()
    {
        return _defaultDate.getValue();
    }

    public void setDefaultDate(KmDate e)
    {
        _defaultDate.setValue(e);
    }

    public boolean hasDefaultDate()
    {
        return getDefaultDate() != null;
    }

    //==================================================
    //= default view
    //==================================================

    public void setDefaultViewMonth()
    {
        setDefaultView(VIEW_MONTH);
    }

    public void setDefaultViewBasicWeek()
    {
        setDefaultView(VIEW_BASIC_WEEK);
    }

    public void setDefaultViewAgendaWeek()
    {
        setDefaultView(VIEW_AGENDA_WEEK);
    }

    public void setDefaultViewBasicDay()
    {
        setDefaultView(VIEW_BASIC_DAY);
    }

    public void setDefaultViewAgendaDay()
    {
        setDefaultView(VIEW_AGENDA_DAY);
    }

    private String getDefaultView()
    {
        return _defaultView.getValue();
    }

    private void setDefaultView(String e)
    {
        _defaultView.setValue(e);
    }

    public boolean hasDefaultView()
    {
        return _defaultView.hasValue();
    }

    //==================================================
    //= time zone
    //==================================================

    public KmTimeZone getTimeZone()
    {
        String code = _timeZoneCode.getValue();
        return KmTimeZone.findCode(code);
    }

    public void setTimeZone(KmTimeZone e)
    {
        String code = KmTimeZone.getCodeFor(e);
        _timeZoneCode.setValue(code);
    }

    //==================================================
    //= business days
    //==================================================

    public KmList<KmWeekDay> getBusinessDays()
    {
        return _businessDays.getValue();
    }

    public void setBusinessDays(KmList<KmWeekDay> v)
    {
        _businessDays.clear();
        _businessDays.addAll(v);
    }

    public void addBusinessDay(KmWeekDay e)
    {
        _businessDays.add(e);
    }

    public void clearBusinessDays()
    {
        _businessDays.clear();
    }

    //==================================================
    //= business hours start
    //==================================================

    public KmTime getBusinessHoursStart()
    {
        return _businessHoursStart.getValue();
    }

    public void setBusinessHoursStart(KmTime e)
    {
        _businessHoursStart.setValue(e);
    }

    public boolean hasBusinessHoursStart()
    {
        return _businessHoursStart.hasValue();
    }

    //==================================================
    //= business hours end
    //==================================================

    public KmTime getBusinessHoursEnd()
    {
        return _businessHoursEnd.getValue();
    }

    public void setBusinessHoursEnd(KmTime e)
    {
        _businessHoursEnd.setValue(e);
    }

    public boolean hasBusinessHoursEnd()
    {
        return _businessHoursEnd.hasValue();
    }

    //==================================================
    //= minimum time
    //==================================================

    public KmTime getMinimumTime()
    {
        return _minimumTime.getValue();
    }

    public void setMinimumTime(KmTime e)
    {
        _minimumTime.setValue(e);
    }

    public boolean hasMinimumTime()
    {
        return _minimumTime.hasValue();
    }

    //==================================================
    //= maximum time
    //==================================================

    public KmTime getMaximumTime()
    {
        return _maximumTime.getValue();
    }

    public void setMaximumTime(KmTime e)
    {
        _maximumTime.setValue(e);
    }

    public boolean hasMaximumTime()
    {
        return _maximumTime.hasValue();
    }

    //==================================================
    //= scroll time
    //==================================================

    public KmTime getScrollTime()
    {
        return _scrollTime.getValue();
    }

    public void setScrollTime(KmTime e)
    {
        _scrollTime.setValue(e);
    }

    public boolean hasScrollTime()
    {
        return _scrollTime.hasValue();
    }

    //==================================================
    //= shows all day
    //==================================================

    public boolean getShowsAllDay()
    {
        return _showsAllDay.isTrue();
    }

    public void setShowsAllDay(boolean e)
    {
        _showsAllDay.setValue(e);
    }

    //##################################################
    //# style
    //##################################################

    private KmStyleBuilder style()
    {
        return _style.toBuilder();
    }

    @Override
    public boolean isVisible()
    {
        return !style().hasHide();
    }

    @Override
    public void setVisible(boolean e)
    {
        style().hide();
    }

    //##################################################
    //# select action
    //##################################################

    public ScAction getSelectAction()
    {
        return _selectAction.getValue();
    }

    public void setSelectAction(ScAction e)
    {
        _selectAction.setValue(e);
    }

    public boolean hasSelectAction()
    {
        return _selectAction.hasValue();
    }

    public void onSelect(ScAction e)
    {
        setSelectAction(e);
    }

    //##################################################
    //# click action
    //##################################################

    public ScAction getClickAction()
    {
        return _clickAction.getValue();
    }

    public void setClickAction(ScAction e)
    {
        _clickAction.setValue(e);
    }

    public boolean hasClickAction()
    {
        return _clickAction.hasValue();
    }

    public void onClick(ScAction e)
    {
        setClickAction(e);
    }

    //##################################################
    //# edit action
    //##################################################

    public ScAction getEditAction()
    {
        return _editAction.getValue();
    }

    public void setEditAction(ScAction e)
    {
        _editAction.setValue(e);
    }

    public boolean hasEditAction()
    {
        return _editAction.hasValue();
    }

    public void onEdit(ScAction e)
    {
        setEditAction(e);
    }

    //##################################################
    //# convenience
    //##################################################

    /**
     * Set up standard business hours. Monday - Friday, 9am - 5pm.
     */
    public void setStandardBusinessHours()
    {
        clearBusinessDays();

        addBusinessDay(KmWeekDay.Monday);
        addBusinessDay(KmWeekDay.Tuesday);
        addBusinessDay(KmWeekDay.Wednesday);
        addBusinessDay(KmWeekDay.Thursday);
        addBusinessDay(KmWeekDay.Friday);

        setBusinessHoursStart(KmTime.fromHour(9));
        setBusinessHoursEnd(KmTime.fromHour(17));
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        out.openDiv();
        out.printAttribute("id", getHtmlId());
        out.printAttribute(style());
        out.close();
        out.endDiv();

        out.getPostRender().run(getRenderScript());
    }

    private String getRenderScript()
    {
        KmStringBuilder out;
        out = new KmStringBuilder();
        out.printf("%s.fullCalendar(%s);", getJqueryReference(), getCalendarOptions());
        return out.toString();
    }

    private KmJsonMap getCalendarOptions()
    {
        KmJsonMap map;
        map = new KmJsonMap();
        map.setBoolean("eventLimit", getCollapseEvents());
        map.setBoolean("selectable", getSelectable());
        map.setBoolean("editable", getEditable());
        map.setMap("header", getHeaderMap());
        map.setBoolean("allDaySlot", getShowsAllDay());
        map.setString("height", "parent");

        renderOptionEventsOn(map);

        if ( getShowBusinessHours() )
            map.setMap("businessHours", getBusinessHoursMap());

        if ( hasDefaultDate() )
            map.setString("defaultDate", getDefaultDate().formatIso());

        if ( hasDefaultView() )
            map.setString("defaultView", getDefaultView());

        if ( hasMinimumTime() )
            map.setString("minTime", getMinimumTime().format_hh24_mm_ss());

        if ( hasMaximumTime() )
            map.setString("maxTime", getMaximumTime().format_hh24_mm_ss());

        if ( hasScrollTime() )
            map.setString("scrollTime", getScrollTime().format_hh24_mm_ss());

        if ( hasSelectAction() )
            map.setLiteral("select", formatAjaxSelectFunction());

        if ( hasClickAction() )
            map.setLiteral("eventClick", formatAjaxClickFunction());

        if ( hasEditAction() )
        {
            String fn = formatAjaxEditFunction();
            map.setLiteral("eventDrop", fn);
            map.setLiteral("eventResize", fn);
        }

        return map;
    }

    private String formatAjaxSelectFunction()
    {
        ScAction action = getSelectAction();
        KmJsonMap options = composeAjaxOptionsFor(action);

        String kmuFn = Kmu.format("Kmu.ajaxCalendarSelect(start,end,%s)", options);
        String calFn = Kmu.format("function(start,end){%s}", kmuFn);

        return calFn;
    }

    private String formatAjaxClickFunction()
    {
        ScAction action = getClickAction();
        KmJsonMap options = composeAjaxOptionsFor(action);

        String kmuFn = Kmu.format("Kmu.ajaxCalendarEvent(event,%s)", options);
        String calFn = Kmu.format("function(event){%s}", kmuFn);

        return calFn;
    }

    private String formatAjaxEditFunction()
    {
        ScAction action = getEditAction();
        KmJsonMap options = composeAjaxOptionsFor(action);

        String kmuFn = Kmu.format("Kmu.ajaxCalendarEvent(event,%s)", options);
        String calFn = Kmu.format("function(event){%s}", kmuFn);

        return calFn;
    }

    private KmJsonMap composeAjaxOptionsFor(ScAction action)
    {
        ScActionScript script;
        script = new ScActionScript();
        script.setAction(action);
        script.setForm(findFormWrapper());
        return script.composeOptions();
    }

    protected abstract void renderOptionEventsOn(KmJsonMap options);

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
        map.setArray("dow", dow);

        if ( hasBusinessHoursStart() )
            map.setString("start", getBusinessHoursStart().format_hh24_mm_ss());

        if ( hasBusinessHoursEnd() )
            map.setString("end", getBusinessHoursEnd().format_hh24_mm_ss());

        return map;
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxAddEvent(ScCalendarEvent e)
    {
        String ref = getJqueryReference();
        KmJsonMap json = e.toJsonMap();

        getRootScript().run("%s.fullCalendar('renderEvent', %s, true);", ref, json);
    }

    public void ajaxRemoveEvent(String uid)
    {
        String ref = getJqueryReference();

        getRootScript().run("%s.fullCalendar('removeEvents', '%s');", ref, uid);
    }

    public void ajaxReplaceEvent(ScCalendarEvent e)
    {
        ajaxRemoveEvent(e.getUid());
        ajaxAddEvent(e);
    }

    public void ajaxUpdateEvent(ScCalendarEvent e)
    {
        String ref = getJqueryReference();
        KmJsonMap json = e.toJsonMap();

        getRootScript().run("Kmu.calendarUpdateEvent(%s,%s);", ref, json);
    }

    @Override
    public ScVisibilityScript ajaxShow(boolean e)
    {
        return _htmlIdAjax().show(e);
    }

    public void ajaxGoto(KmDate date)
    {
        String ref = getJqueryReference();
        String dateIso = date.formatIso();

        getRootScript().run("%s.fullCalendar('gotoDate', %s);", ref, json(dateIso));
    }

    public void ajaxGotoDefaultDate()
    {
        ajaxGoto(getDefaultDate());
    }

    /**
     * Re-render the calendar. This is mostly used for dynamic displays;
     * for example, this should be called when the calendar is used inside
     * a notebook tab.
     */
    public void ajaxRender()
    {
        getRootScript().run("%s.fullCalendar('render');", getJqueryReference());
    }

    /**
     * Refresh the client-side events. This is handled in different ways
     * by the subclasses.
     */
    public abstract void ajaxRefreshEvents();

    //##################################################
    //# response
    //##################################################

    /**
     * This returns a new event based on the user's selection.  This should only be
     * used inside the onSelection callback.
     */
    public ScCalendarEvent getSelectEvent()
    {
        KmJsonMap extra = parseExtraJson();

        if ( extra == null )
            return null;

        Long start = extra.getLong(KEY_EVENT_START);
        Long end = extra.getLong(KEY_EVENT_END);

        KmTimestamp startTs = KmTimestamp.fromEpochMs(start);
        KmTimestamp endTs = KmTimestamp.fromEpochMs(end);

        ScCalendarEvent e;
        e = new ScCalendarEvent();
        e.setStartTs(startTs);
        e.setEndTs(endTs);
        return e;
    }

    public ScCalendarEvent getClickEvent()
    {
        return getAjaxEvent();
    }

    public ScCalendarEvent getEditEvent()
    {
        return getAjaxEvent();
    }

    /**
     * Convenience method to retrieve the event from the calendar submitted through
     * one of its callbacks.
     */
    private ScCalendarEvent getAjaxEvent()
    {
        KmJsonMap extra = parseExtraJson();

        if ( extra == null )
            return null;

        String uid = extra.getString(KEY_EVENT_UID);
        String title = extra.getString(KEY_EVENT_TITLE);
        Long start = extra.getLong(KEY_EVENT_START);
        Long end = extra.getLong(KEY_EVENT_END);
        Boolean allDay = extra.getBoolean(KEY_EVENT_ALL_DAY);

        KmJsonArray cssArray = extra.getArray(KEY_EVENT_CSS_NAME);
        String textColor = extra.getString(KEY_EVENT_TEXT_COLOR);
        String backgroundColor = extra.getString(KEY_EVENT_BACKGROUND_COLOR);
        String borderColor = extra.getString(KEY_EVENT_BORDER_COLOR);

        KmTimestamp startTs = KmTimestamp.fromEpochMs(start);

        KmTimestamp endTs = end == null
            ? null
            : KmTimestamp.fromEpochMs(end);

        ScCalendarEvent e;
        e = new ScCalendarEvent();
        e.setUid(uid);
        e.setTitle(title);
        e.setStartTs(startTs);
        e.setEndTs(endTs);
        e.setAllDay(Kmu.isTrue(allDay));

        if ( cssArray.isNotEmpty() )
        {
            String cssNames = cssArray.toStringList().join(" ");
            e.setCss(cssNames);
        }

        if ( Kmu.hasValue(textColor) )
            e.setTextColor(KmHtmlColor.create(textColor));

        if ( Kmu.hasValue(backgroundColor) )
            e.setBackgroundColor(KmHtmlColor.create(backgroundColor));

        if ( Kmu.hasValue(borderColor) )
            e.setBorderColor(KmHtmlColor.create(borderColor));

        if ( Kmu.hasValue(backgroundColor) )
            e.setBackgroundColor(KmHtmlColor.create(backgroundColor));

        return e;
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

    protected KmJsonArray createEventsArray(KmList<ScCalendarEvent> v)
    {
        KmJsonArray arr = new KmJsonArray();

        for ( ScCalendarEvent e : v )
            arr.addMap(e.toJsonMap());

        return arr;
    }
}
