package com.app.ui.page.report;

import com.kodemore.collection.KmList;
import com.kodemore.filter.KmFilter;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScFilterBox;
import com.kodemore.servlet.control.ScGrid;
import com.kodemore.servlet.control.ScGridGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScDateRangeField;
import com.kodemore.servlet.field.ScDomainDropdownField;
import com.kodemore.servlet.field.ScDropdownField;
import com.kodemore.servlet.field.ScDynamicEnumDropdownField;
import com.kodemore.servlet.field.ScStaticDropdownField;
import com.kodemore.servlet.field.ScStaticEnumDropdownField;
import com.kodemore.time.KmDateRange;
import com.kodemore.utility.KmEnumIF;

import com.app.filter.MyAuditBundleFilter;
import com.app.filter.MyUserFilter;
import com.app.model.MyAuditBundle;
import com.app.model.MyUser;
import com.app.model.base.MyAuditBundleChangeType;
import com.app.model.meta.MyMetaAuditBundle;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

public final class MyAuditBundleReportPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyAuditBundleReportPage _instance;

    public static void installInstance()
    {
        _instance = new MyAuditBundleReportPage();
    }

    public static MyAuditBundleReportPage getInstance()
    {
        return _instance;
    }

    private MyAuditBundleReportPage()
    {
        // singleton
    }

    //##################################################
    //# enum
    //##################################################

    private enum Sort
        implements KmEnumIF
    {
        Recent,
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.tenantAdmin;
    }

    //##################################################
    //# variables
    //##################################################

    private ScDynamicEnumDropdownField _changeTypeField;

    private ScStaticDropdownField<String>        _domainTypeField;
    private ScDomainDropdownField<MyUser,String> _userField;

    private ScDateRangeField _dateRangeField;

    private ScFilterBox           _filterGroup;
    private ScGrid<MyAuditBundle> _grid;

    private ScStaticEnumDropdownField _sortField;

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
        group.setAction(newCheckedAction(this::handleSearch));
        _filterGroup = group;

        ScDiv row;
        row = group.addDiv();
        row.css().flexRow().rowSpacer10();

        ScFieldTable fields;
        fields = newFieldTable(row, "Log");
        fields.add(createChangeTypeField());
        fields.add(createDomainTypeField());

        fields = newFieldTable(row, "User");
        fields.add(createUserNameField());

        fields = newFieldTable(row, "Date Range");
        fields.add(createDateRangeField());

        fields = newFieldTable(row, "Sort On");
        fields.add(createSortField());
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
        ScGridGroup<MyAuditBundle> group;
        group = root.addGroup("Audit Logs", createGrid());
        group.css().flexChildFiller();
    }

    //==================================================
    //= install :: change type field
    //==================================================

    private ScControl createChangeTypeField()
    {
        MyMetaAuditBundle x = MyAuditBundle.Meta;

        ScDynamicEnumDropdownField e;
        e = x.ChangeTypeCode.newDropdown();
        e.setNullAnyPrefix();
        e.setLabel("Change Type");
        e.setOptional();
        _changeTypeField = e;
        return e;
    }

    //==================================================
    //= install :: domain type field
    //==================================================

    private ScDropdownField<String> createDomainTypeField()
    {
        MyMetaAuditBundle x = MyAuditBundle.Meta;

        ScStaticDropdownField<String> e;
        e = new ScStaticDropdownField<>();
        e.setLabel(x.DomainType.getLabel());
        e.setHelp(x.DomainType.getHelp());
        e.setNullAnyPrefix();
        _domainTypeField = e;
        return e;
    }

    //==================================================
    //= install :: user field
    //==================================================

    private ScDomainDropdownField<MyUser,String> createUserNameField()
    {
        ScDomainDropdownField<MyUser,String> e;
        e = MyUser.Tools.newDomainDropdown();
        e.setOptionSupplier(this::findUsers);
        e.setNullAnyPrefix();
        _userField = e;
        return e;
    }

    private KmList<MyUser> findUsers()
    {
        MyUserFilter f;
        f = new MyUserFilter();
        f.setTenant(getCurrentTenant());

        KmList<MyUser> v;
        v = f.findAll();
        v.sort(e -> e.getFullName());
        return f.findAll();
    }

    //==================================================
    //= install :: time fields
    //==================================================

    private ScControl createDateRangeField()
    {
        ScDateRangeField e;
        e = new ScDateRangeField();
        e.setLabel("Time");
        e.setHelp("The time that the change was made.");
        _dateRangeField = e;
        return e;
    }

    //==================================================
    //= install :: sort field
    //==================================================

    private ScControl createSortField()
    {
        ScStaticEnumDropdownField e;
        e = new ScStaticEnumDropdownField();
        e.setLabel("Sort On");
        e.setOptions(Sort.values());
        e.selectFirstOption();
        e.disableChangeTracking();
        _sortField = e;
        return e;
    }

    //##################################################
    //# install :: grid
    //##################################################

    private ScGrid<MyAuditBundle> createGrid()
    {
        MyMetaAuditBundle x = MyAuditBundle.Meta;

        ScGrid<MyAuditBundle> e;
        e = new ScGrid<>();
        e.trackAll(_filterGroup);
        e.setFilterFactory(this::getGridFilter);
        e.layoutFill();
        e.addColumn(x.CreatedLocalTsMessage);
        e.addColumn(x.UserName);
        e.addColumn(x.ChangeTypeName);
        e.addColumn(x.DomainTypeLabel);
        e.addColumn(x.DomainName).setWidth(300);
        _grid = e;
        return e;
    }

    private KmFilter<MyAuditBundle> getGridFilter()
    {
        MyAuditBundleFilter f;
        f = new MyAuditBundleFilter();

        if ( _changeTypeField.hasValue() )
        {
            String code = _changeTypeField.getValue();
            MyAuditBundleChangeType type = MyAuditBundleChangeType.findCode(code);
            f.setChangeType(type);
        }

        if ( _domainTypeField.hasValue() )
        {
            String type = _domainTypeField.getValue();
            f.setDomainType(type);
        }

        if ( _userField.hasValue() )
        {
            MyUser user = _userField.getValue();
            f.setUser(user);
        }

        applyDateRangeTo(f);
        applySortTo(f);
        return f;
    }

    private void applyDateRangeTo(MyAuditBundleFilter f)
    {
        if ( !_dateRangeField.hasValue() )
            return;

        KmDateRange di = _dateRangeField.getValue();

        if ( di.hasStart() )
            f.setMinimumCreatedUtcTs(di.getStart().getStartOfDay().toUtc());

        if ( di.hasEnd() )
            f.setMaximumCreatedUtcTs(di.getEnd().getEndOfDay().toUtc());
    }

    private void applySortTo(MyAuditBundleFilter f)
    {
        String sortCode = _sortField.getValue();
        Sort sort = Sort.valueOf(sortCode);

        switch ( sort )
        {
            case Recent:
                f.sortOnUid();
                f.sortDescending();
                break;
        }
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
