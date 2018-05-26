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

package com.kodemore.servlet.control;

import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Supplier;

import com.kodemore.collection.KmList;
import com.kodemore.filter.KmFilterFactoryIF;
import com.kodemore.filter.KmFilterIF;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.meta.KmMetaProperty;
import com.kodemore.servlet.ScEncodedValueIF;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.encoder.ScDecoder;
import com.kodemore.servlet.encoder.ScEncoder;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.utility.ScJquery;
import com.kodemore.servlet.utility.ScServletCallback;
import com.kodemore.servlet.utility.ScServletCallbackRegistry;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalInteger;
import com.kodemore.servlet.variable.ScLocalList;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

/**
 * A grid based on the JQuery Flexigrid tool.
 * http://flexigrid.info/
 * http://github.com/paulopmx/Flexigrid
 *
 * additional options?
 *      blockOpacity        => 0.5,
 *
 *      The auto-width was not working correctly.
 *          I applied a fix by changing the two instances
 *          of 1024px to 100% in the .css file.
 */
public class ScGrid<T>
    extends ScControl
{
    //##################################################
    //# constants :: defaults
    //##################################################

    private static final int[] DEFAULT_ROWS_PER_PAGE_OPTIONS =
    {
        20,
        50,
        100
    };

    private static final int DEFAULT_ROWS_PER_PAGE = DEFAULT_ROWS_PER_PAGE_OPTIONS[1];

    //==================================================
    //= constants :: flexigrid
    //==================================================

    // standard flexigrid parameters that are passed to the server
    // as part of each request.

    private static final String REQUEST_PAGE = "page";
    private static final String REQUEST_ROWS = "rp";

    //==================================================
    //= constants :: custom parameters
    //==================================================

    // custom callback parameters.
    // these are set grid with it is created so that they can be
    // passed back to the server with every request.

    private static final String PARAMETER_TOTAL_COUNT    = "myTotalCount";
    private static final String PARAMETER_TRACKED_VALUES = "myTrackedValues";

    //##################################################
    //# variables
    //##################################################

    private ScLocalString _header;

    /**
     * Defines a factory capable of creating the filter used to
     * fetch data.
     */
    private KmFilterFactoryIF<T> _filterFactory;

    /**
     * The list of columns to display.
     */
    private KmList<ScGridColumn<T>> _columns;

    /**
     * If true, the contents will be fetched a page at a time.
     * True by default.
     */
    private ScLocalBoolean _usesPager;

    /**
     * The number of rows displayed per page.
     * This can be set to any positive value.
     */
    private ScLocalInteger _rowsPerPage;

    /**
     * Allow the user to select the number of rows per page.
     */
    private ScLocalBoolean _selectRowsPerPage;

    /**
     * The available options for rows per page.
     * For example, the default is [10,15,20,30,50].
     */
    private ScLocalList<Integer> _rowsPerPageOptions;

    /**
     * If true, allows the user to hide the table.
     * Change is not persistent.
     * False by default.
     */
    private ScLocalBoolean _allowsToggleGrid;

    /**
     * If true, allow the user to toggle columns on and off.
     * Defaults to true.
     * Changes are not persistent.
     */
    private ScLocalBoolean _allowsToggleColumns;

    /**
     * If true, the table will only select one row at a time.
     */
    private ScLocalBoolean _singleSelect;

    /**
     * The width of the table, in pixels.
     * Null by default, which fills the available width.
     */
    private ScLocalInteger _width;

    /**
     * The height of the table, in pixels.
     * Null by default.
     */
    private ScLocalInteger _height;

    /**
     * If true, the user can resize the vertical and horizontal sizes.
     */
    private ScLocalBoolean _resizable;

    /**
     * If true, allow values to word wrap.
     * Default to false.
     */
    private ScLocalBoolean _wrap;

    /**
     * If true, attempt to adjust the layout such that the grid will fill its parent.
     * This relies on several assumptions and will likely break is we upgrade
     * to a different version of flexigrid.
     * My parent must have a non-static layout.
     * Additionally, the layout currently assumes that the header and pager are both visible.
     */
    private ScLocalBoolean _fill;

    /**
     * An optional function that determines the unique row id
     * of each element. If non-null, unique ids are included when
     * composing the html/xml content. This allows additional ajax
     * functionality; e.g.: programattically selecting a particular row.
     */
    private Function<T,String> _rowIdFunction;

    //##################################################
    //# variables: state management
    //##################################################

    /**
     * If true, the totalCount is computed during render and
     * subsequent callback requests for data use the
     * predetermined value; the totalCount will be recalculated
     * each time the grid is rendered.
     *
     * If false, the totalCount is recomputed every time the
     * client requests additional data.
     */
    private ScLocalBoolean _cacheTotalCount;

    /**
     * The cached totalCount.  This is only used if _cacheTotalCount
     * is true.
     */
    private ScLocalInteger _totalCount;

    /**
     * Used to bind extra data for filtering and sorting.
     * The values in this list will be encoded into the grid's
     * callback request url.  The values will be rebound to
     * their respective ScValue's before the filter is run.
     */
    private KmList<ScEncodedValueIF> _trackedValues;

    //##################################################
    //# constructor
    //##################################################

    public ScGrid()
    {
        _header = new ScLocalString();
        _columns = new KmList<>();
        _trackedValues = new KmList<>();

        _usesPager = new ScLocalBoolean(true);
        _selectRowsPerPage = new ScLocalBoolean(true);
        _rowsPerPage = new ScLocalInteger(DEFAULT_ROWS_PER_PAGE);
        _rowsPerPageOptions = new ScLocalList<>();
        setRowsPerPageOptions(DEFAULT_ROWS_PER_PAGE_OPTIONS);

        _allowsToggleGrid = new ScLocalBoolean(false);
        _allowsToggleColumns = new ScLocalBoolean(true);
        _singleSelect = new ScLocalBoolean(true);

        _cacheTotalCount = new ScLocalBoolean(true);
        _totalCount = new ScLocalInteger();

        _width = new ScLocalInteger();
        _height = new ScLocalInteger();

        _resizable = new ScLocalBoolean(false);
        _wrap = new ScLocalBoolean(false);
        _fill = new ScLocalBoolean(false);
    }

    //##################################################
    //# html id
    //##################################################

    /**
     * Note that these are private.
     * I currently do NOT implement HtmlIdIF.
     * Additional review would be needed to determine if
     * I can be safely shown/hidden.
     */
    private String getHtmlId()
    {
        return getKeyToken();
    }

    private String getJquerySelector()
    {
        return ScJquery.formatIdSelector(getHtmlId());
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
    //# pager
    //##################################################

    public boolean getUsesPager()
    {
        return _usesPager.getValue();
    }

    public void setUsesPager(boolean e)
    {
        _usesPager.setValue(e);
    }

    //==================================================
    //= pager :: rows per page
    //==================================================

    public Integer getRowsPerPage()
    {
        return _rowsPerPage.getValue();
    }

    public void setRowsPerPage(Integer e)
    {
        _rowsPerPage.setValue(e);
    }

    //==================================================
    //= pager :: rows per page options
    //==================================================

    public KmList<Integer> getRowsPerPageOptions()
    {
        return _rowsPerPageOptions.getValue();
    }

    public void setRowsPerPageOptions(KmList<Integer> v)
    {
        _rowsPerPageOptions.setValue(v);
    }

    public void setRowsPerPageOptions(int... arr)
    {
        _rowsPerPageOptions.clear();

        for ( int i : arr )
            _rowsPerPageOptions.add(i);
    }

    public boolean hasRowsPerPageOptions()
    {
        return _rowsPerPageOptions.isNotEmpty();
    }

    //==================================================
    //= pager :: select rows per page
    //==================================================

    public boolean getSelectRowsPerPage()
    {
        return _selectRowsPerPage.getValue();
    }

    public void setSelectRowsPerPage(boolean e)
    {
        _selectRowsPerPage.setValue(e);
    }

    //##################################################
    //# toggle grid
    //##################################################

    public boolean getAllowsToggleGrid()
    {
        return _allowsToggleGrid.getValue();
    }

    public void setAllowsToggleGrid(boolean e)
    {
        _allowsToggleGrid.setValue(e);
    }

    //##################################################
    //# toggle columns
    //##################################################

    public boolean getAllowsToggleColumns()
    {
        return _allowsToggleColumns.getValue();
    }

    public void setAllowsToggleColumns(boolean e)
    {
        _allowsToggleColumns.setValue(e);
    }

    //##################################################
    //# resizeable
    //##################################################

    public boolean getResizable()
    {
        return _resizable.getValue();
    }

    public void setResizable(boolean e)
    {
        _resizable.setValue(e);
    }

    //##################################################
    //# wrap
    //##################################################

    public boolean getWrap()
    {
        return _wrap.getValue();
    }

    public void setWrap(boolean e)
    {
        _wrap.setValue(e);
    }

    public void setWrap()
    {
        setWrap(true);
    }

    public void setNoWrap()
    {
        setWrap(false);
    }

    //##################################################
    //# single select
    //##################################################

    public boolean getSingleSelect()
    {
        return _singleSelect.getValue();
    }

    public void setSingleSelect(boolean e)
    {
        _singleSelect.setValue(e);
    }

    //##################################################
    //# fill
    //##################################################

    public boolean getFill()
    {
        return _fill.getValue();
    }

    public void setFill(boolean e)
    {
        _fill.setValue(e);
    }

    public void layoutFill()
    {
        setFill(true);
    }

    //##################################################
    //# row id
    //##################################################

    public Function<T,String> getRowIdFunction()
    {
        return _rowIdFunction;
    }

    public void setRowIdFunction(Function<T,String> e)
    {
        _rowIdFunction = e;
    }

    public boolean hasRowIdFunction()
    {
        return getRowIdFunction() != null;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void renderControlOn(KmHtmlBuilder out)
    {
        renderHtml(out);
        renderScript(out);
    }

    private void renderHtml(KmHtmlBuilder out)
    {
        out.open("table");
        out.printAttribute("id", getHtmlId());
        out.printAttribute("style", "display:none");
        out.close();
        out.end("table");
    }

    private void renderScript(KmHtmlBuilder out)
    {
        String sel = getJquerySelector();
        KmJsonMap setup = setupJson();

        out.getPostDom().run("$(%s).flexigrid(%s);", json(sel), setup);

        if ( getFill() )
            out.getPostDom().run("Kmu.flexigridFill(%s);", json(sel));
    }

    //##################################################
    //# setup json
    //##################################################

    private KmJsonMap setupJson()
    {
        KmJsonMap map;
        map = new KmJsonMap();

        setupGeneral(map);
        setupRequestUrl(map);
        setupPager(map);
        setupColumns(map);

        setupInitialParameters(map);

        return map;
    }

    private void setupColumns(KmJsonMap map)
    {
        KmJsonArray cells = map.setArray("colModel");

        for ( ScGridColumn<T> col : getColumns() )
            col.addCellDefinitionTo(cells);
    }

    private void setupGeneral(KmJsonMap map)
    {
        map.setString("title", getHeader());
        map.setBoolean("showTableToggleBtn", getAllowsToggleGrid());
        map.setBoolean("showToggleBtn", getAllowsToggleColumns());
        map.setBoolean("singleSelect", getSingleSelect());
        map.setBoolean("resizable", getResizable());
        map.setBoolean("nowrap", !getWrap());

        if ( hasWidth() )
            map.setInteger("width", getWidth());
        else
            map.setString("width", "auto");

        if ( hasHeight() )
            map.setInteger("height", getHeight());
    }

    private void setupPager(KmJsonMap map)
    {
        if ( !getUsesPager() )
        {
            map.setBoolean("usepager", false);
            return;
        }

        map.setBoolean("usepager", true);
        map.setInteger("rp", getRowsPerPage());
        map.setBoolean("useRp", getSelectRowsPerPage());

        if ( hasRowsPerPageOptions() )
        {
            KmJsonArray arr = map.setArray("rpOptions");
            KmList<Integer> v = getRowsPerPageOptions();
            for ( Integer i : v )
                arr.addInteger(i);
        }
    }

    private void setupRequestUrl(KmJsonMap map)
    {
        map.setString("url", formatRequestUrl());
        map.setString("method", "POST");
        map.setString("dataType", "json");
    }

    /**
     * The path suffix defined here must match getGridForPath.
     *
     * @see #getGridForPath
     */
    private String formatRequestUrl()
    {
        ScServletCallbackRegistry r = ScServletCallbackRegistry.getInstance();
        ScServletCallback c = r.getFlexigridCallback();
        String suffix = getKeyToken();
        return c.getPath(suffix);
    }

    private void setupInitialParameters(KmJsonMap map)
    {
        KmJsonArray params;
        params = map.setArray("params");

        _setupTrackedValues(params);
    }

    private void setupAllParameters(KmJsonMap map)
    {
        KmJsonArray params;
        params = map.setArray("params");

        _setupTotalCount(params);
        _setupTrackedValues(params);
    }

    private void _setupTotalCount(KmJsonArray params)
    {
        if ( _cacheTotalCount.isFalse() )
            return;

        KmJsonMap param;
        param = params.addMap();
        param.setString("name", PARAMETER_TOTAL_COUNT);
        param.setInteger("value", getTotalCount());
    }

    private void _setupTrackedValues(KmJsonArray params)
    {
        KmList<?> values = getTrackedValues();
        if ( values.isEmpty() )
            return;

        KmJsonMap param;
        param = params.addMap();
        param.setString("name", PARAMETER_TRACKED_VALUES);
        param.setString("value", ScEncoder.staticEncode(values));
    }

    //##################################################
    //# total count
    //##################################################

    public int getTotalCount()
    {
        if ( !getCacheTotalCount() )
            return computeTotalCount();

        if ( _totalCount.isNull() )
            _totalCount.setValue(computeTotalCount());

        return _totalCount.getValue();
    }

    private int computeTotalCount()
    {
        KmFilterFactoryIF<T> ff = getFilterFactory();
        if ( ff == null )
            return 0;

        KmFilterIF<T> filter = ff.createFilter();
        if ( filter == null )
            return 0;

        return filter.getCount();
    }

    public boolean getCacheTotalCount()
    {
        return _cacheTotalCount.getValue();
    }

    public void setCacheTotalCount(boolean e)
    {
        _cacheTotalCount.setValue(e);
    }

    //##################################################
    //# accessing
    //##################################################

    public KmFilterFactoryIF<T> getFilterFactory()
    {
        return _filterFactory;
    }

    public void setFilterFactory(KmFilterFactoryIF<T> e)
    {
        _filterFactory = e;
    }

    public void setFilterFactory(Supplier<KmList<T>> e)
    {
        setFilterFactory(new KmFilterFactoryIF<T>()
        {
            @Override
            public KmFilterIF<T> createFilter()
            {
                return e.get().toFilter();
            }
        });
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

    public void setWidthAuto()
    {
        _width.clearValue();
    }

    public boolean hasWidth()
    {
        return getWidth() != null;
    }

    //##################################################
    //# height
    //##################################################

    public Integer getHeight()
    {
        return _height.getValue();
    }

    public void setHeight(Integer e)
    {
        _height.setValue(e);
    }

    public boolean hasHeight()
    {
        return getHeight() != null;
    }

    //##################################################
    //# columns (misc)
    //##################################################

    public ScGridColumn<T> addColumn(ScGridColumn<T> e)
    {
        _columns.add(e);

        return e;
    }

    public ScGridColumn<T> addColumn()
    {
        ScGridColumn<T> e;
        e = new ScGridColumn<>();

        return addColumn(e);
    }

    public ScGridColumn<T> addColumn(KmMetaProperty<T,?> e)
    {
        ScGridColumn<T> c;
        c = e.newGridColumn();

        return addColumn(c);
    }

    public ScGridColumn<T> addColumn(KmMetaProperty<T,?> e, int width)
    {
        ScGridColumn<T> c;
        c = addColumn(e);
        c.setWidth(width);
        return c;
    }

    public ScGridColumn<T> addColumn(KmMetaProperty<T,?> e, String header)
    {
        ScGridColumn<T> c;
        c = e.newGridColumn();
        c.setHeader(header);
        c.setCharacterWidth(e.getColumnWidth());
        return addColumn(c);
    }

    public ScGridColumn<T> addColumn(KmMetaProperty<T,?> e, String header, int width)
    {
        ScGridColumn<T> c;
        c = addColumn(e);
        c.setHeader(header);
        c.setWidth(width);
        return c;
    }

    //==================================================
    //= link column
    //==================================================

    public ScGridColumn<T> addLinkColumn(KmMetaProperty<T,?> text, ScAction action, Object arg)
    {
        ScLink link;
        link = new ScLink();
        link.setText(text);
        link.setAction(action, arg);

        ScGridColumn<T> col;
        col = addColumn(link);
        col.setHeader(text.getLabel());
        col.setCharacterWidth(text.getColumnWidth());
        col.setExportFunction(text.toObjectFunction());
        return col;
    }

    public ScGridColumn<T> addLinkColumn(KmMetaAttribute<T,?> text, ScAction action)
    {
        ScLink link;
        link = new ScLink();
        link.setText(text);
        link.setAction(action, text);

        return addColumn(link);
    }

    public ScGridColumn<T> addLinkColumn(String text, ScAction action, Object arg)
    {
        ScLink link;
        link = new ScLink();
        link.setText(text);
        link.setAction(action, arg);

        return addColumn(link);
    }

    public ScGridColumn<T> addLinkColumn(String text, ScAction action, Function<T,?> arg)
    {
        ScLink link;
        link = new ScLink();
        link.setText(text);
        link.setAction(action, arg);

        return addColumn(link);
    }

    private ScGridColumn<T> addColumn(ScControl e)
    {
        ScGridColumn<T> col;
        col = addColumn();
        col.setWidth(150);
        col.setDisplayControl(e);
        return col;
    }

    public KmList<ScGridColumn<T>> getColumns()
    {
        return _columns;
    }

    //##################################################
    //# tracking
    //##################################################

    public void track(ScEncodedValueIF e)
    {
        _trackedValues.add(e);
    }

    public void trackAll(ScControl c)
    {
        c.visitAllEncodedValues(e -> track(e));
    }

    private KmList<?> getTrackedValues()
    {
        KmList<Object> v = new KmList<>();

        for ( ScEncodedValueIF value : _trackedValues )
            v.add(value.getEncodableValue());

        return v;
    }

    //##################################################
    //# export
    //##################################################

    public String exportCsv()
    {
        return new ScGridCsvExporter<>(this).exportString();
    }

    public String exportHtml()
    {
        return new ScGridHtmlExporter<>(this).exportString();
    }

    public byte[] exportExcel()
    {
        return new ScGridExcelExporter<>(this).exportBytes();
    }

    //##################################################
    //# servlet callback
    //##################################################

    /**
     * Handle servlet callback requests to fill the dropdown dynamically.
     * Callback handlers are registered in the ScServletCallbackRegistry.
     */
    public static void handleServletCallback(String pathSuffix)
    {
        ScGrid<?> e = getGridForPath(pathSuffix);
        if ( e != null )
            e.composeResults();
    }

    /*
     * Find the grid based on the url. The suffix is defined
     * in formatRequestUrl.
     *
     * @see ScGrid#formatRequestUrl
     */
    private static ScGrid<?> getGridForPath(String suffix)
    {
        String token = suffix;
        if ( Kmu.isEmpty(token) )
            return null;

        ScControl e = getRegistry().findToken(token);
        return e instanceof ScGrid
            ? (ScGrid<?>)e
            : null;
    }

    //##################################################
    //# results (local)
    //##################################################

    private void composeResults()
    {
        ScServletData data = getData();
        applyTrackedValuesFor(data);

        String sPage = data.getParameter(REQUEST_PAGE);
        String sRows = data.getParameter(REQUEST_ROWS);

        getTotalCount();
        int total = composeResultTotal();

        Integer page = Kmu.parseInteger(sPage);
        if ( page > total )
            page = total;

        Integer reqRows = Kmu.parseInteger(sRows);

        int index = (page - 1) * reqRows;
        int count = reqRows;
        KmList<T> results = composeResultBatch(index, count);

        KmJsonMap json = composeJsonFor(results, page, total);
        data.setJsonResult(json);
    }

    private int composeResultTotal()
    {
        Integer total = null;

        String s = getData().getParameter(PARAMETER_TOTAL_COUNT);
        if ( s != null )
            total = Kmu.parseInteger(s);

        if ( total != null )
            return total;

        KmFilterIF<T> filter = createFilter();
        if ( filter == null )
            return 0;

        return filter.getCount();
    }

    private KmList<T> composeResultBatch(int index, int count)
    {
        KmFilterIF<T> filter = createFilter();
        if ( filter == null )
            return KmList.createEmpty();

        return filter.findBatch(index, count);
    }

    private KmJsonMap composeJsonFor(KmList<T> results, Integer page, int total)
    {
        KmJsonMap json;
        json = new KmJsonMap();
        json.setInteger("total", total);
        json.setInteger("page", page);

        KmJsonArray rows;
        rows = json.setArray("rows");

        for ( T model : results )
            rows.addMap(composeJsonRowFor(model));

        return json;
    }

    private KmJsonMap composeJsonRowFor(T model)
    {
        KmJsonMap row = new KmJsonMap();

        String suffix = getRowIdSuffixFor(model);
        if ( suffix != null )
            row.setString("id", suffix);

        KmJsonArray cells;
        cells = row.setArray("cell");

        KmList<ScGridColumn<T>> cols = getColumns();
        for ( ScGridColumn<T> col : cols )
            col.addCellDataTo(cells, model);

        return row;
    }

    private KmFilterIF<T> createFilter()
    {
        KmFilterFactoryIF<T> ff = getFilterFactory();

        return ff == null
            ? null
            : ff.createFilter();
    }

    /**
     * Decode the values that are passed in on the request url and apply
     * them to the appropriate ScValue's.  This must be done prior to calling
     * the filter, so that the client code will be able to conveniently
     * access the values.
     */
    private void applyTrackedValuesFor(ScServletData data)
    {
        String encodedValues = data.getParameter(PARAMETER_TRACKED_VALUES);

        if ( Kmu.isEmpty(encodedValues) )
            return;

        KmList<?> decodedValues = (KmList<?>)ScDecoder.staticDecode(encodedValues);
        Iterator<?> decodedIterator = decodedValues.iterator();
        Iterator<ScEncodedValueIF> trackedIterator = _trackedValues.iterator();

        while ( decodedIterator.hasNext() )
        {
            Object nextDecode = decodedIterator.next();

            ScEncodedValueIF nextValue;
            nextValue = trackedIterator.next();
            nextValue.setEncodableValue(nextDecode);
        }
    }

    //==================================================
    //= row id
    //==================================================

    /**
     * Select (highlight) a row via ajax.
     *
     * This works, however...
     *      You must configure the rowIdFunction to return a unique id
     *      for each possible grid row.
     *
     *      The row you are selecting must have already been populated
     *      into the grid.
     *
     *      If you try to select a row while refreshing/populating
     *      the grid, then it does not work because the contents
     *      are populated dynamically.
     */
    public void ajaxSelectRowFor(T e)
    {
        String htmlId = getHtmlId();
        String rowId = getRowIdFor(e);

        if ( rowId == null )
            return;

        ScBlockScript ajax;
        ajax = getRootScript();
        ajax.run("$('#%s tr').removeClass('trSelected');", htmlId);
        ajax.run("$('#%s tr#%s').addClass('trSelected');", htmlId, rowId);
    }

    private String getRowIdFor(T e)
    {
        String suffix = getRowIdSuffixFor(e);
        if ( suffix == null )
            return null;

        return "row" + suffix;
    }

    private String getRowIdSuffixFor(T e)
    {
        return hasRowIdFunction()
            ? "_" + getRowIdFunction().apply(e)
            : null;
    }

    //##################################################
    //# ajax results
    //##################################################

    public void ajaxReload()
    {
        ajaxReload(true);
    }

    public void ajaxReload(boolean gotoFirstPage)
    {
        String sel = getJquerySelector();

        KmJsonMap map = new KmJsonMap();
        setupAllParameters(map);

        if ( gotoFirstPage )
            map.setInteger("newp", 1);

        String options = map.formatJson();

        ScBlockScript ajax;
        ajax = getRootScript();
        ajax.run("$(%s).flexOptions(%s);", json(sel), options);
        ajax.run("$(%s).flexReload();", json(sel));
    }
}
