package com.app.ui.page.chartReport;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmOrderedMap;
import com.kodemore.filter.KmFilter;
import com.kodemore.filter.KmFilterIF;
import com.kodemore.hibernate.KmhProjectionResult;
import com.kodemore.hibernate.KmhProjectionRow;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBarChart;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGrid;
import com.kodemore.servlet.control.ScGridGroup;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScPieChart;
import com.kodemore.servlet.control.ScSubmitButton;
import com.kodemore.servlet.control.ScTransientContainer;
import com.kodemore.servlet.field.ScEnumDropdownField;
import com.kodemore.utility.KmEnumIF;
import com.kodemore.utility.Kmu;

import com.app.criteria.core.MyAbstractCriteria;
import com.app.filter.core.MyCriteriaFilter;
import com.app.model.MyNamedDoubleVo;
import com.app.model.core.MyAbstractDomain;
import com.app.model.meta.MyMetaNamedDoubleVo;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;
import com.app.utility.MyGlobals;

/**
 * I provide the abstract functionality for a report that can select (filter)
 * results and display a summary as either a grid, or as a simple chart.
 *
 * The chart can be displayed as either a pie or bar chart, but both charts
 * really just display the same information in a different visual style.
 *
 * Charts are defined by two selectable attributes...
 * Value: determines the area of the pie chart, or the height of the bar chart.
 * Group: determines how the source data is organized into groups.
 *
 * Note: in most cases, the pie chart and bar chart can simply share the
 * same configuration. For these cases, it is recommended that you subclass
 * from MySimpleChartReportPage.
 * @see MySimpleChartReportPage
 */
public abstract class MyChartReportPage<T extends MyAbstractDomain, C extends MyAbstractCriteria<T>>
    extends MyPage
{
    //##################################################
    //# constants
    //##################################################

    private static final String REPORT_TYPE_LABEL = "Display a";
    private static final String GROUP_LABEL       = "Grouped by";
    private static final String VALUE_LABEL       = "Showing the";

    //##################################################
    //# enum
    //##################################################

    private static enum ReportType
                    implements KmEnumIF
    {
        Grid,
        PieChart,
        PieChartValues,
        BarChart,
        BarChartValues,
    }

    //##################################################
    //# variables
    //##################################################

    //==================================================
    //= report style
    //==================================================

    private ScEnumDropdownField          _reportTypeField;

    private ScFieldTable                 _gridFields;

    private ScFieldTable                 _pieChartFields;
    private ScEnumDropdownField          _pieChartValueField;
    private ScEnumDropdownField          _pieChartGroupField;

    private ScFieldTable                 _barChartFields;
    private ScEnumDropdownField          _barChartValueField;
    private ScEnumDropdownField          _barChartGroupField;

    //==================================================
    //= filter
    //==================================================

    private ScGroup                      _filterGroup;

    //==================================================
    //= results
    //==================================================

    private ScCardFrame                  _resultFrame;
    private ScGridGroup<T>               _gridCard;
    private ScTransientContainer         _chartCard;

    private ScGridGroup<MyNamedDoubleVo> _pieChartGridCard;
    private ScGrid<MyNamedDoubleVo>      _pieChartGrid;

    private ScGridGroup<MyNamedDoubleVo> _barChartGridCard;
    private ScGrid<MyNamedDoubleVo>      _barChartGrid;

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.user;
    }

    //##################################################
    //# bookmark
    //##################################################

    @Override
    public final void composeBookmarkOn(ScParameterList v)
    {
        // none
    }

    @Override
    public final void applyBookmark(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        ScForm form;
        form = root.addForm();
        form.css().fill().flexColumn();
        form.setSubmitAction(this::handleRun);

        installSetupOn(form);
        installGap(form);
        installRunOn(form);
        installGap(form);
        installResultsOn(form);
    }

    private void installSetupOn(ScContainer root)
    {
        ScDiv row;
        row = root.addFlexRow();
        row.css().rowSpacer20();

        installReportTypeOn(row);
        installFilterOn(row);
    }

    private void installReportTypeOn(ScContainer root)
    {
        ScGroup group;
        group = root.addGroup("Report");

        ScDiv body;
        body = group.getBody();
        body.css().pad10().flexColumn().auto();

        ScFieldTable fields;
        fields = body.addFieldTable();
        fields.disableFullWidth();
        fields.add(createReportTypeField());
        fields.addSpace();

        installGridFieldsOn(body);
        installPieChartFieldsOn(body);
        installBarChartFieldsOn(body);
    }

    private void installFilterOn(ScContainer root)
    {
        ScGroup group;
        group = root.addGroup("Filter");
        group.css().flexChildFiller();
        _filterGroup = group;

        ScDiv body;
        body = group.getBody();
        body.css().pad10().auto();
        installFilterFieldsOn(body);
    }

    protected abstract void installFilterFieldsOn(ScDiv root);

    private void installRunOn(ScContainer root)
    {
        ScSubmitButton button;
        button = root.addSubmitButton("Run Report >>");
        button.clearImages();
        button.css().flexChildCrossOverrideStart();
    }

    private void installGridFieldsOn(ScContainer root)
    {
        ScFieldTable fields;
        fields = root.addFieldTable();
        fields.hide();
        _gridFields = fields;
    }

    private void installPieChartFieldsOn(ScContainer root)
    {
        ScFieldTable fields;
        fields = root.addFieldTable();
        fields.add(createPieChartValueField());
        fields.add(createPieChartGroupByField());
        fields.hide();
        _pieChartFields = fields;
    }

    private void installBarChartFieldsOn(ScContainer root)
    {
        ScFieldTable fields;
        fields = root.addFieldTable();
        fields.add(createBarChartValueField());
        fields.add(createBarChartGroupByField());
        fields.hide();
        _barChartFields = fields;
    }

    /**
     * Add manual gaps because forms NEED some extra hidden fields
     * that interfere with the normal mechanism of css.columnSpacer20.
     */
    private void installGap(ScForm form)
    {
        form.addFlexGap(20);
    }

    //==================================================
    //= install :: results
    //==================================================

    private void installResultsOn(ScContainer root)
    {
        ScCardFrame e;
        e = root.addCardFrame();
        e.css().flexChildFiller().relative();
        e.setTransitionNone();
        e.addCard(createGridCard());
        e.addCard(createChartCard());
        e.addCard(createPieChartGridCard());
        e.addCard(createBarChartGridCard());
        _resultFrame = e;
    }

    private ScControl createGridCard()
    {
        ScGridGroup<T> e;
        e = new ScGridGroup<>();
        e.setTitle("Results");
        e.setGrid(createGrid());
        e.css().fill();
        _gridCard = e;
        return e;
    }

    private ScGrid<T> createGrid()
    {
        ScGrid<T> e;
        e = new ScGrid<>();
        e.track(MyGlobals.getGlobalSession().getCurrentProjectUidWrapper());
        e.trackAll(_filterGroup);
        e.setFilterFactory(this::getGridFilter);
        e.layoutFill();
        installGridColumnsOn(e);
        return e;
    }

    private KmFilter<T> getGridFilter()
    {
        C c = createCriteria();
        applyFilterTo(c);
        return new MyCriteriaFilter<>(c);
    }

    protected abstract void installGridColumnsOn(ScGrid<T> e);

    private ScControl createChartCard()
    {
        ScTransientContainer e;
        e = new ScTransientContainer();
        _chartCard = e;
        return e;
    }

    //==================================================
    //= install :: pie chart grid
    //==================================================

    private ScControl createPieChartGridCard()
    {
        ScGridGroup<MyNamedDoubleVo> e;
        e = new ScGridGroup<>();
        e.setTitle("Results");
        e.setGrid(createPieChartGrid());
        e.css().fill();
        _pieChartGridCard = e;
        return e;
    }

    private ScGrid<MyNamedDoubleVo> createPieChartGrid()
    {
        MyMetaNamedDoubleVo x = MyNamedDoubleVo.Meta;

        ScGrid<MyNamedDoubleVo> e;
        e = new ScGrid<>();
        e.track(MyGlobals.getGlobalSession().getCurrentProjectUidWrapper());
        e.trackAll(_pieChartFields);
        e.trackAll(_filterGroup);
        e.layoutFill();
        e.addColumn(x.Name).setWidth(200);
        e.addColumn(x.Value).setWidth(200);
        _pieChartGrid = e;
        return e;
    }

    //==================================================
    //= install :: bar chart grid
    //==================================================

    private ScControl createBarChartGridCard()
    {
        ScGridGroup<MyNamedDoubleVo> e;
        e = new ScGridGroup<>();
        e.setTitle("Results");
        e.setGrid(createBarChartGrid());
        e.css().fill();
        _barChartGridCard = e;
        return e;
    }

    private ScGrid<MyNamedDoubleVo> createBarChartGrid()
    {
        MyMetaNamedDoubleVo x = MyNamedDoubleVo.Meta;

        ScGrid<MyNamedDoubleVo> e;
        e = new ScGrid<>();
        e.track(MyGlobals.getGlobalSession().getCurrentProjectUidWrapper());
        e.trackAll(_barChartFields);
        e.trackAll(_filterGroup);
        e.layoutFill();
        e.addColumn(x.Name).setWidth(200);
        e.addColumn(x.Value).setWidth(200);
        _barChartGrid = e;
        return e;
    }

    //==================================================
    //= install :: report type
    //==================================================

    private ScControl createReportTypeField()
    {

        ScEnumDropdownField e;
        e = new ScEnumDropdownField();
        e.setLabel(REPORT_TYPE_LABEL);
        e.onChange(newUncheckedAction(this::handleReportTypeChanged));
        e.disableChangeTracking();
        e.setNullSelectPrefix();

        ReportType[] options = getReportOptions();
        e.setOptions(options);
        if ( options.length > 0 )
            e.setValue(options[0]);

        _reportTypeField = e;
        return e;
    }

    private ReportType[] getReportOptions()
    {
        KmList<ReportType> v = new KmList<>();

        for ( ReportType e : ReportType.values() )
            if ( hasReportType(e) )
                v.add(e);

        ReportType[] arr = new ReportType[0];
        return v.toArray(arr);
    }

    private boolean hasReportType(ReportType e)
    {
        switch ( e )
        {
            case Grid:
                return true;

            case PieChart:
            case PieChartValues:
                return hasPieChart();

            case BarChart:
            case BarChartValues:
                return hasBarChart();
        }
        return false;
    }

    //==================================================
    //= install :: pie chart options
    //==================================================

    private ScControl createPieChartValueField()
    {
        ScEnumDropdownField e;
        e = new ScEnumDropdownField();
        e.setLabel(VALUE_LABEL);
        e.disableChangeTracking();
        e.setNullSelectPrefix();
        applyOptionsTo(e, getPieChartValueOptions());
        _pieChartValueField = e;
        return e;
    }

    private ScControl createPieChartGroupByField()
    {
        ScEnumDropdownField e;
        e = new ScEnumDropdownField();
        e.setLabel(GROUP_LABEL);
        e.disableChangeTracking();
        e.setNullSelectPrefix();
        applyOptionsTo(e, getPieChartGroupOptions());
        _pieChartGroupField = e;
        return e;
    }

    private boolean hasPieChart()
    {
        boolean hasValueOptions = hasValue(getPieChartValueOptions());
        boolean hasGroupOptions = hasValue(getPieChartGroupOptions());

        return hasValueOptions && hasGroupOptions;
    }

    //==================================================
    //= install :: bar chart options
    //==================================================

    private ScControl createBarChartValueField()
    {
        ScEnumDropdownField e;
        e = new ScEnumDropdownField();
        e.setLabel(VALUE_LABEL);
        e.disableChangeTracking();
        e.setNullSelectPrefix();
        applyOptionsTo(e, getBarChartValueOptions());
        _barChartValueField = e;
        return e;
    }

    private ScControl createBarChartGroupByField()
    {
        ScEnumDropdownField e;
        e = new ScEnumDropdownField();
        e.setLabel(GROUP_LABEL);
        e.disableChangeTracking();
        applyOptionsTo(e, getBarChartGroupOptions());
        _barChartGroupField = e;
        return e;
    }

    private boolean hasBarChart()
    {
        return hasValue(getBarChartValueOptions()) && hasValue(getBarChartGroupOptions());
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }

    //##################################################
    //# criteria
    //##################################################

    protected abstract C createCriteria();

    protected abstract void applyFilterTo(C c);

    //##################################################
    //# handle
    //##################################################

    private void handleRun()
    {
        ReportType type = getSelectedReportType();
        if ( type == null )
            return;

        switch ( type )
        {
            case Grid:
                runGrid();
                return;

            case PieChart:
                runPieChart();
                return;

            case PieChartValues:
                runPieChartGrid();
                return;

            case BarChart:
                runBarChart();
                return;

            case BarChartValues:
                runBarChartGrid();
                return;
        }
    }

    private void handleReportTypeChanged()
    {
        _gridFields.ajaxHide();
        _pieChartFields.ajaxHide();
        _barChartFields.ajaxHide();

        ReportType style = getSelectedReportType();
        if ( style == null )
            return;

        switch ( style )
        {
            case Grid:
                _gridFields.ajaxShow();
                return;

            case PieChart:
            case PieChartValues:
                _pieChartFields.ajaxShow();
                return;

            case BarChart:
            case BarChartValues:
                _barChartFields.ajaxShow();
                return;
        }
    }

    //##################################################
    //# run
    //##################################################

    private void runGrid()
    {
        _resultFrame.ajaxPrint(_gridCard);
    }

    private void runPieChart()
    {
        ajax().hideAllErrors();

        _chartCard.add(createPieChart());
        _resultFrame.ajaxPrint(_chartCard);
    }

    private void runPieChartGrid()
    {
        ajax().hideAllErrors();
        _pieChartGrid.setFilterFactory(this::createPieChartGridFilter);
        _resultFrame.ajaxPrint(_pieChartGridCard);
    }

    private void runBarChartGrid()
    {
        ajax().hideAllErrors();
        _barChartGrid.setFilterFactory(this::createBarChartGridFilter);
        _resultFrame.ajaxPrint(_barChartGridCard);
    }

    private KmFilterIF<MyNamedDoubleVo> createPieChartGridFilter()
    {
        return getNormalizedPieChartResults().toFilter();
    }

    private KmFilterIF<MyNamedDoubleVo> createBarChartGridFilter()
    {
        return getNormalizedBarChartResults().toFilter();
    }

    private void runBarChart()
    {
        ajax().hideAllErrors();

        _chartCard.add(createBarChart());
        _resultFrame.ajaxPrint(_chartCard);
    }

    //##################################################
    //# pie chart
    //##################################################

    private ScControl createPieChart()
    {
        MyChartReportValue<T,C> value = getPieChartValue();

        ScPieChart chart;
        chart = new ScPieChart();
        chart.setLabelTypeKey();
        chart.setValueDecimals(value.getDecimals());
        chart.css().fill();

        KmList<MyNamedDoubleVo> v = getNormalizedPieChartResults();

        for ( MyNamedDoubleVo vo : v )
            chart.addSlice(vo.getName(), vo.getValue());

        return chart;
    }

    private KmList<MyNamedDoubleVo> getNormalizedPieChartResults()
    {
        KmList<MyNamedDoubleVo> v;
        v = findPieChartResults();
        v = normalizePieChartResults(v);
        return v;
    }

    private KmList<MyNamedDoubleVo> findPieChartResults()
    {
        C c = createCriteria();

        applyFilterTo(c);
        applyPieChartGroupTo(c);
        applyPieChartValueTo(c);

        getRoot().checkErrors();

        return findResultsFor(c, getPieChartGroup(), getPieChartValue());
    }

    private KmList<MyNamedDoubleVo> findResultsFor(
        C c,
        MyChartReportGroup<T,C> group,
        MyChartReportValue<T,C> field)
    {
        KmList<MyNamedDoubleVo> v = new KmList<>();

        KmhProjectionResult results = c.findResults();
        for ( KmhProjectionRow row : results )
        {
            String name = group.readFrom(row);
            Double value = field.readFrom(row);

            MyNamedDoubleVo vo = new MyNamedDoubleVo(name, value);
            v.add(vo);
        }
        return v;
    }

    private void applyPieChartGroupTo(C c)
    {
        MyChartReportGroup<T,C> group = getPieChartGroup();
        if ( group == null )
            _pieChartGroupField.addError("required");
        else
            group.applyTo(c);
    }

    private void applyPieChartValueTo(C c)
    {
        MyChartReportValue<T,C> value = getPieChartValue();
        if ( value == null )
            _pieChartValueField.addError("required");
        else
            value.applyTo(c);
    }

    protected KmList<MyNamedDoubleVo> normalizePieChartResults(KmList<MyNamedDoubleVo> v)
    {
        return normalizeNamedDoubles(v);
    }

    //==================================================
    //= pie chart :: accessing
    //==================================================

    private String getPieChartValueCode()
    {
        return _pieChartValueField.getValue();
    }

    private String getPieChartGroupCode()
    {
        return _pieChartGroupField.getValue();
    }

    //==================================================
    //= pie chart :: overrides
    //==================================================

    protected abstract MyChartReportValue<T,C>[] getPieChartValueOptions();

    protected abstract MyChartReportGroup<T,C>[] getPieChartGroupOptions();

    //==================================================
    //= pie chart :: selection
    //==================================================

    protected final MyChartReportValue<T,C> getPieChartValue()
    {
        return getPieChartValueFor(getPieChartValueCode());
    }

    protected final MyChartReportGroup<T,C> getPieChartGroup()
    {
        return getPieChartGroupFor(getPieChartGroupCode());
    }

    protected final MyChartReportValue<T,C> getPieChartValueFor(String code)
    {
        MyChartReportValue<T,C>[] arr = getPieChartValueOptions();
        for ( MyChartReportValue<T,C> e : arr )
            if ( e.hasCode(code) )
                return e;

        return null;
    }

    protected final MyChartReportGroup<T,C> getPieChartGroupFor(String code)
    {
        MyChartReportGroup<T,C>[] arr = getPieChartGroupOptions();
        for ( MyChartReportGroup<T,C> e : arr )
            if ( e.hasCode(code) )
                return e;

        return null;
    }

    //##################################################
    //# bar chart
    //##################################################

    private ScControl createBarChart()
    {
        ScBarChart chart;
        chart = new ScBarChart();
        chart.staggerLabels();
        chart.css().fill();

        KmList<MyNamedDoubleVo> v = getNormalizedBarChartResults();

        for ( MyNamedDoubleVo vo : v )
            chart.addBar(vo.getName(), vo.getValue());

        return chart;
    }

    private KmList<MyNamedDoubleVo> getNormalizedBarChartResults()
    {
        KmList<MyNamedDoubleVo> v;
        v = findBarChartResults();
        v = normalizeBarChartResults(v);
        return v;
    }

    private KmList<MyNamedDoubleVo> findBarChartResults()
    {
        C c = createCriteria();

        applyFilterTo(c);
        applyBarChartGroupTo(c);
        applyBarChartValueTo(c);

        getRoot().checkErrors();

        return findResultsFor(c, getBarChartGroup(), getBarChartField());
    }

    private void applyBarChartGroupTo(C c)
    {
        MyChartReportGroup<T,C> group = getBarChartGroup();
        if ( group == null )
            _barChartGroupField.addError("required");
        else
            group.applyTo(c);
    }

    private void applyBarChartValueTo(C c)
    {
        MyChartReportValue<T,C> value = getBarChartField();
        if ( value == null )
            _barChartValueField.addError("required");
        else
            value.applyTo(c);
    }

    //==================================================
    //= bar chart :: accessing
    //==================================================

    protected String getBarChartValueCode()
    {
        return _barChartValueField.getValue();
    }

    protected String getBarChartGroupCode()
    {
        return _barChartGroupField.getValue();
    }

    //==================================================
    //= bar chart :: overrides
    //==================================================

    /**
     * Get the value options for the bar chart.
     */
    protected abstract MyChartReportValue<T,C>[] getBarChartValueOptions();

    /**
     * Get the group options for the bar chart.
     */
    protected abstract MyChartReportGroup<T,C>[] getBarChartGroupOptions();

    protected KmList<MyNamedDoubleVo> normalizeBarChartResults(KmList<MyNamedDoubleVo> v)
    {
        return normalizeNamedDoubles(v);
    }

    //==================================================
    //= bar chart :: selection
    //==================================================

    protected final MyChartReportValue<T,C> getBarChartField()
    {
        return getBarChartValueFor(getBarChartValueCode());
    }

    protected final MyChartReportGroup<T,C> getBarChartGroup()
    {
        return getBarChartGroupFor(getBarChartGroupCode());
    }

    protected final MyChartReportValue<T,C> getBarChartValueFor(String code)
    {
        MyChartReportValue<T,C>[] arr = getBarChartValueOptions();
        for ( MyChartReportValue<T,C> e : arr )
            if ( e.hasCode(code) )
                return e;

        return null;
    }

    protected final MyChartReportGroup<T,C> getBarChartGroupFor(String code)
    {
        MyChartReportGroup<T,C>[] arr = getBarChartGroupOptions();
        for ( MyChartReportGroup<T,C> e : arr )
            if ( e.hasCode(code) )
                return e;

        return null;
    }

    //##################################################
    //# normalize
    //##################################################

    protected KmList<MyNamedDoubleVo> normalizeNamedDoubles(KmList<MyNamedDoubleVo> in)
    {
        in.forEach(e -> normalizeNamedDouble(e));
        KmList<MyNamedDoubleVo> out = consolidateNames(in);
        sortOnValues(out);
        return out;
    }

    private KmList<MyNamedDoubleVo> consolidateNames(KmList<MyNamedDoubleVo> v)
    {
        KmOrderedMap<String,MyNamedDoubleVo> map;
        map = new KmOrderedMap<>();

        for ( MyNamedDoubleVo e : v )
        {
            String name = e.getName();
            MyNamedDoubleVo existing = map.get(name);

            if ( existing == null )
                map.put(name, e);
            else
                existing.addValue(e);
        }

        KmList<MyNamedDoubleVo> results = map.getValues();
        return results;
    }

    private void normalizeNamedDouble(MyNamedDoubleVo e)
    {
        e.setName(normalizeName(e.getName()));
        e.setValue(normalizeValue(e.getValue()));
    }

    private String normalizeName(String e)
    {
        return Kmu.hasValue(e)
            ? e.trim()
            : "[None]";
    }

    private Double normalizeValue(Double e)
    {
        return e == null
            ? null
            : Kmu.round(e, 2);
    }

    private void sortOnValues(KmList<MyNamedDoubleVo> v)
    {
        v.sortOn(e -> e.getValue(), e -> e.getName());
        v.reverse();
    }

    //##################################################
    //# support
    //##################################################

    private ReportType getSelectedReportType()
    {
        String code = _reportTypeField.getValue();
        return code == null
            ? null
            : ReportType.valueOf(code);
    }

    private void applyOptionsTo(ScEnumDropdownField e, KmEnumIF[] options)
    {
        if ( !hasValue(options) )
        {
            e.hide();
            return;
        }

        e.setOptions(options);
        e.setValue(options[0]);
    }

    private boolean hasValue(KmEnumIF[] arr)
    {
        return arr != null && arr.length > 0;
    }

    protected <E extends KmEnumIF> E find(E[] arr, String code)
    {
        return KmEnumIF.getValueFor(arr, code);
    }

}
