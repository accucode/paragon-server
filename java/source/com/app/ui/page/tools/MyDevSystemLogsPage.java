package com.app.ui.page.tools;

import org.apache.log4j.Level;

import com.kodemore.filter.KmFilter;
import com.kodemore.filter.KmFilterFactoryIF;
import com.kodemore.log.KmLog;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScArray;
import com.kodemore.servlet.control.ScBorderLayout;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFilterBox;
import com.kodemore.servlet.control.ScGrid;
import com.kodemore.servlet.control.ScGridColumn;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScLink;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScSimpleContainer;
import com.kodemore.servlet.field.ScDateField;
import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.servlet.field.ScTextField;

import com.app.filter.MySystemLogFilter;
import com.app.model.MySystemLog;
import com.app.model.MySystemLogTools;
import com.app.model.meta.MyMetaSystemLog;

public class MyDevSystemLogsPage
    extends MyDevAbstractPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyDevSystemLogsPage instance = new MyDevSystemLogsPage();

    private MyDevSystemLogsPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScFilterBox         _filterBox;
    private ScDropdown          _levelDropdown;
    private ScTextField         _loggerField;
    private ScTextField         _contextField;
    private ScDateField         _startDateField;
    private ScDateField         _endDateField;

    private ScGrid<MySystemLog> _grid;

    private ScDiv               _logPanel;
    private ScGroup             _logGroup;
    private ScLink              _deleteLogLink;

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
        root.css().fillOffset();

        ScBorderLayout layout;
        layout = root.addBorderLayout();

        ScDiv top = layout.addTop(200);
        layout.padTop();

        ScDiv left = layout.addLeftPercent(50);
        _logPanel = layout.addCenter();

        installFilter(top);
        installGrid(left);
        installLogGroup();
    }

    private void installFilter(ScDiv root)
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

        _filterBox = root.addFilterBox("System Logs");
        _filterBox.layoutFill();
        _filterBox.setAction(newFilterAction());

        ScArray row;
        row = _filterBox.addSpacedRow();

        ScFieldTable fields;
        fields = row.addFields();
        fields.add(_levelDropdown);
        fields.add(_loggerField);
        fields.add(_contextField);

        fields = row.addFields();
        fields.add(_startDateField);
        fields.add(_endDateField);

        ScActionButton button;
        button = _filterBox.getLeftButtons().addButton("Delete All", newDeleteAllAction());
        button.setConfirmationMessage("Delete All Logs?");

        installTestButtons();
    }

    private void installTestButtons()
    {
        ScBox buttons;
        buttons = _filterBox.getRightButtons();
        buttons.addButton("Add Debug", newAddDebugLogAction());
        buttons.addButton("Add Info", newAddInfoLogAction());
        buttons.addButton("Add Fatal", newAddFatalLogAction());
    }

    private void installGrid(ScDiv root)
    {
        MyMetaSystemLog x = MySystemLog.Meta;

        ScGrid<MySystemLog> grid;
        grid = new ScGrid<MySystemLog>();
        grid.setFilterFactory(newFetcher());
        grid.trackAll(_filterBox);
        grid.layoutFill();

        ScGridColumn<MySystemLog> col;
        col = grid.addLinkColumn(x.Id, newSelectAction());
        col.setWidth(50);
        col.setHeader("Id");

        grid.addColumn(x.CreatedLocalTsMessage);
        grid.addColumn(x.LevelName, "Level");
        grid.addColumn(x.Message);

        ScGroup group;
        group = root.addGroup("Results");
        group.layoutFill();
        group.add(grid);

        _grid = grid;
    }

    private void installLogGroup()
    {
        MyMetaSystemLog x = MySystemLog.Meta;

        ScGroup group;
        group = new ScGroup();
        group.setTitle("Log");
        group.layoutFill();
        group.css().marginLeft();
        group.bodyCss().pad();

        // created, but disconnected from the main content.
        _logGroup = group;

        ScSimpleContainer idRow;
        idRow = new ScSimpleContainer();
        idRow.setLabel("Id");
        idRow.addText(x.Id);
        idRow.addSpace();

        _deleteLogLink = idRow.addLink("delete", newDeleteAction(), x.Id);
        _deleteLogLink.setConfirmationMessage("Delete?");

        ScBox body;
        body = group.addBox();

        ScFieldTable fields;
        fields = body.addFields();
        fields.add(idRow);
        fields.addText(x.CreatedLocalTsMessage);
        fields.addText(x.Context);
        fields.addText(x.LevelName);
        fields.addText(x.LoggerName);

        body.addBreak();
        body.addParagraph().addBold("Message");
        body.addParagraph().addText(x.Message);

        body.addBreak();
        body.addParagraph().addBold("Trace");
        body.addParagraph().addText(x.FullTrace);
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newFilterAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleFilter();
            }
        };
    }

    private ScActionIF newSelectAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleSelect();
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

    private ScActionIF newAddDebugLogAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleAddDebugLog();
            }
        };
    }

    private ScActionIF newAddInfoLogAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleAddInfoLog();
            }
        };
    }

    private ScActionIF newAddFatalLogAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleAddFatalLog();
            }
        };
    }

    //##################################################
    //# handle
    //##################################################

    private void handleFilter()
    {
        _grid.ajaxReload();
        _logPanel.ajax().clearContents();
    }

    private void handleSelect()
    {
        Integer id = getIntegerArgument();
        MySystemLog log = getAccess().findSystemLogId(id);

        if ( log == null )
        {
            ajax().toast("Cannot find log; refresh.");
            return;
        }

        _logGroup.applyFromModel(log);
        _logPanel.ajax().setContents(_logGroup).fade();
    }

    private void handleDeleteAll()
    {
        getAccess().getSystemLogDao()._truncate();
        getAccess().getSystemLogTraceDao()._truncate();

        ajax().toast("All logs deleted.");
        print();
    }

    private void handleDelete()
    {
        Integer id = getIntegerArgument();

        MySystemLog e;
        e = getAccess().findSystemLogId(id);

        if ( e != null )
            e.deleteDao();

        _grid.ajaxReload();
        _logGroup.ajax().hide().fade();
        ajax().toast("Log %s, deleted.", id);
    }

    private void handleAddDebugLog()
    {
        KmLog.debug("Debug log test.");
        ajax().toast("Debug log created.  Refresh.");
    }

    private void handleAddInfoLog()
    {
        KmLog.info("Info log test.");
        ajax().toast("Info log created.  Refresh.");
    }

    private void handleAddFatalLog()
    {
        KmLog.fatalTrace("Info log test.");
        ajax().toast("Fatal log created.  Refresh.");
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
