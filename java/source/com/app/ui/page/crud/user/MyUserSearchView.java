
package com.app.ui.page.crud.user;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.field.ScStaticDropdownField;
import com.kodemore.servlet.field.ScTextField;

import com.app.criteria.MyUserCriteria;
import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudGeneralCriteriaSearchView;

public final class MyUserSearchView
    extends MyCrudGeneralCriteriaSearchView<MyTenant,MyUser,MyUserCriteria>
{
    //##################################################
    //# constructor
    //##################################################

    public MyUserSearchView(MyCrudBuilder<MyTenant,MyUser> e)
    {
        super(e);
    }

    //##################################################
    //# variables
    //##################################################

    private ScTextField                    _nameField;
    private ScTextField                    _emailField;
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
        fields.add(createEmailField());
        fields.add(createEnabledField());
    }

    private ScControl createEmailField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel("Email");
        e.disableChangeTracking();
        _emailField = e;
        return e;
    }

    private ScControl createEnabledField()
    {
        ScStaticDropdownField<Boolean> e;
        e = new ScStaticDropdownField<>();
        e.setLabel("Enabled");
        e.addOption(true, "Enabled");
        e.addOption(false, "Disabled");
        e.setNullAnyPrefix();
        e.disableChangeTracking();
        e.setValue(true);
        _enabledField = e;
        return e;
    }

    @Override
    protected void addExtendedMessagesTo(KmList<String> v)
    {
        if ( _emailField.hasValue() )
            v.add(_emailField.getValue());

        if ( _enabledField.hasValue() )
            v.add(formatEnabled(_enabledField.getValue()));
    }

    //##################################################
    //# criteria
    //##################################################

    @Override
    protected MyUserCriteria createCriteria()
    {
        return getAccess().getUserDao().createCriteria();
    }

    @Override
    protected void filter(MyUserCriteria c)
    {
        MyTenant tenant = getDomainParent();
        c.whereTenantIs(tenant);

        if ( _nameField.hasValue() )
            c.whereFullName().hasSubstring(_nameField.getValue());

        if ( _emailField.hasValue() )
            c.whereEmail().hasSubstring(_emailField.getValue());

        if ( _enabledField.hasValue() )
            c.whereEnabled().is(_enabledField.getValue());
    }

    @Override
    protected void sort(MyUserCriteria c)
    {
        c.sortOnFullName();
    }
}
