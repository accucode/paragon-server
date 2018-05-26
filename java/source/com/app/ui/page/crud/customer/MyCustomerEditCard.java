package com.app.ui.page.crud.customer;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.field.ScTextField;

import com.app.model.MyCustomer;
import com.app.model.meta.MyMetaCustomer;
import com.app.ui.control.MyAddressField;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudLayout;

public class MyCustomerEditCard
    extends MyCrudEditCard<MyCustomer>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField _nameField;

    //##################################################
    //# constructor
    //##################################################

    public MyCustomerEditCard()
    {
        super(new MyCustomerBuilder());
    }

    public MyCustomerEditCard(MyCustomerBuilder e)
    {
        super(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected MyCrudLayout getDetailLayout()
    {
        return MyCrudLayout.scroll;
    }

    @Override
    protected void installDetailsOn(ScDiv root)
    {
        root.css().gap20();
        root.add(createGeneralFields());
        root.add(createBillingAddressFields());
    }

    //==================================================
    //= install :: general
    //==================================================

    private ScControl createGeneralFields()
    {
        MyMetaCustomer x = MyCustomer.Meta;

        ScFieldset set;
        set = new ScFieldset();
        set.setLabel("General");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.add(createNameField());
        fields.addField(x.Enabled);

        return set;
    }

    private ScControl createNameField()
    {
        MyMetaCustomer x = MyCustomer.Meta;

        ScTextField e;
        e = x.Name.newField();
        _nameField = e;
        return e;
    }

    //==================================================
    //= install :: address
    //==================================================

    private ScFieldset createBillingAddressFields()
    {
        ScFieldset set;
        set = new ScFieldset();
        set.setLabel("Billing Address");
        set.add(createBillingAddressField());
        return set;
    }

    private ScControl createBillingAddressField()
    {
        MyAddressField e;
        e = new MyAddressField();
        e.setValueAdaptor(MyCustomer.getBillingAddressAdaptor());
        return e;
    }

    @Override
    protected void preRenderDetails(MyCustomer customer)
    {
        super.preRenderDetails(customer);
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
        ScTextField field = _nameField;
        if ( field.hasErrors() )
            return;

        MyCustomer customer = getDomainChild();
        String name = field.getValue();

        boolean dup = getAccess().getCustomerDao().isDuplicateName(customer, name);
        if ( dup )
            field.addError("Duplicate.");
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected void saveDomainChild(MyCustomer e)
    {
        e.applyFrom(this);
    }
}
