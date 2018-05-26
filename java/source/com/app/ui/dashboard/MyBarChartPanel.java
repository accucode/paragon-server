package com.app.ui.dashboard;

import java.util.function.Function;

import com.kodemore.collection.KmBag;
import com.kodemore.collection.KmList;
import com.kodemore.collection.KmSet;
import com.kodemore.servlet.control.ScChartAxis;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScTransientDiv;
import com.kodemore.servlet.control.ScVerticalBarChart;
import com.kodemore.servlet.control.nvd3.ScBarChartPoint;
import com.kodemore.servlet.control.nvd3.ScBarChartSet;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmDateRange;
import com.kodemore.time.KmMonth;
import com.kodemore.time.KmMonthRange;

import com.app.model.MyDatedCountVo;
import com.app.model.MyMonthlyCountVo;
import com.app.ui.dashboard.core.MyDashboardPanel;

public abstract class MyBarChartPanel
    extends MyDashboardPanel
{
    //##################################################
    //# variables
    //##################################################

    private ScTransientDiv _wrapper;

    //##################################################
    //# setup
    //##################################################

    @Override
    protected final void installPanelOn(ScDiv root)
    {
        _wrapper = root.addTransientDiv();
        _wrapper.css().fill().pad20();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected final void preRenderPanel()
    {
        _wrapper.add(createChart());
    }

    //##################################################
    //# chart
    //##################################################

    private ScVerticalBarChart createChart()
    {
        ScVerticalBarChart chart;
        chart = new ScVerticalBarChart();
        chart.css().fill();

        ScChartAxis labelAxis;
        labelAxis = chart.getLabelAxis();
        labelAxis.setLabel("Date");
        labelAxis.setLabelDegrees(60);

        ScChartAxis valueAxis;
        valueAxis = chart.getValueAxis();
        valueAxis.setLabel(getCountLabel());

        addDataTo(chart);
        return chart;
    }

    private void addDataTo(ScVerticalBarChart chart)
    {
        ScBarChartSet set = chart.addDataSet();

        for ( MyBarChartValue e : findValues() )
        {
            ScBarChartPoint bar;
            bar = set.addPoint();
            bar.setLabel(e.getName());
            bar.setValue(e.getCount());
            bar.setColor(e.getColor());
        }
    }

    /**
     * The label used for the count on the y-axis.
     */
    protected abstract String getCountLabel();

    protected abstract KmList<MyBarChartValue> findValues();

    //##################################################
    //# dated values
    //##################################################

    protected KmList<MyBarChartValue> toDatedBarChartValues(KmList<MyDatedCountVo> v)
    {
        return v.collect(e -> toBarChartValue(e));
    }

    protected MyBarChartValue toBarChartValue(MyDatedCountVo in)
    {
        MyBarChartValue out;
        out = new MyBarChartValue();
        out.setName(formatDate(in.getDate()));
        out.setCount(in.getCount());
        return out;
    }

    protected String formatDate(KmDate e)
    {
        return e.format_m_d_yy();
    }

    protected void normalizeDatedCounts(KmList<MyDatedCountVo> v)
    {
        KmDate min = v.getMinimumValue(e -> e.getDate());
        KmDate max = v.getMaximumValue(e -> e.getDate());
        KmDateRange range = KmDateRange.create(min, max);

        normalizeDatedCounts(v, range);
    }

    /**
     * Ensure that all of the dates in the range are represented,
     * and sort the results by date.
     */
    protected void normalizeDatedCounts(KmList<MyDatedCountVo> v, KmDateRange range)
    {
        KmSet<KmDate> dates = v.toSet(e -> e.getDate());

        for ( KmDate date : range )
        {
            if ( dates.contains(date) )
                continue;

            MyDatedCountVo e;
            e = new MyDatedCountVo();
            e.setDate(date);
            e.setCount(0);
            v.add(e);
        }

        v.sortOn(e -> e.getDate());
    }

    //##################################################
    //# monthly values
    //##################################################

    protected KmList<MyBarChartValue> toMonthlyBarChartValues(KmList<MyMonthlyCountVo> v)
    {
        return v.collect(e -> toBarChartValue(e));
    }

    protected MyBarChartValue toBarChartValue(MyMonthlyCountVo in)
    {
        MyBarChartValue out;
        out = new MyBarChartValue();
        out.setName(in.getMonth().format_m_yy());
        out.setCount(in.getCount());
        return out;
    }

    protected void normalizeMonthlyCounts(KmList<MyMonthlyCountVo> v)
    {
        KmMonth min = v.getMinimumValue(e -> e.getMonth());
        KmMonth max = v.getMaximumValue(e -> e.getMonth());
        KmMonthRange range = KmMonthRange.create(min, max);

        normalizeMonthlyCounts(v, range);
    }

    /**
     * Ensure that all of the dates in the range are represented,
     * and sort the results by date.
     */
    protected void normalizeMonthlyCounts(KmList<MyMonthlyCountVo> v, KmMonthRange range)
    {
        KmSet<KmMonth> months = v.toSet(e -> e.getMonth());

        for ( KmMonth month : range )
        {
            if ( months.contains(month) )
                continue;

            MyMonthlyCountVo e;
            e = new MyMonthlyCountVo();
            e.setMonth(month);
            e.setCount(0);
            v.add(e);
        }

        v.sortOn(e -> e.getMonth());
    }

    //##################################################
    //# dated counts
    //##################################################

    protected <T> KmList<MyDatedCountVo> toDatedCounts(
        KmList<T> models,
        KmDateRange dates,
        Function<T,KmDate> fn)
    {
        KmBag<KmDate> counts = countDates(models, fn);

        KmList<MyDatedCountVo> v = new KmList<>();
        for ( KmDate date : dates )
        {
            Integer count = counts.getCount(date);
            v.add(new MyDatedCountVo(date, count));
        }
        return v;
    }

    private <T> KmBag<KmDate> countDates(KmList<T> list, Function<T,KmDate> fn)
    {
        KmBag<KmDate> counts = new KmBag<>();

        for ( T e : list )
            counts.add(fn.apply(e));

        return counts;
    }

    //##################################################
    //# recent date ranges
    //##################################################

    protected KmDateRange getRecentDaysRange(int days)
    {
        KmDate end = KmClock.getLocalDate();
        KmDate start = end.subtractDays(days);
        return KmDateRange.create(start, end);
    }

    protected KmDateRange getRecentMonthsRange(int months)
    {
        KmDate today = KmClock.getLocalDate();
        KmDate start = today.getStartOfMonth().subtractMonths(months - 1);
        KmDate end = today.getEndOfMonth();
        return KmDateRange.create(start, end);
    }

}
