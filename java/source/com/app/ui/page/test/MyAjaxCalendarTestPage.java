package com.app.ui.page.test;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScTextSpan;
import com.kodemore.servlet.control.calendar.ScAjaxCalendar;
import com.kodemore.servlet.control.calendar.ScCalendarEvent;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.servlet.variable.ScLocalTimestamp;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmDateInterval;
import com.kodemore.time.KmTime;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.KmRandom;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

/**
 * Test the calendar widget using an AJAX callback function
 * to dynamically generate the events.
 */
public final class MyAjaxCalendarTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyAjaxCalendarTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyAjaxCalendarTestPage();
    }

    public static MyAjaxCalendarTestPage getInstance()
    {
        return _instance;
    }

    private MyAjaxCalendarTestPage()
    {
        // singleton
    }

    //##################################################
    //# static
    //##################################################

    /**
     * NOT SAFE - FOR DEVELOPMENT TESTING ONLY
     *
     * This is the server-side list of events that are being managed.
     * This list would normally be managed in the database, but it
     * managed in a simplistic static variable for testing. This is
     * not intended to be thread safe, nor will it work correctly if
     * deployed in a multi-jvm environment.
     */
    private static KmList<ScCalendarEvent> _events = new KmList<>();

    //##################################################
    //# variables
    //##################################################

    private ScAjaxCalendar                 _calendar;

    private ScLocalString                  _eventUid;
    private ScLocalString                  _eventTitle;
    private ScLocalTimestamp               _eventStartUtcTs;
    private ScLocalTimestamp               _eventEndUtcTs;
    private ScLocalBoolean                 _eventAllDay;

    private ScTextSpan                     _selectionStartText;
    private ScTextSpan                     _selectionEndText;

    private ScTextSpan                     _clickText;

    private ScTextSpan                     _editEventText;
    private ScTextSpan                     _editStartText;
    private ScTextSpan                     _editEndText;

    //##################################################
    //# settings
    //##################################################

    @Override
    public final MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }

    //##################################################
    //# bookmark
    //##################################################

    @Override
    public void composeBookmarkOn(ScParameterList v)
    {
        // none
    }

    @Override
    public void applyBookmark(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        installVariables();

        root.css().fill().flexRow().rowSpacer10();
        installCalendarGroupOn(root);

        ScDiv col;
        col = root.addFlexColumn();
        col.css().flexChildFiller0().columnSpacer10();

        installSelectionGroupOn(col);
        installClickGroupOn(col);
        installEditGroupOn(col);
    }

    private void installVariables()
    {
        _eventUid = new ScLocalString();
        _eventUid.setAutoSave();

        _eventTitle = new ScLocalString();
        _eventTitle.setAutoSave();

        _eventStartUtcTs = new ScLocalTimestamp();
        _eventStartUtcTs.setAutoSave();

        _eventEndUtcTs = new ScLocalTimestamp();
        _eventEndUtcTs.setAutoSave();

        _eventAllDay = new ScLocalBoolean();
        _eventAllDay.setAutoSave();
    }

    private void installCalendarGroupOn(ScDiv root)
    {
        ScGroup group;
        group = root.addGroup("Calendar Test");
        group.css().flexChildFiller0();

        ScDiv body;
        body = group.getBody();
        body.add(createCalendar());
        body.css().clip();

        ScDiv buttons;
        buttons = group.showFooter().addButtonBox();
        buttons.addButton("Add Sample Events", this::handleAddSampleEvents);
        buttons.addButton("Remove All", this::handleRemoveEvents);
    }

    private ScAjaxCalendar createCalendar()
    {
        ScAjaxCalendar e;
        e = new ScAjaxCalendar();
        e.setEditable();
        e.setSelectable();
        e.setStandardBusinessHours();
        e.showBusinessHours();
        e.collapseEvents();
        e.setMinimumTime(KmTime.fromHour(2));
        e.setMaximumTime(KmTime.fromHour(22));
        e.setScrollTime(KmTime.fromHour(5));
        e.onSelect(newCheckedAction(this::handleSelect));
        e.onClick(newCheckedAction(this::handleClick));
        e.onEdit(newCheckedAction(this::handleEdit));
        e.setEventsFunction(this::getEventsFor);
        _calendar = e;
        return e;
    }

    private void installSelectionGroupOn(ScDiv root)
    {
        ScGroup group;
        group = root.addGroup("Select");
        group.css().flexChildFiller0();

        ScDiv body;
        body = group.getBody();
        body.css().pad().auto();
        body.addText(""
            + "Click the calendar to select a date/time. "
            + "Click and drag the calendar to select a date/time span.");
        body.addBreak();

        ScFieldLayout fields;
        fields = body.addFieldLayout();

        _selectionStartText = fields.addTextSpan();
        _selectionStartText.setLabel("Start");

        _selectionEndText = fields.addTextSpan();
        _selectionEndText.setLabel("End");

        ScDiv buttons;
        buttons = group.showFooter().addButtonBox();
        buttons.addButton("Add Event", this::handleAdd);
    }

    private void installClickGroupOn(ScDiv root)
    {
        ScGroup group;
        group = root.addGroup("Click Event");
        group.css().flexChildFiller0();

        ScDiv body;
        body = group.getBody();
        body.css().pad();

        ScFieldLayout fields;
        fields = body.addFieldLayout();
        fields.addText("Click an event.");

        _clickText = fields.addTextSpan();
        _clickText.setLabel("Event Clicked");

        ScDiv buttons;
        buttons = group.showFooter().addButtonBox();
        buttons.addButton("Remove", this::handleRemove);
        buttons.addButton("Style A", this::handleStyleA);
        buttons.addButton("Style B", this::handleStyleB);
        buttons.addButton("Style C", this::handleStyleC);
    }

    private void installEditGroupOn(ScDiv root)
    {
        ScGroup group;
        group = root.addGroup("Edit");
        group.css().flexChildFiller0();

        ScDiv body;
        body = group.getBody();
        body.css().pad();

        ScFieldLayout fields;
        fields = body.addFieldLayout();

        fields.addText(
            "Click and drag an event to move it.  "
                + "Resize an event by dragging the handle on the bottom of events in "
                + "the week or day view.");

        _editEventText = fields.addTextSpan();
        _editEventText.setLabel("Event Edited");

        _editStartText = fields.addTextSpan();
        _editStartText.setLabel("New Start");

        _editEndText = fields.addTextSpan();
        _editEndText.setLabel("New End");
    }

    //##################################################
    //# function
    //##################################################

    private KmList<ScCalendarEvent> getEventsFor(KmDate start, KmDate end)
    {
        KmDateInterval di = start.toInterval(end);
        return _events.select(e -> e.getUtcInterval().toDateInterval().intersects(di));
    }

    //##################################################
    //# handle
    //##################################################

    private void handleAddSampleEvents()
    {
        _events.addAll(getSampleEvents());
        _calendar.ajaxRefreshEvents();
    }

    private void handleRemoveEvents()
    {
        _events.clear();
        _calendar.ajaxRefreshEvents();
    }

    private void handleSelect()
    {
        ScCalendarEvent e = _calendar.getSelectEvent();

        setEvent(e);

        clearAllText();

        _selectionStartText.ajaxSetText(e.getStartUtcTs().format_m_d_yyyy_hh_mm_ss());
        _selectionStartText.ajaxGlow();

        _selectionEndText.ajaxSetText(e.getEndUtcTs().format_m_d_yyyy_hh_mm_ss());
        _selectionEndText.ajaxGlow();
    }

    private void handleAdd()
    {
        if ( !_eventStartUtcTs.hasValue() )
        {
            ajax().toast("Must select a date/time").warn();
            return;
        }

        ScCalendarEvent e;
        e = getEvent();
        e.setTitle("Event from selection");
        e.setCssSelection();

        _events.add(e);
        _calendar.ajaxRefreshEvents();

        clearAllText();
        clearEvent();
    }

    private void handleClick()
    {
        ScCalendarEvent e = _calendar.getClickEvent();

        setEvent(e);

        clearAllText();
        _clickText.ajaxSetText(e.getTitle());
        _clickText.ajaxGlow();
    }

    private void handleRemove()
    {
        if ( !_eventUid.hasValue() )
        {
            ajax().toast("Must click an event first").warn();
            return;
        }

        String uid = _eventUid.getValue();
        _events.removeIf(e -> e.hasUid(uid));
        _calendar.ajaxRefreshEvents();

        clearAllText();
        clearEvent();
    }

    private void handleStyleA()
    {
        if ( !_eventUid.hasValue() )
        {
            ajax().toast("Must click an event first").warn();
            return;
        }

        String uid = _eventUid.getValue();
        ScCalendarEvent ev = _events.selectFirst(e -> e.hasUid(uid));

        if ( ev == null )
        {
            ajax().toast("Invalid selection.").warn();
            return;
        }

        ev.setCssStyleA();
        _calendar.ajaxRefreshEvents();
    }

    private void handleStyleB()
    {
        if ( !_eventUid.hasValue() )
        {
            ajax().toast("Must click an event first").warn();
            return;
        }

        String uid = _eventUid.getValue();
        ScCalendarEvent ev = _events.selectFirst(e -> e.hasUid(uid));

        if ( ev == null )
        {
            ajax().toast("Invalid selection.").warn();
            return;
        }

        ev.setCssStyleB();
        _calendar.ajaxRefreshEvents();
    }

    private void handleStyleC()
    {
        if ( !_eventUid.hasValue() )
        {
            ajax().toast("Must click an event first").warn();
            return;
        }

        String uid = _eventUid.getValue();
        ScCalendarEvent ev = _events.selectFirst(e -> e.hasUid(uid));

        if ( ev == null )
        {
            ajax().toast("Invalid selection.").warn();
            return;
        }

        ev.setCssStyleC();
        _calendar.ajaxRefreshEvents();
    }

    private void handleEdit()
    {
        ScCalendarEvent e = _calendar.getEditEvent();

        clearAllText();

        KmTimestamp endUtcTs = e.getEndUtcTs();

        String endText = "null";
        if ( endUtcTs != null )
            endText = endUtcTs.format_m_d_yyyy_hh_mm_ss();

        _editEventText.ajaxSetText(e.getTitle());
        _editEventText.ajaxGlow();

        _editStartText.ajaxSetText(e.getStartUtcTs().format_m_d_yyyy_hh_mm_ss());
        _editStartText.ajaxGlow();

        _editEndText.ajaxSetText(endText);
        _editEndText.ajaxGlow();
    }

    //##################################################
    //# utility
    //##################################################

    private KmList<ScCalendarEvent> getSampleEvents()
    {
        KmList<ScCalendarEvent> v;
        v = new KmList<>();

        // Events that have time duration during a day
        int n = 10;
        for ( int i = 0; i < n; i++ )
        {
            String title = "Event " + i;
            KmTimestamp start = getRandomUtcTs().addHours(KmRandom.getInstance().getInteger(5));
            KmTimestamp end = start.addHours(KmRandom.getInstance().getInteger(3));

            v.add(createEvent(title, start, end));
        }

        // All days events
        n = 10;
        for ( int i = 0; i < n; i++ )
        {
            String title = "All Day Event " + i;
            KmDate start = getRandomDate();
            v.add(createAllDayEvent(title, start));
        }

        //Multi day events
        n = 3;
        for ( int i = 0; i < n; i++ )
        {
            String title = "Multi Day Event " + i;

            KmDate start = getRandomDate();
            KmDate end = start.addDays(KmRandom.getInstance().getInteger(7));

            v.add(createMultiDayEvent(title, start, end));
        }

        return v;
    }

    private KmTimestamp getRandomUtcTs()
    {
        KmRandom random = KmRandom.getInstance();

        KmTimestamp ts;
        ts = KmClock.getUtcTimestamp().getStartOfDay().addDays(random.getInteger(15));
        ts = ts.addHours(9);
        return ts;
    }

    private KmDate getRandomDate()
    {
        KmDate today = KmClock.getLocalDate();
        int dayOffset = KmRandom.getInstance().getInteger(30);

        return today.addDays(dayOffset);
    }

    private ScCalendarEvent createEvent(String title, KmTimestamp start, KmTimestamp end)
    {
        ScCalendarEvent e;
        e = new ScCalendarEvent();
        e.setTitle(title);
        e.setStartUtcTs(start);
        e.setEndUtcTs(end);
        return e;
    }

    private ScCalendarEvent createAllDayEvent(String title, KmDate start)
    {
        ScCalendarEvent e;
        e = new ScCalendarEvent();
        e.setTitle(title);
        e.setStartDate(start);
        e.setAllDay();
        return e;
    }

    private ScCalendarEvent createMultiDayEvent(String title, KmDate start, KmDate end)
    {
        ScCalendarEvent e;
        e = new ScCalendarEvent();
        e.setTitle(title);
        e.setStartDate(start);
        e.setEndDate(end);
        e.setAllDay();
        return e;
    }

    private void setEvent(ScCalendarEvent e)
    {
        if ( e == null )
        {
            clearEvent();
            return;
        }

        _eventUid.setValue(e.getUid());
        _eventTitle.setValue(e.getTitle());
        _eventStartUtcTs.setValue(e.getStartUtcTs());
        _eventEndUtcTs.setValue(e.getEndUtcTs());
        _eventAllDay.setValue(e.getAllDay());
    }

    private ScCalendarEvent getEvent()
    {
        ScCalendarEvent e;
        e = new ScCalendarEvent();
        e.setUid(_eventUid.getValue());
        e.setTitle(_eventTitle.getValue());
        e.setStartUtcTs(_eventStartUtcTs.getValue());
        e.setEndUtcTs(_eventEndUtcTs.getValue());
        e.setAllDay(_eventAllDay.getValue());
        return e;
    }

    private void clearEvent()
    {
        _eventUid.clearValue();
        _eventTitle.clearValue();
        _eventStartUtcTs.clearValue();
        _eventEndUtcTs.clearValue();
        _eventAllDay.clearValue();
    }

    private void clearAllText()
    {
        _selectionStartText.ajaxSetText("");
        _selectionEndText.ajaxSetText("");
        _clickText.ajaxSetText("");
        _editEventText.ajaxSetText("");
        _editStartText.ajaxSetText("");
        _editEndText.ajaxSetText("");
    }
}
