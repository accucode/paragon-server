package com.app.ui.dashboard;

import java.util.function.Function;

import com.kodemore.collection.KmBag;
import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScBarChart;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScTransientDiv;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmDateInterval;
import com.kodemore.types.KmHtmlColor;

import com.app.model.MyDatedCountVo;
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

    private ScBarChart createChart()
    {
        ScBarChart e;
        e = new ScBarChart();
        e.css().fill();
        e.setXAxisLabel("Date");
        e.setYAxisLabel(getCountLabel());
        e.staggerLabels();
        addDataTo(e);
        return e;
    }

    private void addDataTo(ScBarChart chart)
    {
        KmHtmlColor color = KmHtmlColor.createBlack();

        for ( MyDatedCountVo e : findResults() )
        {
            String date = format(e.getDate());
            Integer count = e.getCount();
            chart.addBar(date, count, color);
        }
    }

    /**
     * The label used for the count on the y-axis.
     */
    protected abstract String getCountLabel();

    protected abstract KmList<MyDatedCountVo> findResults();

    //##################################################
    //# format
    //##################################################

    /**
     * Subclasses can optionally override this to format the date differently.
     */
    protected String format(KmDate e)
    {
        return e.format_m_d();
    }

    //##################################################
    //# support
    //##################################################

    protected <T> KmList<MyDatedCountVo> toDatedCounts(
        KmList<T> models,
        KmDateInterval dates,
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

    protected KmDateInterval getRecentDaysInterval(int days)
    {
        KmDate end = KmClock.getLocalDate();
        KmDate start = end.subtractDays(days);
        return KmDateInterval.create(start, end);
    }
}
