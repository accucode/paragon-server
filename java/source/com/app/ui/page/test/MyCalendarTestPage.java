package com.app.ui.page.test;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScAbsoluteLayout;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScCalendar;
import com.kodemore.servlet.control.ScCalendarEvent;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScTextSpan;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.servlet.variable.ScLocalTimestamp;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;
import com.kodemore.types.KmHtmlColor;
import com.kodemore.utility.KmRandom;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyCalendarTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyCalendarTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyCalendarTestPage();
    }

    public static MyCalendarTestPage getInstance()
    {
        return _instance;
    }

    private MyCalendarTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScCalendar _calendar;

    private ScLocalString    _eventUid;
    private ScLocalString    _eventTitle;
    private ScLocalTimestamp _eventStartUtcTs;
    private ScLocalTimestamp _eventEndUtcTs;
    private ScLocalBoolean   _eventAllDay;

    private ScTextSpan _selectionStartText;
    private ScTextSpan _selectionEndText;

    private ScTextSpan _clickText;

    private ScTextSpan _editEventText;
    private ScTextSpan _editStartText;
    private ScTextSpan _editEndText;

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

        ScAbsoluteLayout layout;
        layout = root.addAbsoluteLayout();

        ScBox left = addLeftPercentPadded(layout, 45);
        installCalendarGroupOn(left);

        ScBox top;
        top = addTopPercentPadded(layout, 32);
        installSelectionGroupOn(top);

        top = addTopPercentPadded(layout, 32);
        installClickGroupOn(top);

        ScBox center = addCenterPadded(layout);
        installEditGroupOn(center);
    }

    private void installCalendarGroupOn(ScDiv root)
    {
        ScGroup group;
        group = root.addGroup("Calendar Test");
        group.css().fill();

        ScDiv body;
        body = group.getBody();
        body.css().auto();

        _calendar = createCalendar();

        ScDiv div = body.addDiv();
        div.css().backgroundWhite();
        div.add(_calendar);

        ScBox buttons = group.showFooter().addButtonBox();
        buttons.addButton("Add Sample Events", this::handleAddSampleEvents);
        buttons.addButton("Remove All", this::handleRemoveEvents);
    }

    private ScCalendar createCalendar()
    {
        ScCalendar calendar;
        calendar = new ScCalendar();
        calendar.setEditable();
        calendar.setSelectable();
        calendar.setStandardBusinessHours();
        calendar.showBusinessHours();
        calendar.collapseEvents();

        calendar.setOnSelectAction(newAction(this::handleSelect));
        calendar.setOnClickAction(newAction(this::handleClick));
        calendar.setOnEditAction(newAction(this::handleEdit));

        calendar.setEvents(getSampleEvents());

        return calendar;
    }

    private void installSelectionGroupOn(ScDiv root)
    {
        ScGroup group;
        group = root.addGroup("Select");
        group.css().fill();

        ScDiv body;
        body = group.getBody();
        body.css().pad();

        ScFieldLayout fields;
        fields = body.addFieldLayout();

        fields.addText(
            "Click the calendar to select a date/time.  "
                + "Click and drag the calendar to select a date/time span.");

        _selectionStartText = fields.addTextSpan();
        _selectionStartText.setLabel("Start");

        _selectionEndText = fields.addTextSpan();
        _selectionEndText.setLabel("End");

        group.showFooter().addButtonBox().addButton("Add Event", this::handleAdd);
    }

    private void installClickGroupOn(ScDiv root)
    {
        ScGroup group;
        group = root.addGroup("Click Event");
        group.css().fill();

        ScDiv body;
        body = group.getBody();
        body.css().pad();

        ScFieldLayout fields;
        fields = body.addFieldLayout();

        fields.addText("Click an event.");

        _clickText = fields.addTextSpan();
        _clickText.setLabel("Event Clicked");

        ScBox buttons;
        buttons = group.showFooter().addButtonBox();
        buttons.addButton("Remove", this::handleRemove);
        buttons.addButton("Turn Red", this::handleRed);
    }

    private void installEditGroupOn(ScDiv root)
    {
        ScGroup group;
        group = root.addGroup("Edit");
        group.css().fill();

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
    //# layout
    //##################################################

    private ScBox addLeftPercentPadded(ScAbsoluteLayout root, int percent)
    {
        ScDiv left = root.addLeftPercent(percent);

        ScAbsoluteLayout inner;
        inner = left.addAbsoluteLayout();
        inner.padTop();
        inner.padLeft();
        inner.padBottom();

        ScBox content;
        content = inner.addCenter().addBox();
        content.css().fill();
        return content;
    }

    private ScBox addTopPercentPadded(ScAbsoluteLayout root, int percent)
    {
        ScDiv left = root.addTopPercent(percent);

        ScAbsoluteLayout inner;
        inner = left.addAbsoluteLayout();
        inner.padTop();
        inner.padLeft();
        inner.padRight();

        ScBox content;
        content = inner.addCenter().addBox();
        content.css().fill();
        return content;
    }

    private ScBox addCenterPadded(ScAbsoluteLayout root)
    {
        ScDiv left = root.addCenter();

        ScAbsoluteLayout inner;
        inner = left.addAbsoluteLayout();
        inner.padTop();
        inner.padLeft();
        inner.padBottom();
        inner.padRight();

        ScBox content;
        content = inner.addCenter().addBox();
        content.css().fill();
        return content;
    }

    //##################################################
    //# handle
    //##################################################

    private void handleAddSampleEvents()
    {
        _calendar.setEvents(getSampleEvents());
        _calendar.ajaxUpdateEvents();
    }

    private void handleRemoveEvents()
    {
        _calendar.removeAllEvents();
    }

    private void handleSelect()
    {
        ScCalendarEvent e = _calendar.getSelectionAsEvent();

        setEvent(e);

        clearAllText();

        _selectionStartText.ajaxSetText(e.getStartUtcTs().format_m_d_yyyy_hh_mm_ss());
        _selectionStartText.ajax().glow();

        _selectionEndText.ajaxSetText(e.getEndUtcTs().format_m_d_yyyy_hh_mm_ss());
        _selectionEndText.ajax().glow();
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
        e.setColor(KmHtmlColor.createGreen());

        _calendar.ajaxAddEvent(e);

        clearAllText();
        clearEvent();
    }

    private void handleClick()
    {
        ScCalendarEvent e = _calendar.getEventFromData();

        setEvent(e);

        clearAllText();
        _clickText.ajaxSetText(e.getTitle());
        _clickText.ajax().glow();
    }

    private void handleRemove()
    {
        if ( !_eventUid.hasValue() )
        {
            ajax().toast("Must click an event first").warn();
            return;
        }

        _calendar.ajaxRemoveEvent(_eventUid.getValue());

        clearAllText();
        clearEvent();
    }

    private void handleRed()
    {
        if ( !_eventUid.hasValue() )
        {
            ajax().toast("Must click an event first").warn();
            return;
        }

        ScCalendarEvent e = getEvent();
        e.setTitle(e.getTitle() + " - Red");
        e.setColor(KmHtmlColor.createRed());

        _calendar.ajaxUpdateEvent(e);
    }

    private void handleEdit()
    {
        ScCalendarEvent e = _calendar.getEventFromData();

        clearAllText();

        KmTimestamp endUtcTs = e.getEndUtcTs();

        String endText = "null";
        if ( endUtcTs != null )
            endText = endUtcTs.format_m_d_yyyy_hh_mm_ss();

        _editEventText.ajaxSetText(e.getTitle());
        _editEventText.ajax().glow();

        _editStartText.ajaxSetText(e.getStartUtcTs().format_m_d_yyyy_hh_mm_ss());
        _editStartText.ajax().glow();

        _editEndText.ajaxSetText(endText);
        _editEndText.ajax().glow();
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
        ts = KmClock.getTodayUtc().getStartOfDay().addDays(random.getInteger(15));
        ts = ts.addHours(9);
        return ts;
    }

    private KmDate getRandomDate()
    {
        return KmClock.getTodayUtc().addDays(KmRandom.getInstance().getInteger(30));
    }

    private ScCalendarEvent createEvent(String title, KmTimestamp start, KmTimestamp end)
    {
        ScCalendarEvent event;
        event = new ScCalendarEvent();
        event.setTitle(title);
        event.setStartUtcTs(start);
        event.setEndUtcTs(end);

        return event;
    }

    private ScCalendarEvent createAllDayEvent(String title, KmDate start)
    {
        ScCalendarEvent event;
        event = new ScCalendarEvent();
        event.setTitle(title);
        event.setStartDate(start);
        event.setAllDay();

        return event;
    }

    private ScCalendarEvent createMultiDayEvent(String title, KmDate start, KmDate end)
    {
        ScCalendarEvent event;
        event = new ScCalendarEvent();
        event.setTitle(title);
        event.setStartDate(start);
        event.setEndDate(end);
        event.setAllDay();

        return event;
    }

    private void setEvent(ScCalendarEvent e)
    {
        if ( e == null )
            clearEvent();

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
