package com.app.ui.activity.test;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScChart;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.utility.KmRandomUtility;
import com.kodemore.utility.Kmu;

/**
 * Test the layout and usage of the groups.
 */
public class MyChartTestPage
    extends MyTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyChartTestPage instance = new MyChartTestPage();

    private MyChartTestPage()
    {
        // singleton
    }

    //##################################################
    //# constants
    //##################################################

    private static final int POINTS = 100;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().gap();

        ScGroup group;
        group = root.addGroup("Chart Test");
        group.addPad().addText("This is a test of the ScChart");
        root.add(createChart());
    }

    private ScChart createChart()
    {
        ScChart chart;
        chart = new ScChart();

        chart.setDataPoints(generateData());
        chart.setXAxisLabel("Time (s)");
        chart.setYAxisLabel("Voltage (V)");
        chart.setWidth(800);

        return chart;
    }

    //##################################################
    //# utility
    //##################################################

    private KmList<String> generateData()
    {
        KmList<String> data;
        data = new KmList<String>();

        int n = POINTS;
        for ( int i = 0; i < n; i++ )
            data.add(createRandomDataPoint(i));

        return data;
    }

    private String createRandomDataPoint(int x)
    {
        double y = KmRandomUtility.getInteger(100);

        return Kmu.format("{x: %s, y: %s}", x, y);
    }
}
