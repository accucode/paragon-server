package com.app.ui.selector;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldText;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.servlet.field.ScTimeZoneCodeField;

import com.app.model.MyCustomer;
import com.app.model.MyPriority;
import com.app.model.MyProject;
import com.app.model.MySite;
import com.app.model.base.MyChoiceType;
import com.app.model.meta.MyMetaSite;
import com.app.ui.selector.core.MyAbstractCustomerSelectorDialog;
import com.app.utility.MyInstaller;

/**
 * I am used by the to dynamically add a new option/type on the fly.
 */
public class MySiteSelectorDialog
    extends MyAbstractCustomerSelectorDialog<MySite>
{
    //##################################################
    //# instance
    //##################################################

    private static MySiteSelectorDialog _instance;

    public static MySiteSelectorDialog getInstance()
    {
        return _instance;
    }

    /**
     * @see MyInstaller#_installSelectorDialogs
     */
    public static void installInstance()
    {
        _instance = new MySiteSelectorDialog();
    }

    //##################################################
    //# variables
    //##################################################

    private ScFieldText         _customerNameText;
    private ScTextField         _numberField;
    private MyChoiceSelector    _typeField;
    private ScTimeZoneCodeField _timeZoneField;

    //##################################################
    //# settings
    //##################################################

    @Override
    protected String getDomainChildTitle()
    {
        return "Site";
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installFieldsOn(ScDiv root)
    {
        root.css().pad();

        ScFieldTable fields;
        fields = root.addFieldTable();
        fields.add(createCustomerNameText());
        fields.add(createNumberField());
        fields.add(createNameField());
        fields.add(createSiteTypeField());
        fields.add(createTimeZoneField());
    }

    private ScControl createCustomerNameText()
    {
        ScFieldText e;
        e = new ScFieldText();
        e.setLabel("Customer");
        _customerNameText = e;
        return e;
    }

    private ScControl createNumberField()
    {
        MyMetaSite x = MySite.Meta;

        ScTextField e;
        e = x.Number.newField();
        _numberField = e;
        return e;
    }

    private ScControl createNameField()
    {
        MyMetaSite x = MySite.Meta;

        ScTextField e;
        e = x.Name.newField();
        return e;
    }

    private ScControl createSiteTypeField()
    {
        MyMetaSite x = MySite.Meta;

        MyChoiceSelector e;
        e = new MyChoiceSelector();
        e.setMeta(x.Type);
        e.setChoiceType(MyChoiceType.SiteType);
        _typeField = e;
        return e;
    }

    private ScTimeZoneCodeField createTimeZoneField()
    {
        MyMetaSite x = MySite.Meta;

        ScTimeZoneCodeField e;
        e = x.TimeZoneCode.newTimeZoneDropdown();
        _timeZoneField = e;
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        MyCustomer customer = getDomainParent();
        MyProject project = customer.getProject();

        _customerNameText.setValue(customer.getName());

        _typeField.setProject(project);
        _typeField.selectSingleOption();

        _timeZoneField.setValue(project.getTimeZoneCode());
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        super.validate();

        validateNumber();
    }

    private void validateNumber()
    {
        ScTextField field = _numberField;
        if ( field.hasErrors() )
            return;

        MyCustomer customer = getDomainParent();
        String number = field.getValue();

        boolean dup = getAccess().getSiteDao().isDuplicateNumber(customer, number);
        if ( dup )
            field.addError("Duplicate.");
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MySite saveDomainChildFor(MyCustomer customer)
    {
        MyProject project = customer.getProject();
        MyPriority defPriority = project.getDefaultPriority();

        MySite e;
        e = new MySite();
        e.setCustomer(customer);
        e.setPriority(defPriority);
        e.applyFrom(this);
        e.daoAttach();
        return e;
    }

}
