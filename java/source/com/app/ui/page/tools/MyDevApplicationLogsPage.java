package com.app.ui.page.tools;

import org.apache.log4j.Level;

import com.kodemore.filter.KmFilter;
import com.kodemore.filter.KmFilterFactoryIF;
import com.kodemore.log.KmLog;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScAbsoluteLayout;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScArray;
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

import com.app.filter.MyApplicationLogFilter;
import com.app.model.MyApplicationLog;
import com.app.model.MyApplicationLogTools;
import com.app.model.meta.MyMetaApplicationLog;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyDevApplicationLogsPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyDevApplicationLogsPage _instance;

    public static void installInstance()
    {
        _instance = new MyDevApplicationLogsPage();
    }

    public static MyDevApplicationLogsPage getInstance()
    {
        return _instance;
    }

    private MyDevApplicationLogsPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScFilterBox _filterBox;
    private ScDropdown  _levelDropdown;
    private ScTextField _loggerField;
    private ScTextField _contextField;
    private ScDateField _startDateField;
    private ScDateField _endDateField;

    private ScGrid<MyApplicationLog> _grid;

    private ScDiv   _logPanel;
    private ScGroup _detailGroup;
    private ScLink  _deleteLogLink;

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
        root.css().fillOffset();

        ScAbsoluteLayout layout;
        layout = root.addAbsoluteLayout();

        ScDiv top = layout.addTop(200);
        layout.padTop();

        ScDiv left = layout.addLeftPercent(50);
        _logPanel = layout.addCenter();

        installFilter(top);
        installGrid(left);
        installDetailGroup();
    }

    private void installFilter(ScDiv root)
    {
        MyApplicationLogTools x = MyApplicationLog.Tools;

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

        _filterBox = root.addFilterBox("Filter");
        _filterBox.layoutFill();
        _filterBox.setAction(this::handleFilter);

        ScArray row;
        row = _filterBox.addArraySpacedRow();

        ScFieldTable fields;
        fields = row.addFieldTable();
        fields.add(_levelDropdown);
        fields.add(_loggerField);
        fields.add(_contextField);

        fields = row.addFieldTable();
        fields.add(_startDateField);
        fields.add(_endDateField);

        ScActionButton button;
        button = _filterBox.getLeftButtons().addButton("Delete All", this::handleDeleteAll);
        button.setConfirmationMessage("Delete All Logs?");

        installTestButtons();
    }

    private void installTestButtons()
    {
        ScBox buttons;
        buttons = _filterBox.getRightButtons();
        buttons.addButton("Add Debug", this::handleAddDebugLog);
        buttons.addButton("Add Info", this::handleAddInfoLog);
        buttons.addButton("Add Fatal", this::handleAddFatalLog);
    }

    private void installGrid(ScDiv root)
    {
        MyMetaApplicationLog x = MyApplicationLog.Meta;

        ScGroup group;
        group = root.addGroup("Results");
        group.css().fill();

        ScDiv body;
        body = group.getBody();
        body.css().relative().noBorder();

        _grid = body.addGrid();
        _grid.setFilterFactory(newFetcher());
        _grid.trackAll(_filterBox);
        _grid.layoutFill();

        ScGridColumn<MyApplicationLog> col;
        col = _grid.addLinkColumn("View", this::handleSelect, x.Uid);
        col.setWidth(40);

        _grid.addColumn(x.CreatedLocalTsMessage);
        _grid.addColumn(x.LevelName, "Level");
        _grid.addColumn(x.Message);
    }

    private void installDetailGroup()
    {
        MyMetaApplicationLog x = MyApplicationLog.Meta;

        ScGroup group;
        group = new ScGroup();
        group.setTitle("Detail");
        group.css().fill().marginLeft();

        // created, but disconnected from the main content.
        _detailGroup = group;

        ScSimpleContainer idRow;
        idRow = new ScSimpleContainer();
        idRow.setLabel("Uid");
        idRow.addText(x.Uid);
        idRow.addSpace();

        _deleteLogLink = idRow.addLink("delete", this::handleDelete, x.Uid);
        _deleteLogLink.setConfirmationMessage("Delete?");

        group.bodyCss().auto();

        ScDiv box;
        box = group.getBody().addBox();
        box.css().pad();

        ScFieldTable fields;
        fields = box.addFieldTable();
        fields.add(idRow);
        fields.addText(x.CreatedLocalTsMessage);
        fields.addText(x.Context);
        fields.addText(x.LevelName);
        fields.addText(x.LoggerName);

        box.addBreak();
        box.addParagraph().addBold("Message");
        box.addParagraph().addTextSpan(x.Message).css().noWrap();

        box.addBreak();
        box.addParagraph().addBold("Trace");
        box.addParagraph().addTextSpan(x.Trace).css().noWrap();
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

    private void handleFilter()
    {
        _grid.ajaxReload();
        _logPanel.ajax().clearContents();
    }

    private void handleSelect()
    {
        String uid = getStringArgument();
        MyApplicationLog log = getAccess().findApplicationLogUid(uid);

        if ( log == null )
        {
            ajax().toast("Cannot find log; refresh.");
            return;
        }

        _detailGroup.applyFromModel(log);
        _logPanel.ajax().setContents(_detailGroup).fade();
    }

    private void handleDeleteAll()
    {
        getAccess().getApplicationLogDao()._truncate();

        ajax().toast("All logs deleted.");
        ajaxPrint();
    }

    private void handleDelete()
    {
        String uid = getStringArgument();

        MyApplicationLog e;
        e = getAccess().findApplicationLogUid(uid);

        if ( e != null )
            e.deleteDao();

        _grid.ajaxReload();
        _detailGroup.ajax().hide().fade();
        ajax().toast("Log %s, deleted.", uid);
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

    private KmFilterFactoryIF<MyApplicationLog> newFetcher()
    {
        return new KmFilterFactoryIF<MyApplicationLog>()
        {
            @Override
            public KmFilter<MyApplicationLog> createFilter()
            {
                return getFilter();
            }
        };
    }

    private MyApplicationLogFilter getFilter()
    {
        MyApplicationLogFilter f;
        f = new MyApplicationLogFilter();
        f.sortOnUid();
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
