package com.app.ui.page.tools;

import com.kodemore.collection.KmList;
import com.kodemore.filter.KmFilter;
import com.kodemore.filter.KmFilterFactoryIF;
import com.kodemore.meta.KmMetaProperty;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFilterBox;
import com.kodemore.servlet.control.ScFlexbox;
import com.kodemore.servlet.control.ScGrid;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScDateField;
import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.time.KmDate;
import com.kodemore.utility.KmNamedEnumIF;

import com.app.model.MyPerformanceLogSummaryVo;
import com.app.model.meta.MyMetaPerformanceLogSummaryVo;

public class MyDevPerformanceLogPage
    extends MyDevAbstractPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyDevPerformanceLogPage instance = new MyDevPerformanceLogPage();

    private MyDevPerformanceLogPage()
    {
        // singleton
    }

    //##################################################
    //# sort
    //##################################################

    private enum Sort
        implements KmNamedEnumIF
    {
        Name("Name"),
        Minimum("Minimum"),
        Maximum("Maximum"),
        Average("Average"),
        Total("Total"),
        Count("Count");

        private String _name;

        private Sort(String name)
        {
            _name = name;
        }

        @Override
        public String getName()
        {
            return _name;
        }
    }

    //##################################################
    //# variables
    //##################################################

    private ScFilterBox                       _filterBox;
    private ScDateField                       _startDateField;
    private ScDateField                       _endDateField;
    private ScDropdown                        _sortField;

    private ScGrid<MyPerformanceLogSummaryVo> _grid;

    //##################################################
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeQueryParameters()
    {
        return null;
    }

    @Override
    public void applyQueryParameters(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().fill();

        ScFlexbox col;
        col = root.addColumn();
        col.css().fill().gap();

        installFilterOn(col);
        installGridOn(col);
    }

    private void installFilterOn(ScFlexbox col)
    {
        _startDateField = new ScDateField();
        _endDateField = new ScDateField();

        _sortField = new ScDropdown();
        _sortField.addOptions(Sort.values());
        _sortField.setValue(Sort.Total);

        ScDiv root;
        root = col.addDiv();
        root.css().flexStatic().relative();

        _filterBox = root.addFilterBox("Search");
        _filterBox.setAction(this::handleSearch);

        ScFlexbox row;
        row = _filterBox.addRow();
        row.crossAlignCenter();
        row.addLabel("Date");
        row.addSpace();
        row.add(_startDateField);
        row.addSpace();
        row.addText("to");
        row.addSpace();
        row.add(_endDateField);
        row.addSpace();

        row.addFiller();

        row.addLabel("Sort");
        row.addSpace();
        row.add(_sortField);

        row.addFiller();
    }

    private void installGridOn(ScFlexbox col)
    {
        MyMetaPerformanceLogSummaryVo x = MyPerformanceLogSummaryVo.Meta;

        _grid = new ScGrid<>();
        _grid.trackAll(_filterBox);
        _grid.setFilterFactory(newFetcher());

        _grid.addColumn(x.Name).setWidth(200);
        _grid.addColumn(x.Count);
        _grid.addColumn(x.MinimumMs, "Min");
        _grid.addColumn(x.MaximumMs, "Max");
        _grid.addColumn(x.AverageMs, "Avg");
        _grid.addColumn(x.TotalMs, "Total");
        _grid.layoutFill();

        ScDiv root;
        root = col.addDiv();
        root.css().flexFiller().relative();

        ScGroup group;
        group = root.addGroup("Results");
        group.css().fill();

        ScDiv body;
        body = group.getBody();
        body.css().relative().noBorder();
        body.add(_grid);

        ScDiv buttons;
        buttons = group.getBanner().addFloatRight();
        buttons.css().smallPad();
        buttons.addButton("Delete All", this::handleDeleteAll);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSearch()
    {
        _grid.ajaxReload();
    }

    private void handleDeleteAll()
    {
        getAccess().getPerformanceLogDao()._truncate();

        _grid.ajaxReload();
    }

    //##################################################
    //# fetcher
    //##################################################

    private KmFilterFactoryIF<MyPerformanceLogSummaryVo> newFetcher()
    {
        return new KmFilterFactoryIF<MyPerformanceLogSummaryVo>()
        {
            @Override
            public KmFilter<MyPerformanceLogSummaryVo> createFilter()
            {
                KmDate start = _startDateField.getValue();
                KmDate end = _endDateField.getValue();

                KmList<MyPerformanceLogSummaryVo> v;
                v = getAccess().getPerformanceLogDao().findSummaries(start, end);
                v.sortOn(getSortProperty());
                v.reverse();

                return v.toFilter();
            }

            private KmMetaProperty<MyPerformanceLogSummaryVo,?> getSortProperty()
            {
                MyMetaPerformanceLogSummaryVo x = MyPerformanceLogSummaryVo.Meta;

                Integer ord = _sortField.getIntegerValue();
                Sort sort = Sort.values()[ord];

                switch ( sort )
                {
                    case Name:
                        return x.Name;

                    case Minimum:
                        return x.MinimumMs;

                    case Maximum:
                        return x.MaximumMs;

                    case Average:
                        return x.AverageMs;

                    case Total:
                        return x.TotalMs;

                    case Count:
                        return x.Count;
                }

                return x.TotalMs;
            }
        };
    }

}
