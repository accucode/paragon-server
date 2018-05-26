package com.app.ui.page.tools;

import org.apache.log4j.Level;

import com.kodemore.filter.KmFilter;
import com.kodemore.filter.KmFilterFactoryIF;
import com.kodemore.log.KmLog;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScArray;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFilterBox;
import com.kodemore.servlet.control.ScGrid;
import com.kodemore.servlet.control.ScGridGroup;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScLink;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScSimpleContainer;
import com.kodemore.servlet.field.ScDateField;
import com.kodemore.servlet.field.ScDropdownField;
import com.kodemore.servlet.field.ScTextField;

import com.app.filter.MyApplicationLogFilter;
import com.app.model.MyApplicationLog;
import com.app.model.MyApplicationLogBuffer;
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

    private ScFilterBox              _filterBox;
    private ScDropdownField<Integer> _levelDropdown;
    private ScTextField              _loggerField;
    private ScTextField              _contextField;
    private ScDateField              _startDateField;
    private ScDateField              _endDateField;

    private ScGrid<MyApplicationLog> _grid;

    private ScCardFrame _detailFrame;
    private ScGroup     _detailGroup;

    //##################################################
    //# settings
    //##################################################

    @Override
    public final MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().fill().flexColumn().columnSpacer10();

        installFilterOn(root);

        ScDiv row;
        row = root.addDiv();
        row.css().flexRow().rowSpacer10().flexChildFiller();

        installGridOn(row);
        installDetailOn(row);
    }

    //==================================================
    //= install :: filter
    //==================================================

    private void installFilterOn(ScDiv root)
    {
        ScFilterBox filter;
        filter = createFilterBoxOn(root);

        ScArray row;
        row = filter.addArraySpacedRow();

        ScFieldTable fields;
        fields = row.addFullWidthFieldTable();
        fields.add(createLevelField());
        fields.add(createLoggerField());
        fields.add(createContextField());

        fields = row.addFullWidthFieldTable();
        fields.add(createStartDateField());
        fields.add(createEndDateField());

        installLeftButtonsOn(filter);
        installRightButtonsOn(filter);
    }

    private ScFilterBox createFilterBoxOn(ScDiv root)
    {
        ScFilterBox e;
        e = root.addFilterBox("Filter");
        e.getFormWrapper().css().flexChildStatic();
        e.setAction(newCheckedAction(this::handleFilter));
        _filterBox = e;
        return e;
    }

    private ScDropdownField<Integer> createLevelField()
    {
        ScDropdownField<Integer> e;
        e = MyApplicationLog.Tools.newLevelDropdown();
        e.setNullAnyPrefix();
        e.setValue(Level.FATAL.getSyslogEquivalent());
        e.disableChangeTracking();
        _levelDropdown = e;
        return e;
    }

    private ScTextField createLoggerField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel("Logger");
        e.disableChangeTracking();
        _loggerField = e;
        return e;
    }

    private ScTextField createContextField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel("Context");
        e.disableChangeTracking();
        _contextField = e;
        return e;
    }

    private ScDateField createStartDateField()
    {
        ScDateField e;
        e = new ScDateField();
        e.setLabel("Start Date");
        e.disableChangeTracking();
        _startDateField = e;
        return e;
    }

    private ScDateField createEndDateField()
    {
        ScDateField e;
        e = new ScDateField();
        e.setLabel("End Date");
        e.disableChangeTracking();
        _endDateField = e;
        return e;
    }

    private void installLeftButtonsOn(ScFilterBox root)
    {
        ScDiv buttons;
        buttons = root.getLeftButtons();

        ScActionButton button;
        button = buttons.addButton("Delete All", newCheckedAction(this::handleDeleteAll));
        button.setConfirmationMessageText("Delete All Logs?");
    }

    private void installRightButtonsOn(ScFilterBox root)
    {
        ScDiv buttons;
        buttons = root.getRightButtons();
        buttons.addButton("Add Debug", newCheckedAction(this::handleAddDebugLog));
        buttons.addButton("Add Info", newCheckedAction(this::handleAddInfoLog));
        buttons.addButton("Add Fatal", newCheckedAction(this::handleAddFatalLog));
        buttons.addButton("Flush", newCheckedAction(this::handleFlush));
    }

    //==================================================
    //= install :: grid
    //==================================================

    private void installGridOn(ScDiv root)
    {
        ScGridGroup<MyApplicationLog> group;
        group = root.addGroup("Results", createGrid());
        group.css().flexChildFiller0();
    }

    private ScGrid<MyApplicationLog> createGrid()
    {
        MyMetaApplicationLog x = MyApplicationLog.Meta;

        ScGrid<MyApplicationLog> grid;
        grid = new ScGrid<>();
        grid.setFilterFactory(newFetcher());
        grid.trackAll(_filterBox);
        grid.layoutFill();

        grid.addLinkColumn("View", newCheckedAction(this::handleSelect), x.Uid).width(40);
        grid.addColumn(x.CreatedLocalTsMessage);
        grid.addColumn(x.LevelName, "Level");
        grid.addColumn(x.Message, 250);

        _grid = grid;
        return grid;
    }

    //==================================================
    //= install :: details
    //==================================================

    private void installDetailOn(ScDiv root)
    {
        ScCardFrame frame;
        frame = root.addCardFrame();
        frame.setTransitionFade();
        frame.css().flexChildFiller0().relative();
        frame.addCard(createDetailGroup());
        _detailFrame = frame;
    }

    private ScGroup createDetailGroup()
    {
        MyMetaApplicationLog x = MyApplicationLog.Meta;

        ScGroup group;
        group = new ScGroup();
        group.css().fill();
        group.setTitle("Detail");

        ScDiv body;
        body = group.getBody();
        body.css().auto().pad();

        ScFieldTable fields;
        fields = body.addFullWidthFieldTable();
        fields.add(createUidRow());
        fields.addFieldText(x.CreatedLocalTsMessage);
        fields.addFieldText(x.Context);
        fields.addFieldText(x.LevelName);
        fields.addFieldText(x.LoggerName);

        installMessageOn(body);
        installTraceOn(body);

        _detailGroup = group;
        return group;
    }

    private ScSimpleContainer createUidRow()
    {
        MyMetaApplicationLog x = MyApplicationLog.Meta;

        ScSimpleContainer row;
        row = new ScSimpleContainer();
        row.setLabel("Uid");
        row.addFieldText(x.Uid);
        row.addSpace();

        ScLink link;
        link = row.addLink("delete", newCheckedAction(this::handleDelete), x.Uid);
        link.setConfirmationMessage("Delete?");

        return row;
    }

    private void installMessageOn(ScDiv box)
    {
        MyMetaApplicationLog x = MyApplicationLog.Meta;

        box.addBreak();
        box.addParagraph().addBold("Message");
        box.addParagraph().addTextSpan(x.Message).css().noWrap();
    }

    private void installTraceOn(ScDiv box)
    {
        MyMetaApplicationLog x = MyApplicationLog.Meta;

        box.addBreak();
        box.addParagraph().addBold("Trace");
        box.addParagraph().addTextSpan(x.Trace).css().noWrap();
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
    //# handle
    //##################################################

    private void handleFilter()
    {
        _grid.ajaxReload();
        _detailFrame.ajaxClose();
    }

    private void handleSelect()
    {
        String uid = getData().getStringArgument();
        MyApplicationLog log = getAccess().findApplicationLogUid(uid);

        if ( log == null )
        {
            ajax().toast("Cannot find log; refresh.");
            return;
        }

        _detailGroup.applyFromModel(log);
        _detailFrame.ajaxPrint(_detailGroup);
    }

    private void handleDeleteAll()
    {
        getAccess().getApplicationLogDao()._truncate();

        ajax().toast("All logs deleted.");
        ajaxPrint();
    }

    private void handleDelete()
    {
        String uid = getData().getStringArgument();

        MyApplicationLog e;
        e = getAccess().findApplicationLogUid(uid);

        if ( e != null )
            e.daoDelete();

        _grid.ajaxReload();
        _detailFrame.ajaxClose();
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

    private void handleFlush()
    {
        MyApplicationLogBuffer.flush();
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
            f.setLevelCode(_levelDropdown.getValue());

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
