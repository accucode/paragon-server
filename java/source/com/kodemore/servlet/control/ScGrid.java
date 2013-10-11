/*
  Copyright (c) 2005-2013 www.kodemore.com

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

import com.app.ui.servlet.ScServletCallback;
import com.app.ui.servlet.ScServletCallbackRegistry;

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.collection.KmList;
import com.kodemore.csv.KmCsvBuilder;
import com.kodemore.filter.KmFilterFactoryIF;
import com.kodemore.filter.KmFilterIF;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.meta.KmMetaProperty;
import com.kodemore.servlet.ScEncodedValueIF;
import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.encoder.ScDecoder;
import com.kodemore.servlet.encoder.ScEncoder;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.servlet.utility.ScJquery;
import com.kodemore.servlet.variable.ScLocalBoolean;
import com.kodemore.servlet.variable.ScLocalInteger;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

/**
 * A grid based on the JQuery Flexigrid tool.
 * http://flexigrid.info/
 * http://github.com/paulopmx/Flexigrid
 *
 * additional options?
 *      rpOptions           => [10,15,20,25,40]
 *      blockOpacity        => 0.5,
 * 
 *      The auto-width was not working correctly.  
 *          I applied a fix by changing the two instances 
 *          of 1024px to 100% in the .css file. 
 */
public class ScGrid<T>
    extends ScControl
    implements ScHtmlIdIF
{
    //##################################################
    //# constants
    //##################################################

    // standard flexigrid parameters that are passed to the server
    // as part of each request.

    private static final String      REQUEST_PAGE             = "page";
    private static final String      REQUEST_ROWS             = "rp";

    // my custom callback parameters.
    // these are set grid with it is created so that they can be
    // passed back to the server with every request.

    private static final String      PARAMETER_TOTAL_COUNT    = "myTotalCount";
    private static final String      PARAMETER_TRACKED_VALUES = "myTrackedValues";

    /**
     * The name of the file used when exported csv data as an attachment.
     */
    private static final String      CSV_DATA_FILE            = "data.csv";

    //##################################################
    //# variables
    //##################################################

    private ScLocalString            _header;

    /**
     * Defines a factory capable of creating the filter used to 
     * fetch data.
     */
    private KmFilterFactoryIF<T>     _filterFactory;

    /**
     * The list of columns to display.
     */
    private KmList<ScGridColumn<T>>  _columns;

    /**
     * If true, the contents will be fetched a page at a time.
     * True by default.
     */
    private ScLocalBoolean           _usesPager;

    /**
     * The number of rows displayed per page.
     * This can be set to any positive value.
     */
    private ScLocalInteger           _rowsPerPage;

    /**
     * Allow the user to select the number of rows per page.
     */
    private ScLocalBoolean           _selectRowsPerPage;

    /**
     * If true, allows the user to hide the table.
     * Change is not persistent.
     * False by default.
     */
    private ScLocalBoolean           _allowsToggleGrid;

    /**
     * If true, allow the user to toggle columns on and off.
     * Defaults to true.
     * Changes are not persistent.
     */
    private ScLocalBoolean           _allowsToggleColumns;

    /**
     * If true, the table will only select one row at a time.
     */
    private ScLocalBoolean           _singleSelect;

    /**
     * The width of the table, in pixels.
     * Null by default, which fills the available width.
     */
    private ScLocalInteger           _width;

    /**
     * The height of the table, in pixels.
     * Null by default.
     */
    private ScLocalInteger           _height;

    /**
     * If true, the user can resize the vertical and horizontal sizes.
     */
    private ScLocalBoolean           _resizable;

    /**
     * If false, then allow values to word wrap.  Wrapper is disabled
     * by default.
     */
    private ScLocalBoolean           _noWrap;

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
    private ScLocalBoolean           _cacheTotalCount;

    /**
     * The cached totalCount.  This is only used if _cacheTotalCount
     * is true.
     */
    private ScLocalInteger           _totalCount;

    /**
     * Used to bind extra data for filtering and sorting.
     * The values in this list will be encoded into the grid's
     * callback request url.  The values will be rebound to
     * their respective ScValue's prior to execute the filter.
     */
    private KmList<ScEncodedValueIF> _trackedValues;

    //##################################################
    //# init
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        _header = new ScLocalString();
        _columns = new KmList<ScGridColumn<T>>();
        _trackedValues = new KmList<ScEncodedValueIF>();

        _usesPager = new ScLocalBoolean(true);
        _rowsPerPage = new ScLocalInteger(30);
        _selectRowsPerPage = new ScLocalBoolean(true);

        _allowsToggleGrid = new ScLocalBoolean(false);
        _allowsToggleColumns = new ScLocalBoolean(true);
        _singleSelect = new ScLocalBoolean(true);

        _cacheTotalCount = new ScLocalBoolean(true);
        _totalCount = new ScLocalInteger();

        _width = new ScLocalInteger();
        _height = new ScLocalInteger();

        _resizable = new ScLocalBoolean(false);
        _noWrap = new ScLocalBoolean(true);
    }

    //##################################################
    //# html id
    //##################################################

    @Override
    public String getHtmlId()
    {
        return getKey();
    }

    @Override
    public String formatJquerySelector()
    {
        return ScJquery.formatSelector(this);
    }

    @Override
    public String formatJqueryReference()
    {
        return ScJquery.formatReference(this);
    }

    @Override
    public ScHtmlIdAjax ajax()
    {
        return new ScHtmlIdAjax(getRootScript(), this);
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

    public Integer getRowsPerPage()
    {
        return _rowsPerPage.getValue();
    }

    public void setRowsPerPage(Integer e)
    {
        _rowsPerPage.setValue(e);
    }

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

    public boolean getNoWrap()
    {
        return _noWrap.getValue();
    }

    public void setNoWrap(boolean e)
    {
        _noWrap.setValue(e);
    }

    public void setWrap()
    {
        setNoWrap(false);
    }

    public void setNoWrap()
    {
        setNoWrap(true);
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
    //# print
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
        String ref = formatJqueryReference();
        KmJsonMap setup = setupJson();

        out.getPostDom().run("%s.flexigrid(%s);", ref, setup);
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
        setupSorting(map);
        setupColumns(map);

        return map;
    }

    private void setupColumns(KmJsonMap map)
    {
        KmJsonArray cells = map.setArray("colModel");

        for ( ScGridColumn<T> col : getColumns() )
            col.addCellDefinitionTo(cells);
    }

    private void setupSorting(KmJsonMap map)
    {
        ScGridColumn<T> sortedCol = getSortedColumn();
        if ( sortedCol != null )
        {
            map.setString("sortname", sortedCol.getKey());
            map.setString("sortorder", sortedCol.formatDefaultSort());
        }
    }

    private void setupGeneral(KmJsonMap map)
    {
        map.setString("title", getHeader());
        map.setBoolean("showTableToggleBtn", getAllowsToggleGrid());
        map.setBoolean("showToggleBtn", getAllowsToggleColumns());
        map.setBoolean("singleSelect", getSingleSelect());
        map.setBoolean("resizable", getResizable());
        map.setBoolean("nowrap", getNoWrap());

        if ( hasWidth() )
            map.setInteger("width", getWidth());
        else
            map.setString("width", "auto");

        if ( hasHeight() )
            map.setInteger("height", getHeight());
    }

    private void setupPager(KmJsonMap map)
    {
        if ( getUsesPager() )
        {
            map.setBoolean("usepager", true);
            map.setInteger("rp", getRowsPerPage());
            map.setBoolean("useRp", getSelectRowsPerPage());
        }
    }

    private void setupRequestUrl(KmJsonMap map)
    {
        map.setString("url", formatRequestUrl());
        map.setString("method", "POST");
        map.setString("dataType", "json");
    }

    private String formatRequestUrl()
    {
        ScServletCallbackRegistry r = ScServletCallbackRegistry.getInstance();
        ScServletCallback c = r.getFlexigridCallback();
        return c.getPath(getKey());
    }

    private void setupRequestParameters(KmJsonMap map)
    {
        KmJsonArray params;
        params = map.setArray("params");

        KmJsonMap param;
        param = params.addMap();

        if ( _cacheTotalCount.isTrue() )
        {
            param = params.addMap();
            param.setString("name", PARAMETER_TOTAL_COUNT);
            param.setInteger("value", getTotalCount());
        }

        KmList<?> values = getTrackedValues();
        if ( values.isNotEmpty() )
        {
            param = params.addMap();
            param.setString("name", PARAMETER_TRACKED_VALUES);
            param.setString("value", ScEncoder.staticEncode(values));
        }
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
        e = new ScGridColumn<T>();

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

    public ScGridColumn<T> addLinkColumn(
        KmMetaProperty<T,?> text,
        ScActionIF action,
        KmMetaProperty<T,?> arg)
    {
        ScLink link;
        link = new ScLink();
        link.setText(text);
        link.setAction(action, arg);

        ScGridColumn<T> col;
        col = addColumn(link);
        col.setHeader(text.getLabel());
        col.setCharacterWidth(text.getColumnWidth());
        return col;
    }

    public ScGridColumn<T> addLinkColumn(KmMetaAttribute<T,?> text, ScActionIF action)
    {
        ScLink link;
        link = new ScLink();
        link.setText(text);
        link.setAction(action, text);

        return addColumn(link);
    }

    public ScGridColumn<T> addLinkColumn(String text, ScActionIF action, KmMetaProperty<T,?> arg)
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
    //# sort
    //##################################################

    public void clearDefaultSort()
    {
        for ( ScGridColumn<T> e : getColumns() )
            e.clearDefaultSort();
    }

    public ScGridColumn<T> getSortedColumn()
    {
        for ( ScGridColumn<T> e : getColumns() )
            if ( e.hasDefaultSort() )
                return e;

        return null;
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
        if ( c instanceof ScEncodedValueIF )
            track((ScEncodedValueIF)c);

        Iterator<ScControl> i = c.getComponents();
        while ( i.hasNext() )
        {
            ScControl e = i.next();

            if ( e instanceof ScEncodedValueIF )
                track((ScEncodedValueIF)e);

            trackAll(e);
        }
    }

    private KmList<?> getTrackedValues()
    {
        KmList<Object> v = new KmList<Object>();

        for ( ScEncodedValueIF value : _trackedValues )
            v.add(value.getEncodedValue());

        return v;
    }

    //##################################################
    //# print csv
    //##################################################

    public void printCsvAttachment()
    {
        KmCsvBuilder out = new KmCsvBuilder();
        String fileName = CSV_DATA_FILE;
        printCsvAttachmentOn(out, fileName);
    }

    private void printCsvAttachmentOn(KmCsvBuilder out, String fileName)
    {
        KmFilterIF<T> filter = getFilterFactory().createFilter();
        if ( filter == null )
            return;

        Iterable<T> cursor = filter.getCursor();
        printCsvAttachment(out, cursor, fileName);
    }

    private void printCsvAttachment(KmCsvBuilder out, Iterable<T> cursor, String fileName)
    {
        renderCsvOn(out, cursor);
        String csv = out.toString();
        getData().setAttachmentResult(fileName, csv);
    }

    //##################################################
    //# render csv
    //##################################################

    public String renderCsv()
    {
        KmFilterIF<T> filter = getFilterFactory().createFilter();
        if ( filter == null )
            return null;

        KmCsvBuilder out = new KmCsvBuilder();

        Iterable<T> cursor = filter.getCursor();
        renderCsvOn(out, cursor);

        return out.toString();
    }

    private void renderCsvOn(KmCsvBuilder out, Iterable<T> cursor)
    {
        renderCsvHeaders(out);
        renderCsvData(out, cursor);
    }

    private void renderCsvHeaders(KmCsvBuilder out)
    {
        for ( ScGridColumn<T> col : getCsvColumns() )
            out.printField(col.getHeader());

        out.endRecord();
    }

    private void renderCsvData(KmCsvBuilder out, Iterable<T> cursor)
    {
        KmList<ScGridColumn<T>> columns = getCsvColumns();
        for ( T e : cursor )
        {
            for ( ScGridColumn<T> col : columns )
                renderCsvField(out, col, e);

            out.endRecord();
        }
    }

    private void renderCsvField(KmCsvBuilder out, ScGridColumn<T> column, Object model)
    {
        if ( !column.getVisible() )
            return;

        if ( !column.isCsvCell() )
            return;

        renderCsvField(out, column.getCsvCell(), model);
    }

    private void renderCsvField(KmCsvBuilder out, Object o, Object model)
    {
        if ( o instanceof KmAdaptorIF<?,?> )
        {
            renderCsvAdaptor(out, o, model);
            return;
        }

        if ( o instanceof ScLink )
        {
            ScLink link = (ScLink)o;
            renderCsvField(out, link.getText(), model);
            return;
        }

        if ( o instanceof ScRenderer )
        {
            if ( model == null )
            {
                renderCsvValue(out, null);
                return;
            }

            KmHtmlBuilder html = new KmHtmlBuilder();

            ScRenderer renderer;
            renderer = (ScRenderer)o;
            renderer.renderOn(html, this, model);

            out.printField(html.toString());
            return;
        }

        renderCsvValue(out, o);
    }

    @SuppressWarnings(
    {
        "unchecked",
        "rawtypes"
    })
    private void renderCsvAdaptor(KmCsvBuilder out, Object adaptor, Object model)
    {
        if ( model == null )
        {
            renderCsvValue(out, null);
            return;
        }

        KmAdaptorIF a = (KmAdaptorIF)adaptor;
        Object value = a.getValue(model);
        renderCsvValue(out, value);
    }

    private void renderCsvValue(KmCsvBuilder out, Object e)
    {
        out.printField(e);
    }

    private KmList<ScGridColumn<T>> getCsvColumns()
    {
        KmList<ScGridColumn<T>> v = new KmList<ScGridColumn<T>>();

        for ( ScGridColumn<T> e : getColumns() )
            if ( e.isCsvCell() && e.isVisible() )
                v.add(e);

        return v;
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
        ScGrid<?> g = getGridForPath(pathSuffix);
        if ( g != null )
            g.composeResults();
    }

    private static ScGrid<?> getGridForPath(String suffix)
    {
        /*
         * We assume the pathSuffix is the control's key since that is 
         * what we provided when composing the url.  See formatRequestUrl().
         */
        String key = suffix;
        if ( Kmu.isEmpty(key) )
            return null;

        ScControl c = getRegistry().getControl(key);
        if ( !(c instanceof ScGrid) )
            return null;

        return (ScGrid<?>)c;
    }

    //##################################################
    //# results (local)
    //##################################################

    private void composeResults()
    {
        ScServletData data = getData();
        applyTrackedValuesFor(data);

        KmFilterIF<T> filter = getFilter();
        if ( filter == null )
            return;

        String sPage = data.getParameter(REQUEST_PAGE);
        String sRows = data.getParameter(REQUEST_ROWS);

        int total = getTotalFor(data, filter);

        Integer page = Kmu.parseInteger(sPage);
        if ( page > total )
            page = total;

        Integer reqRows = Kmu.parseInteger(sRows);

        int index = (page - 1) * reqRows;
        int count = reqRows;
        KmList<T> results = filter.findBatch(index, count);

        KmJsonMap json = composeJsonFor(results, page, total);
        data.setJsonResult(json);
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
        {
            KmJsonMap row;
            row = rows.addMap();

            KmJsonArray cells;
            cells = row.setArray("cell");

            KmList<ScGridColumn<T>> cols = getColumns();
            for ( ScGridColumn<T> col : cols )
                col.addCellDataTo(cells, model);
        }

        return json;
    }

    private KmFilterIF<T> getFilter()
    {
        KmFilterFactoryIF<T> ff = getFilterFactory();

        return ff == null
            ? null
            : ff.createFilter();
    }

    private int getTotalFor(ScServletData data, KmFilterIF<T> filter)
    {
        Integer total = null;

        String s = data.getParameter(PARAMETER_TOTAL_COUNT);
        if ( s != null )
            total = Kmu.parseInteger(s);

        if ( total != null )
            return total;

        return filter.getCount();
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
            nextValue.setEncodedValue(nextDecode);
        }
    }

    //##################################################
    //# ajax results
    //##################################################

    public void ajaxReload()
    {
        String ref = formatJqueryReference();

        KmJsonMap map = new KmJsonMap();
        setupRequestParameters(map);
        String options = map.formatJson();

        ajax().run("%s.flexOptions(%s);", ref, options);
        ajax().run("%s.flexReload();", formatJqueryReference());
    }

    public void ajaxDownloadCsv()
    {
        ajaxDownloadCsv("export.csv");
    }

    public void ajaxDownloadCsv(String name)
    {
        getRootScript().download(name, renderCsv());
    }

}
