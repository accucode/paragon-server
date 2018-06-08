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

package com.kodemore.servlet.control.chart;

import java.util.function.Function;

import com.kodemore.string.KmStringBuilder;
import com.kodemore.time.KmDate;
import com.kodemore.utility.KmVirtualOptions;
import com.kodemore.utility.Kmu;

/**
 * A gantt chart to be used with dates.
 */
public class ScDateGanttChart
    extends ScGanttChart
{
    //##################################################
    //# constants
    //##################################################

    private static final String NONE = KmVirtualOptions.NONE;

    //##################################################
    //# setup
    //##################################################

    @Override
    protected Integer getDefaultUnitWidth()
    {
        return 400;
    }

    //##################################################
    //# mode
    //##################################################

    public void setChartMode(ScDateGanttChartMode e)
    {
        switch ( e )
        {
            case Day:
                setChartModeDay();
                return;

            case Month:
                setChartModeMonth();
                return;

            case Week:
                setChartModeWeek();
                return;
        }
        throw Kmu.newEnumError(e);
    }

    public void setChartModeDay()
    {
        setAxisUnitWidth(getDefaultUnitWidth());
        setAxisIntervalDay();
    }

    public void setChartModeWeek()
    {
        int width = getDefaultUnitWidth() / 7;

        setAxisUnitWidth(width);
        setAxisIntervalWeek();
        formatAxis_m_d();
    }

    public void setChartModeMonth()
    {
        int width = getDefaultUnitWidth() / 30;

        setAxisUnitWidth(width);
        setAxisIntervalMonth();
        formatAxis_monthName_day();
    }

    //##################################################
    //# range
    //##################################################

    public KmDate getRangeMin()
    {
        return intToDate(getRangeMinIntValue());
    }

    public void setRangeMin(KmDate e)
    {
        setRangeMinIntValue(dateToInt(e));
    }

    public KmDate getRangeMax()
    {
        return intToDate(getRangeMaxIntValue());
    }

    public void setRangeMax(KmDate e)
    {
        setRangeMaxIntValue(dateToInt(e));
    }

    //##################################################
    //# now
    //##################################################

    public KmDate getNow()
    {
        return intToDate(getNowIntValue());
    }

    public void setNow(KmDate e)
    {
        setNowIntValue(dateToInt(e));
    }

    //##################################################
    //# axis
    //##################################################

    public void setAxisLabelFunction(Function<KmDate,String> e)
    {
        setAxisLabelIntFunction(i -> e.apply(intToDate(i)));
    }

    //==================================================
    //= axis :: common labels
    //==================================================

    public void formatAxis_m_d()
    {
        setAxisLabelFunction(e -> e.format_m_d());
    }

    public void formatAxis_mm_dd_yy()
    {
        setAxisLabelFunction(e -> e.format_mm_dd_yy());
    }

    public void formatAxis_monthName_day()
    {
        setAxisLabelFunction(e -> Kmu.format("%s %s", e.getMonthAbbreviation(), e.getDay()));
    }

    //==================================================
    //= axis :: default label
    //==================================================

    @Override
    protected String getDefaultAxisLabelIntFunction(Integer i)
    {
        KmDate date;
        date = intToDate(i);
        return date.format_mm_dd_yy();
    }

    //##################################################
    //# axis display function
    //##################################################

    public void setAxisLabelDisplayFunction(Function<KmDate,Boolean> e)
    {
        setAxisLabelDisplayIntFunction(i -> e.apply(intToDate(i)));
    }

    //==================================================
    //= axis display :: daily
    //==================================================

    /**
     * The top axis will show labels for every day.
     */
    public void setAxisIntervalDay()
    {
        setAxisLabelDisplayFunction(e -> true);
    }

    //==================================================
    //= axis display :: start of week
    //==================================================

    /**
     * The top axis will only show labels for the start of the week.
     */
    public void setAxisIntervalWeek()
    {
        setAxisLabelDisplayFunction(e -> e.isStartOfWeek());
    }

    //==================================================
    //= axis display :: start of month
    //==================================================

    /**
     * The top axis will only show labels for the start of the month.
     */
    public void setAxisIntervalMonth()
    {
        setAxisLabelDisplayFunction(e -> e.isStartOfMonth());
    }

    //##################################################
    //# sets
    //##################################################

    @Override
    public ScDateGanttChartDataset addDataset()
    {
        ScGanttChartRow row = addRow();

        ScDateGanttChartDataset e;
        e = new ScDateGanttChartDataset();
        e.setRow(row);
        row.addDataset(e);
        return e;
    }

    //##################################################
    //# items
    //##################################################

    @Override
    protected String getHoverTextFor(ScGanttChartItem item)
    {
        if ( item instanceof ScDateGanttChartItem )
            return formatHoverTextFor((ScDateGanttChartItem)item);

        return super.getHoverTextFor(item);
    }

    private String formatHoverTextFor(ScDateGanttChartItem item)
    {
        KmStringBuilder out;
        out = new KmStringBuilder();
        out.println(item.getDescription());
        out.printf("%s - %s", formatItemStart(item), formatItemEnd(item));
        return out.toString();
    }

    private String formatItemStart(ScDateGanttChartItem item)
    {
        return item.hasStart()
            ? item.getStart().format_mm_dd_yy()
            : NONE;
    }

    private String formatItemEnd(ScDateGanttChartItem item)
    {
        return item.hasEnd()
            ? item.getEnd().format_mm_dd_yy()
            : NONE;
    }

    //##################################################
    //# value conversion
    //##################################################

    private Integer dateToInt(KmDate e)
    {
        if ( e == null )
            return null;

        return e.toEpochDays();
    }

    private KmDate intToDate(Integer i)
    {
        if ( i == null )
            return null;

        return KmDate.fromEpochDays(i);
    }
}
