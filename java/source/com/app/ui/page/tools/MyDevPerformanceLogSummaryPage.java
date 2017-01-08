package com.app.ui.page.tools;

import com.kodemore.filter.KmFilter;
import com.kodemore.filter.KmFilterFactoryIF;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldLayout;
import com.kodemore.servlet.control.ScFilterBox;
import com.kodemore.servlet.control.ScGrid;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScDateField;
import com.kodemore.servlet.field.ScEnumDropdownField;
import com.kodemore.servlet.field.ScTextField;

import com.app.filter.MyPerformanceLogSummaryFilter;
import com.app.model.MyPerformanceLogSummary;
import com.app.model.meta.MyMetaPerformanceLogSummary;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyDevPerformanceLogSummaryPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyDevPerformanceLogSummaryPage _instance;

    public static void installInstance()
    {
        _instance = new MyDevPerformanceLogSummaryPage();
    }

    public static MyDevPerformanceLogSummaryPage getInstance()
    {
        return _instance;
    }

    private MyDevPerformanceLogSummaryPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScFilterBox                     _filterBox;
    private ScTextField                     _nameField;
    private ScDateField                     _startDateField;
    private ScDateField                     _endDateField;
    private ScEnumDropdownField             _sortField;

    private ScGrid<MyPerformanceLogSummary> _grid;

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
        root.css().fill().flexColumn().columnSpacer10();

        installFilterOn(root);
        installGridOn(root);
    }

    private void installFilterOn(ScDiv root)
    {
        _nameField = new ScTextField();
        _nameField.setLabel("Name");
        _nameField.disableChangeTracking();

        _startDateField = new ScDateField();
        _startDateField.disableChangeTracking();

        _endDateField = new ScDateField();
        _endDateField.disableChangeTracking();

        _sortField = new ScEnumDropdownField();
        _sortField.setLabel("Sort");
        _sortField.addOptions(MyPerformanceLogSummaryFilter.Sort.values());
        _sortField.setValue(MyPerformanceLogSummaryFilter.Sort.Total);
        _sortField.disableChangeTracking();

        _filterBox = root.addFilterBox("Search");
        _filterBox.setAction(this::handleSearch);
        _filterBox.getFormWrapper().css().flexChildStatic();

        ScFieldLayout fields;
        fields = _filterBox.addFieldLayout();
        fields.add(_nameField);

        ScDiv dateBox;
        dateBox = fields.addFlexRow();
        dateBox.css().flexCrossAlignCenter();
        dateBox.setLabel("Date");
        dateBox.add(_startDateField);
        dateBox.addSpace();
        dateBox.addText("to");
        dateBox.addSpace();
        dateBox.add(_endDateField);

        fields.add(_sortField);
    }

    private void installGridOn(ScDiv root)
    {
        MyMetaPerformanceLogSummary x = MyPerformanceLogSummary.Meta;

        _grid = new ScGrid<>();
        _grid.trackAll(_filterBox);
        _grid.setFilterFactory(newFetcher());

        _grid.addColumn(x.UtcDate);
        _grid.addColumn(x.Name).setWidth(200);
        _grid.addColumn(x.Count).alignRight();
        _grid.addColumn(x.MinimumMs, "Min (ms)").alignRight();
        _grid.addColumn(x.MaximumMs, "Max (ms)").alignRight();
        _grid.addColumn(x.AverageMs, "Avg (ms)").alignRight();
        _grid.addColumn(x.TotalMs, "Total (ms)").alignRight();
        _grid.layoutFill();

        ScGroup group;
        group = root.addGroup("Results");
        group.css().flexChildFiller();

        ScDiv body;
        body = group.getBody();
        body.css().noBorder();
        body.add(_grid);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        // none
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSearch()
    {
        _grid.ajaxReload();
    }

    //##################################################
    //# fetcher
    //##################################################

    private KmFilterFactoryIF<MyPerformanceLogSummary> newFetcher()
    {
        return new KmFilterFactoryIF<MyPerformanceLogSummary>()
        {
            @Override
            public KmFilter<MyPerformanceLogSummary> createFilter()
            {
                MyPerformanceLogSummaryFilter f;
                f = new MyPerformanceLogSummaryFilter();

                if ( _nameField.hasValue() )
                    f.setName(_nameField.getValue());

                if ( _startDateField.hasValue() )
                    f.setMinimumDate(_startDateField.getValue());

                if ( _endDateField.hasValue() )
                    f.setMaximumDate(_endDateField.getValue());

                f.sortDescending();
                if ( _sortField.hasValue() )
                    f.sortOn(_sortField.getValue());
                else
                    f.sortOnTotal();

                return f;
            }
        };
    }

}
