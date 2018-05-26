package com.app.ui.page.crud.customerContact;

import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScTable;
import com.kodemore.servlet.control.ScTableRow;
import com.kodemore.servlet.control.ScText;
import com.kodemore.servlet.field.ScCheckboxField;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.utility.Kmu;

import com.app.model.MyCustomer;
import com.app.model.MyCustomerContact;
import com.app.model.meta.MyMetaCustomerContact;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudLayout;

public class MyCustomerContactEditCard
    extends MyCrudEditCard<MyCustomerContact>
{
    //##################################################
    //# variables
    //##################################################

    private ScTextField _firstNameField;
    private ScTextField _lastNameField;
    private ScTextField _nicknameField;

    private ScCheckboxField _approverContactCheckbox;
    private ScText          _approverContactText;

    private ScCheckboxField _billingContactCheckbox;
    private ScText          _billingContactText;

    //##################################################
    //# constructor
    //##################################################

    public MyCustomerContactEditCard()
    {
        super(new MyCustomerContactBuilder());
    }

    public MyCustomerContactEditCard(MyCustomerContactBuilder e)
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
        root.css().flexColumn().columnSpacer20();

        installGeneralFieldsOn(root);
        installRoleFieldsOn(root);
    }

    private void installGeneralFieldsOn(ScDiv root)
    {
        MyMetaCustomerContact x = MyCustomerContact.Meta;

        _firstNameField = x.FirstName.newField();
        _lastNameField = x.LastName.newField();
        _nicknameField = x.Nickname.newField();

        ScFieldset set;
        set = root.addFieldset("General");

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.add(_firstNameField);
        fields.add(_lastNameField);
        fields.add(_nicknameField);
        fields.addSpace();
        fields.addField(x.Title);
        fields.addField(x.Phone);
        fields.addField(x.Email);
    }

    private void installRoleFieldsOn(ScDiv root)
    {
        _approverContactCheckbox = new ScCheckboxField();
        _approverContactText = new ScText();

        _billingContactCheckbox = new ScCheckboxField();
        _billingContactText = new ScText();

        ScFieldset set;
        set = root.addFieldset("Is Primary For");

        ScTable table;
        table = set.addTable();
        table.defaultCellCss().pad5x2();

        ScTableRow row;
        row = table.addRow();
        row.addCell().addText("Role");
        row.addCell().addText("Be Primary");
        row.addCell().addText("Current Primary");

        row = table.addRow();
        row.addCell().addLabel("Approver");
        row.addCell().add(_approverContactCheckbox);
        row.addCell().add(_approverContactText);

        row = table.addRow();
        row.addCell().addLabel("Billing");
        row.addCell().add(_billingContactCheckbox);
        row.addCell().add(_billingContactText);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRenderDetails(MyCustomerContact contact)
    {
        super.preRenderDetails(contact);

        MyCustomer customer = contact.getCustomer();

        _approverContactCheckbox.setValue(contact.isApprovalContact());
        _approverContactText.setValue(customer.getApprovalContactFullName());

        _billingContactCheckbox.setValue(contact.isBillingContact());
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
    protected void saveDomainChild(MyCustomerContact e)
    {
        e.applyFrom(this);
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
