package com.app.ui.page.crud.site;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScNotebook;
import com.kodemore.servlet.field.ScStaticDropdownField;
import com.kodemore.servlet.field.ScTextField;

import com.app.filter.MySiteFilter;
import com.app.model.MyFilterTemplate;
import com.app.model.MyProject;
import com.app.model.base.MyChoiceType;
import com.app.ui.selector.MyChoiceSelector;
import com.app.utility.MyGlobals;

public final class MySiteFilterDialog
    extends MyFilterDialog<MySiteFilter>
{
    //##################################################
    //# variables
    //##################################################

    private ScGroup                        _commonTab;
    private ScTextField                    _numberField;
    private ScTextField                    _nameSubstringField;
    private ScStaticDropdownField<Boolean> _enabledField;

    private ScGroup          _otherTab;
    private MyChoiceSelector _typeField;

    //##################################################
    //# settings
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        setLabel("Site Filter");
        setWidth(600);
        setHeight(500);
    }

    //##################################################
    //# setup
    //##################################################

    @Override
    protected MySiteFilter createFilter()
    {
        return new MySiteFilter();
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installNotebook(ScNotebook book)
    {
        book.add(createCommonTab());
        book.add(createOtherTab());
    }

    //==================================================
    //= install :: common tab
    //==================================================

    private ScControl createCommonTab()
    {
        ScGroup e;
        e = createTab("Common");
        e.getBody().add(createCommonFields());
        _commonTab = e;
        return e;
    }

    private ScControl createCommonFields()
    {
        ScFieldTable e;
        e = new ScFieldTable();
        e.add(createNumberField());
        e.add(createNameField());
        e.add(createEnabledField());
        return e;
    }

    private ScControl createNumberField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel("Number");
        e.disableChangeTracking();
        _numberField = e;
        return e;
    }

    private ScControl createNameField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel("Name");
        e.disableChangeTracking();
        _nameSubstringField = e;
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
        _enabledField = e;
        return e;
    }

    //==================================================
    //= install :: other tab
    //==================================================

    private ScControl createOtherTab()
    {
        ScGroup e;
        e = createTab("Other");
        e.getBody().add(createOtherFields());
        _otherTab = e;
        return e;
    }

    private ScControl createOtherFields()
    {
        ScFieldTable e;
        e = new ScFieldTable();
        e.add(createTypeField());
        return e;
    }

    private ScControl createTypeField()
    {
        MyChoiceSelector e;
        e = new MyChoiceSelector();
        e.setLabel("Type");
        e.setChoiceType(MyChoiceType.SiteType);
        e.setNullAnyPrefix();
        e.disableAdd();
        e.disableChangeTracking();
        _typeField = e;
        return e;
    }

    //##################################################
    //# tab changing
    //##################################################

    @Override
    protected void saveTabTo(ScControl tab, MySiteFilter filter)
    {
        ScControl oldTab = getSelectedTab();

        if ( oldTab == _commonTab )
            saveCommonTabOn(filter);

        if ( oldTab == _otherTab )
            saveOtherTabOn(filter);
    }

    private void saveCommonTabOn(MySiteFilter filter)
    {
        filter.resetNumber();
        if ( _numberField.hasValue() )
            filter.setNumber(_numberField.getValue());

        filter.resetNameSubstring();
        if ( _nameSubstringField.hasValue() )
            filter.setNameSubstring(_nameSubstringField.getValue());

        filter.resetEnabled();
        if ( _enabledField.hasValue() )
            filter.setEnabled(_enabledField.getValue());
    }

    private void saveOtherTabOn(MySiteFilter filter)
    {
        filter.resetType();
        if ( _typeField.hasValue() )
            filter.setType(_typeField.getValue());
    }

    //##################################################
    //# tab render
    //##################################################

    @Override
    protected void preRenderTab(ScControl tab)
    {
        if ( tab == _commonTab )
            preRenderCommonTab();

        if ( tab == _otherTab )
            preRenderOtherTab();
    }

    private void preRenderCommonTab()
    {
        MyFilterTemplate template = getDetachedTemplate();

        MySiteFilter filter;
        filter = createFilter();
        filter.loadFromTemplate(template);

        if ( filter.usesNameSubstring() )
            _nameSubstringField.setValue(filter.getNameSubstring());

        if ( filter.usesNumber() )
            _numberField.setValue(filter.getNumber());

        if ( filter.usesEnabled() )
            _enabledField.setValue(filter.getEnabled());
    }

    private void preRenderOtherTab()
    {
        MyFilterTemplate template = getDetachedTemplate();
        MyProject project = getCurrentProject();

        MySiteFilter filter;
        filter = createFilter();
        filter.loadFromTemplate(template);

        _typeField.setProject(project);
        if ( filter.usesType() )
            _typeField.setValue(filter.getType());
    }

    protected MyProject getCurrentProject()
    {
        return MyGlobals.getCurrentProject();
    }

}
