package com.app.ui.page.crud.site;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.layout.ScLayout;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.servlet.field.ScTimeZoneCodeField;

import com.app.model.MyCustomer;
import com.app.model.MyProject;
import com.app.model.MySite;
import com.app.model.base.MyChoiceType;
import com.app.model.meta.MyMetaSite;
import com.app.ui.control.MyAddressField;
import com.app.ui.control.MyPriorityField;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;
import com.app.ui.selector.MyChoiceSelector;
import com.app.ui.selector.MyCustomerSelector;

public class MySiteAddCard
    extends MyCrudAddCard<MyProject,MySite>
{
    //##################################################
    //# variables
    //##################################################

    private MyCustomerSelector _customerField;
    private ScTextField        _numberField;

    private MyChoiceSelector    _typeField;
    private ScTimeZoneCodeField _timeZoneField;

    private MyPriorityField _priorityField;

    //##################################################
    //# constructor
    //##################################################

    public MySiteAddCard()
    {
        super(new MySiteBuilder());
    }

    public MySiteAddCard(MySiteBuilder e)
    {
        super(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installBody(ScDiv body)
    {
        body.add(createLayout());
    }

    private ScControl createLayout()
    {
        ScLayout e;
        e = new ScLayout();
        e.setTypeFieldset();
        e.css().fill().auto();
        e.add(createGeneralSection());
        e.add(createPrioritySection());
        e.add(createAddressSection());
        return e;
    }

    //==================================================
    //= install :: general
    //==================================================

    private ScControl createGeneralSection()
    {
        MyMetaSite x = MySite.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("General");
        e.add(createCustomerField());
        e.addSpace();
        e.add(createNumberField());
        e.add(createNameField());
        e.add(createTypeField());
        e.addSpace();
        e.add(createTimeZoneField(x));
        return e;
    }

    private ScControl createCustomerField()
    {
        MyMetaSite x = MySite.Meta;

        MyCustomerSelector e;
        e = new MyCustomerSelector();
        e.setMeta(x.Customer);
        _customerField = e;
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

    private ScControl createTypeField()
    {
        MyMetaSite x = MySite.Meta;

        MyChoiceSelector e;
        e = new MyChoiceSelector();
        e.setMeta(x.Type);
        e.setChoiceType(MyChoiceType.SiteType);
        _typeField = e;
        return e;
    }

    private ScControl createTimeZoneField(MyMetaSite x)
    {
        ScTimeZoneCodeField e;
        e = x.TimeZoneCode.newTimeZoneDropdown();
        e.setLabel("Time Zone");
        _timeZoneField = e;
        return e;
    }

    //==================================================
    //= install :: priority
    //==================================================

    private ScControl createPrioritySection()
    {
        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("Priority");
        e.add(createPriorityField());
        return e;
    }

    private ScControl createPriorityField()
    {
        MyMetaSite x = MySite.Meta;

        MyPriorityField e;
        e = new MyPriorityField();
        e.setMeta(x.Priority);
        _priorityField = e;
        return e;
    }

    //==================================================
    //= install :: address
    //==================================================

    private ScControl createAddressSection()
    {
        MyAddressField e;
        e = new MyAddressField();
        e.setLabel("Address");
        e.setValueAdaptor(MySite.getAddressAdaptor());
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRenderDetails(MyProject project)
    {
        super.preRenderDetails(project);

        preRenderNumber(project);
        preRenderCustomer(project);
        preRenderType(project);
        preRenderTimeZone(project);
        preRenderPriorities(project);
        preRenderProjectOptions(project);
    }

    private void preRenderNumber(MyProject project)
    {
        boolean enabled = project.isAutoSiteNumberEnabled();
        if ( !enabled )
            return;

        String s = project.allocateNextAutoSiteNumber();
        _numberField.setValue(s);
    }

    private void preRenderCustomer(MyProject project)
    {
        _customerField.setProject(project);
        _customerField.selectSingleOption();
    }

    private void preRenderType(MyProject project)
    {
        _typeField.setProject(project);
        _typeField.selectSingleOption();
    }

    private void preRenderPriorities(MyProject project)
    {
        _priorityField.setProject(project);
        _priorityField.setValue(project.getDefaultPriority());
    }

    private void preRenderTimeZone(MyProject project)
    {
        _timeZoneField.setValue(project.getTimeZoneCode());
    }

    private void preRenderProjectOptions(MyProject project)
    {
        _typeField.setProject(project);
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
        if ( _customerField.hasErrors() )
            return;

        if ( _numberField.hasErrors() )
            return;

        MyCustomer customer = _customerField.getValue();
        String number = _numberField.getValue();

        boolean dup = getAccess().getSiteDao().isDuplicateNumber(customer, number);
        if ( dup )
            _numberField.addError("Duplicate.");
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MySite saveNewChildOn(MyProject parent)
    {
        MyCustomer customer = _customerField.getValue();

        MySite e;
        e = new MySite();
        e.applyFrom(this);
        e.setCustomer(customer);
        e.daoAttach();
        return e;
    }
}
