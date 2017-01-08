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
import com.kodemore.time.KmTimestamp;

import com.app.filter.MyPerformanceLogDetailFilter;
import com.app.model.MyPerformanceLogDetail;
import com.app.model.meta.MyMetaPerformanceLogDetail;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyDevPerformanceLogDetailPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyDevPerformanceLogDetailPage _instance;

    public static void installInstance()
    {
        _instance = new MyDevPerformanceLogDetailPage();
    }

    public static MyDevPerformanceLogDetailPage getInstance()
    {
        return _instance;
    }

    private MyDevPerformanceLogDetailPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScFilterBox                    _filterBox;
    private ScTextField                    _nameField;
    private ScDateField                    _startDateField;
    private ScDateField                    _endDateField;
    private ScEnumDropdownField            _sortField;

    private ScGrid<MyPerformanceLogDetail> _grid;

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
        _sortField.addOptions(MyPerformanceLogDetailFilter.Sort.values());
        _sortField.setValue(MyPerformanceLogDetailFilter.Sort.CreatedUtcTs);
        _sortField.disableChangeTracking();

        _filterBox = root.addFilterBox("Search");
        _filterBox.setAction(this::handleSearch);
        _filterBox.getFormWrapper().css().flexChildStatic();

        ScFieldLayout fields;
        fields = _filterBox.addFieldLayout();
        fields.add(_nameField);

        ScDiv dateBox;
        dateBox = fields.addFlexRow();
        dateBox.css().flexCrossAlignCenter().rowSpacer5();
        dateBox.setLabel("Date");
        dateBox.add(_startDateField);
        dateBox.addTextSpan("to");
        dateBox.add(_endDateField);

        fields.add(_sortField);
    }

    private void installGridOn(ScDiv root)
    {
        MyMetaPerformanceLogDetail x = MyPerformanceLogDetail.Meta;

        _grid = new ScGrid<>();
        _grid.trackAll(_filterBox);
        _grid.setFilterFactory(newFetcher());

        _grid.addColumn(x.CreatedUtcTs).setWidth(200);
        _grid.addColumn(x.Name).setWidth(200);
        _grid.addColumn(x.DurationMs);
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

    private KmFilterFactoryIF<MyPerformanceLogDetail> newFetcher()
    {
        return new KmFilterFactoryIF<MyPerformanceLogDetail>()
        {
            @Override
            public KmFilter<MyPerformanceLogDetail> createFilter()
            {
                MyPerformanceLogDetailFilter f;
                f = new MyPerformanceLogDetailFilter();

                if ( _nameField.hasValue() )
                    f.setName(_nameField.getValue());

                if ( _startDateField.hasValue() )
                {
                    KmTimestamp min = _startDateField.getValue().getStartOfDay().toUtc();
                    f.setMinimumCreatedUtcTs(min);
                }

                if ( _endDateField.hasValue() )
                {
                    KmTimestamp max = _endDateField.getValue().getEndOfDay().toUtc();
                    f.setMaximumCreatedUtcTs(max);
                }

                f.sortDescending();
                if ( _sortField.hasValue() )
                    f.sortOn(_sortField.getValue());
                else
                    f.sortOnCreatedUtcTs();

                return f;
            }
        };
    }

}
