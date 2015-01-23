package com.app.ui.page.test;

import com.kodemore.json.KmJsonMap;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScAbstractChart;
import com.kodemore.servlet.control.ScBarChart;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScChartSeries;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScLineChart;
import com.kodemore.servlet.control.ScMultiBarChart;
import com.kodemore.servlet.control.ScNotebook;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScPieChart;
import com.kodemore.types.KmHtmlColor;
import com.kodemore.utility.KmRandom;

/**
 * Test the Nvd3 charts.
 */
public class MyNvd3ChartTestPage
    extends MyAbstractTestEntryPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyNvd3ChartTestPage instance = new MyNvd3ChartTestPage();

    private MyNvd3ChartTestPage()
    {
        // singleton
    }

    //##################################################
    //# constants
    //##################################################

    private static final int LINE_POINTS = 80;
    private static final int BAR_POINTS  = 20;

    //##################################################
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeQueryParameters()
    {
        return null;
    }

    @Override
    public void applyQueryParameters(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().pad();

        ScNotebook tabs;
        tabs = root.addNotebook();
        tabs.setTabChangedAction(this::handleTabChanged);

        installLineTabOn(tabs);
        installBarTabOn(tabs);
        installMultiBarTabOn(tabs);
        installPieTabOn(tabs);
    }

    private void installLineTabOn(ScNotebook tabs)
    {
        ScBox tab;
        tab = tabs.addBox();
        tab.setLabel("Line Chart");
        tab.css().gap();

        String message = ""
            + "This demonstrates a line chart with multiple series.  Clicking on the "
            + "labels in the legend will enable and disable the display of an individual "
            + "series.";

        ScGroup group;
        group = tab.addGroup();
        group.setTitle("Line Chart");
        group.getBody().addPad().addText(message);

        tab.add(createLineChart());
    }

    private void installBarTabOn(ScNotebook tabs)
    {
        ScBox tab;
        tab = tabs.addBox();
        tab.setLabel("Bar Chart");
        tab.css().gap();

        String message = "This demonstrates a bar chart with several discrete data points.  "
            + "Bar charts have the option to stagger the labels which can help accomodate "
            + "longer labels.";

        ScGroup group;
        group = tab.addGroup();
        group.setTitle("Bar Chart");
        group.getBody().addPad().addText(message);

        tab.add(createBarChart());
    }

    private void installMultiBarTabOn(ScNotebook tabs)
    {
        ScBox tab;
        tab = tabs.addBox();
        tab.setLabel("Multi Bar Chart");
        tab.css().gap();

        String message = "This demonstrates a multi-bar chart, which is similar to a line chart "
            + "but displays data as bars.  Clicking on the labels in the legend will enable or "
            + "disable the display of idividual data series.  Additionally, this chart has the "
            + "option between grouped and stacked display.";

        ScGroup group;
        group = tab.addGroup();
        group.setTitle("Multi Bar Chart");
        group.getBody().addPad().addText(message);

        tab.add(createMultiBarChart());
    }

    private void installPieTabOn(ScNotebook tabs)
    {
        ScBox tab;
        tab = tabs.addBox();
        tab.setLabel("Pie Chart");
        tab.css().gap();

        String message = "This demonstrates a pie chat with several discrete data points.  "
            + "Clicking on the label in the legend will toggle the display of individual "
            + "slices.  The pie chart has the option be be displayed as a traditional pie, "
            + "or as a 'donut'.";

        ScGroup group;
        group = tab.addGroup();
        group.setTitle("Pie Chart");
        group.getBody().addPad().addText(message);

        tab.add(createPieChart());
    }

    //==================================================
    //= install :: charts
    //==================================================

    private ScLineChart createLineChart()
    {
        ScLineChart chart;
        chart = new ScLineChart();
        chart.css().borderBlack();
        chart.style().height(400);
        chart.setXAxisLabel("X Axis");
        chart.setYAxisLabel("Y Axis");
        chart.setYAxisScale(1);
        chart.setYAxisMin(-10);
        chart.setYAxisMax(75);

        ScChartSeries s;
        s = chart.addSeries();
        s.setKey("Blue Line");
        s.setColor(KmHtmlColor.createBlue());
        generateData(s, LINE_POINTS);

        s = chart.addSeries();
        s.setKey("Green Area");
        s.setColor(KmHtmlColor.createGreen());
        s.setArea();
        generateData(s, LINE_POINTS);

        s = chart.addSeries();
        s.setKey("No Color Set Line");
        generateData(s, LINE_POINTS);

        s = chart.addSeries();
        s.setKey("No Color Set Area");
        s.setArea();
        generateData(s, LINE_POINTS);

        return chart;
    }

    private ScBarChart createBarChart()
    {
        ScBarChart chart;
        chart = new ScBarChart();
        chart.css().borderBlack();
        chart.style().height(400);
        chart.setXAxisLabel("Name");
        chart.setYAxisLabel("Value");
        chart.setYAxisMax(5);
        chart.staggerLabels();

        generateBarChartData(chart);

        return chart;
    }

    private ScMultiBarChart createMultiBarChart()
    {
        ScMultiBarChart chart;
        chart = new ScMultiBarChart();
        chart.css().borderBlack();
        chart.style().height(400);
        chart.setXAxisLabel("X Axis");
        chart.setYAxisLabel("Y Axis");
        chart.setYAxisScale(2);
        chart.setGroupSpacing(0.2);
        chart.setRotateLabelsDegrees(45);
        chart.showGroupStackControl();

        ScChartSeries s;
        s = chart.addSeries();
        s.setKey("Blue");
        s.setColor(KmHtmlColor.createBlue());
        generateData(s, BAR_POINTS);

        s = chart.addSeries();
        s.setKey("Green");
        s.setColor(KmHtmlColor.createGreen());
        generateData(s, BAR_POINTS);

        s = chart.addSeries();
        s.setKey("No Color Set 1");
        generateData(s, BAR_POINTS);

        s = chart.addSeries();
        s.setKey("No Color Set 2");
        generateData(s, BAR_POINTS);

        return chart;
    }

    private ScPieChart createPieChart()
    {
        ScPieChart chart;
        chart = new ScPieChart();
        chart.setDonut(true);
        chart.setLabelTypeKey();
        chart.css().borderBlack();
        chart.style().height(400);

        generatePieChartData(chart);

        return chart;
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

    private KmJsonMap createRandomDataPoint(int i)
    {
        KmRandom r = KmRandom.getInstance();

        double x = i;
        double y = r.getInteger(60) - r.getInteger(40) + r.getDouble();

        KmJsonMap point;
        point = new KmJsonMap();
        point.setDouble("x", x);
        point.setDouble("y", y);
        return point;
    }

    private void generateBarChartData(ScBarChart pie)
    {
        pie.addBar("pi (blue)", 3.14, KmHtmlColor.createBlue());
        pie.addBar("phi (black)", 1.618, KmHtmlColor.createBlack());
        pie.addBar("gamma (green)", 1.4, KmHtmlColor.createGreen());
        pie.addBar("e", 2.72);
        pie.addBar("0", 0);
        pie.addBar("-1", -1);
        pie.addBar("Square Root of 2", 1.414);
        pie.addBar("Random 1", getRandomNumber());
        pie.addBar("Random 2 (This is Extra Text to denonstate a large label)", getRandomNumber());
        pie.addBar(
            "Random 3 (Enabling Stagger Labels helps display large labels)",
            getRandomNumber());
        pie.addBar("Random 4", getRandomNumber());
    }

    private double getRandomNumber()
    {
        KmRandom r = KmRandom.getInstance();
        return r.getDouble() + r.getInteger(3) - r.getInteger(3);
    }

    private void generatePieChartData(ScPieChart pie)
    {
        pie.addSlice("pi", 3.14);
        pie.addSlice("phi", 1.618);
        pie.addSlice("gamma", 1.4);
        pie.addSlice("e", 2.72);
        pie.addSlice("1", 1);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleTabChanged()
    {
        ajax().run(ScAbstractChart.getUpdateAllChartsScript());
    }
}
