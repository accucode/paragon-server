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

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

/**
 * I am used to create simple bar charts using the JFreeChart library.
 * I currently assume a single series.
 */
public class KmSimpleBarChart
    extends KmAbstractChart
{
    //##################################################
    //# variables
    //##################################################

    private String                        _valueAxisLabel;
    private String                        _categoryAxisLabel;
    private boolean                       _horizontal;
    private boolean                       _showsLegend;

    private boolean                       _usesAutoHeight;

    /**
     * By default, null values are displayed as zeroes.
     */
    private boolean                       _skipNullValues;

    /**
     * The list of data groups.  Each group represents a series of data.
     */
    private KmList<KmSimpleBarChartGroup> _groups;

    /**
     * If true, the chart will draw with lines connected to dots, 
     * rather than as raised bars.   False by default.
     */
    private boolean                       _formatWithLines;

    //##################################################
    //# constructor
    //##################################################

    public KmSimpleBarChart()
    {
        _valueAxisLabel = "Value Axis";
        _categoryAxisLabel = "Category Axis";

        _horizontal = true;
        _showsLegend = false;

        _usesAutoHeight = true;
        _skipNullValues = false;

        _groups = new KmList<>();
    }

    //##################################################
    //# groups
    //##################################################

    public KmSimpleBarChartGroup addGroup()
    {
        String name = "Group-" + (_groups.size() + 1);

        KmSimpleBarChartGroup e;
        e = new KmSimpleBarChartGroup();
        e.setName(name);

        _groups.add(e);

        return e;
    }

    public KmList<KmSimpleBarChartGroup> getGroups()
    {
        return _groups;
    }

    public KmSimpleBarChartGroup getGroup(String name)
    {
        KmList<KmSimpleBarChartGroup> v = _groups;
        for ( KmSimpleBarChartGroup e : v )
            if ( e.hasName(name) )
                return e;

        return null;
    }

    public KmSimpleBarChartGroup getGroupLazy(String name)
    {
        KmSimpleBarChartGroup e = getGroup(name);

        if ( e == null )
        {
            e = addGroup();
            e.setName(name);
        }

        return e;
    }

    //##################################################
    //# override
    //##################################################

    @Override
    public void setHeight(int e)
    {
        super.setHeight(e);

        setUsesAutoHeight(false);
    }

    @Override
    public int getHeight()
    {
        if ( getUsesAutoHeight() )
            return getAutoHeight();

        return super.getHeight();
    }

    public int getAutoHeight()
    {
        int n = getHorizontal()
            ? countAllDistinctCategoryNames()
            : countAllDistinctValues();

        int h;
        h = 100 + 20 * n;
        h = Kmu.max(h, 200);

        return h;
    }

    //##################################################
    //# accessing
    //##################################################

    public String getValueAxisLabel()
    {
        return _valueAxisLabel;
    }

    public void setValueAxisLabel(String e)
    {
        _valueAxisLabel = e;
    }

    public String getCategoryAxisLabel()
    {
        return _categoryAxisLabel;
    }

    public void setCategoryAxisLabel(String e)
    {
        _categoryAxisLabel = e;
    }

    public boolean isShowsLegend()
    {
        return _showsLegend;
    }

    public void setShowsLegend(boolean e)
    {
        _showsLegend = e;
    }

    public boolean getHorizontal()
    {
        return _horizontal;
    }

    public void setHorizontal(boolean e)
    {
        _horizontal = e;
    }

    public void setHorizontal()
    {
        setHorizontal(true);
    }

    public void setVertical()
    {
        setHorizontal(false);
    }

    public boolean getUsesAutoHeight()
    {
        return _usesAutoHeight;
    }

    public void setUsesAutoHeight(boolean e)
    {
        _usesAutoHeight = e;
    }

    public boolean getSkipNullValues()
    {
        return _skipNullValues;
    }

    public void setSkipNullValues(boolean e)
    {
        _skipNullValues = e;
    }

    public boolean getFormatWithLines()
    {
        return _formatWithLines;
    }

    public void setFormatWithLines(boolean e)
    {
        _formatWithLines = e;
    }

    public void setFormatWithLines()
    {
        setFormatWithLines(true);
    }

    //##################################################
    //# support
    //##################################################

    @Override
    protected JFreeChart createAbstractChart()
    {
        boolean tooltips = false;
        boolean urls = false;

        DefaultCategoryDataset dataset;
        dataset = new DefaultCategoryDataset();

        KmList<String> categoryNames;
        categoryNames = getAllDistinctCategoryNames();

        KmList<KmSimpleBarChartGroup> groups = getGroups();
        for ( KmSimpleBarChartGroup group : groups )
        {
            String groupName = group.getName();
            for ( String categoryName : categoryNames )
            {
                Double value = group.getValueFor(categoryName);

                if ( value == null )
                {
                    if ( getSkipNullValues() )
                        continue;

                    value = 0.0;
                }

                dataset.setValue(value, groupName, categoryName);
            }
        }

        PlotOrientation orientation = getHorizontal()
            ? PlotOrientation.HORIZONTAL
            : PlotOrientation.VERTICAL;

        JFreeChart chart = ChartFactory.createBarChart3D(
            getTitle(),
            getCategoryAxisLabel(),
            getValueAxisLabel(),
            dataset,
            orientation,
            isShowsLegend(),
            tooltips,
            urls);

        if ( getFormatWithLines() )
        {
            LineAndShapeRenderer renderer;
            renderer = new LineAndShapeRenderer();

            CategoryPlot plot;
            plot = (CategoryPlot)chart.getPlot();
            plot.setRenderer(renderer);
        }

        return chart;
    }

    private KmList<String> getAllDistinctCategoryNames()
    {
        KmList<String> v = new KmList<>();

        for ( KmSimpleBarChartGroup group : getGroups() )
        {
            KmList<String> names = group.getCategoryNames();
            v.addAllDistinct(names);
        }

        return v;
    }

    private KmList<Double> getAllDistinctValues()
    {
        KmList<Double> v = new KmList<>();

        for ( KmSimpleBarChartGroup group : getGroups() )
        {
            KmList<Double> values = group.getDistinctValues();
            v.addAllDistinct(values);
        }

        return v;
    }

    //##################################################
    //# counts
    //##################################################

    private int countAllDistinctCategoryNames()
    {
        return getAllDistinctCategoryNames().size();
    }

    private int countAllDistinctValues()
    {
        return getAllDistinctValues().size();
    }

}
