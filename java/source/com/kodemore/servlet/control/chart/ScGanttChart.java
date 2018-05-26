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

import com.google.common.base.Function;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScDivWrapper;
import com.kodemore.servlet.control.ScSpan;
import com.kodemore.servlet.control.ScTransientContainer;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.variable.ScLocalInteger;
import com.kodemore.servlet.variable.ScLocalList;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

/**
 * A gantt chart.  A chart intended to give a visual representation of progress
 * and status over time.
 */
public class ScGanttChart
    extends ScDivWrapper
{
    //##################################################
    //# constants
    //##################################################

    private static final String LABELS_ID_SUFFIX = "-labels";
    private static final String LEGEND_ID_SUFFIX = "-legend";
    private static final String CHART_ID_SUFFIX  = "-chart";

    private static final String NONE = Kmu.formatMetaValue("none");

    //##################################################
    //# variables
    //##################################################

    /**
     * The chart sets.  A set contains the items that will displayed in a
     * row of the chart.
     */
    private ScLocalList<ScGanttChartRow> _rows;

    /**
     * The optional chart title.
     */
    private ScLocalString _title;

    /**
     * The minimum value of the chart.
     */
    private ScLocalInteger _rangeMinIntValue;

    /**
     * The maximum value of the chart.
     */
    private ScLocalInteger _rangeMaxIntValue;

    /**
     * The width (in pixels) of the units along the top axis;
     * If not set this will be a default value;
     */
    private ScLocalInteger _axisUnitWidth;

    /**
     * The current value or "now" of the chart.
     */
    private ScLocalInteger _nowIntValue;

    /**
     * The function that format's the legend label.
     */
    private Function<Integer,String> _axisLabelIntFunction;

    /**
     * A function that determines if the axis label should be shown for a
     * specific value.  By default, all values are shown.
     * Note: The first and last value in the range are always displayed.
     */
    private Function<Integer,Boolean> _axisLabelDisplayIntFunction;

    /**
     * The transient container that contains the progess bar.
     */
    private ScTransientContainer _transient;

    //##################################################
    //# constructor
    //##################################################

    public ScGanttChart()
    {
        _title = new ScLocalString();
        _rangeMinIntValue = new ScLocalInteger();
        _rangeMaxIntValue = new ScLocalInteger();
        _axisUnitWidth = new ScLocalInteger(getDefaultUnitWidth());
        _nowIntValue = new ScLocalInteger();

        _rows = new ScLocalList<>();

        _transient = getInner().addTransientContainer();

        css().ganttChart();

        setAxisLabelIntFunction(this::getDefaultAxisLabelIntFunction);
        setAxisLabelDisplayIntFunction(this::getDefaultLabelAxisDisplayIntFunction);
    }

    /**
     * The default unit width for new charts.
     */
    protected Integer getDefaultUnitWidth()
    {
        return 40;
    }

    //##################################################
    //# rows
    //##################################################

    public KmList<ScGanttChartRow> getRows()
    {
        return _rows.getValue();
    }

    public void setRows(KmList<ScGanttChartRow> v)
    {
        _rows.setValue(v);
    }

    public boolean hasRows()
    {
        return getRows().isNotEmpty();
    }

    public void addRow(ScGanttChartRow e)
    {
        e.setChart(this);
        _rows.add(e);
    }

    public ScGanttChartRow addRow()
    {
        ScGanttChartRow e;
        e = new ScGanttChartRow();
        addRow(e);
        return e;
    }

    //##################################################
    //# sets
    //##################################################

    public KmList<ScGanttChartDataset> getDatasets()
    {
        return getRows().collectAll(e -> e.getDatasets());
    }

    public boolean hasDatasets()
    {
        return getDatasets().isNotEmpty();
    }

    public void addDataset(ScGanttChartDataset e)
    {
        addRow().addDataset(e);
    }

    public ScGanttChartDataset addDataset()
    {
        return addRow().addDataset();
    }

    public void setDatasets(KmList<ScGanttChartDataset> v)
    {
        _rows.clearValue();

        for ( ScGanttChartDataset set : v )
            addDataset(set);
    }

    //##################################################
    //# categories
    //##################################################

    public void setCategoryColors()
    {
        KmList<ScGanttChartDataset> sets = getDatasets();

        for ( ScGanttChartDataset set : sets )
            setDatasetCategoryColors(set);
    }

    private void setDatasetCategoryColors(ScGanttChartDataset set)
    {
        KmList<ScGanttChartColor> colors = ScGanttChartColor.getRainbowThemeColors();
        KmList<ScGanttChartItemCategory> categories;
        categories = set.getCategories();

        int i = 0;
        for ( ScGanttChartItemCategory cat : categories )
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
    //# title
    //##################################################

    public String getTitle()
    {
        return _title.getValue();
    }

    public void setTitle(String e)
    {
        _title.setValue(e);
    }

    private boolean hasTitle()
    {
        return getTitle() != null;
    }

    //##################################################
    //# range min
    //##################################################

    public Integer getRangeMinIntValue()
    {
        return _rangeMinIntValue.getValue();
    }

    public void setRangeMinIntValue(Integer e)
    {
        _rangeMinIntValue.setValue(e);
    }

    private boolean hasRangeMinIntValue()
    {
        return _rangeMinIntValue.hasValue();
    }

    public Integer getEffectiveRangeMinIntValue()
    {
        return hasRangeMinIntValue()
            ? getRangeMinIntValue()
            : findStart();
    }

    //##################################################
    //# range max
    //##################################################

    public Integer getRangeMaxIntValue()
    {
        return _rangeMaxIntValue.getValue();
    }

    public void setRangeMaxIntValue(Integer e)
    {
        _rangeMaxIntValue.setValue(e);
    }

    private boolean hasRangeMaxIntValue()
    {
        return _rangeMaxIntValue.hasValue();
    }

    public Integer getEffectiveRangeMaxIntValue()
    {
        return hasRangeMaxIntValue()
            ? getRangeMaxIntValue()
            : findEnd();
    }

    //##################################################
    //# axis unit width
    //##################################################

    public Integer getAxisUnitWidth()
    {
        return _axisUnitWidth.getValue();
    }

    public void setAxisUnitWidth(Integer i)
    {
        _axisUnitWidth.setValue(i);
    }

    //##################################################
    //# current
    //##################################################

    public Integer getNowIntValue()
    {
        return _nowIntValue.getValue();
    }

    public void setNowIntValue(Integer e)
    {
        _nowIntValue.setValue(e);
    }

    public boolean hasNowIntValue()
    {
        return getNowIntValue() != null;
    }

    //##################################################
    //# legend label function
    //##################################################

    public Function<Integer,String> getAxisLabelIntFunction()
    {
        return _axisLabelIntFunction;
    }

    public void setAxisLabelIntFunction(Function<Integer,String> e)
    {
        _axisLabelIntFunction = e;
    }

    private boolean hasLegendFunction()
    {
        return getAxisLabelIntFunction() != null;
    }

    protected String getDefaultAxisLabelIntFunction(Integer i)
    {
        return i.toString();
    }

    //##################################################
    //# axis lable display
    //##################################################

    public Function<Integer,Boolean> getAxisLabelDisplayIntFunction()
    {
        return _axisLabelDisplayIntFunction;
    }

    public void setAxisLabelDisplayIntFunction(Function<Integer,Boolean> e)
    {
        _axisLabelDisplayIntFunction = e;
    }

    @SuppressWarnings("unused")
    protected Boolean getDefaultLabelAxisDisplayIntFunction(Integer i)
    {
        return true;
    }

    protected boolean showAxisLabelFor(Integer i)
    {
        return Kmu.isTrue(getAxisLabelDisplayIntFunction().apply(i));
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        renderLeftColumn();
        renderRightColumn();

        ScBlockScript script;
        script = getPostRenderScript();
        script.run(formatPostRenderScript());
    }

    private String formatPostRenderScript()
    {
        KmStringBuilder out;
        out = new KmStringBuilder();
        out.printf("$('#%s').on('scroll', function()", getChartHtmlId());
        out.printf("{");
        out.printf("$('#%s').scrollTop($(this).scrollTop());", getLabelsHtmlId());
        out.printf("$('#%s').scrollLeft($(this).scrollLeft());", getLegendHtmlId());
        out.printf("});");
        return out.toString();
    }

    //==================================================
    //= render :: left
    //==================================================

    private void renderLeftColumn()
    {
        ScDiv left;
        left = _transient.addDiv();
        left.css().ganttChart_leftColumn().ganttChart_bgGray();

        ScDiv header;
        header = left.addDiv();
        header.css().ganttChart_header();

        ScDiv labels;
        labels = left.addDiv();
        labels.setHtmlId(getLabelsHtmlId());
        labels.css().ganttChart_labelContent();
        renderLabelRowOn(labels);
    }

    private void renderLabelRowOn(ScDiv labels)
    {
        ScDiv rowDiv;

        KmList<ScGanttChartRow> v = getRows();
        for ( ScGanttChartRow row : v )
        {
            rowDiv = labels.addDiv();
            rowDiv.css().ganttChart_row().ganttChart_rowLabelWrapper();

            ScDiv left;
            left = rowDiv.addDiv();
            left.css().ganttChart_rowLabel();
            left.addText(row.getLabel());

            ScDiv right;
            right = rowDiv.addDiv();
            renderSetLabelsOn(row, right);
        }
    }

    private void renderSetLabelsOn(ScGanttChartRow row, ScDiv rowDiv)
    {
        ScDiv label;

        KmList<ScGanttChartDataset> v = row.getDatasets();
        for ( ScGanttChartDataset set : v )
        {
            label = rowDiv.addDiv();
            label.css().ganttChart_setLabel().ganttChart_set();
            label.addText(set.getName());
        }
    }

    //==================================================
    //= render :: right
    //==================================================

    private void renderRightColumn()
    {
        ScDiv right;
        right = _transient.addDiv();
        right.css().ganttChart_rightColumn();

        renderHeaderOn(right);
        renderChartOn(right);
    }

    //==================================================
    //= render :: header
    //==================================================

    private void renderHeaderOn(ScDiv right)
    {
        ScDiv header;
        header = right.addDiv();
        header.css().ganttChart_header().ganttChart_rightHeader().ganttChart_bgGray();

        renderTitleOn(header);
        renderTopAxisOn(header);
    }

    private void renderTitleOn(ScDiv header)
    {
        ScDiv title;
        title = header.addDiv();
        title.css().ganttChart_title();

        if ( hasTitle() )
            title.addText(getTitle());
    }

    private void renderTopAxisOn(ScDiv header)
    {
        ScDiv axisWrapper;
        axisWrapper = header.addDiv();
        axisWrapper.css().ganttChart_topAxisWrapper();
        axisWrapper.setHtmlId(getLegendHtmlId());

        ScDiv topAxis;
        topAxis = axisWrapper.addDiv();
        topAxis.css().ganttChart_topAxis();
        topAxis.style().width(getChartWidth());

        renderTopAxisItemsOn(topAxis);
    }

    private void renderTopAxisItemsOn(ScDiv topAxis)
    {
        Integer max = getEffectiveRangeMaxIntValue();
        Integer min = getEffectiveRangeMinIntValue();

        if ( max == null || min == null )
            return;

        ScSpan item;

        // Add first axis label
        item = addAxisItemTo(topAxis, min);

        // Add intermediate labels
        for ( int i = min + 1; i < max; i++ )
        {
            if ( !showAxisLabelFor(i) )
                continue;

            int left = computeLeftPixelsFor(i);
            //            int marginLeft = -getAxisUnitWidth() / 2;

            item = addAxisItemTo(topAxis, i);
            item.style().left(left);
            //                        item.style().left(left).marginLeft(marginLeft);
        }

        // Add last axis label
        item = addAxisItemTo(topAxis, max);
    }

    private ScSpan addAxisItemTo(ScDiv topAxis, int i)
    {
        ScSpan item;
        item = topAxis.addSpan();
        item.css().ganttChart_topAxisItem();
        item.addText(formatAxisLabel(i));
        return item;
    }

    //==================================================
    //= render :: chart content
    //==================================================

    private void renderChartOn(ScDiv right)
    {
        ScDiv chart;
        chart = right.addDiv();
        chart.css().ganttChart_chartWrapper();
        chart.setHtmlId(getChartHtmlId());

        renderChartContentOn(chart);
    }

    private void renderChartContentOn(ScDiv chart)
    {
        ScDiv content;
        content = chart.addDiv();
        content.css().ganttChart_chartContent();
        content.style().width(getChartWidth());

        KmList<ScGanttChartRow> v = getRows();
        for ( ScGanttChartRow row : v )
            renderRowOn(content, row);

        renderNowOn(content);
    }

    private void renderRowOn(ScDiv content, ScGanttChartRow row)
    {
        ScDiv rowContent;
        rowContent = content.addDiv();
        rowContent.css().ganttChart_row();

        KmList<ScGanttChartDataset> v = row.getDatasets();
        for ( ScGanttChartDataset set : v )
            renderSetOn(rowContent, set);
    }

    private void renderSetOn(ScDiv rowContent, ScGanttChartDataset set)
    {
        ScDiv setContent;
        setContent = rowContent.addDiv();
        setContent.css().ganttChart_setContent().ganttChart_set();

        KmList<ScGanttChartItem> v = set.getItems();
        for ( ScGanttChartItem item : v )
            renderItemOn(setContent, item);
    }

    //==================================================
    //= render :: row items
    //==================================================

    private void renderItemOn(ScDiv row, ScGanttChartItem item)
    {
        if ( isItemOutOfBounds(item) )
            return;

        checkItemBounds(item);

        int left = computeLeftPixelsFor(item);
        int right = computeRightPixelsFor(item);

        ScDiv itemDiv;
        itemDiv = row.addDiv();
        itemDiv.css().ganttChart_item();

        if ( left == -1 )
            itemDiv.css().ganttChart_item_startsBefore();
        else
            itemDiv.style().left(left);

        if ( right == -1 )
            itemDiv.css().ganttChart_item_endsAfter();
        else
            itemDiv.style().right(right);

        applyItemColorTo(itemDiv, item);

        ScSpan text;
        text = itemDiv.addSpan();
        text.css().ganttChart_itemLabel();
        text.addText(getTextFor(item));

        itemDiv.setHoverText(getHoverTextFor(item));
    }

    protected String getTextFor(ScGanttChartItem item)
    {
        return item.getDisplayName();
    }

    protected String getHoverTextFor(ScGanttChartItem item)
    {
        KmStringBuilder out;
        out = new KmStringBuilder();
        out.println(item.getDescription());
        out.printf("%s - %s", formatItemStart(item), formatItemEnd(item));
        return out.toString();
    }

    private String formatItemStart(ScGanttChartItem item)
    {
        return item.hasStartIntValue()
            ? item.getStartIntValue().toString()
            : NONE;
    }

    private String formatItemEnd(ScGanttChartItem item)
    {
        return item.hasEndIntValue()
            ? item.getEndIntValue().toString()
            : NONE;
    }

    private void checkItemBounds(ScGanttChartItem e)
    {
        Integer start = e.getStartIntValue();
        Integer end = e.getEndIntValue();

        if ( end == null )
            return;

        if ( start > end )
        {
            e.setStartIntValue(end);
            e.setEndIntValue(start);
        }
    }

    private void applyItemColorTo(ScDiv itemDiv, ScGanttChartItem item)
    {
        ScGanttChartColor color = item.getColor();

        if ( color == null )
            color = ScGanttChartColor.getDefaultColor();

        switch ( color )
        {
            case Blue:
                itemDiv.css().ganttChart_itemBlue();
                return;

            case Blue1:
                itemDiv.css().ganttChart_itemBlue1();
                return;

            case Blue2:
                itemDiv.css().ganttChart_itemBlue2();
                return;

            case Blue3:
                itemDiv.css().ganttChart_itemBlue3();
                return;

            case Blue4:
                itemDiv.css().ganttChart_itemBlue4();
                return;

            case Blue5:
                itemDiv.css().ganttChart_itemBlue5();
                return;

            case Blue6:
                itemDiv.css().ganttChart_itemBlue6();
                return;

            case Cyan:
                itemDiv.css().ganttChart_itemCyan();
                return;

            case Gray:
                itemDiv.css().ganttChart_itemGray();
                return;

            case Gray1:
                itemDiv.css().ganttChart_itemGray1();
                return;

            case Gray2:
                itemDiv.css().ganttChart_itemGray2();
                return;

            case Gray3:
                itemDiv.css().ganttChart_itemGray3();
                return;

            case Gray4:
                itemDiv.css().ganttChart_itemGray4();
                return;

            case Gray5:
                itemDiv.css().ganttChart_itemGray5();
                return;

            case Gray6:
                itemDiv.css().ganttChart_itemGray6();
                return;

            case Green:
                itemDiv.css().ganttChart_itemGreen();
                return;

            case Orange:
                itemDiv.css().ganttChart_itemOrange();
                return;

            case Orange1:
                itemDiv.css().ganttChart_itemOrange1();
                return;

            case Orange2:
                itemDiv.css().ganttChart_itemOrange2();
                return;

            case Orange3:
                itemDiv.css().ganttChart_itemOrange3();
                return;

            case Orange4:
                itemDiv.css().ganttChart_itemOrange4();
                return;

            case Orange5:
                itemDiv.css().ganttChart_itemOrange5();
                return;

            case Orange6:
                itemDiv.css().ganttChart_itemOrange6();
                return;

            case Purple:
                itemDiv.css().ganttChart_itemPurple();
                return;

            case Purple1:
                itemDiv.css().ganttChart_itemPurple1();
                return;

            case Purple2:
                itemDiv.css().ganttChart_itemPurple2();
                return;

            case Purple3:
                itemDiv.css().ganttChart_itemPurple3();
                return;

            case Purple4:
                itemDiv.css().ganttChart_itemPurple4();
                return;

            case Purple5:
                itemDiv.css().ganttChart_itemPurple5();
                return;

            case Purple6:
                itemDiv.css().ganttChart_itemPurple6();
                return;

            case Red:
                itemDiv.css().ganttChart_itemRed();
                return;

            case Yellow:
                itemDiv.css().ganttChart_itemYellow();
                return;
        }
        throw Kmu.newEnumError(color);
    }

    //==================================================
    //= render :: now
    //==================================================

    private void renderNowOn(ScDiv content)
    {
        if ( !hasNowIntValue() )
            return;

        if ( isNowOutOfBounds() )
            return;

        if ( !hasDatasets() )
            return;

        int left = computeLeftPixelsFor(getNowIntValue());

        ScDiv now;
        now = content.addDiv();
        now.css().ganttChart_now();
        now.style().left(left);
    }

    //##################################################
    //# support
    //##################################################

    /**
     * Find minimum start value of the chart's items.
     */
    private Integer findStart()
    {
        if ( !hasDatasets() )
            return null;

        KmList<ScGanttChartDataset> v = getDatasets().select(e -> e.hasStart());
        Integer start = v.getMinimumValue(e -> e.findStart());

        return start;
    }

    /**
     * Find minimum start value of the chart's items.
     */
    private Integer findEnd()
    {
        if ( !hasDatasets() )
            return null;

        KmList<ScGanttChartDataset> v = getDatasets().select(e -> e.hasEnd());
        Integer end = v.getMaximumValue(e -> e.findEnd());

        return end;
    }

    private Integer findTotalRange()
    {
        Integer min = getEffectiveRangeMinIntValue();
        Integer max = getEffectiveRangeMaxIntValue();

        if ( min == null || max == null )
            return null;

        return max - min;
    }

    private String formatAxisLabel(Integer i)
    {
        if ( !hasLegendFunction() )
            return null;

        return getAxisLabelIntFunction().apply(i);
    }

    private Integer getChartWidth()
    {
        Integer range = findTotalRange();
        if ( range == null )
            return null;

        return range * getAxisUnitWidth();
    }

    //==================================================
    //= support :: computation
    //==================================================

    /**
     * The distance between the left side of the chart and the left
     * side of the item (expressed as a precentage of the chart width).
     */
    private int computeLeftPixelsFor(ScGanttChartItem e)
    {
        return computeLeftPixelsFor(e.getStartIntValue());
    }

    private int computeLeftPixelsFor(Integer startValue)
    {
        Integer chartStart = getEffectiveRangeMinIntValue();
        Integer chartWidth = getChartWidth();

        if ( startValue < chartStart )
            return -1;

        Double startDouble = new Double(startValue - chartStart);
        Double rangeDouble = new Double(findTotalRange());

        Double pixels = startDouble / rangeDouble * chartWidth;
        return pixels.intValue();
    }

    /**
     * The distance between the right side of the item and the right
     * side of the chart (expressed as a precentage of the chart width).
     */
    private int computeRightPixelsFor(ScGanttChartItem e)
    {

        Integer chartStart = getEffectiveRangeMinIntValue();
        Integer chartEnd = getEffectiveRangeMaxIntValue();
        Integer itemEnd = e.getEndIntValue();
        Integer chartWidth = getChartWidth();

        if ( itemEnd == null || itemEnd > chartEnd )
            return -1;

        Double endDouble = new Double(itemEnd - chartStart);
        Double rangeDouble = new Double(findTotalRange());

        Double pixels = endDouble / rangeDouble * chartWidth;
        return chartWidth - pixels.intValue();
    }

    /**
     * True if the item completely outside of the bounds of the chart.
     */
    private boolean isItemOutOfBounds(ScGanttChartItem e)
    {
        Integer chartStart = getEffectiveRangeMinIntValue();
        Integer chartEnd = getEffectiveRangeMaxIntValue();

        Integer itemStart = e.getStartIntValue();
        Integer itemEnd = e.getEndIntValue();

        if ( itemEnd == null )
            return itemStart >= chartEnd;

        if ( itemEnd < chartStart )
            return true;

        if ( itemStart > chartEnd )
            return true;

        return false;
    }

    private boolean isNowOutOfBounds()
    {
        if ( !hasNowIntValue() )
            return false;

        Integer now = getNowIntValue();
        Integer chartStart = getEffectiveRangeMinIntValue();
        Integer chartEnd = getEffectiveRangeMaxIntValue();

        if ( chartStart == null || chartEnd == null )
            return true;

        if ( now < chartStart )
            return true;

        if ( now > chartEnd )
            return true;

        return false;
    }

    //==================================================
    //= support :: html ids
    //==================================================

    private String getLabelsHtmlId()
    {
        return getHtmlId() + LABELS_ID_SUFFIX;
    }

    private String getLegendHtmlId()
    {
        return getHtmlId() + LEGEND_ID_SUFFIX;
    }

    private String getChartHtmlId()
    {
        return getHtmlId() + CHART_ID_SUFFIX;
    }
}
