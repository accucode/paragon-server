package com.app.ui.dashboard;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScPieChart;
import com.kodemore.servlet.control.ScTransientDiv;

import com.app.model.MyNamedIntegerVo;
import com.app.ui.dashboard.core.MyDashboardPanel;

public abstract class MyPieChartPanel
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

    private ScPieChart createChart()
    {
        ScPieChart chart;
        chart = new ScPieChart();
        chart.setDonut(true);
        chart.setLabelTypeKey();
        chart.css().fill();

        KmList<MyNamedIntegerVo> results = findResults();
        sortResults(results);

        for ( MyNamedIntegerVo e : results )
            chart.addSlice(e.getName(), e.getValue());

        return chart;
    }

    protected abstract KmList<MyNamedIntegerVo> findResults();

    //##################################################
    //# support
    //##################################################

    /**
     * Sort the results to show the big sections first.
     */
    private void sortResults(KmList<MyNamedIntegerVo> results)
    {
        results.sort(e -> e.getValue());
        results.reverse();
    }

}
