package com.app.ui.page.report;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScGrid;
import com.kodemore.servlet.field.ScDomainDropdownField;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.KmEnumIF;

import com.app.criteria.MySiteCriteria;
import com.app.model.MyCustomer;
import com.app.model.MyProject;
import com.app.model.MySite;
import com.app.model.base.MyChoiceType;
import com.app.model.meta.MyMetaSite;
import com.app.ui.grid.MyCustomerColumn;
import com.app.ui.grid.MySiteColumn;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.chartReport.MySimpleChartReportPage;
import com.app.ui.page.chartReport.group.MyChartReportSection;
import com.app.ui.page.chartReport.group.MyChartReportStringSection;
import com.app.ui.page.chartReport.value.MyChartReportValue;
import com.app.ui.selector.MyChoiceSelector;

public class MySiteReportPage
    extends MySimpleChartReportPage<MySite,MySiteCriteria>
{
    //##################################################
    //# singleton
    //##################################################

    private static MySiteReportPage _instance;

    public static void installInstance()
    {
        _instance = new MySiteReportPage();
    }

    public static MySiteReportPage getInstance()
    {
        return _instance;
    }

    private MySiteReportPage()
    {
        // singleton
    }

    //##################################################
    //# sort
    //##################################################

    private enum Sort
        implements KmEnumIF
    {
        Number,
        Name
    }

    //##################################################
    //# variables
    //##################################################

    private ScDomainDropdownField<MyCustomer,String> _customerField;
    private ScTextField                              _nameField;
    private MyChoiceSelector                         _typeField;

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.projectWorker;
    }

    @Override
    public String getHelpMessage()
    {
        return "This report shows all sites from the selected project.";
    }

    //##################################################
    //# install :: filter
    //##################################################

    @Override
    protected void installFilterFieldsOn(ScDiv root)
    {
        ScDiv row;
        row = root.addDiv();
        row.css().flexRow().rowSpacer10().flexChildFiller();

        row.add(createSitefields());
    }

    //==================================================
    //= install :: site filter
    //==================================================

    private ScControl createSitefields()
    {
        ScFieldset set;
        set = createFilterBox("Site");
        set.css().flexChildFiller();

        ScDiv row;
        row = set.addDiv();
        row.css().flexRow().rowSpacer40();

        ScFieldTable fields;
        fields = row.addFieldTable();
        fields.add(createCustomerField());
        fields.add(createNameField());

        fields = row.addFieldTable();
        fields.add(createTypeField());

        return set;
    }

    private ScControl createCustomerField()
    {
        ScDomainDropdownField<MyCustomer,String> e;
        e = MyCustomer.Tools.newDomainDropdown();
        e.setLabel("Customer");
        e.setOptionLabelFunction(MyCustomer.Meta.Name);
        e.setOptionSupplier(this::findCustomers);
        e.setNullAnyPrefix();
        e.disableChangeTracking();
        _customerField = e;
        return e;
    }

    private ScControl createNameField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel(MySite.Meta.FullName);
        e.setHelp(MySite.Meta.FullName);
        e.disableChangeTracking();
        _nameField = e;
        return e;
    }

    private ScControl createTypeField()
    {
        MyMetaSite x = MySite.Meta;

        MyChoiceSelector e;
        e = new MyChoiceSelector();
        e.setMeta(x.Type);
        e.setChoiceType(MyChoiceType.SiteType);
        e.setNullAnyPrefix();
        e.disableAdd();
        e.disableChangeTracking();
        _typeField = e;
        return e;
    }

    //==================================================
    //= install :: filters
    //==================================================

    private KmList<MyCustomer> findCustomers()
    {
        return getCurrentProject().getEnabledCustomersByName();
    }

    //##################################################
    //# grid
    //##################################################

    @Override
    protected void installGridColumnsOn(ScGrid<MySite> e)
    {
        MyMetaSite x = MySite.Meta;

        e.addColumn(new MySiteColumn<>());
        e.addColumn(new MyCustomerColumn<>(x.Customer));
        e.addColumn(x.Number);
        e.addColumn(x.Name);
        e.addColumn(x.TypeName);
        e.addColumn(x.AddressShortLine);
        e.addColumn(x.MainContactFullName);
    }

    @Override
    protected KmEnumIF[] getGridSortOptions()
    {
        return Sort.values();
    }

    //##################################################
    //# criteria
    //##################################################

    @Override
    protected MySiteCriteria createEmptyCriteria()
    {
        return getAccess().getSiteDao().createCriteria();
    }

    @Override
    protected void applyFilterTo(MySiteCriteria c)
    {
        c.whereEnabled().isTrue();
        c.joinToCustomer().whereProjectIs(getCurrentProject());

        if ( _customerField.hasValue() )
            c.whereCustomerIs(_customerField.getValue());

        if ( _nameField.hasValue() )
            c.whereFullName().hasSubstring(_nameField.getValue());

        if ( _typeField.hasValue() )
            c.whereTypeIs(_typeField.getValue());
    }

    //==================================================
    //= sort
    //==================================================

    @Override
    protected void applyGridSortTo(MySiteCriteria c)
    {
        String sortCode = getGridSortCode();
        Sort sort = Sort.valueOf(sortCode);
        boolean asc = getSortAscending();

        switch ( sort )
        {
            case Number:
                c.sortOnFullName(asc);
                break;

            case Name:
                c.sortOnName(asc);
                break;
        }
    }

    //##################################################
    //# chart values
    //##################################################

    @Override
    protected void defineChartValues(KmList<MyChartReportValue<MySite,MySiteCriteria>> v)
    {
        v.add(newRowCountValue());
    }

    //##################################################
    //# chart groups
    //##################################################

    @Override
    protected void defineChartSections(KmList<MyChartReportSection<MySite,MySiteCriteria>> v)
    {
        v.add(newCustomerSection());
    }

    private MyChartReportSection<MySite,MySiteCriteria> newCustomerSection()
    {
        return new MyChartReportStringSection<MySite,MySiteCriteria>()
        {
            @Override
            public String getName()
            {
                return "Customer";
            }

            @Override
            protected void groupByString(MySiteCriteria c)
            {
                c.joinToCustomer().groupByName();
            }
        };
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        MyProject project = getCurrentProject();
        _typeField.setProject(project);
    }

}
