package com.app.ui.page.crud.customerSite;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.layout.ScLayout;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.servlet.field.ScTimeZoneCodeField;

import com.app.model.MyCustomer;
import com.app.model.MySite;
import com.app.model.base.MyChoiceType;
import com.app.model.meta.MyMetaSite;
import com.app.ui.control.MyAddressField;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;
import com.app.ui.selector.MyChoiceSelector;

public class MyCustomerSiteAddCard
    extends MyCrudAddCard<MyCustomer,MySite>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField      _numberField;
    private MyChoiceSelector _typeField;

    //##################################################
    //# constructor
    //##################################################

    public MyCustomerSiteAddCard()
    {
        super(new MyCustomerSiteBuilder());
    }

    public MyCustomerSiteAddCard(MyCustomerSiteBuilder e)
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
        e.add(createAddressSection());
        return e;
    }

    //==================================================
    //= install :: general
    //==================================================

    private ScControl createGeneralSection()
    {
        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("General");
        e.add(createNumberField());
        e.add(createNameField());
        e.add(createTypeField());
        e.addSpace();
        e.add(createTimeZoneField());
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

    private ScControl createTimeZoneField()
    {
        MyMetaSite x = MySite.Meta;

        ScTimeZoneCodeField e;
        e = x.TimeZoneCode.newTimeZoneDropdown();
        e.setLabel("Time Zone");
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
    protected void preRenderDetails(MyCustomer customer)
    {
        super.preRenderDetails(customer);

        _typeField.setProject(customer.getProject());
    }

    //##################################################
    //# validate
    //##################################################

    @Override
    public void validate()
    {
        super.validate();
        validateName();
    }

    private void validateName()
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
    protected MySite saveNewChildOn(MyCustomer parent)
    {
        MySite e;
        e = new MySite();
        e.applyFrom(this);
        e.setCustomer(parent);
        e.daoAttach();
        return e;
    }
}
