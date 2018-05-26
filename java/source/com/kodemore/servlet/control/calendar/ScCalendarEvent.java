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

import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.json.KmJsonMap;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmDuration;
import com.kodemore.time.KmTimestamp;
import com.kodemore.time.KmTimestampRange;
import com.kodemore.types.KmHtmlColor;
import com.kodemore.utility.Kmu;

/**
 * An event for display in a ScCalendar.
 *
 * @see ScCalendar
 * @see ScListCalendar
 * @see ScAjaxCalendar
 */
public class ScCalendarEvent
{
    //##################################################
    //# constants
    //##################################################

    public static final String ID       = "id";
    public static final String TITLE    = "title";
    public static final String START    = "start";
    public static final String END      = "end";
    public static final String ALL_DAY  = "allDay";
    public static final String EDITABLE = "editable";

    public static final String CSS_NAME         = "className";
    public static final String TEXT_COLOR       = "textColor";
    public static final String BACKGROUND_COLOR = "backgroundColor";
    public static final String BORDER_COLOR     = "borderColor";
    public static final String RENDERING        = "rendering";

    //##################################################
    //# variables
    //##################################################

    /**
     * The unique value that identifies a particular event.
     */
    private String _uid;

    /**
     * The title displayed at the top of the calendar.
     */
    private String _title;

    /**
     * Determine if this event is editable.
     * If null, the default rule is determined by the calendar.
     */
    private Boolean _editable;

    //==================================================
    //= variables :: time
    //==================================================

    /**
     * The zone-less time at which this event starts.
     *
     * It is the clients responsibility to ensure that the calendar
     * and all of its events use a consistent time zone. If this is
     * set to 2:30am, the event will be displayed at 2:30am on the
     * calendar - the calendar does not apply any timezone offsets.
     *
     * If allDay is true, this is used to determine the date
     * of the event.
     */
    private KmTimestamp _startTs;

    /**
     * The zone-less time at which this event ends.
     *
     * See _startTs for details on timezone.
     * This is left null for allDay events.
     */
    private KmTimestamp _endTs;

    /**
     * Set to true for all day events.
     * If true, the startTs is used to determine the date.
     */
    private boolean _allDay;

    //==================================================
    //= variables :: style
    //==================================================

    /**
     * The css class name. This is the preferred method for styling
     * events since configuration changes can be managed in the .css files.
     */
    private KmCssDefaultBuilder _css;

    private KmHtmlColor _backgroundColor;
    private KmHtmlColor _textColor;
    private KmHtmlColor _borderColor;

    /**
     * If set to "background", the event will be rendered as a non-clickable
     * highlight in the background, rather than a floating event in the foreground.
     *
     * For example, this provides an alternate mechanism for rendering the
     * business hours. This is a more flexible approach, particularlly if
     * the business hours span from one day to the next.
     *
     * https://fullcalendar.io/docs/event_rendering/Background_Events/
     */
    private String _rendering;

    //##################################################
    //# constructors
    //##################################################

    public ScCalendarEvent()
    {
        _uid = Kmu.newUid();
        _css = new KmCssDefaultBuilder();
    }

    //##################################################
    //# accessing
    //##################################################

    //==================================================
    //= uid
    //==================================================

    public String getUid()
    {
        return _uid;
    }

    public void setUid(String e)
    {
        _uid = e;
    }

    public boolean hasUid(String e)
    {
        return Kmu.isEqual(e, getUid());
    }

    //==================================================
    //= title
    //==================================================

    public String getTitle()
    {
        return _title;
    }

    public void setTitle(String e)
    {
        _title = e;
    }

    //==================================================
    //= start
    //==================================================

    public KmTimestamp getStartTs()
    {
        return _startTs;
    }

    public void setStartTs(KmTimestamp e)
    {
        _startTs = e;
    }

    public boolean hasStartTs()
    {
        return getStartTs() != null;
    }

    //==================================================
    //= end
    //==================================================

    public KmTimestamp getEndTs()
    {
        return _endTs;
    }

    public void setEndTs(KmTimestamp e)
    {
        _endTs = e;
    }

    public boolean hasEndTs()
    {
        return getEndTs() != null;
    }

    //==================================================
    //= all day
    //==================================================

    public boolean getAllDay()
    {
        return _allDay;
    }

    public void setAllDay(boolean e)
    {
        _allDay = e;
    }

    public void setAllDay()
    {
        setAllDay(true);
    }

    public boolean isAllDay()
    {
        return getAllDay();
    }

    //==================================================
    //= css
    //==================================================

    public String getCss()
    {
        return _css.getValue();
    }

    public void setCss(String e)
    {
        css().setValue(e);
    }

    public boolean hasCss()
    {
        return _css.hasValue();
    }

    private KmCssDefaultBuilder css()
    {
        return _css;
    }

    public void setCssSelection()
    {
        css().clear().calendar_eventSelection();
    }

    public void setCssHoliday()
    {
        css().clear().calendar_eventHoliday();
    }

    public void setCssStyleA()
    {
        css().clear().calendar_eventA();
    }

    public void setCssStyleB()
    {
        css().clear().calendar_eventB();
    }

    public void setCssStyleC()
    {
        css().clear().calendar_eventC();
    }

    public void setCssStyleD()
    {
        css().clear().calendar_eventD();
    }

    public void setCssStyleE()
    {
        css().clear().calendar_eventE();
    }

    public void setCssStyleF()
    {
        css().clear().calendar_eventF();
    }

    public void addCssClickable()
    {
        css().calendar_clickable();
    }

    //==================================================
    //= text color
    //==================================================

    public KmHtmlColor getTextColor()
    {
        return _textColor;
    }

    public void setTextColor(KmHtmlColor e)
    {
        _textColor = e;
    }

    public boolean hasTextColor()
    {
        return getTextColor() != null;
    }

    //==================================================
    //= background color
    //==================================================

    public KmHtmlColor getBackgroundColor()
    {
        return _backgroundColor;
    }

    public void setBackgroundColor(KmHtmlColor e)
    {
        _backgroundColor = e;
    }

    public boolean hasBackgroundColor()
    {
        return getBackgroundColor() != null;
    }

    //==================================================
    //= border color
    //==================================================

    public KmHtmlColor getBorderColor()
    {
        return _borderColor;
    }

    public void setBorderColor(KmHtmlColor e)
    {
        _borderColor = e;
    }

    public boolean hasBorderColor()
    {
        return getBorderColor() != null;
    }

    //==================================================
    //= editable
    //==================================================

    public Boolean getEditable()
    {
        return _editable;
    }

    public void setEditable(Boolean e)
    {
        _editable = e;
    }

    public boolean hasEditable()
    {
        return _editable != null;
    }

    //==================================================
    //= rendering
    //==================================================

    public String getRenderingMode()
    {
        return _rendering;
    }

    public void setRenderingMode(String e)
    {
        _rendering = e;
    }

    public void setRenderingBackground()
    {
        setRenderingMode("background");
    }

    public boolean hasRenderingMode()
    {
        return Kmu.hasValue(getRenderingMode());
    }

    //##################################################
    //# convenience
    //##################################################

    public KmTimestampRange toRange()
    {
        return getStartTs().toRange(getEndTs());
    }

    public KmDuration toDuration()
    {
        return toRange().toDuration();
    }

    public void setStartDate(KmDate e)
    {
        if ( e == null )
            setStartTs(null);
        else
            setStartTs(e.getStartOfDay());
    }

    public void setEndDate(KmDate date)
    {
        if ( date == null )
            setEndTs(null);
        else
            setEndTs(date.getEndOfDay());
    }

    //##################################################
    //# format
    //##################################################

    private String getStartIsoString()
    {
        if ( !hasStartTs() )
            return null;

        if ( isAllDay() )
            return getStartTs().getDate().formatIso();

        return getStartTs().formatIsoUtc();
    }

    private String getEndIsoString()
    {
        if ( !hasEndTs() )
            return null;

        if ( isAllDay() )
            return getEndTs().getDate().formatIso();

        return getEndTs().formatIsoUtc();
    }

    public KmJsonMap toJsonMap()
    {
        KmJsonMap map;
        map = new KmJsonMap();
        map.setString(ID, getUid());
        map.setString(TITLE, getTitle());
        map.setString(START, getStartIsoString());
        map.setBoolean(ALL_DAY, getAllDay());

        if ( hasEndTs() )
            map.setString(END, getEndIsoString());

        if ( hasEditable() )
            map.setBoolean(EDITABLE, getEditable());

        if ( hasCss() )
            map.setString(CSS_NAME, css().getValue());

        if ( hasTextColor() )
            map.setString(TEXT_COLOR, getTextColor().getHexValue());

        if ( hasBackgroundColor() )
            map.setString(BACKGROUND_COLOR, getBackgroundColor().getHexValue());

        if ( hasBorderColor() )
            map.setString(BORDER_COLOR, getBorderColor().getHexValue());

        if ( hasRenderingMode() )
            map.setString(RENDERING, getRenderingMode());

        return map;
    }

}
