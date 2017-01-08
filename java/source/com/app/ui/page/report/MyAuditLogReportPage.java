package com.app.ui.page.report;

import com.kodemore.collection.KmList;
import com.kodemore.filter.KmFilter;
import com.kodemore.filter.KmFilterIF;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScFilterBox;
import com.kodemore.servlet.control.ScGrid;
import com.kodemore.servlet.control.ScGridGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScDateIntervalField;
import com.kodemore.servlet.field.ScDomainDropdownField;
import com.kodemore.servlet.field.ScDropdownField;
import com.kodemore.servlet.field.ScEnumDropdownField;
import com.kodemore.time.KmDateInterval;

import com.app.filter.MyAuditLogBundleFilter;
import com.app.filter.MyUserFilter;
import com.app.model.MyAuditLog;
import com.app.model.MyAuditLogBundleVo;
import com.app.model.MyUser;
import com.app.model.meta.MyMetaAuditLog;
import com.app.model.meta.MyMetaAuditLogBundleVo;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyAuditLogReportPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyAuditLogReportPage _instance;

    public static void installInstance()
    {
        _instance = new MyAuditLogReportPage();
    }

    public static MyAuditLogReportPage getInstance()
    {
        return _instance;
    }

    private MyAuditLogReportPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScEnumDropdownField                  _logTypeField;
    private ScDropdownField<String>              _domainTypeField;
    private ScDomainDropdownField<MyUser,String> _userNameField;

    private ScDateIntervalField                  _dateIntervalField;

    private ScFilterBox                          _filterGroup;
    private ScGrid<MyAuditLogBundleVo>           _grid;

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
        root.css().flexColumn().columnSpacer20();

        installFilterOn(root);
        installResultsOn(root);
    }

    private void installFilterOn(ScContainer root)
    {
        ScFilterBox group;
        group = root.addFilterBox();
        group.setAction(this::handleSearch);
        _filterGroup = group;

        ScDiv row;
        row = group.addFlexRow();
        row.css().rowSpacer10();

        ScFieldTable fields;
        fields = newFieldTable(row, "Log");
        fields.add(createLogTypeField());
        fields.add(createDomainTypeField());

        fields = newFieldTable(row, "User");
        fields.add(createUserNameField());

        fields = newFieldTable(row, "Date Range");
        fields.add(createDateIntervalField());
    }

    private ScFieldTable newFieldTable(ScContainer root, String label)
    {
        ScFieldset set;
        set = root.addFieldset(label);
        set.css().flexChildFiller0();

        return set.addFieldTable();
    }

    private void installResultsOn(ScContainer root)
    {
        ScGridGroup<MyAuditLogBundleVo> group;
        group = root.addGroup("Audit Logs", createResultGrid());
        group.css().flexChildFiller();
    }

    private ScGrid<MyAuditLogBundleVo> createResultGrid()
    {
        MyMetaAuditLogBundleVo x = MyAuditLogBundleVo.Meta;

        ScGrid<MyAuditLogBundleVo> e;
        e = new ScGrid<>();
        e.trackAll(_filterGroup);
        e.setFilterFactory(this::getLogFilter);
        e.layoutFill();
        e.addColumn(x.DisplayUserName);
        e.addColumn(x.LogLocalTsMessage);
        e.addColumn(x.DisplaySummary).setWidth(300);
        _grid = e;
        return e;
    }

    //==================================================
    //= install :: fields
    //==================================================

    private ScEnumDropdownField createLogTypeField()
    {
        MyMetaAuditLog x = MyAuditLog.Meta;

        ScEnumDropdownField e;
        e = x.TypeCode.newDropdown();
        e.setNullAnyPrefix();
        e.setLabel("Log Type");
        e.setOptional();
        _logTypeField = e;
        return e;
    }

    private ScDropdownField<String> createDomainTypeField()
    {
        MyMetaAuditLog x = MyAuditLog.Meta;

        ScDropdownField<String> e;
        e = new ScDropdownField<>();
        e.setLabel(x.DomainType.getLabel());
        e.setHelp(x.DomainType.getHelp());
        e.setNullAnyPrefix();
        _domainTypeField = e;
        return e;
    }

    private ScDomainDropdownField<MyUser,String> createUserNameField()
    {
        ScDomainDropdownField<MyUser,String> e;
        e = MyUser.Tools.newDomainDropdown();
        e.setOptionLabelFunction(MyUser.Meta.FullName);
        e.setFilterFactoryWith(this::getUserFilter);
        e.setNullAnyPrefix();
        _userNameField = e;
        return e;
    }

    private ScDateIntervalField createDateIntervalField()
    {
        ScDateIntervalField e;
        e = new ScDateIntervalField();
        _dateIntervalField = e;
        return e;
    }

    //##################################################
    //# filters
    //##################################################

    private KmFilterIF<MyUser> getUserFilter()
    {
        MyUserFilter f;
        f = new MyUserFilter();
        f.sortOnName();
        f.sortAscending();
        return f;
    }

    private KmFilter<MyAuditLogBundleVo> getLogFilter()
    {
        MyAuditLogBundleFilter f;
        f = new MyAuditLogBundleFilter();

        if ( _logTypeField.hasValue() )
            f.setTypeCode(_logTypeField.getValue());

        if ( _domainTypeField.hasValue() )
            f.setDomainType(_domainTypeField.getValue());

        if ( _userNameField.hasValue() )
            f.setUser(_userNameField.getValue());

        applyDateIntervalTo(f);
        return f;
    }

    private void applyDateIntervalTo(MyAuditLogBundleFilter f)
    {
        if ( !_dateIntervalField.hasValue() )
            return;

        KmDateInterval di = _dateIntervalField.getValue();

        if ( di.hasStart() )
            f.setMinimumCreatedUtcTs(di.getStart().getStartOfDay().toUtc());

        if ( di.hasEnd() )
            f.setMaximumCreatedUtcTs(di.getEnd().getEndOfDay().toUtc());
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        _domainTypeField.setOptions(getDomainTypes());
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSearch()
    {
        _grid.ajaxReload();
    }

    //##################################################
    //# support
    //##################################################

    private KmList<String> getDomainTypes()
    {
        return getAccess().getAuditLogDao().getDomainTypes();
    }

}
