package com.app.ui.page.crud.customerContact;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScTable;
import com.kodemore.servlet.control.ScTableRow;
import com.kodemore.servlet.control.ScText;
import com.kodemore.servlet.control.layout.ScLayout;
import com.kodemore.servlet.field.ScCheckboxField;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.Kmu;

import com.app.model.MyCustomer;
import com.app.model.MyCustomerContact;
import com.app.model.meta.MyMetaCustomerContact;
import com.app.ui.page.crud.abstractBase.MyCrudAddCard;

public class MyCustomerContactAddCard
    extends MyCrudAddCard<MyCustomer,MyCustomerContact>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField _firstNameField;
    private ScTextField _lastNameField;
    private ScTextField _nicknameField;

    private ScCheckboxField _approverContactCheckbox;
    private ScText          _approvalContactText;

    private ScCheckboxField _billingContactCheckbox;
    private ScText          _billingContactText;

    //##################################################
    //# constructor
    //##################################################

    public MyCustomerContactAddCard()
    {
        super(new MyCustomerContactBuilder());
    }

    public MyCustomerContactAddCard(MyCustomerContactBuilder e)
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
        e.add(createRoleSection());
        return e;
    }

    //==================================================
    //= install :: general
    //==================================================

    private ScControl createGeneralSection()
    {
        MyMetaCustomerContact x = MyCustomerContact.Meta;

        _firstNameField = x.FirstName.newField();
        _lastNameField = x.LastName.newField();
        _nicknameField = x.Nickname.newField();

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("General");
        e.add(_firstNameField);
        e.add(_lastNameField);
        e.add(_nicknameField);
        e.addSpace();
        e.addField(x.Phone);
        e.addField(x.Email);
        e.addField(x.Title);
        return e;
    }

    //==================================================
    //= install :: role
    //==================================================

    private ScControl createRoleSection()
    {
        _approverContactCheckbox = new ScCheckboxField();
        _approvalContactText = new ScText();

        _billingContactCheckbox = new ScCheckboxField();
        _billingContactText = new ScText();

        ScTable table;
        table = new ScTable();
        table.setLabel("Is Primary For");
        table.defaultCellCss().pad5x2();

        ScTableRow row;
        row = table.addRow();
        row.addCell().addText("Role");
        row.addCell().addText("Be Primary");
        row.addCell().addText("Current Primary");

        row = table.addRow();
        row.addCell().addLabel("Approver");
        row.addCell().add(_approverContactCheckbox);
        row.addCell().add(_approvalContactText);

        row = table.addRow();
        row.addCell().addLabel("Billing");
        row.addCell().add(_billingContactCheckbox);
        row.addCell().add(_billingContactText);

        return table;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRenderDetails(MyCustomer customer)
    {
        super.preRenderDetails(customer);

        _approvalContactText.setValue(customer.getApprovalContactFullName());
        _billingContactText.setValue(customer.getBillingContactFullName());
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
        if ( _firstNameField.hasErrors() )
            return;

        if ( _lastNameField.hasErrors() )
            return;

        if ( _nicknameField.hasErrors() )
            return;

        String first = _firstNameField.getValue();
        String last = _lastNameField.getValue();
        String nick = _nicknameField.getValue();

        boolean none = Kmu.allNulls(first, last, nick);
        if ( none )
            _firstNameField.addError("You must specify a name (first, last, or nickname).");
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected MyCustomerContact saveNewChildOn(MyCustomer parent)
    {
        MyCustomerContact e;
        e = parent.addContact();
        e.applyFrom(this);
        e.daoAttach();
        return e;
    }

    //##################################################
    //# post save
    //##################################################

    @Override
    protected void postSave(MyCustomerContact e)
    {
        postSaveApprovalContact(e);
        postSaveBillingContact(e);
    }

    private void postSaveApprovalContact(MyCustomerContact e)
    {
        MyCustomer customer = e.getCustomer();

        if ( _approverContactCheckbox.getValue() )
        {
            customer.setApprovalContact(e);
            return;
        }

        if ( customer.hasApprovalContact(e) )
            customer.clearApprovalContact();
    }

    private void postSaveBillingContact(MyCustomerContact e)
    {
        MyCustomer customer = e.getCustomer();

        if ( _billingContactCheckbox.getValue() )
        {
            customer.setBillingContact(e);
            return;
        }

        if ( customer.hasBillingContact(e) )
            customer.clearBillingContact();
    }
}
