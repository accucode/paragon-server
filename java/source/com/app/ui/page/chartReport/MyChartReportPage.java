package com.app.ui.page.chartReport;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmOrderedMap;
import com.kodemore.filter.KmFilter;
import com.kodemore.filter.KmFilterIF;
import com.kodemore.hibernate.KmhProjectionResult;
import com.kodemore.hibernate.KmhProjectionRow;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGrid;
import com.kodemore.servlet.control.ScGridGroup;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScSubmitButton;
import com.kodemore.servlet.control.ScTransientContainer;
import com.kodemore.servlet.control.ScVerticalBarChart;
import com.kodemore.servlet.control.chart.ScDateGanttChart;
import com.kodemore.servlet.control.chart.ScDateGanttChartMode;
import com.kodemore.servlet.control.nvd3.ScBarChartSet;
import com.kodemore.servlet.control.nvd3.ScPieChart;
import com.kodemore.servlet.field.ScDateRangeField;
import com.kodemore.servlet.field.ScDateRangeField.Mode;
import com.kodemore.servlet.field.ScStaticDropdownField;
import com.kodemore.servlet.field.ScStaticEnumDropdownField;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmDateRange;
import com.kodemore.utility.KmEnumIF;
import com.kodemore.utility.Kmu;

import com.app.criteria.core.MyAbstractCriteria;
import com.app.model.MyNamedDoubleVo;
import com.app.model.core.MyAbstractDomain;
import com.app.model.meta.MyMetaNamedDoubleVo;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.chartReport.group.MyChartReportSection;
import com.app.ui.page.chartReport.value.MyChartReportRowCountValue;
import com.app.ui.page.chartReport.value.MyChartReportValue;
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
public abstract class MyChartReportPage<T extends MyAbstractDomain<?>, C extends MyAbstractCriteria<T>>
    extends MyPage
{
    //##################################################
    //# constants
    //##################################################

    private static final String REPORT_TYPE_LABEL = "Display a";

    private static final String GRID_SORT_LABEL           = "Sort on";
    private static final String GRID_SORT_ASCENDING_LABEL = "Sort";

    private static final String CHART_VALUE_LABEL = "Showing the";
    private static final String CHART_GROUP_LABEL = "Grouped by";
    private static final String CHART_SORT_LABEL  = "Sort on";
    private static final String CHART_LIMIT_LABEL = "Limit to";

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
        GanttChart,
    }

    private static enum GridSortDirection
        implements KmEnumIF
    {
        Ascending,
        Descending
    }

    private static enum ChartSortOption
        implements KmEnumIF
    {
        Value,
        Name
    }

    //##################################################
    //# variables
    //##################################################

    private ScForm _form;

    //==================================================
    //= report style
    //==================================================

    private ScStaticEnumDropdownField _reportTypeField;

    private ScFieldTable              _gridFields;
    private ScStaticEnumDropdownField _gridSortField;
    private ScStaticEnumDropdownField _gridSortAscendingField;

    private ScFieldTable              _ganttChartFields;
    private ScDateRangeField          _ganttChartRangeField;
    private ScStaticEnumDropdownField _ganttChartZoomField;

    private ScFieldTable                   _pieChartFields;
    private ScStaticDropdownField<String>  _pieChartValueField;
    private ScStaticDropdownField<String>  _pieChartGroupField;
    private ScStaticEnumDropdownField      _pieChartSortField;
    private ScStaticDropdownField<Integer> _pieChartLimitField;

    private ScFieldTable                   _barChartFields;
    private ScStaticDropdownField<String>  _barChartValueField;
    private ScStaticDropdownField<String>  _barChartGroupField;
    private ScStaticEnumDropdownField      _barChartSortField;
    private ScStaticDropdownField<Integer> _barChartLimitField;

    //==================================================
    //= filter
    //==================================================

    private ScGroup _filterGroup;

    //==================================================
    //= results
    //==================================================

    private ScCardFrame          _resultFrame;
    private ScContainer          _gridCard;
    private ScTransientContainer _chartCard;

    private ScGridGroup<MyNamedDoubleVo> _pieChartGridCard;
    private ScGrid<MyNamedDoubleVo>      _pieChartGrid;

    private ScGridGroup<MyNamedDoubleVo> _barChartGridCard;
    private ScGrid<MyNamedDoubleVo>      _barChartGrid;

    //##################################################
    //# settings
    //##################################################

    @Override
    public abstract MySecurityLevel getSecurityLevel();

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        ScForm form;
        form = root.addForm();
        form.css().fill();
        form.onSubmit(newUncheckedAction(this::handleRun));
        _form = form;

        ScDiv inner;
        inner = form.addDiv();
        inner.css().fill().flexColumn().columnSpacer20();

        installSetupOn(inner);
        installRunOn(inner);
        installResultsOn(inner);
    }

    private void installSetupOn(ScContainer root)
    {
        ScDiv row;
        row = root.addDiv();
        row.css().flexRow().rowSpacer20().auto();

        installReportTypeOn(row);
        installFilterOn(row);
    }

    private void installReportTypeOn(ScContainer root)
    {
        ScGroup group;
        group = root.addGroup("Report");
        group.css().flexChildStatic();

        ScDiv body;
        body = group.getBody();
        body.css().pad20().flexColumn().auto();

        ScFieldTable fields;
        fields = body.addFieldTable();
        fields.add(createReportTypeField());
        fields.addSpace();

        installGridFieldsOn(body);
        installGanttChartFieldsOn(body);
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
        body.css().flexRow().gap20().auto();

        installFilterFieldsOn(body);
    }

    protected abstract void installFilterFieldsOn(ScDiv root);

    protected ScFieldset createFilterBox(String label)
    {
        ScFieldset e;
        e = new ScFieldset();
        e.setLabel(label);
        e.css().flexChildFiller0();
        return e;
    }

    private void installRunOn(ScContainer root)
    {
        ScSubmitButton button;
        button = root.addSubmitButton("Run Report >>");
        button.clearIcons();
        button.css().flexChildCrossOverrideStart();
    }

    private void installGridFieldsOn(ScContainer root)
    {
        ScFieldTable fields;
        fields = root.addFieldTable();
        fields.add(createGridSortField());
        fields.add(createGridSortAscendingField());
        fields.hide();
        _gridFields = fields;
    }

    private void installGanttChartFieldsOn(ScContainer root)
    {
        ScFieldTable fields;
        fields = root.addFieldTable();
        fields.addSpace();
        fields.add(createGanttChartRangeField());
        fields.add(createGanttChartModeField());
        fields.hide();
        _ganttChartFields = fields;
    }

    private void installPieChartFieldsOn(ScContainer root)
    {
        ScFieldTable fields;
        fields = root.addFieldTable();
        fields.add(createPieChartValueField());
        fields.add(createPieChartGroupByField());
        fields.add(createPieChartSortOnField());
        fields.add(createPieChartLimitField());
        fields.hide();
        _pieChartFields = fields;
    }

    private void installBarChartFieldsOn(ScContainer root)
    {
        ScFieldTable fields;
        fields = root.addFieldTable();
        fields.add(createBarChartValueField());
        fields.add(createBarChartGroupByField());
        fields.add(createBarChartSortOnField());
        fields.add(createBarChartLimitField());
        fields.hide();
        _barChartFields = fields;
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
        ScDiv e;
        e = new ScDiv();
        e.css().fill().flexColumn().columnSpacer20();
        e.add(createGridGroup());
        e.addSafe(createGridFooter());
        _gridCard = e;
        return e;
    }

    private ScGridGroup<T> createGridGroup()
    {
        ScGridGroup<T> e;
        e = new ScGridGroup<>();
        e.setTitle("Results");
        e.setGrid(createGrid());
        e.css().flexChildFiller();
        return e;
    }

    private ScGrid<T> createGrid()
    {
        ScGrid<T> e;
        e = new ScGrid<>();
        e.track(MyGlobals.getGlobalSession().getCurrentProjectUidWrapper());
        e.trackAll(_filterGroup);
        e.trackAll(_gridFields);
        e.setFilterFactory(this::getGridFilter);
        e.layoutFill();
        installGridColumnsOn(e);
        return e;
    }

    protected KmFilter<T> getGridFilter()
    {
        C c = createCriteria();
        applyGridSortTo(c);
        return c.toFilter();
    }

    protected abstract void installGridColumnsOn(ScGrid<T> e);

    private ScControl createChartCard()
    {
        ScTransientContainer e;
        e = new ScTransientContainer();
        _chartCard = e;
        return e;
    }

    protected ScGroup createGridFooter()
    {
        return null;
    }

    protected void preRenderGridFooter()
    {
        // subclass
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
        e.track(_reportTypeField);
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
        e.track(_reportTypeField);
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

        ScStaticEnumDropdownField e;
        e = new ScStaticEnumDropdownField();
        e.setLabel(REPORT_TYPE_LABEL);
        e.onChange(newUncheckedAction(this::handleReportTypeChanged));
        e.disableChangeTracking();
        e.setNullSelectPrefix();

        ReportType[] options = getReportOptions();
        e.setOptions(options);
        e.selectFirstOption();

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
                return includesPieChart();

            case BarChart:
            case BarChartValues:
                return includesBarChart();

            case GanttChart:
                return hasGanttChart();
        }
        return false;
    }

    //==================================================
    //= install :: grid options
    //==================================================

    private ScControl createGridSortField()
    {
        ScStaticEnumDropdownField e;
        e = new ScStaticEnumDropdownField();
        e.setLabel(GRID_SORT_LABEL);
        e.setOptions(getGridSortOptions());
        e.setValue(getDefaultGridSort());
        e.disableChangeTracking();
        _gridSortField = e;
        return e;
    }

    private ScControl createGridSortAscendingField()
    {
        ScStaticEnumDropdownField e;
        e = new ScStaticEnumDropdownField();
        e.setLabel(GRID_SORT_ASCENDING_LABEL);
        e.setOptions(GridSortDirection.values());
        e.selectFirstOption();
        e.disableChangeTracking();
        _gridSortAscendingField = e;
        return e;
    }

    //==================================================
    //= install :: gantt chart options
    //==================================================

    private ScControl createGanttChartRangeField()
    {
        ScDateRangeField e;
        e = new ScDateRangeField();
        e.setLabel("Chart Range");
        e.disableChangeTracking();
        setDefaultValueFor(e);
        _ganttChartRangeField = e;
        return e;
    }

    private void setDefaultValueFor(ScDateRangeField e)
    {
        KmDate today = KmClock.getLocalDate();
        KmDate start = today.getStartOfMonth();
        KmDate end = start.getEndOfMonth();
        KmDateRange di;
        di = KmDateRange.create(start, end);

        e.setMode(Mode.ThisMonth);
        e.setValue(di);
    }

    private ScControl createGanttChartModeField()
    {
        ScStaticEnumDropdownField e;
        e = new ScStaticEnumDropdownField();
        e.setLabel("Chart Zoom");
        e.disableChangeTracking();
        e.setOptions(ScDateGanttChartMode.values());
        e.setValue(ScDateGanttChartMode.Week);
        _ganttChartZoomField = e;
        return e;
    }

    //==================================================
    //= install :: pie chart options
    //==================================================

    private ScControl createPieChartValueField()
    {
        ScStaticDropdownField<String> e;
        e = new ScStaticDropdownField<>();
        e.setLabel(CHART_VALUE_LABEL);
        e.disableChangeTracking();
        e.setNullSelectPrefix();
        applyOptionsTo(e, getPieChartValues());
        _pieChartValueField = e;
        return e;
    }

    private ScControl createPieChartGroupByField()
    {
        ScStaticDropdownField<String> e;
        e = new ScStaticDropdownField<>();
        e.setLabel(CHART_GROUP_LABEL);
        e.disableChangeTracking();
        e.setNullSelectPrefix();
        applyOptionsTo(e, getPieChartGroups());
        _pieChartGroupField = e;
        return e;
    }

    private ScControl createPieChartSortOnField()
    {
        ScStaticEnumDropdownField e;
        e = new ScStaticEnumDropdownField();
        e.setLabel(CHART_SORT_LABEL);
        e.setNullSelectPrefix();
        e.setOptions(ChartSortOption.values());
        e.selectFirstOption();
        e.disableChangeTracking();
        _pieChartSortField = e;
        return e;
    }

    private ScControl createPieChartLimitField()
    {
        ScStaticDropdownField<Integer> e;
        e = new ScStaticDropdownField<>();
        e.setLabel(CHART_LIMIT_LABEL);
        e.setNullAllPrefix();
        e.setOptions(getChartLimitOptions());
        e.disableChangeTracking();
        _pieChartLimitField = e;
        return e;
    }

    private boolean includesPieChart()
    {
        boolean hasValues = getPieChartValues().isNotEmpty();
        boolean hasGroups = getPieChartGroups().isNotEmpty();

        return hasValues && hasGroups;
    }

    //==================================================
    //= install :: bar chart options
    //==================================================

    private ScControl createBarChartValueField()
    {
        ScStaticDropdownField<String> e;
        e = new ScStaticDropdownField<>();
        e.setLabel(CHART_VALUE_LABEL);
        e.disableChangeTracking();
        e.setNullSelectPrefix();
        applyOptionsTo(e, getBarChartValues());
        _barChartValueField = e;
        return e;
    }

    private ScControl createBarChartGroupByField()
    {
        ScStaticDropdownField<String> e;
        e = new ScStaticDropdownField<>();
        e.setLabel(CHART_GROUP_LABEL);
        e.disableChangeTracking();
        applyOptionsTo(e, getBarChartGroups());
        _barChartGroupField = e;
        return e;
    }

    private ScControl createBarChartSortOnField()
    {
        ScStaticEnumDropdownField e;
        e = new ScStaticEnumDropdownField();
        e.setLabel(CHART_SORT_LABEL);
        e.setNullSelectPrefix();
        e.setOptions(ChartSortOption.values());
        e.selectFirstOption();
        e.disableChangeTracking();
        _barChartSortField = e;
        return e;
    }

    private ScControl createBarChartLimitField()
    {
        ScStaticDropdownField<Integer> e;
        e = new ScStaticDropdownField<>();
        e.setLabel(CHART_LIMIT_LABEL);
        e.setNullAllPrefix();
        e.setOptions(getChartLimitOptions());
        e.disableChangeTracking();
        _barChartLimitField = e;
        return e;
    }

    private boolean includesBarChart()
    {
        return getBarChartValues().isNotEmpty() && getBarChartGroups().isNotEmpty();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        ReportType style = getSelectedReportType();
        if ( style == null )
            return;

        switch ( style )
        {
            case GanttChart:
                _gridFields.show();
                _ganttChartFields.show();
                return;

            case Grid:
                _gridFields.show();
                return;

            case PieChart:
            case PieChartValues:
                _pieChartFields.show();
                return;

            case BarChart:
            case BarChartValues:
                _barChartFields.show();
                return;
        }
    }

    //##################################################
    //# criteria
    //##################################################

    /**
     * Create the criteria object for this page.
     * This is used for both the grid and the charts.
     */
    protected abstract C createEmptyCriteria();

    /**
     * Create the criteria and and apply the criteria.
     * @return
     */
    protected final C createCriteria()
    {
        C c;
        c = createEmptyCriteria();
        applyFilterTo(c);
        return c;
    }

    /**
     * Filter the results.
     * This is used for both the grid and the charts.
     */
    protected abstract void applyFilterTo(C c);

    /**
     * Sort the results.
     * This is ONLY used for the grid.
     * The charts always sort the biggest chart values first.
     */
    protected abstract void applyGridSortTo(C c);

    //##################################################
    //# handle
    //##################################################

    protected void handleRun()
    {
        ajaxHideAllErrors();
        validateAndCheck();
        _form.saveFieldValues();

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

            case GanttChart:
                runGanttChart();
                return;
        }
    }

    private void handleReportTypeChanged()
    {
        _ganttChartFields.ajaxHide();
        _gridFields.ajaxHide();
        _pieChartFields.ajaxHide();
        _barChartFields.ajaxHide();

        ReportType style = getSelectedReportType();
        if ( style == null )
            return;

        switch ( style )
        {
            case GanttChart:
                _ganttChartFields.ajaxShow();
                _gridFields.ajaxShow();
                return;

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
        preRenderGridFooter();
        _resultFrame.ajaxPrint(_gridCard);
    }

    //==================================================
    //= run :: pie chart
    //==================================================

    private void runPieChart()
    {
        validatePieChartFields();

        _chartCard.add(createPieChart());
        _resultFrame.ajaxPrint(_chartCard);
    }

    private void runPieChartGrid()
    {
        validatePieChartFields();

        Double total = getNormalizedPieChartResults().sumDouble(e -> e.getValue());
        String footerText = Kmu.format("Total: %,.2f", total);
        _pieChartGrid.setFilterFactory(this::createPieChartGridFilter);
        _pieChartGridCard.setFooterText(footerText);
        _resultFrame.ajaxPrint(_pieChartGridCard);
    }

    private void validatePieChartFields()
    {
        ajax().hideAllErrors();

        if ( !_pieChartValueField.hasValue() )
            _pieChartValueField.addError("Required");

        if ( !_pieChartGroupField.hasValue() )
            _pieChartGroupField.addError("Required");

        getRoot().checkErrors();
    }

    private KmFilterIF<MyNamedDoubleVo> createPieChartGridFilter()
    {
        return getNormalizedPieChartResults().toFilter();
    }

    //==================================================
    //= run :: bar chart
    //==================================================

    private void runBarChart()
    {
        validateBarChartFields();

        _chartCard.add(createBarChart());
        _resultFrame.ajaxPrint(_chartCard);
    }

    private void runBarChartGrid()
    {
        validateBarChartFields();

        Double total = getNormalizedPieChartResults().sumDouble(e -> e.getValue());
        String footerText = Kmu.format("Total: %s", total);
        _barChartGrid.setFilterFactory(this::createBarChartGridFilter);
        _barChartGridCard.setFooterText(footerText);
        _resultFrame.ajaxPrint(_barChartGridCard);
    }

    private void validateBarChartFields()
    {
        ajax().hideAllErrors();

        if ( !_barChartValueField.hasValue() )
            _barChartValueField.addError("Required");

        if ( !_barChartGroupField.hasValue() )
            _barChartGroupField.addError("Required");

        getRoot().checkErrors();
    }

    private KmFilterIF<MyNamedDoubleVo> createBarChartGridFilter()
    {
        return getNormalizedBarChartResults().toFilter();
    }

    //==================================================
    //= run :: gantt chart
    //==================================================

    private boolean hasGanttChart()
    {
        return createGanttChart() != null;
    }

    private void runGanttChart()
    {
        ScDateGanttChart chart = createGanttChart();
        if ( chart == null )
            return;

        KmList<T> results = getGanttChartResults();
        applyGanttChartResults(chart, results);
        applyGanttChartRangeTo(chart);
        applyGanttChartModeTo(chart);

        _chartCard.add(chart);
        _resultFrame.ajaxPrint(_chartCard);
    }

    private KmList<T> getGanttChartResults()
    {
        return getGridFilter().findAll();
    }

    protected ScDateGanttChart createGanttChart()
    {
        // subclass
        return null;
    }

    @SuppressWarnings("unused")
    protected void applyGanttChartResults(ScDateGanttChart chart, KmList<T> results)
    {
        // subclass
    }

    private void applyGanttChartRangeTo(ScDateGanttChart chart)
    {
        if ( !_ganttChartRangeField.hasValue() )
            return;

        KmDateRange di = _ganttChartRangeField.getValue();
        chart.setRangeMin(di.getStart());
        chart.setRangeMax(di.getEnd());
    }

    private void applyGanttChartModeTo(ScDateGanttChart chart)
    {
        String modeCode = _ganttChartZoomField.getValue();
        ScDateGanttChartMode mode = ScDateGanttChartMode.findCode(modeCode);
        chart.setChartMode(mode);
    }

    //##################################################
    //# grid
    //##################################################

    protected abstract KmEnumIF[] getGridSortOptions();

    protected KmEnumIF getDefaultGridSort()
    {
        return getGridSortOptions()[0];
    }

    protected String getGridSortCode()
    {
        return _gridSortField.getValue();
    }

    protected boolean getSortAscending()
    {
        String code = _gridSortAscendingField.getValue();
        GridSortDirection direction = GridSortDirection.valueOf(code);

        switch ( direction )
        {
            case Ascending:
                return true;

            case Descending:
                return false;
        }
        throw Kmu.newEnumError(direction);
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
        {
            String label = Kmu.format("%s (%s)", vo.getName(), vo.getValue());
            chart.addSlice(label, vo.getValue());
        }

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

        applyPieChartGroupTo(c);
        applyPieChartValueTo(c);

        getRoot().checkErrors();

        return findResultsFor(c, getPieChartGroup(), getPieChartValue());
    }

    private KmList<MyNamedDoubleVo> findResultsFor(
        C c,
        MyChartReportSection<T,C> group,
        MyChartReportValue<T,C> field)
    {
        KmList<MyNamedDoubleVo> v = new KmList<>();

        KmhProjectionResult results = c.findResults();
        for ( KmhProjectionRow row : results )
        {
            String name = group.readFrom(row);
            Double value = field.readValue(row);

            MyNamedDoubleVo vo = new MyNamedDoubleVo(name, value);
            v.add(vo);
        }
        return v;
    }

    private void applyPieChartGroupTo(C c)
    {
        MyChartReportSection<T,C> group = getPieChartGroup();
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
            value.selectValue(c);
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

    protected abstract KmList<MyChartReportValue<T,C>> getPieChartValues();

    protected abstract KmList<MyChartReportSection<T,C>> getPieChartGroups();

    //==================================================
    //= pie chart :: selection
    //==================================================

    protected final MyChartReportValue<T,C> getPieChartValue()
    {
        return getPieChartValueFor(getPieChartValueCode());
    }

    protected final MyChartReportSection<T,C> getPieChartGroup()
    {
        return getPieChartGroupFor(getPieChartGroupCode());
    }

    protected final MyChartReportValue<T,C> getPieChartValueFor(String code)
    {
        KmList<MyChartReportValue<T,C>> v = getPieChartValues();
        for ( MyChartReportValue<T,C> e : v )
            if ( e.hasCode(code) )
                return e;

        return null;
    }

    protected final MyChartReportSection<T,C> getPieChartGroupFor(String code)
    {
        KmList<MyChartReportSection<T,C>> arr = getPieChartGroups();
        for ( MyChartReportSection<T,C> e : arr )
            if ( e.hasCode(code) )
                return e;

        return null;
    }

    //##################################################
    //# bar chart
    //##################################################

    private ScControl createBarChart()
    {
        ScVerticalBarChart chart;
        chart = new ScVerticalBarChart();
        chart.getLabelAxis().setLabelDegrees(60);

        chart.css().fill();

        ScBarChartSet set = chart.addDataSet();
        KmList<MyNamedDoubleVo> v = getNormalizedBarChartResults();

        for ( MyNamedDoubleVo vo : v )
            set.addPoint(vo.getName(), vo.getValue());

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

        applyBarChartGroupTo(c);
        applyBarChartValueTo(c);

        getRoot().checkErrors();

        return findResultsFor(c, getBarChartGroup(), getBarChartField());
    }

    private void applyBarChartGroupTo(C c)
    {
        MyChartReportSection<T,C> group = getBarChartGroup();
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
            value.selectValue(c);
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
    protected abstract KmList<MyChartReportValue<T,C>> getBarChartValues();

    /**
     * Get the group options for the bar chart.
     */
    protected abstract KmList<MyChartReportSection<T,C>> getBarChartGroups();

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

    protected final MyChartReportSection<T,C> getBarChartGroup()
    {
        return getBarChartGroupFor(getBarChartGroupCode());
    }

    protected final MyChartReportValue<T,C> getBarChartValueFor(String code)
    {
        return getBarChartValues().selectFirst(e -> e.hasCode(code));
    }

    protected final MyChartReportSection<T,C> getBarChartGroupFor(String code)
    {
        return getBarChartGroups().selectFirst(e -> e.hasCode(code));
    }

    //##################################################
    //# normalize
    //##################################################

    protected KmList<MyNamedDoubleVo> normalizeNamedDoubles(KmList<MyNamedDoubleVo> in)
    {
        in.forEach(e -> normalizeNamedDouble(e));
        KmList<MyNamedDoubleVo> out;
        out = consolidateNames(in);
        out.retainIf(e -> e.hasValue());
        sortChartValues(out);
        return limitChartOptions(out);
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

    //##################################################
    //# sort charge
    //##################################################

    private void sortChartValues(KmList<MyNamedDoubleVo> out)
    {
        ReportType type = getSelectedReportType();
        switch ( type )
        {
            case PieChart:
            case PieChartValues:
                sortPieChartValues(out);
                return;

            case BarChart:
            case BarChartValues:
                sortBarChartValues(out);
                return;

            case Grid:
            case GanttChart:
                return;
        }
    }

    private void sortPieChartValues(KmList<MyNamedDoubleVo> out)
    {
        String code = _pieChartSortField.getValue();
        sortOnChartOption(out, code);
    }

    private void sortBarChartValues(KmList<MyNamedDoubleVo> out)
    {
        String code = _barChartSortField.getValue();
        sortOnChartOption(out, code);
    }

    private void sortOnChartOption(KmList<MyNamedDoubleVo> out, String optionCode)
    {
        if ( optionCode == null )
            return;

        ChartSortOption option = ChartSortOption.valueOf(optionCode);
        switch ( option )
        {
            case Name:
                sortOnNames(out);
                return;

            case Value:
                sortOnValues(out);
                return;
        }
    }

    private void sortOnValues(KmList<MyNamedDoubleVo> v)
    {
        v.sortOn(e -> e.getValue(), e -> e.getName());
        v.reverse();
    }

    private void sortOnNames(KmList<MyNamedDoubleVo> v)
    {
        v.sortOn(e -> e.getName(), e -> e.getValue());
    }

    //##################################################
    //# chart limit
    //##################################################

    private KmList<MyNamedDoubleVo> limitChartOptions(KmList<MyNamedDoubleVo> out)
    {
        Integer limit = getChartLimit();
        return limit == null
            ? out
            : out.getFirstSafe(limit);
    }

    private Integer getChartLimit()
    {
        ReportType type = getSelectedReportType();
        switch ( type )
        {
            case PieChart:
            case PieChartValues:
                return _pieChartLimitField.getValue();

            case BarChart:
            case BarChartValues:
                return _barChartLimitField.getValue();

            case GanttChart:
            case Grid:
                return null;
        }
        throw Kmu.newEnumError(type);
    }

    //##################################################
    //# convenience
    //##################################################

    protected MyChartReportRowCountValue<T,C> newRowCountValue()
    {
        return new MyChartReportRowCountValue<>();
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

    private void applyOptionsTo(
        ScStaticDropdownField<String> e,
        KmList<? extends MyChartReportOption> options)
    {
        if ( options.isEmpty() )
        {
            e.hide();
            return;
        }

        for ( MyChartReportOption option : options )
            e.addOption(option.getCode(), option.getName());

        e.selectFirstOption();
    }

    private KmList<Integer> getChartLimitOptions()
    {
        return KmList.createWith(5, 10, 20);
    }

    protected <E extends KmEnumIF> E find(E[] arr, String code)
    {
        return KmEnumIF.getValueFor(arr, code);
    }

}
