package com.app.ui.page.crud.project;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.field.ScStaticDropdownField;
import com.kodemore.servlet.field.ScTextField;

import com.app.criteria.MyProjectCriteria;
import com.app.model.MyProject;
import com.app.model.MyTenant;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudGeneralCriteriaSearchView;

public final class MyProjectSearchView
    extends MyCrudGeneralCriteriaSearchView<MyTenant,MyProject,MyProjectCriteria>
{
    //##################################################
    //# constructor
    //##################################################

    public MyProjectSearchView(MyCrudBuilder<MyTenant,MyProject> e)
    {
        super(e);
    }

    //##################################################
    //# variables
    //##################################################

    private ScTextField                    _nameField;
    private ScStaticDropdownField<Boolean> _enabledField;

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
        ScStaticDropdownField<Boolean> e;
        e = new ScStaticDropdownField<>();
        e.setLabel("Enabled");
        e.addOption(true, "Enabled");
        e.addOption(false, "Disabled");
        e.setNullAnyPrefix();
        e.setValue(true);
        e.disableChangeTracking();
        _enabledField = e;
        return e;
    }

    //==================================================
    //= extended message
    //==================================================

    @Override
    protected void addExtendedMessagesTo(KmList<String> v)
    {
        if ( _enabledField.hasValue() )
            v.add(formatEnabled(_enabledField.getValue()));
    }

    //##################################################
    //# criteria
    //##################################################

    @Override
    protected MyProjectCriteria createCriteria()
    {
        return getAccess().getProjectDao().createCriteria();
    }

    @Override
    protected void filter(MyProjectCriteria c)
    {
        MyTenant tenant = getDomainParent();
        c.whereTenantIs(tenant);

        if ( _nameField.hasValue() )
            c.whereName().hasSubstring(_nameField.getValue());

        if ( _enabledField.hasValue() )
            c.whereEnabled().is(_enabledField.getValue());
    }

    @Override
    protected void sort(MyProjectCriteria c)
    {
        c.sortOnName();
        c.sortOnUid();
    }
}
