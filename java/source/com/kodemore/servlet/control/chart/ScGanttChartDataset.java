/*
  Copyright (c) 2005-2018 www.kodemore.com

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

package com.kodemore.servlet.control.chart;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

/**
 * A gannt chart set represents a single row on the chart and contains
 * the items in that row.
 */
public class ScGanttChartDataset
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The row this set belongs to.
     */
    private ScGanttChartRow _row;

    /**
     * The chart's item categories.
     */
    private KmList<ScGanttChartItemCategory> _categories;

    /**
     * The items contained in this set.
     */
    private KmList<ScGanttChartItem> _items;

    /**
     * The name of this set.
     */
    private String _name;

    //##################################################
    //# constructor
    //##################################################

    public ScGanttChartDataset()
    {
        _categories = new KmList<>();
        _items = new KmList<>();
    }

    //##################################################
    //# chart
    //##################################################

    public ScGanttChart getChart()
    {
        if ( hasRow() )
            return getRow().getChart();

        return null;
    }

    //##################################################
    //# row
    //##################################################

    public ScGanttChartRow getRow()
    {
        return _row;
    }

    public void setRow(ScGanttChartRow e)
    {
        _row = e;
    }

    private boolean hasRow()
    {
        return getRow() != null;
    }

    //##################################################
    //# categories
    //##################################################

    public KmList<ScGanttChartItemCategory> getCategories()
    {
        return _categories;
    }

    public void setCategories(KmList<ScGanttChartItemCategory> categories)
    {
        _categories = categories;
    }

    public ScGanttChartItemCategory addCategory(String name, ScGanttChartColor color)
    {
        ScGanttChartItemCategory e;
        e = new ScGanttChartItemCategory();
        e.setName(name);
        e.setColor(color);
        _categories.add(e);
        return e;
    }

    public ScGanttChartItemCategory addCategory(String name)
    {
        return addCategory(name, null);
    }

    public ScGanttChartItemCategory findCategory(String e)
    {
        return getCategories().selectFirst(x -> x.hasName(e));
    }

    //##################################################
    //# items
    //##################################################

    public KmList<ScGanttChartItem> getItems()
    {
        return _items;
    }

    public void setItems(KmList<ScGanttChartItem> v)
    {
        _items = v;
    }

    public boolean hasItems()
    {
        return getItems().isNotEmpty();
    }

    public void addItem(ScGanttChartItem e)
    {
        e.setDataset(this);
        _items.add(e);
    }

    public ScGanttChartItem addItem()
    {
        ScGanttChartItem e;
        e = new ScGanttChartItem();
        addItem(e);
        return e;
    }

    public ScGanttChartItem addItem(int start, int end, String name)
    {
        ScGanttChartItem e;
        e = addItem();
        e.setStartIntValue(start);
        e.setEndIntValue(end);
        e.setLabel(name);
        return e;
    }

    //##################################################
    //# name
    //##################################################

    public String getName()
    {
        return _name;
    }

    public void setName(String e)
    {
        _name = e;
    }

    public boolean hasName()
    {
        return Kmu.hasValue(getName());
    }

    //##################################################
    //# theme
    //##################################################

    public void applyBlueTheme()
    {
        applyCategoryColors(ScGanttChartColor.getBlueThemeColors());
    }

    public void applyOrangeTheme()
    {
        applyCategoryColors(ScGanttChartColor.getOrangeThemeColors());
    }

    public void applyPurpleTheme()
    {
        applyCategoryColors(ScGanttChartColor.getPurpleThemeColors());
    }

    public void applyRainbowTheme()
    {
        applyCategoryColors(ScGanttChartColor.getRainbowThemeColors());
    }

    //==================================================
    //= theme :: apply
    //==================================================

    private void applyCategoryColors(KmList<ScGanttChartColor> colors)
    {
        KmList<ScGanttChartItemCategory> cats = getCategories();

        int i = 0;
        for ( ScGanttChartItemCategory cat : cats )
        {
            if ( cat.hasColor() )
                continue;

            if ( i >= colors.size() )
                i = 0;

            ScGanttChartColor color;
            color = colors.get(i);
            cat.setColor(color);
            i++;
        }
    }

    //##################################################
    //# convenience
    //##################################################

    /**
     * Find the start of this set.  This is the minimum start value
     * of the set's items;
     */
    public Integer findStart()
    {
        if ( !hasItems() )
            return null;

        KmList<ScGanttChartItem> v;
        v = getItems().select(e -> e.hasStartIntValue());
        return v.getMinimumValue(e -> e.getStartIntValue());
    }

    public boolean hasStart()
    {
        return findStart() != null;
    }

    /**
     * Find the end of this set.  This is the maximum end value
     * of the set's items;
     */
    public Integer findEnd()
    {
        if ( !hasItems() )
            return null;

        KmList<ScGanttChartItem> v;
        v = getItems().select(e -> e.hasEndIntValue());
        return v.getMaximumValue(e -> e.getEndIntValue());
    }

    public boolean hasEnd()
    {
        return findEnd() != null;
    }
}
