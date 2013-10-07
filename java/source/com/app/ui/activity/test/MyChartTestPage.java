package com.app.ui.activity.test;

import com.kodemore.json.KmJsonObject;
import com.kodemore.servlet.control.ScBarChart;
import com.kodemore.servlet.control.ScChartSeries;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScLineChart;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScPieChart;
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

    private static final int LINE_POINTS = 100;
    private static final int BAR_POINTS  = 20;

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
        root.add(createLineChart());
        root.add(createBarChart());
        root.add(createPieChart());
    }

    private ScLineChart createLineChart()
    {
        ScLineChart chart;
        chart = new ScLineChart();
        chart.css().borderBlack();

        ScChartSeries s;
        s = chart.addSeries();
        s.setKey("Blue");
        s.setColor(KmHtmlColor.createBlue());
        s.setArea();
        generateData(s, LINE_POINTS);

        s = chart.addSeries();
        s.setKey("Green");
        s.setColor(KmHtmlColor.createGreen());
        s.setArea();
        generateData(s, LINE_POINTS);

        chart.setXAxisLabel("X Axis");
        chart.setYAxisLabel("Y Axis");
        chart.setWidth(800);

        return chart;
    }

    private ScBarChart createBarChart()
    {
        ScBarChart chart;
        chart = new ScBarChart();
        chart.css().borderBlack();

        ScChartSeries s;
        s = chart.addSeries();
        s.setKey("Blue");
        s.setColor(KmHtmlColor.createBlue());
        s.setArea();
        generateData(s, BAR_POINTS);

        s = chart.addSeries();
        s.setKey("Black");
        s.setColor(KmHtmlColor.createBlack());
        s.setArea();
        generateData(s, BAR_POINTS);

        s = chart.addSeries();
        s.setKey("Green");
        s.setColor(KmHtmlColor.createGreen());
        s.setArea();
        generateData(s, BAR_POINTS);

        chart.setXAxisLabel("X Axis");
        chart.setYAxisLabel("Y Axis");
        chart.setWidth(800);

        return chart;
    }

    private ScPieChart createPieChart()
    {
        ScPieChart pie;
        pie = new ScPieChart();
        pie.setDonut(false);
        pie.css().borderBlack();

        generatePieChartData(pie);

        return pie;
    }

    //##################################################
    //# utility
    //##################################################

    private void generateData(ScChartSeries s, int number)
    {
        int n = number;
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

    private void generatePieChartData(ScPieChart pie)
    {
        pie.addSlice("pi", 3.14);
        pie.addSlice("phi", 1.618);
        pie.addSlice("gamma", 1.4);
        pie.addSlice("e", 2.72);
        pie.addSlice("1", 1);
    }
}
