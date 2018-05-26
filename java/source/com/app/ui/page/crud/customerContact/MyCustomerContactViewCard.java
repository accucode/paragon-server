package com.app.ui.page.crud.customerContact;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.layout.ScLayout;

import com.app.model.MyCustomerContact;
import com.app.model.meta.MyMetaCustomerContact;
import com.app.ui.page.crud.abstractBase.MyCrudViewCard;

public class MyCustomerContactViewCard
    extends MyCrudViewCard<MyCustomerContact>
{
    //##################################################
    //# constructor
    //##################################################

    public MyCustomerContactViewCard()
    {
        super(new MyCustomerContactBuilder());
    }

    public MyCustomerContactViewCard(MyCustomerContactBuilder e)
    {
        super(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installBodyOn(ScDiv body)
    {
        ScLayout e;
        e = body.addLayout();
        e.setTypeFieldset();
        e.css().fill().auto();
        e.add(createGeneralSection());
        e.add(createRoleSection());
    }

    private ScControl createGeneralSection()
    {
        MyMetaCustomerContact x = MyCustomerContact.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("General");
        e.addFieldText(x.FullName);
        e.addFieldText(x.Title);
        e.addFieldText(x.Phone);
        e.addFieldText(x.Email);
        return e;
    }

    private ScControl createRoleSection()
    {
        MyMetaCustomerContact x = MyCustomerContact.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("Is Primary For");
        e.addFieldText(x.ApprovalContact, "Approval");
        e.addFieldText(x.BillingContact, "Billing");
        return e;
    }
}
