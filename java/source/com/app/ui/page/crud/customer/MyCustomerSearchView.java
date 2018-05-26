package com.app.ui.page.crud.customer;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScPopupMenu;
import com.kodemore.servlet.field.ScChoiceField;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.Kmu;

import com.app.criteria.MyCustomerCriteria;
import com.app.model.MyCustomer;
import com.app.model.MyProject;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudGeneralCriteriaSearchView;

public final class MyCustomerSearchView
    extends MyCrudGeneralCriteriaSearchView<MyProject,MyCustomer,MyCustomerCriteria>
{
    //##################################################
    //# constructor
    //##################################################

    public MyCustomerSearchView(MyCrudBuilder<MyProject,MyCustomer> e)
    {
        super(e);
    }

    //##################################################
    //# variables
    //##################################################

    private ScTextField            _nameField;
    private ScChoiceField<Boolean> _enabledField;

    //##################################################
    //# basic filter
    //##################################################

    @Override
    protected void installBasicFieldsOn(ScDiv root)
    {
        ScFieldTable fields;
        fields = root.addFieldTable();
        fields.add(createNameField());
    }

    private ScControl createNameField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel("Name");
        e.disableChangeTracking();
        _nameField = e;
        return e;
    }

    //##################################################
    //# extended filter
    //##################################################

    @Override
    protected void installExtendedFieldsOn(ScDiv root)
    {
        ScFieldTable fields;
        fields = root.addFieldTable();
        fields.add(createEnabledField());
    }

    private ScControl createEnabledField()
    {
        ScChoiceField<Boolean> e;
        e = new ScChoiceField<>();
        e.setLabel("Enabled");
        e.addOption(null, "Any");
        e.addOption(true, "Enabled");
        e.addOption(false, "Disabled");
        e.setValue(true);
        e.disableChangeTracking();
        _enabledField = e;
        return e;
    }

    @Override
    protected void addExtendedMessagesTo(KmList<String> v)
    {
        v.add(formatActiveFilter());
    }

    private String formatActiveFilter()
    {
        return Kmu.formatBoolean(
            _enabledField.getValue(),
            "active",
            "inactive only",
            "include inactive");
    }

    //##################################################
    //# menu
    //##################################################

    @Override
    protected void installMenuItemsOn(ScPopupMenu e)
    {
        e.addItem("Enable All", newCheckedAction(this::handleEnableAll));
        e.addItem("Disable All", newCheckedAction(this::handleDisableAll));
    }

    //##################################################
    //# criteria
    //##################################################

    @Override
    protected MyCustomerCriteria createCriteria()
    {
        return getAccess().getCustomerDao().createCriteria();
    }

    @Override
    protected void filter(MyCustomerCriteria c)
    {
        MyProject project = getDomainParent();
        c.whereProjectIs(project);

        if ( _nameField.hasValue() )
        {
            String name = _nameField.getValue();
            c.whereName().hasSubstring(name);
        }

        if ( _enabledField.hasValue() )
        {
            Boolean enabled = _enabledField.getValue();
            c.whereEnabled().is(enabled);
        }
    }

    @Override
    protected void sort(MyCustomerCriteria c)
    {
        c.sortOnName();
        c.sortOnUid();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleEnableAll()
    {
        enableAll(true);
    }

    private void handleDisableAll()
    {
        enableAll(false);
    }

    private void enableAll(boolean enable)
    {
        KmList<MyCustomer> v = findChildren();
        for ( MyCustomer e : v )
        {
            e.setEnabled(enable);
            e.validateAndCheck();
        }

        ajaxRefreshList();
    }

}
