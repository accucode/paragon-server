package com.app.ui.page.crud.projectOption.core;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.field.ScStaticDropdownField;
import com.kodemore.servlet.field.ScTextField;

import com.app.criteria.MyChoiceCriteria;
import com.app.model.MyProject;
import com.app.model.MyChoice;
import com.app.model.base.MyChoiceType;
import com.app.ui.page.crud.abstractBase.MyCrudGeneralCriteriaSearchView;

public final class MyChoiceSearchView
    extends MyCrudGeneralCriteriaSearchView<MyProject,MyChoice,MyChoiceCriteria>
{
    //##################################################
    //# constructor
    //##################################################

    public MyChoiceSearchView(MyChoiceBuilder e)
    {
        super(e);
    }

    //##################################################
    //# variables
    //##################################################

    private ScTextField                    _nameField;
    private ScStaticDropdownField<Boolean> _enabledField;

    //##################################################
    //# topic
    //##################################################

    @Override
    public MyChoiceBuilder getCrudBuilder()
    {
        return (MyChoiceBuilder)super.getCrudBuilder();
    }

    private MyChoiceType getType()
    {
        return getCrudBuilder().getType();
    }

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
        e.disableChangeTracking();
        e.setValue(true);
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
    protected MyChoiceCriteria createCriteria()
    {
        return getAccess().getChoiceDao().createCriteria();
    }

    @Override
    protected void filter(MyChoiceCriteria c)
    {
        MyProject project = getDomainParent();
        c.whereProjectIs(project);
        c.whereTypeIs(getType());

        if ( _nameField.hasValue() )
            c.whereName().hasSubstring(_nameField.getValue());

        if ( _enabledField.hasValue() )
            c.whereEnabled().is(_enabledField.getValue());
    }

    @Override
    protected void sort(MyChoiceCriteria c)
    {
        c.sortOnName();
        c.sortOnUid();
    }
}
