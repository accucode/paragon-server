/*
  Copyright (c) 2005-2016 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
 */

package com.kodemore.freechart;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.kodemore.collection.KmList;

/**
 * I am used to create simple line charts using the JFreeChart library.
 */
public class KmSimpleLineChart
    extends KmAbstractChart
{
    //##################################################
    //# variables
    //##################################################

    /**
     * Each group forms a line on the chart.
     */
    private KmList<KmSimpleLineChartGroup> _groups;

    /**
     * If true, the x axis units will be forced to integers.
     */
    private boolean                        _integerUnitsX;

    /**
     * If true, the y axis units will be forced to integers.
     */
    private boolean                        _integerUnitsY;

    /**
     * By default, null values are displayed as zeroes.
     */
    private boolean                        _skipNullValues;

    /**
     * The title displayed along the x axis.
     */
    private String                         _axisTitleX;

    /**
     * The title displayed along the y axis.
     */
    private String                         _axisTitleY;

    /**
     * The background color used outside the plot area.
     */
    private Color                          _backgroundColor;

    /**
     * The background color used inside the plot area.
     */
    private Color                          _plotBackgroundColor;

    /**
     * The color used for both horizontal and vertical grid lines.
     */
    private Color                          _plotGridLineColor;

    /**
     * If true, the legend is displayed.
     */
    private boolean                        _showsLegend;

    //##################################################
    //# constructor
    //##################################################

    public KmSimpleLineChart()
    {
        _groups = new KmList<>();
    }

    //##################################################
    //# accessing
    //##################################################

    public boolean getIntegerUnitsX()
    {
        return _integerUnitsX;
    }

    public void setIntegerUnitsX(boolean e)
    {
        _integerUnitsX = e;
    }

    public boolean getIntegerUnitsY()
    {
        return _integerUnitsY;
    }

    public void setIntegerUnitsY(boolean e)
    {
        _integerUnitsY = e;
    }

    public boolean getSkipNullValues()
    {
        return _skipNullValues;
    }

    public void setSkipNullValues(boolean e)
    {
        _skipNullValues = e;
    }

    //##################################################
    //# titles
    //##################################################

    public String getAxisTitleX()
    {
        return _axisTitleX;
    }

    public void setAxisTitleX(String e)
    {
        _axisTitleX = e;
    }

    public String getAxisTitleY()
    {
        return _axisTitleY;
    }

    public void setAxisTitleY(String e)
    {
        _axisTitleY = e;
    }

    //##################################################
    //# colors
    //##################################################

    public Color getBackgroundColor()
    {
        return _backgroundColor;
    }

    public void setBackgroundColor(Color e)
    {
        _backgroundColor = e;
    }

    public boolean hasBackgroundColor()
    {
        return getBackgroundColor() != null;
    }

    public Color getPlotBackgroundColor()
    {
        return _plotBackgroundColor;
    }

    public void setPlotBackgroundColor(Color e)
    {
        _plotBackgroundColor = e;
    }

    public boolean hasPlotBackgroundColor()
    {
        return getPlotBackgroundColor() != null;
    }

    public Color getPlotGridLineColor()
    {
        return _plotGridLineColor;
    }

    public void setPlotGridLineColor(Color e)
    {
        _plotGridLineColor = e;
    }

    public boolean hasPlotGridLineColor()
    {
        return getPlotGridLineColor() != null;
    }

    //##################################################
    //# legend
    //##################################################

    public boolean getShowsLegend()
    {
        return _showsLegend;
    }

    public void setShowsLegend(boolean e)
    {
        _showsLegend = e;
    }

    //##################################################
    //# groups
    //##################################################

    public KmList<KmSimpleLineChartGroup> getGroups()
    {
        return _groups;
    }

    public KmSimpleLineChartGroup addGroup()
    {
        String name = "group-" + (_groups.size() + 1);

        KmSimpleLineChartGroup e;
        e = new KmSimpleLineChartGroup();
        e.setName(name);

        _groups.add(e);

        return e;
    }

    //##################################################
    //# support
    //##################################################

    @Override
    protected JFreeChart createAbstractChart()
    {
        return createChart(createDataset());
    }

    private JFreeChart createChart(XYDataset dataset)
    {
        PlotOrientation orientation = PlotOrientation.VERTICAL;

        boolean showsTooltips = false;
        boolean showsUrls = false;

        JFreeChart chart = ChartFactory.createXYLineChart(
            getTitle(),
            getAxisTitleX(),
            getAxisTitleY(),
            dataset,
            orientation,
            getShowsLegend(),
            showsTooltips,
            showsUrls);

        if ( hasBackgroundColor() )
            chart.setBackgroundPaint(getBackgroundColor());

        XYPlot plot;
        plot = chart.getXYPlot();

        if ( hasPlotBackgroundColor() )
            plot.setBackgroundPaint(getPlotBackgroundColor());

        if ( hasPlotGridLineColor() )
        {
            Color color = getPlotGridLineColor();
            plot.setDomainGridlinePaint(color);
            plot.setRangeGridlinePaint(color);
        }

        XYLineAndShapeRenderer renderer;
        renderer = new XYLineAndShapeRenderer();

        KmList<KmSimpleLineChartGroup> groups = getGroups();
        int n = groups.size();
        for ( int i = 0; i < n; i++ )
        {
            KmSimpleLineChartGroup group = groups.getAt(i);

            renderer.setSeriesLinesVisible(i, group.getShowsLines());
            renderer.setSeriesShapesVisible(i, group.getShowsShapes());
        }

        plot.setRenderer(renderer);

        if ( getIntegerUnitsX() )
        {
            NumberAxis rangeAxis;
            rangeAxis = (NumberAxis)plot.getRangeAxis();
            rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        }

        if ( getIntegerUnitsY() )
        {
            NumberAxis rangeAxis;
            rangeAxis = (NumberAxis)plot.getDomainAxis();
            rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        }

        return chart;
    }

    private XYDataset createDataset()
    {
        XYSeriesCollection dataset = new XYSeriesCollection();

        KmList<KmSimpleLineChartGroup> groups = getGroups();
        for ( KmSimpleLineChartGroup g : groups )
        {
            String name = g.getName();
            XYSeries series = new XYSeries(name);

            KmList<Double> xs = g.getXs();
            for ( Double x : xs )
            {
                Double y = g.getY(x);
                if ( y == null )
                {
                    if ( getSkipNullValues() )
                        continue;

                    y = 0.0;
                }
                series.add(x, y);
            }
            dataset.addSeries(series);
        }

        return dataset;
    }
}
