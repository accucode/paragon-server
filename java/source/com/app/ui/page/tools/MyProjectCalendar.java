package com.app.ui.page.tools;

import com.kodemore.collection.KmList;
import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.calendar.ScAjaxCalendar;
import com.kodemore.servlet.control.calendar.ScCalendar;
import com.kodemore.servlet.control.calendar.ScCalendarEvent;
import com.kodemore.servlet.field.ScHiddenField;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmDateRange;
import com.kodemore.time.KmTime;
import com.kodemore.time.KmTimeZone;
import com.kodemore.time.KmTimestamp;
import com.kodemore.time.KmTimestampRange;
import com.kodemore.utility.KmEnumIF;
import com.kodemore.utility.Kmu;

import com.app.criteria.MyHolidayCriteria;
import com.app.dao.base.MyDaoAccess;
import com.app.model.MyHoliday;
import com.app.model.MyProject;
import com.app.utility.MyGlobals;

/**
 * A calendar that displays information about the current project.
 */
public class MyProjectCalendar
    extends ScDiv
{
    //##################################################
    //# variables
    //##################################################

    private ScHiddenField<String> _projectUidField;
    private ScHiddenField<String> _timeZoneCodeField;
    private ScAjaxCalendar        _calendar;

    //##################################################
    //# constructor
    //##################################################

    public MyProjectCalendar()
    {
        install();
    }

    //##################################################
    //# install
    //##################################################

    private void install()
    {
        MyProjectCalendar root;
        root = this;
        root.add(createProjectUidField());
        root.add(createTimeZoneCodeField());
        root.add(createCalendar());
    }

    //==================================================
    //= install :: fields
    //==================================================

    private ScHiddenField<String> createProjectUidField()
    {
        ScHiddenField<String> e;
        e = new ScHiddenField<>();
        _projectUidField = e;
        return e;
    }

    private ScHiddenField<String> createTimeZoneCodeField()
    {
        ScHiddenField<String> e;
        e = new ScHiddenField<>();
        _timeZoneCodeField = e;
        return e;
    }

    private ScAjaxCalendar createCalendar()
    {
        ScAjaxCalendar e;
        e = new ScAjaxCalendar();
        e.setShowsAllDay(false);
        e.setDefaultViewAgendaWeek();
        e.setEventsFunction(this::getAjaxEvents);
        e.onClick(newCheckedAction(this::handleClick));
        _calendar = e;
        return e;
    }

    //##################################################
    //# project
    //##################################################

    public MyProject getProject()
    {
        String uid = _projectUidField.getValue();
        return getAccess().findProjectUid(uid);
    }

    public void setProject(MyProject e)
    {
        String uid = e.getUid();
        _projectUidField.setValue(uid);
    }

    //##################################################
    //# zime zone
    //##################################################

    public KmTimeZone getTimeZone()
    {
        String code = _timeZoneCodeField.getValue();
        return KmTimeZone.findCode(code);
    }

    public void setTimeZone(KmTimeZone e)
    {
        String code = KmTimeZone.getCodeFor(e);
        _timeZoneCodeField.setValue(code);
    }

    //##################################################
    //# calendar
    //##################################################

    public ScCalendar getCalendar()
    {
        return _calendar;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    protected boolean applyFromModel_here(Object model)
    {
        if ( model instanceof MyProject )
            setProject((MyProject)model);

        return false;
    }

    //##################################################
    //# events
    //##################################################

    private KmList<ScCalendarEvent> getAjaxEvents(KmDate start, KmDate end)
    {
        KmList<ScCalendarEvent> v;
        v = new KmList<>();
        v.addAll(getBusinessHourEvents(start, end));
        v.addAll(getHolidayEvents(start, end));
        return v;
    }

    //==================================================
    //= events :: business hours
    //==================================================

    /**
     * @param end
     */
    private KmList<ScCalendarEvent> getBusinessHourEvents(KmDate start, KmDate end)
    {
        // Add one day to should to accomodate various timezone offsets.
        start = start.subtractDay();
        end = end.addDay();

        KmList<KmDate> dates = start.toRange(end).toList();

        KmList<ScCalendarEvent> events;
        events = dates.collect(e -> toBusinessHourEvent(e));
        events.removeNulls();
        return events;

    }

    private ScCalendarEvent toBusinessHourEvent(KmDate calendarDate)
    {
        MyProject project = getProject();
        KmTimeZone projectZone = project.getTimeZone();

        KmTimeZone calendarZone = getTimeZone();
        KmTimestamp calendarDayStart = calendarDate.getStartOfDay();

        KmTimestamp projectDayStart = calendarDayStart.changeZone(calendarZone, projectZone);
        KmDate projectDate = projectDayStart.getDate();

        boolean isBusinessDay = project.getBusinessDays().matchesDate(projectDate);
        if ( !isBusinessDay )
            return null;

        KmTime projectStartTime = project.getBusinessStartTime();
        KmTime projectEndTime = project.getBusinessEndTime();
        KmTimestamp projectStartTs = projectDate.toTimestamp(projectStartTime);
        KmTimestamp projectEndTs = projectDate.toTimestamp(projectEndTime);
        KmTimestampRange projectHours = projectStartTs.toRange(projectEndTs);

        KmTimestampRange calendarHours = projectHours.changeZone(projectZone, calendarZone);
        KmTimestamp calendarStart = calendarHours.getStart();
        KmTimestamp calendarEnd = calendarHours.getEnd();

        ScCalendarEvent ev;
        ev = new ScCalendarEvent();
        ev.setStartTs(calendarStart);
        ev.setEndTs(calendarEnd);
        ev.setRenderingBackground();
        return ev;
    }

    //==================================================
    //= events :: holidays
    //==================================================

    private KmList<ScCalendarEvent> getHolidayEvents(KmDate start, KmDate end)
    {
        MyProject project = getProject();
        KmDateRange dates = start.toRange(end);

        MyHolidayCriteria c;
        c = getAccess().getHolidayDao().createCriteria();
        c.whereProjectIs(project);
        c.whereDay().isIn(dates);

        return c.findAll().collect(e -> toHolidayEvent(e));
    }

    private ScCalendarEvent toHolidayEvent(MyHoliday holiday)
    {
        MyProject project = getProject();
        KmTimeZone projectZone = project.getTimeZone();
        KmTimeZone calendarZone = getTimeZone();

        KmDate date = holiday.getDay();
        KmTime startTime = project.getBusinessStartTime();
        KmTime endTime = project.getBusinessEndTime();

        KmTimestamp start;
        start = date.toTimestamp(startTime);
        start.changeZone(projectZone, calendarZone);

        KmTimestamp end;
        end = date.toTimestamp(endTime);
        end.changeZone(projectZone, calendarZone);

        ScCalendarEvent ev;
        ev = new ScCalendarEvent();
        ev.setUid(formatHolidayUid(holiday));
        ev.setTitle(holiday.getName());
        ev.setStartTs(start);
        ev.setEndTs(end);
        ev.setCssHoliday();
        return ev;
    }

    //##################################################
    //# event uids
    //##################################################

    private enum EventType
        implements KmEnumIF
    {
        holiday;
    }

    private String formatUid(EventType type, KmUidDomainIF e)
    {
        return formatTypePrefix(type) + e.getUid();
    }

    private String formatTypePrefix(EventType type)
    {
        return type.name() + "/";
    }

    private String getClickedUidFor(EventType type)
    {
        ScCalendarEvent ev = _calendar.getClickEvent();
        if ( ev == null )
            return null;

        String path = ev.getUid();
        String prefix = formatTypePrefix(type);

        return path.startsWith(prefix)
            ? Kmu.removePrefix(path, prefix)
            : null;
    }

    //==================================================
    //= uids :: holiday
    //==================================================

    private String formatHolidayUid(MyHoliday e)
    {
        return formatUid(EventType.holiday, e);
    }

    private MyHoliday getClickedHoliday()
    {
        String uid = getClickedUidFor(EventType.holiday);
        return getAccess().findHolidayUid(uid);
    }

    //##################################################
    //# ajax
    //##################################################

    public void ajaxRefreshEvents()
    {
        _projectUidField.ajaxUpdateFieldValues();
        _timeZoneCodeField.ajaxUpdateFieldValues();
        _calendar.ajaxRefreshEvents();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleClick()
    {
        for ( EventType type : EventType.values() )
            if ( handleClick(type) )
                break;
    }

    private boolean handleClick(EventType type)
    {
        switch ( type )
        {
            case holiday:
                return handleHolidayClicked();
        }
        throw Kmu.newEnumError(type);
    }

    private boolean handleHolidayClicked()
    {
        MyHoliday e = getClickedHoliday();
        if ( e == null )
            return false;

        ajaxToast("Holiday: %s", e.getName());
        return true;
    }

    //##################################################
    //# support
    //##################################################

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }
}
