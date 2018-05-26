package com.app.ui.page.crud.customer;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.layout.ScLayout;
import com.kodemore.servlet.field.ScTextField;

import com.app.model.MyCustomer;
import com.app.model.MyProject;
import com.app.model.meta.MyMetaCustomer;
import com.app.ui.control.MyAddressField;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;

public class MyCustomerAddCard
    extends MyCrudAddCard<MyProject,MyCustomer>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField _nameField;

    //##################################################
    //# constructor
    //##################################################

    public MyCustomerAddCard()
    {
        super(new MyCustomerBuilder());
    }

    public MyCustomerAddCard(MyCustomerBuilder e)
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
        e.add(createNameField());
        return e;
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

    private ScControl createAddressSection()
    {
        MyAddressField e;
        e = new MyAddressField();
        e.setLabel("Billing Address");
        e.setValueAdaptor(MyCustomer.getBillingAddressAdaptor());
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRenderDetails(MyProject project)
    {
        super.preRenderDetails(project);
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

        MyProject project = getDomainParent();
        String name = field.getValue();

        boolean dup = getAccess().getCustomerDao().isDuplicateName(project, name);
        if ( dup )
            field.addError("Duplicate.");
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyCustomer saveNewChildOn(MyProject project)
    {
        MyCustomer e;
        e = project.addCustomer();
        e.applyFrom(this);
        e.daoAttach();
        return e;
    }
}
