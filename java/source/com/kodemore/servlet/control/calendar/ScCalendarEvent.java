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

import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.json.KmJsonMap;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmDuration;
import com.kodemore.time.KmTimestamp;
import com.kodemore.time.KmTimestampInterval;
import com.kodemore.types.KmHtmlColor;
import com.kodemore.utility.Kmu;

/**
 * An event for display in a ScCalendar.
 */
public class ScCalendarEvent
{
    //##################################################
    //# constants
    //##################################################

    public static final String  ID               = "id";
    public static final String  TITLE            = "title";
    public static final String  START            = "start";
    public static final String  END              = "end";
    public static final String  ALL_DAY          = "allDay";
    public static final String  EDITABLE         = "editable";

    public static final String  CSS_NAME         = "className";
    public static final String  TEXT_COLOR       = "textColor";
    public static final String  BACKGROUND_COLOR = "backgroundColor";
    public static final String  BORDER_COLOR     = "borderColor";

    //##################################################
    //# variables
    //##################################################

    private String              _uid;
    private String              _title;
    private KmTimestamp         _startUtcTs;
    private KmTimestamp         _endUtcTs;
    private boolean             _allDay;

    /**
     * Determine if this event is editable.
     * If null, the default rule is determined by the calendar.
     */
    private Boolean             _editable;

    //==================================================
    //= variables :: style
    //==================================================

    /**
     * The css class name. This is the preferred method for styling
     * events since configuration changes can be managed in the .css files.
     */
    private KmCssDefaultBuilder _css;

    private KmHtmlColor         _backgroundColor;
    private KmHtmlColor         _textColor;
    private KmHtmlColor         _borderColor;

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

    public KmTimestamp getStartUtcTs()
    {
        return _startUtcTs;
    }

    public void setStartUtcTs(KmTimestamp e)
    {
        _startUtcTs = e;
    }

    public boolean hasStartUtcTs()
    {
        return getStartUtcTs() != null;
    }

    //==================================================
    //= end
    //==================================================

    public KmTimestamp getEndUtcTs()
    {
        return _endUtcTs;
    }

    public void setEndUtcTs(KmTimestamp e)
    {
        _endUtcTs = e;
    }

    public boolean hasEndUtcTs()
    {
        return getEndUtcTs() != null;
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

    //##################################################
    //# convenience
    //##################################################

    public KmTimestampInterval getUtcInterval()
    {
        return KmTimestampInterval.create(getStartUtcTs(), getEndUtcTs());
    }

    public KmDuration getDuration()
    {
        return getUtcInterval().getDuration();
    }

    public void setStartDate(KmDate e)
    {
        if ( e == null )
            setStartUtcTs(null);
        else
            setStartUtcTs(e.getStartOfDay());
    }

    public void setEndDate(KmDate date)
    {
        if ( date == null )
            setEndUtcTs(null);
        else
            setEndUtcTs(date.getEndOfDay());
    }

    //##################################################
    //# format
    //##################################################

    private String getStartIsoUtcString()
    {
        if ( !hasStartUtcTs() )
            return null;

        if ( isAllDay() )
            return getStartUtcTs().getDate().formatIso();

        return getStartUtcTs().formatIsoUtc();
    }

    private String getEndIsoUtcString()
    {
        if ( !hasEndUtcTs() )
            return null;

        if ( isAllDay() )
            return getEndUtcTs().getDate().formatIso();

        return getEndUtcTs().formatIsoUtc();
    }

    public KmJsonMap toJsonMap()
    {
        KmJsonMap map;
        map = new KmJsonMap();
        map.setString(ID, getUid());
        map.setString(TITLE, getTitle());
        map.setString(START, getStartIsoUtcString());
        map.setBoolean(ALL_DAY, getAllDay());

        if ( hasEndUtcTs() )
            map.setString(END, getEndIsoUtcString());

        if ( hasEditable() )
            map.setBoolean(EDITABLE, getEditable());

        KmCssDefaultBuilder css = css();
        if ( css.hasValue() )
            map.setString(CSS_NAME, css().getValue());

        if ( hasTextColor() )
            map.setString(TEXT_COLOR, getTextColor().getHexValue());

        if ( hasBackgroundColor() )
            map.setString(BACKGROUND_COLOR, getBackgroundColor().getHexValue());

        if ( hasBorderColor() )
            map.setString(BORDER_COLOR, getBorderColor().getHexValue());

        return map;
    }

}
