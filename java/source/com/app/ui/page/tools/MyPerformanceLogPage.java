package com.app.ui.page.tools;

import com.kodemore.collection.KmList;
import com.kodemore.filter.KmFilter;
import com.kodemore.filter.KmFilterFactoryIF;
import com.kodemore.meta.KmMetaProperty;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScArray;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFilterBox;
import com.kodemore.servlet.control.ScGrid;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScDateField;
import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.time.KmDate;
import com.kodemore.utility.KmNamedEnumIF;

import com.app.model.MyPerformanceLogSummaryVo;
import com.app.model.meta.MyMetaPerformanceLogSummaryVo;
import com.app.ui.page.MyPage;

public class MyPerformanceLogPage
    extends MyToolsPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyPage instance = new MyPerformanceLogPage();

    private MyPerformanceLogPage()
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
    public void initUrlFromSession(ScParameterList v)
    {
        // none
    }

    @Override
    public void initSessionFromUrl(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().gap();

        installFilter(root);
        installGrid(root);
    }

    private void installFilter(ScContainer root)
    {
        _startDateField = new ScDateField();
        _endDateField = new ScDateField();

        _sortField = new ScDropdown();
        _sortField.addOptions(Sort.values());
        _sortField.setValue(Sort.Total);

        _filterBox = root.addFilterBox();
        _filterBox.setAction(newSearchAction());

        ScArray row;
        row = _filterBox.addRow();
        row.addLabel("Date");
        row.add(_startDateField);
        row.addText("to");
        row.add(_endDateField);
        row.addSpace();
        row.addLabel("Sort");
        row.add(_sortField);
    }

    private void installGrid(ScContainer root)
    {
        MyMetaPerformanceLogSummaryVo x = MyPerformanceLogSummaryVo.Meta;

        _grid = new ScGrid<MyPerformanceLogSummaryVo>();
        _grid.trackAll(_filterBox);
        _grid.setFilterFactory(newFetcher());

        _grid.addColumn(x.Name).setWidth(50);
        _grid.addColumn(x.Count);
        _grid.addColumn(x.MinimumMs, "Min");
        _grid.addColumn(x.MaximumMs, "Max");
        _grid.addColumn(x.AverageMs, "Avg");
        _grid.addColumn(x.TotalMs, "Total");

        ScGroup group;
        group = root.addGroup("Performance Logs");
        group.add(_grid);

        ScDiv buttons;
        buttons = group.getHeader().addFloatRight();
        buttons.css().pad5();
        buttons.addButton("Delete All", newDeleteAllAction());
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newSearchAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleSearch();
            }
        };
    }

    private ScActionIF newDeleteAllAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleDeleteAll();
            }
        };
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
