package com.app.ui.page.crud.emailTemplate;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.field.ScStaticDropdownField;
import com.kodemore.servlet.field.ScStaticEnumDropdownField;
import com.kodemore.servlet.field.ScTextField;

import com.app.criteria.MyEmailTemplateCriteria;
import com.app.model.MyEmailTemplate;
import com.app.model.MyProject;
import com.app.model.base.MyEmailTemplateContextType;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudGeneralCriteriaSearchView;

public final class MyEmailTemplateSearchView
    extends MyCrudGeneralCriteriaSearchView<MyProject,MyEmailTemplate,MyEmailTemplateCriteria>
{
    //##################################################
    //# constructor
    //##################################################

    public MyEmailTemplateSearchView(MyCrudBuilder<MyProject,MyEmailTemplate> e)
    {
        super(e);
    }

    //##################################################
    //# variables
    //##################################################

    private ScTextField _nameField;

    private ScStaticEnumDropdownField      _typeField;
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
        fields.add(createTypeField());
    }

    private ScControl createTypeField()
    {
        ScStaticEnumDropdownField e;
        e = new ScStaticEnumDropdownField();
        e.setLabel("Type");
        e.setOptions(MyEmailTemplateContextType.values());
        e.setNullAnyPrefix();
        e.disableChangeTracking();
        _typeField = e;
        return e;
    }

    private ScControl createEnabledField()
    {
        ScStaticDropdownField<Boolean> e;
        e = new ScStaticDropdownField<>();
        e.setLabel("Enabled");
        e.setNullAnyPrefix();
        e.addOption(true, "Enabled");
        e.addOption(false, "Disabled");
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

        if ( _typeField.hasValue() )
        {
            String code = _typeField.getValue();
            MyEmailTemplateContextType type = MyEmailTemplateContextType.findCode(code);
            v.add(type.getLabel());
        }
    }

    //##################################################
    //# criteria
    //##################################################

    @Override
    protected MyEmailTemplateCriteria createCriteria()
    {
        return getAccess().getEmailTemplateDao().createCriteria();
    }

    @Override
    protected void filter(MyEmailTemplateCriteria c)
    {
        MyProject project = getDomainParent();
        c.whereProjectIs(project);

        if ( _nameField.hasValue() )
            c.whereName().hasSubstring(_nameField.getValue());

        if ( _typeField.hasValue() )
            c.whereContextTypeCode().is(_typeField.getValue());

        if ( _enabledField.hasValue() )
            c.whereEnabled().is(_enabledField.getValue());
    }

    @Override
    protected void sort(MyEmailTemplateCriteria c)
    {
        c.sortOnName();
    }
}
