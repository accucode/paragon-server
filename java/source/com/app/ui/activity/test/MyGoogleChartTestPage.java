package com.app.ui.activity.test;

import com.app.ui.activity.MyActivity;

import com.kodemore.servlet.control.ScArray;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScGoogleChart;
import com.kodemore.servlet.control.ScPageRoot;

public class MyGoogleChartTestPage
    extends MyTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyActivity instance = new MyGoogleChartTestPage();

    private MyGoogleChartTestPage()
    {
        // singleton
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        ScArray arr;
        arr = new ScArray();
        arr.setColumnCount(3);

        addBar1(arr);
        addBar2(arr);
        addBar3(arr);

        addPie1(arr);
        addPie2(arr);
        addLine1(arr);
    }

    private void addBar1(ScContainer root)
    {
        ScGoogleChart c;
        c = new ScGoogleChart();
        c.setTitle("Bar");
        c.setTypeBarVerticalGrouped();
        c.setSize(400, 200);
        c.setRainbowColors();
        c.setBarSize(30, 2, 15);
        c.addSeries(10, 20, 30);
        c.addSeries(20, 50, 10);
        root.add(c);
    }

    private void addBar2(ScContainer root)
    {
        ScGoogleChart c;
        c = new ScGoogleChart();
        c.setTitle("Bar");
        c.setTypeBarVerticalStacked();
        c.setSize(400, 200);
        c.setRainbowColors();
        c.setBarSize(40, 20);
        c.addSeries(10, 20, 30);
        c.addSeries(20, 50, 10);
        root.add(c);
    }

    private void addBar3(ScContainer root)
    {
        ScGoogleChart c;
        c = new ScGoogleChart();
        c.setTitle("Bar");
        c.setTypeBarHorizontalStacked();
        c.setSize(400, 200);
        c.setRainbowColors();
        c.setBarSize(40, 20);
        c.addSeries(10, 20, 30);
        c.addSeries(20, 50, 10);
        c.setLegends("Red", "Orange");
        root.add(c);
    }

    private void addPie1(ScContainer root)
    {
        ScGoogleChart c;
        c = new ScGoogleChart();
        c.setTitle("Pie");
        c.setTypePie();
        c.setSize(400, 200);
        c.setRainbowColors();
        c.addSeries(10, 20, 40);
        root.add(c);
    }

    private void addPie2(ScContainer root)
    {
        ScGoogleChart c;
        c = new ScGoogleChart();
        c.setTitle("Pie");
        c.setTypePie3D();
        c.setSize(400, 200);
        c.setRainbowColors();
        c.addSeries(10, 20, 40);
        c.setLabels("One", "Two", "Three");
        root.add(c);
    }

    private void addLine1(ScContainer root)
    {
        ScGoogleChart c;
        c = new ScGoogleChart();
        c.setTitle("Line");
        c.setTypeLine();
        c.setSize(400, 200);
        c.setRainbowColors();
        c.addSeries(10, 80, 40);
        c.addSeries(20, 40, 90);
        c.setLabels("Jan", "Feb", "Mar");
        c.setLegends("Red", "Orange");
        c.setLegendLeft();
        root.add(c);
    }

}
