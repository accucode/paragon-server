package com.app.ui.page.general;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScTimeZoneField;
import com.kodemore.time.KmTimeZone;

import com.app.model.MyProject;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.tools.MyProjectCalendar;

public final class MyProjectCalendarPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyProjectCalendarPage _instance;

    public static void installInstance()
    {
        _instance = new MyProjectCalendarPage();
    }

    public static MyProjectCalendarPage getInstance()
    {
        return _instance;
    }

    private MyProjectCalendarPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScTimeZoneField   _timeZoneField;
    private MyProjectCalendar _calendar;

    //##################################################
    //# settings
    //##################################################

    @Override
    public final MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.projectWorker;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().fill();

        ScForm form;
        form = root.addForm();
        form.css().fill().flexColumn();
        form.add(createSetupRow());
        form.addFlexGap(20);
        form.add(createCalendar());
    }

    private ScControl createSetupRow()
    {
        ScDiv row;
        row = new ScDiv();
        row.css().flexRow().flexChildStatic().rowSpacer20();
        row.addFieldLayout().add(createTimeZoneField());
        return row;
    }

    private ScControl createTimeZoneField()
    {
        ScTimeZoneField e;
        e = new ScTimeZoneField();
        e.onChange(newCheckedAction(this::handleUpdateCalendar));
        e.disableChangeTracking();
        e.setNullSelectPrefix();
        _timeZoneField = e;
        return e;
    }

    private ScControl createCalendar()
    {
        MyProjectCalendar e;
        e = new MyProjectCalendar();
        e.css().flexChildFiller();
        _calendar = e;
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        KmTimeZone zone = getCurrentTimeZone();
        _timeZoneField.setValue(zone);

        MyProject project = getCurrentProject();
        if ( project == null )
            return;

        _calendar.setProject(project);
        _calendar.setTimeZone(zone);
        _calendar.show();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleUpdateCalendar()
    {
        KmTimeZone zone = _timeZoneField.getValue();
        if ( zone == null )
        {
            _calendar.ajaxHide();
            return;
        }

        ajaxShowCalendarFor(zone);
    }

    private void ajaxShowCalendarFor(KmTimeZone zone)
    {
        MyProjectCalendar cal;
        cal = _calendar;
        cal.setProject(getCurrentProject());
        cal.setTimeZone(zone);
        cal.ajaxShow();
        cal.ajaxRefreshEvents();
    }

}
