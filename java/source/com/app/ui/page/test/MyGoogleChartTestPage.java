package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScArray;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScGoogleChart;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyGoogleChartTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyGoogleChartTestPage _instance;

    public static void installInstance()
    {
        _instance = new MyGoogleChartTestPage();
    }

    public static MyGoogleChartTestPage getInstance()
    {
        return _instance;
    }

    private MyGoogleChartTestPage()
    {
        // singleton
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public final MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }

    //##################################################
    //# bookmark
    //##################################################

    @Override
    public void composeBookmarkOn(ScParameterList v)
    {
        // none
    }

    @Override
    public void applyBookmark(ScParameterList v)
    {
        // none
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

        installBar1(arr);
        installBar2(arr);
        installBar3(arr);

        installPie1(arr);
        installPie2(arr);
        installLine1(arr);
    }

    private void installBar1(ScContainer root)
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

    private void installBar2(ScContainer root)
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

    private void installBar3(ScContainer root)
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

    private void installPie1(ScContainer root)
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

    private void installPie2(ScContainer root)
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

    private void installLine1(ScContainer root)
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

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }

}
