package com.kodemore.servlet.control;

import java.util.function.BiConsumer;
import java.util.function.Function;

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.html.cssBuilder.KmCssDefaultBuilder;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.renderer.ScRenderer;
import com.kodemore.servlet.utility.ScControlRegistry;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalFunction;
import com.kodemore.servlet.variable.ScLocalInteger;
import com.kodemore.servlet.variable.ScLocalRenderer;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

public class ScGridColumn<T>
{
    //##################################################
    //# constants
    //##################################################

    private static final String               SORT_ASCENDING  = "asc";
    private static final String               SORT_DESCENDING = "desc";

    //##################################################
    //# variables
    //##################################################

    /**
     * The unique key.
     */
    private String                            _key;

    /**
     * The grid.
     */
    private ScGrid<T>                         _grid;

    /**
     * The column header.
     */
    private ScLocalString                     _header;

    /**
     * The column width, in pixels.
     */
    private ScLocalInteger                    _width;

    /**
     * The horizontal alignment; left, right, center.
     */
    private ScLocalString                     _alignment;

    /**
     * If false the column is hidden by default.
     */
    private ScLocalBoolean                    _visible;

    /**
     * If true, the client side grid will allow the user to
     * select it for sorting.
     */
    private ScLocalBoolean                    _sortable;

    /**
     * Sort ascending (true), descending (false), or not sorted (null).
     */
    private ScLocalBoolean                    _defaultSort;

    /**
     * Convert each row's model into a value for display in the
     * table's column.  The result must be compatible with the
     * default formatter, ScFormatter.printAny(Object)
     */
    private ScLocalRenderer                   _displayRenderer;

    /**
     * If non-null, include the column in data exports.
     */
    private ScLocalFunction<T,Object>         _exportFunction;

    /**
     * This consumer is called for each cell in order to determine
     * the css class(es). The result of the display renderer is
     * wrapped in a span with the specified css.
     */
    private BiConsumer<T,KmCssDefaultBuilder> _spanCss;

    //##################################################
    //# constructor
    //##################################################

    public ScGridColumn()
    {
        _key = ScControlRegistry.getInstance().getNextKey();
        _header = new ScLocalString();
        _width = new ScLocalInteger();
        _alignment = new ScLocalString();
        _visible = new ScLocalBoolean(true);

        _sortable = new ScLocalBoolean(false);
        _defaultSort = new ScLocalBoolean(null);

        _displayRenderer = new ScLocalRenderer();
        _exportFunction = new ScLocalFunction<>();

        alignLeft();
        setWidth(150);
        setDefaultSort();
    }

    //##################################################
    //# key
    //##################################################

    public String getKey()
    {
        return _key;
    }

    public boolean hasKey(String e)
    {
        return Kmu.isEqual(getKey(), e);
    }

    //##################################################
    //# grid
    //##################################################

    public ScGrid<T> getGrid()
    {
        return _grid;
    }

    public void setGrid(ScGrid<T> e)
    {
        _grid = e;
    }

    //##################################################
    //# header
    //##################################################

    public String getHeader()
    {
        return _header.getValue();
    }

    public void setHeader(String e)
    {
        _header.setValue(e);
    }

    public boolean hasHeader()
    {
        return _header.hasValue();
    }

    //##################################################
    //# width
    //##################################################

    public Integer getWidth()
    {
        return _width.getValue();
    }

    public void setWidth(Integer e)
    {
        _width.setValue(e);
    }

    public ScGridColumn<T> width(Integer e)
    {
        setWidth(e);
        return this;
    }

    public boolean hasWidth()
    {
        return _width.hasValue() && getWidth() > 0;
    }

    public void setCharacterWidth(int e)
    {
        setWidth(8 * e);
    }

    //##################################################
    //# align
    //##################################################

    public String getAlignment()
    {
        return _alignment.getValue();
    }

    public ScGridColumn<T> alignLeft()
    {
        _alignment.setValue("left");
        return this;
    }

    public ScGridColumn<T> alignRight()
    {
        _alignment.setValue("right");
        return this;
    }

    public ScGridColumn<T> alignCenter()
    {
        _alignment.setValue("center");
        return this;
    }

    //##################################################
    //# visible
    //##################################################

    public boolean getVisible()
    {
        return _visible.getValue();
    }

    public void setVisible(boolean e)
    {
        _visible.setValue(e);
    }

    public ScGridColumn<T> show()
    {
        setVisible(true);
        return this;
    }

    public ScGridColumn<T> hide()
    {
        setVisible(false);
        return this;
    }

    public boolean isVisible()
    {
        return getVisible();
    }

    public boolean isHidden()
    {
        return !isVisible();
    }

    //##################################################
    //# span css
    //##################################################

    public BiConsumer<T,KmCssDefaultBuilder> getSpanCss()
    {
        return _spanCss;
    }

    public void setSpanCss(BiConsumer<T,KmCssDefaultBuilder> e)
    {
        _spanCss = e;
    }

    //##################################################
    //# sortable
    //##################################################

    public boolean getSortable()
    {
        return _sortable.getValue();
    }

    public void setSortable(boolean e)
    {
        _sortable.setValue(e);
    }

    public void setSortable()
    {
        setSortable(true);
    }

    public boolean isSortable()
    {
        return getSortable();
    }

    //##################################################
    //# default sort order
    //##################################################

    public Boolean getDefaultSort()
    {
        return _defaultSort.getValue();
    }

    public void setDefaultSort(Boolean e)
    {
        if ( _grid != null )
            _grid.clearDefaultSort();

        _defaultSort.setValue(e);
    }

    public void setDefaultSort()
    {
        setDefaultSort(true);
    }

    public boolean hasDefaultSort()
    {
        return _defaultSort.hasValue();
    }

    public void clearDefaultSort()
    {
        _defaultSort.clearValue();
    }

    public String formatDefaultSort()
    {
        if ( !hasDefaultSort() )
            return SORT_ASCENDING;

        return getDefaultSort()
            ? SORT_ASCENDING
            : SORT_DESCENDING;
    }

    //##################################################
    //# sort: request
    //##################################################

    /**
     * Determine if the user requested to sort on this column.
     */
    public boolean isSorted()
    {
        return getSortOrder() != null;
    }

    /**
     * The sort order requested by the user.
     * Ascending (true), descending (false), not sorted (null).
     */
    public Boolean getSortOrder()
    {
        String name = getData().getParameter("sortname");
        if ( !hasKey(name) )
            return null;

        String order = getData().getParameter("sortorder");
        return !Kmu.isEqual(order, SORT_DESCENDING);
    }

    //##################################################
    //# display adaptor
    //##################################################

    public ScRenderer getDisplayRenderer()
    {
        return _displayRenderer.getValue();
    }

    public boolean hasDisplayRenderer()
    {
        return _displayRenderer.hasValue();
    }

    public void setDisplayAdaptor(KmAdaptorIF<T,?> e)
    {
        _displayRenderer.setAdaptor(e);
    }

    public void setDisplayAdaptor(KmMetaAttribute<T,?> e)
    {
        _displayRenderer.setAttribute(e);
    }

    public void setDisplayControl(ScControl e)
    {
        _displayRenderer.setControl(e);
    }

    //##################################################
    //# export adaptor
    //##################################################

    public Function<T,?> getExportFunction()
    {
        return _exportFunction.getValue();
    }

    public void setExportFunction(Function<T,Object> e)
    {
        _exportFunction.setValue(e);
    }

    public boolean hasExportFunction()
    {
        return _exportFunction.hasValue();
    }

    //##################################################
    //# compose
    //##################################################

    public void addCellDefinitionTo(KmJsonArray cells)
    {
        KmJsonMap map;
        map = cells.addMap();
        map.setString("name", getKey());

        map.setString("display", formatHeader());

        if ( hasWidth() )
            map.setInteger("width", getWidth());

        if ( isHidden() )
            map.setBoolean("hide", true);

        map.setBoolean("sortable", getSortable());
        map.setString("align", getAlignment());
    }

    public void addCellDataTo(KmJsonArray cells, T model)
    {
        if ( !hasDisplayRenderer() )
        {
            cells.addNull();
            return;
        }

        String html = renderCellHtmlFor(model);

        cells.addString(html);
    }

    private String renderCellHtmlFor(T model)
    {
        ScControl parent = getGrid();
        String html = getDisplayRenderer().render(parent, model);

        if ( _spanCss == null )
            return html;

        KmCssDefaultBuilder css = new KmCssDefaultBuilder();
        _spanCss.accept(model, css);
        if ( css.isEmpty() )
            return html;

        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.openSpan();
        out.printAttribute(css);
        out.close();
        out.printLiteral(html);
        out.endSpan();
        return out.formatHtml();
    }

    private String formatHeader()
    {
        return hasHeader()
            ? getHeader()
            : "";
    }

    //##################################################
    //# support
    //##################################################

    private ScServletData getData()
    {
        return ScServletData.getLocal();
    }

}
