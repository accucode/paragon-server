package com.app.ui.activity.test;

import com.kodemore.json.KmJsonObject;
import com.kodemore.servlet.control.ScChart;
import com.kodemore.servlet.control.ScChartSeries;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.types.KmHtmlColor;
import com.kodemore.utility.KmRandomUtility;

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
        chart.css().borderBlack();

        ScChartSeries s;
        s = chart.addSeries();
        s.setKey("Blue");
        s.setColor(KmHtmlColor.createBlue());
        s.setArea();
        generateData(s);

        s = chart.addSeries();
        s.setKey("Green");
        s.setColor(KmHtmlColor.createGreen());
        s.setArea();
        generateData(s);

        chart.setXAxisLabel("Time (s)");
        chart.setYAxisLabel("Voltage (V)");
        chart.setWidth(800);

        return chart;
    }

    //##################################################
    //# utility
    //##################################################

    private void generateData(ScChartSeries s)
    {
        int n = POINTS;
        for ( int i = 0; i < n; i++ )
            s.addPoint(createRandomDataPoint(i));
    }

    private KmJsonObject createRandomDataPoint(int x)
    {
        int y = KmRandomUtility.getInteger(100);

        KmJsonObject point;
        point = new KmJsonObject();
        point.setInteger("x", x);
        point.setInteger("y", y);
        return point;
    }
}
