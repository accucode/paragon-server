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

import com.kodemore.json.KmJsonMap;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;
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

    public static final String ID      = "id";
    public static final String TITLE   = "title";
    public static final String START   = "start";
    public static final String END     = "end";
    public static final String ALL_DAY = "allDay";
    public static final String COLOR   = "color";

    //##################################################
    //# variables
    //##################################################

    private String      _uid;
    private String      _title;
    private KmTimestamp _startUtcTs;
    private KmTimestamp _endUtcTs;
    private boolean     _allDay;
    private KmHtmlColor _color;

    //##################################################
    //# constructors
    //##################################################

    public ScCalendarEvent()
    {
        _uid = Kmu.newUid();
    }

    //##################################################
    //# accessing
    //##################################################

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

    public String getTitle()
    {
        return _title;
    }

    public void setTitle(String e)
    {
        _title = e;
    }

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

    public KmHtmlColor getColor()
    {
        return _color;
    }

    public void setColor(KmHtmlColor e)
    {
        _color = e;
    }

    public boolean hasColor()
    {
        return getColor() != null;
    }

    //##################################################
    //# convenience
    //##################################################

    public void setStartDate(KmDate date)
    {
        if ( date == null )
        {
            setStartUtcTs(null);
            return;
        }

        setStartUtcTs(date.getStartOfDay());
    }

    public void setEndDate(KmDate date)
    {
        if ( date == null )
        {
            setEndUtcTs(null);
            return;
        }

        setEndUtcTs(date.getStartOfDay());
    }

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
        KmJsonMap map = new KmJsonMap();

        map.setString(ID, getUid());
        map.setString(TITLE, getTitle());
        map.setString(START, getStartIsoUtcString());
        map.setBoolean(ALL_DAY, getAllDay());

        if ( hasEndUtcTs() )
            map.setString(END, getEndIsoUtcString());

        if ( hasColor() )
            map.setString(COLOR, getColor().getValue());

        return map;
    }
}
