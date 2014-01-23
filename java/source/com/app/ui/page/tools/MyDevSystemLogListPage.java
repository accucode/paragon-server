package com.app.ui.page.tools;

import org.apache.log4j.Level;

import com.kodemore.filter.KmFilter;
import com.kodemore.filter.KmFilterFactoryIF;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScArray;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFilterBox;
import com.kodemore.servlet.control.ScGrid;
import com.kodemore.servlet.control.ScOldGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScDateField;
import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.servlet.variable.ScLocalInteger;

import com.app.filter.MySystemLogFilter;
import com.app.model.MySystemLog;
import com.app.model.MySystemLogTools;
import com.app.model.meta.MyMetaSystemLog;

public class MyDevSystemLogListPage
    extends MyDevAbstractPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyDevSystemLogListPage instance = new MyDevSystemLogListPage();

    private MyDevSystemLogListPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScFilterBox    _filterBox;
    private ScDropdown     _levelDropdown;
    private ScTextField    _loggerField;
    private ScTextField    _contextField;
    private ScDateField    _startDateField;
    private ScDateField    _endDateField;

    private ScLocalInteger _logId;
    @SuppressWarnings("unused")
    private ScOldGroup        _logGroup;

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
        ScArray arr;
        arr = root.addArray();

        ScArray row;
        row = arr.addRow();

        installFilter(row);
        installActions(row);

        installGrid(arr);
        installTrace(arr);
    }

    private void installFilter(ScContainer root)
    {
        MySystemLogTools x = MySystemLog.Tools;

        _levelDropdown = x.newLevelDropdown();
        _levelDropdown.addNullAnyPrefix();
        _levelDropdown.setValue(Level.FATAL.getSyslogEquivalent());

        _loggerField = new ScTextField();
        _loggerField.setLabel("Logger");

        _contextField = new ScTextField();
        _contextField.setLabel("Context");

        _startDateField = new ScDateField();
        _startDateField.setLabel("Start Date");

        _endDateField = new ScDateField();
        _endDateField.setLabel("End Date");

        _filterBox = root.addFilterBox();

        ScArray row;
        row = _filterBox.getGroup().addSpacedRow();

        ScFieldTable fields;
        fields = row.addFields();
        fields.add(_levelDropdown);
        fields.add(_loggerField);
        fields.add(_contextField);

        fields = row.addFields();
        fields.add(_startDateField);
        fields.add(_endDateField);
    }

    private void installActions(ScContainer root)
    {
        ScOldGroup group;
        group = root.addOldGroup("Actions");
        group.addButton("Delete All", newDeleteAllAction());
    }

    private void installGrid(ScContainer root)
    {
        MyMetaSystemLog x = MySystemLog.Meta;

        ScGrid<MySystemLog> grid;
        grid = new ScGrid<MySystemLog>();
        grid.setFilterFactory(newFetcher());
        grid.trackAll(_filterBox);

        grid.addLinkColumn(x.Id, newTraceAction());
        grid.addColumn(x.CreatedUtcTs);
        grid.addColumn(x.CreatedLocalTsMessage);
        grid.addColumn(x.LevelCodeName, "Level");
        grid.addColumn(x.LoggerName, "Logger");
        grid.addColumn(x.Context);
        grid.addColumn(x.Message);

        ScOldGroup group;
        group = root.addOldGroup("System Logs");
        group.add(grid);
    }

    private void installTrace(ScContainer root)
    {
        MyMetaSystemLog x = MySystemLog.Meta;

        _logId = new ScLocalInteger();
        _logId.setAutoSave();

        ScOldGroup group;
        group = root.addOldGroup("Trace");
        group.style().hide();

        ScFieldTable fields;
        fields = group.addFields();
        fields.addLink("Delete", newDeleteAction());
        fields.addText(x.Id);
        fields.addText(x.CreatedUtcTs);
        fields.addText(x.CreatedLocalTsMessage);
        fields.addText(x.Message);
        fields.addText(x.FullTrace);

        _logGroup = group;
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newTraceAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleTrace();
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

    private ScActionIF newDeleteAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleDelete();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleTrace()
    {
        _logId.setValue(getIntegerArgument());
        //        print();
    }

    private void handleDeleteAll()
    {
        getAccess().getSystemLogDao()._truncate();
        getAccess().getSystemLogTraceDao()._truncate();

        _logId.resetValue();
        //        print();
    }

    private void handleDelete()
    {
        MySystemLog e;
        e = getAccess().findSystemLogId(_logId.getValue());
        e.deleteDao();

        _logId.resetValue();
        //        print();
    }

    //##################################################
    //# support
    //##################################################

    private KmFilterFactoryIF<MySystemLog> newFetcher()
    {
        return new KmFilterFactoryIF<MySystemLog>()
        {
            @Override
            public KmFilter<MySystemLog> createFilter()
            {
                return getFilter();
            }
        };
    }

    private MySystemLogFilter getFilter()
    {
        MySystemLogFilter f;
        f = new MySystemLogFilter();
        f.sortOnId();
        f.sortDescending();

        if ( _levelDropdown.hasValue() )
            f.setLevelCode(_levelDropdown.getIntegerValue());

        if ( _loggerField.hasValue() )
            f.setLoggerNamePrefix(_loggerField.getValue());

        if ( _contextField.hasValue() )
            f.setContext(_contextField.getValue());

        if ( _startDateField.hasValue() )
            f.setMinimumCreatedUtcDate(_startDateField.getValue());

        if ( _endDateField.hasValue() )
            f.setMaximumCreatedUtcDate(_endDateField.getValue());

        return f;
    }

}
