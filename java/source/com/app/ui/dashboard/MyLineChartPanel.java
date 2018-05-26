package com.app.ui.dashboard;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScTransientDiv;
import com.kodemore.servlet.control.nvd3.ScLineChart;

import com.app.model.MyNamedIntegerVo;
import com.app.ui.dashboard.core.MyDashboardPanel;

public abstract class MyLineChartPanel
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

    private ScLineChart createChart()
    {
        return null;
    }

    protected abstract KmList<MyNamedIntegerVo> findResults();
}
